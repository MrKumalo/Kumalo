/*
* @(#)Table.java 1, 18 Nov 2013
 *
 * Copyright (c) arnars12, axelg12, gadidjah12, gunnarsa12, haraldurs12, solberg12 
 */
package is.ru.ttt;

import static spark.Spark.*;
import spark.*;

/**
 * [lýsing]
 *
 * @author arnars12, axelg12, gadidjah12, gunnarsa12, haraldurs12, solberg12  
 * @version 1, 20 November 2013
 */

public class Table{

	public static final char empty = 'E';
	public static final int Rows = 9;
	private char[] table = new char[Rows];

	/**
	 * [Table description]
	 * @return [description]
	 */
	public Table()
	{
		for(int i = 0; i < Rows; i++)
		{
			this.table[i] = empty;
		}
	}

	/**
	 * [getTable description]
	 * @param  i [description]
	 * @return   [description]
	 */
	public char getTable(int i)
	{
		return this.table[i];
	}

	/**
	 * 
	 */
	public char[] getFullTable()
	{
		return this.table;
	}

	/**
	 * [setX description]
	 * @param  input                        [description]
	 * @param  location                     [description]
	 * @throws IllegalPlayerOptionException [description]
	 * @throws AlreadyOccupiedException     [description]
	 * @throws OutOfBoundsException         [description]
	 */
	public void setX(char input, int location) throws IllegalPlayerOptionException, 
		AlreadyOccupiedException, OutOfBoundsException
	{
		if(location > 8 || location < 0)
		{
			throw new OutOfBoundsException("Location Out Of Bounds");
		}
		if(input != 'X' && input != 'O')
		{
			throw new IllegalPlayerOptionException("Not a valid input");
		}
		if(this.table[location] != 'E')
		{
			throw new AlreadyOccupiedException("Cell already occupied");
		}
		this.table[location] = input;
	}

	/**
	 * [toJson description]
	 * @return [description]
	 */
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