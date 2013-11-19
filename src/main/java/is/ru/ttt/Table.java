package is.ru.ttt;

import static spark.Spark.*;
import spark.*;

public class Table{

	public static final char empty = "E";
	public static final int Rows = 9;
	public static char[] table = new char[Rows];

	public char InitializeTable(){

		for(int i = 0; i < Rows; i++){
			table[i] = empty;
		}
		return table;
	}
}