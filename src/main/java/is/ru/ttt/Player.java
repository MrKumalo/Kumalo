/**
 * @(#)Player.java 1, 18 Nov 2013
 *
 * Copyright (c) arnars12, axelg12, gadidjah12, gunnarsa12, haraldurs12, solberg12 
 */
package is.ru.ttt;
import java.util.ArrayList;

/**
 * The Player class maintains the players.
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
	 * The player function is the default constructor for the class. The function initializes the playername and myturn variables.
	 */
	public Player()
	{
		playerName = null;
		myTurn = null;
	}

	/**
	 * The player function is another constructor which takes in two variables creates a player.
	 * @param  name Name of the player.
	 * @param  turn Specifies if it's this players turn to play or not.
	 */
	public Player(String name, Boolean turn)
	{
		playerName = name;
		myTurn = turn;
	}

	/**
	 * The getPlayerName function returns the player name.
	 * @return playername.
	 */
	public String getPlayerName()
	{
		return this.playerName;
	}
	
	/**
	 * The getTurn function returns true or false, which indicates if it's the player turn to play.
	 * @return myturn.
	 */
	public Boolean getTurn()
	{
		return this.myTurn;
	}

	/**
	 * 	The turn function updates the turn variable so that the player who just completed his turn will not
	 *	get another turn until the other player has finished his turn.
	 */
	public void turn()
	{
		myTurn = !myTurn;
	}

	/**
	 * The insertIntoTable function inserts a certain cell into an arraylist which maintains the cells for certain player.
	 * @param  cell                     Specifies a location on the game board.
	 * @throws OutOfBoundsException     This exception is thrown if the cell location is out of the board range.
	 * @throws AlreadyOccupiedException This exception is thrown if the cell is already occupied.
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
	 * The getInserted function returns the arraylist.
	 * @return arraylist.
	 */
	public ArrayList<Integer> getInserted()
	{
		return inserted;
	}

	/**
	 * The toJson function creates a json string and returns it.
	 * @return json string.
	 */
	public String toJson()
	{
		String json = ":\"" + playerName + "\"}";
		return json;
	}
}