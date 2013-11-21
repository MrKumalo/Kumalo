package is.ru.ttt;

import static spark.Spark.*;
import spark.*;

public class TicTacToe 
{

    public static Game game;

    public static Table table;

    public static Player player1;
    public static Player player2;

    public static void main(String[] args) {
        staticFileLocation("/public");
        
        setPort(Integer.valueOf(System.getenv("PORT")));

        post(new Route("/players") {
            @Override
            public Object handle(Request request, Response response) {
                String p1 = request.queryParams("player1");
                String p2 = request.queryParams("player2");
                
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

                int cell = Integer.valueOf(request.queryParams("cell"));
                String p = request.queryParams("player");
                char option = p.charAt(0);

                table = game.getTable();

                try
                {
                    table.setX(option, cell);
                }
                catch(IllegalPlayerOptionException ex)
                {
                    return "[{\"Status\":\"error\"}]";''
                }
                catch(OutOfBoundsException ex)
                {
                    return "[{\"Status\":\"error\"}]";
                }
                catch(AlreadyOccupiedException ex)
                {
                    return "[{\"Status\":\"error\"}]";
                }

                Player player;

                if(option == 'X')
                    player = game.getP1();
                else
                    player = game.getP2();

                try
                {
                    player.insertIntoTable(cell);
                }
                catch(OutOfBoundsException ex)
                {
                    return "[{\"Status\":\"error\"}]";
                }
                catch(AlreadyOccupiedException ex)
                {
                    return "[{\"Status\":\"error\"}]";
                }

                if(game.winningCombinations(player.getInserted()))
                    return "[{\"Status\":\"" + player.getPlayerName() + "\"}]";

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