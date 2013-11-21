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

	public void setX(char input, int location) throws IllegalPlayerOptionException, 
		AlreadyOccupiedException, OutOfBoundsException
	{
		if(input != 'X' && input != 'O')
		{
			throw new IllegalPlayerOptionException("Not a valid input");
		}
		if(this.table[location] != 'E')
		{
			throw new AlreadyOccupiedException("Cell already occupied");
		}
		if(location < 0 || location > 8)
		{
			throw new OutOfBoundsException("Location Out Of Bounds");
		}
		*/
		this.table[location] = input;
	}

	public String toJson()
    {
    	String result = "";
    	for(int i = 0; i < Rows; i++)
		{
			result += "{\"cell" + i + "\":\"" + this.table[i] + "\"}";
			if(i < 8)
			{
				result += ",";	
			}
		}
		return result;
    }
}