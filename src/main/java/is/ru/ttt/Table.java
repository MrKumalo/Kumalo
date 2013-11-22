/*
* @(#)Table.java 1, 18 Nov 2013
 *
 * Copyright (c) arnars12, axelg12, gadidjah12, gunnarsa12, haraldurs12, solberg12 
 */
package is.ru.ttt;

import static spark.Spark.*;
import spark.*;

/**
 * The Table class maintains the game-board.
 *
 * @author arnars12, axelg12, gadidjah12, gunnarsa12, haraldurs12, solberg12  
 * @version 1, 20 November 2013
 */

public class Table{

	public static final char empty = 'E';
	public static final int Rows = 9;
	private char[] table = new char[Rows];

	/**
	 * The Table function is the default constructor for the Table class. Initializes the table array.
	 */
	public Table()
	{
		for(int i = 0; i < Rows; i++)
		{
			this.table[i] = empty;
		}
	}

	/**
	 * the getTable function takes in the location of the cell you want to get returned.
	 * @param  i The location we want to find in the array.
	 * @return   returns one cell from the array.
	 */
	public char getTable(int i)
	{
		return this.table[i];
	}

	/**
	 * The getFullTable function returns the whole table array.
	 * @return 	returns the whole arrray.
	 */
	public char[] getFullTable()
	{
		return this.table;
	}

	/**
	 * The setX function takes in an input and a location. The function then inserts the input in a specified location in the table.
	 * @param  input                        Input specifies the type of input to insert in the table, the input can be either X, O or E.
	 * @param  location                     Location variable specifies where in the table we want to insert the input.
	 * @throws IllegalPlayerOptionException This exception is thrown if the input is not X or O.
	 * @throws AlreadyOccupiedException     This exception is thrown if the input location is already occupied.
	 * @throws OutOfBoundsException         This exception is thrown if the location integer is not within a certain range.
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
	 * This toJson function is used to create a json string.
	 * @return json string.
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