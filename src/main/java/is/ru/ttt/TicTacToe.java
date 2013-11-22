/*
* @(#)OutOfBoundsException.java 1, 18 Nov 2013
 *
 * Copyright (c) arnars12, axelg12, gadidjah12, gunnarsa12, haraldurs12, solberg12 
 */

package is.ru.ttt;

import static spark.Spark.*;
import spark.*;

public class TicTacToe 
{

    public static Game game;

    public static Table table;

    public static Player player1;
    public static Player player2;

    public static int counter = 0;

    public static void main(String[] args) {
        staticFileLocation("/public");
        
        setPort(Integer.valueOf(System.getenv("PORT")));

        post(new Route("/players") {
            @Override
            public Object handle(Request request, Response response) {
                String p1 = request.queryParams("player1");
                String p2 = request.queryParams("player2");

                if(p2.equals(p1))
                    return "[{\"Status\":\"player_names\"}]";
                
                player1 = new Player(p1, true);
                player2 = new Player(p2, false);

                table = new Table();

                try
                {
                    game = new Game(player1, player2, table, 1);
                }
                catch(IllegalTurnException ex)
                {
                    return "[{\"Status\":\"error\"}]";
                }
                return game.toJson();
           }
        });

        post(new Route("/makemove") {
            @Override
            public Object handle(Request request, Response response) {

                Integer cell = Integer.valueOf(request.queryParams("cell"));
                System.out.println(cell);

                String p = request.queryParams("player");
                System.out.println(p);
                char option = p.charAt(0);

                table = game.getTable();

                try
                {
                    table.setX(option, cell);
                }
                catch(IllegalPlayerOptionException ex)
                {
                    return "[{\"Status\":\"player_error\"}]";
                }
                catch(OutOfBoundsException ex)
                {
                    return "[{\"Status\":\"outofbounds_error\"}]";
                }
                catch(AlreadyOccupiedException ex)
                {
                    return "[{\"Status\":\"occupied_error\"}]";
                }

                Player player1 = game.getP1();
                Player player2 = game.getP2();

                try
                {
                    if(!player1.getTurn() && !player2.getTurn())
                        return "[{\"Status\":\"player_turn\"}]";


                    if(option == 'X')
                    {
                        game.addCounter();
                        game.setTurn(2);
                        player1.insertIntoTable(cell);
                    }
                    else
                    {
                        game.addCounter();
                         game.setTurn(1);
                         player2.insertIntoTable(cell);
                    }
                    
                    player1.turn();
                    player2.turn();

                }
                catch(OutOfBoundsException ex)
                {
                    return "[{\"Status\":\"outofbounds_error\"}]";
                }
                catch(AlreadyOccupiedException ex)
                {
                    return "[{\"Status\":\"occupied_error\"}]";
                }
                catch(IllegalTurnException ex)
                {
                    return "[{\"Status\":\"illegalturn_error\"}]";
                }
                if(game.winningCombinations(player1.getInserted()))
                    return "[{\"Status\":\"" + player1.getPlayerName() + "\"}]";
                if(game.winningCombinations(player2.getInserted()))
                    return "[{\"Status\":\"" + player2.getPlayerName() + "\"}]";

                try
                {
                    if(game.getTurn() == 1)
                        game.setTurn(2);
                    else
                        game.setTurn(1);
                }
                catch(IllegalTurnException ex)
                {
                    return "[{\"Status\":\"turn_error\"}]";
                }
                if(game.getTurnCounter() == 9)
                {
                    return "[{\"Status\":\"draw\"}]";
                }

                System.out.println(counter);

                return game.toJson();  
            }
        });

        get(new Route("/getboard") {
            @Override
            public Object handle(Request request, Response response) {
                Table table = new Table();
                return table.toJson();
            }
        });
        
        post(new Route("/add") {
            @Override
            public Object handle(Request request, Response response) {
                Integer a = Integer.valueOf(request.queryParams("a"));
                Integer b = Integer.valueOf(request.queryParams("b"));
                return a + b;
            }
        });
    }
}