package is.ru.ttt;

import static spark.Spark.*;
import spark.*;

public class Table{

	public static final char empty = 'E';
	public static final int Rows = 9;
	private char[] table = new char[Rows];

	public Table()
	{
		for(int i = 0; i < Rows; i++)
		{
			this.table[i] = empty;
		}
	}
	public char getTable(int i)
	{
		return this.table[i];
	}

	public char[] getFullTable()
	{
		return this.table;
	}

	public void setX(char input, int location)
	{
		this.table[location] = input;
	}
}