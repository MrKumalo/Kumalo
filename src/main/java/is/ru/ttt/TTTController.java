package is.ru.ttt;

import static spark.Spark.*;
import spark.*;

class TTTController {
	public static void main(String[] args) {
		staticFileLocation("/public");

		setPort(Integer.valueOf(System.getenv("PORT")));

		get(new Route("/hello") {
			@Override
			public Object handle(Request request, Response response) { 
				
			}
		});
	}
}