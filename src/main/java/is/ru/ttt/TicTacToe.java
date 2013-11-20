package is.ru.ttt;

import static spark.Spark.*;
import spark.*;

public class TicTacToe 
{
    public static void main(String[] args) {
        staticFileLocation("/public");
        
        setPort(Integer.valueOf(System.getenv("PORT")));

        post(new Route("/players") {
            @Override
            public Object handle(Request request, Response response) {
                String p1 = request.queryParams("player1");
                String p2 = request.queryParams("player2");
                
                Player player1 = new Player(p1, true);
                Player player2 = new Player(p2, false);

                Table table = new Table();

                Game game;

                try
                {
                    game = new Game(player1, player2, table, 1);
                }
                catch(IllegalTurnException ex)
                {
                    return "[{\"Status\":\"error\"}]";
                }
                System.out.println(game.toJson());
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

