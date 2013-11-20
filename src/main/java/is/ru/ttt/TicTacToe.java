package is.ru.ttt;

import static spark.Spark.*;
import spark.*;

public class TicTacToe 
{
    public static void main(String[] args) {
        staticFileLocation("/public");
        
        setPort(Integer.valueOf(System.getenv("PORT")));

        get(new Route("/board") {
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

