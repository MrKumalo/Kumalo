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
                String player1 = request.queryParams("player1");
                String player2 = request.queryParams("player2");
                String json = "[{\"Player1\":\"" + player1 + "\"},{\"Player2\":\""
                + player2 + "\"}]";
                return json;
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

