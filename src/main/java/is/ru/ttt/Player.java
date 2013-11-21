/*
* @(#)Player.java 1, 18 Nov 2013
 *
 * Copyright (c) arnars12, axelg12, gadidjah12, gunnarsa12, haraldurs12, solberg12 
 */
package is.ru.ttt;
import java.util.ArrayList;

/**
 * [lýsing]
 *
 * @author arnars12, axelg12, gadidjah12, gunnarsa12, haraldurs12, solberg12  
 * @version 1, 20 November 2013
 */

public class Player
{

	private String playerName;
	private Boolean myTurn;
	ArrayList<Integer> inserted = new ArrayList<Integer>();
	
	/**
	 * [Player description]
	 * @return [description]
	 */
	public Player()
	{
		playerName = null;
		myTurn = null;
	}

	/**
	 * [Player description]
	 * @param  name [description]
	 * @param  turn [description]
	 * @return      [description]
	 */
	public Player(String name, Boolean turn)
	{
		playerName = name;
		myTurn = turn;
	}

	/**
	 * [getPlayerName description]
	 * @return [description]
	 */
	public String getPlayerName()
	{
		return this.playerName;
	}
	
	/**
	 * [getTurn description]
	 * @return [description]
	 */
	public Boolean getTurn()
	{
		return this.myTurn;
	}

	/**
	 * [turn description]
	 */
	public void turn()
	{
		myTurn = !myTurn;
	}

	/**
	 * [insertIntoTable description]
	 * @param  cell                     [description]
	 * @throws OutOfBoundsException     [description]
	 * @throws AlreadyOccupiedException [description]
	 */
	public void insertIntoTable(int cell) throws OutOfBoundsException, AlreadyOccupiedException
	{
		if(cell >= 0 && cell < 9)
		{
				if(!inserted.contains(cell))
				{
					inserted.add(cell);
				}
				else
				{
					throw new AlreadyOccupiedException("Cell is already occupied");
				}

		}
		else
		{
			throw new OutOfBoundsException("Input out of bounds");
		}
	}

	/**
	 * [getInserted description]
	 * @return [description]
	 */
	public ArrayList<Integer> getInserted()
	{
		return inserted;
	}

	/**
	 * [toJson description]
	 * @return [description]
	 */
	public String toJson()
	{
		String json = ":\"" + playerName + "\"}";
		return json;
	}
}