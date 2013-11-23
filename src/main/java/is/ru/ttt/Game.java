/**
 * @(#)Game.java 1, 18 Nov 2013
 *
 * Copyright (c) arnars12, axelg12, gadidjah12, gunnarsa12, haraldurs12, solberg12 
 */
package is.ru.ttt;

import java.util.ArrayList;

/**
 * The Game class maintains the game, players and table.
 *
 * @author arnars12, axelg12, gadidjah12, gunnarsa12, haraldurs12, solberg12  
 * @version 1, 20 November 2013
 */
public class Game {
	private Player p1;
	private Player p2;
	private Table table;
	private int turn;
	private int turnCounter;

	/**
	 *	This constructor takes in 4 variables and initializes them.
	 *
	 * @param	p1 						Intance of player.
 	 * @param	p2 						Intance of player.
	 * @param	table 					Intance of table.
	 * @param	turn 					Indicates which player can play.
	 * @throws	IllegalTurnException	This exception is thrown if turn is not 1 or 2.
	 */

	public Game(Player p1, Player p2, Table table, int turn) throws IllegalTurnException
	{
		turnCounter = 0;
		this.p1 = p1;
		this.p2 = p2;
		this.table = table;
		if(turn != 1 && turn != 2)
			throw new IllegalTurnException("Turn must be either 1 (Player 1) or 2 (Player 2)");

		this.turn = turn;
	}

	/**
	 *	This is the default constructor, which initializes the variables.
	 */
	public Game()
	{
		p1 = null;
		p2 = null;
		table = null;
		turn = -1;
	}

	/**
	 * The setCounter function changes the counter variable which is used to determine if the game is a draw.
	 * @param	counter 	This variable counts the turns already played.
	 */
	public void setCounter(int counter)
	{
		this.turnCounter = counter;
	} 

	/**
	 * The getTurnCounter function returns the turnCounter which holds the info on turns played.
	 * @return 	turnCounter variable.
	 */
	public int getTurnCounter()
	{
		return this.turnCounter;
	}

	/**
	 * The getP1 function returns player1.
	 * @return 	player1
	 */
	public Player getP1()
	{
		return this.p1;
	}

	/**
	 * The getP1 function returns player2.
	 * @return 	player2.
	 */
	public Player getP2()
	{
		return this.p2;
	}

	/**
	 * The addCounter function increases the counter variable by 1.
	 */
	public void addCounter()
	{
		this.turnCounter++;
	}

	/**
	 * The getTable function returns the current gametable.
	 * @return 	table.
	 */
	public Table getTable()
	{
		return this.table;
	}

	/**
	 * The getTurn function returns the current turn.
	 * @return 	turn.
	 */
	public int getTurn()
	{
		return this.turn;
	}

	/**
	 * The setP1 function sets player1 as p1 in the game.
	 * @param p1 	player1 intance
	 */
	public void setP1(Player p1)
	{
		this.p1 = p1;
	}

	/**
	 * The setP2 function sets player2 as p2 in the game.
	 * @param p2 	player2 intance
	 */
	public void setP2(Player p2)
	{
		this.p2 = p2;
	}

	/**
	 * The setTable function sets table as current table.
	 * @param table 	table instance
	 */
	public void setTable(Table table)
	{
		this.table = table;
	}

	/**
	 * The setTurn function sets the current turn.
	 * @param turn 	current turn
	 * @throws IllegalTurnException 	This exception is thrown if turn is not 1 or 2.
	 */	
	public void setTurn(int turn) throws IllegalTurnException
	{
		if(turn != 1 && turn != 2)
			throw new IllegalTurnException("Turn must be either 1 (Player 1) or 2 (Player 2)");

		this.turn = turn;
	}

	/**
	 * The winningCombinations function is a boolean function which defines how a player can win the game.
	 * @return boolean true.
	 * @param 	cells 		Arraylist for cells combinations that can win the game.
	 */
	public Boolean winningCombinations(ArrayList<Integer> cells)
	{
		if(cells.contains(0) && cells.contains(1) && cells.contains(2))
			return true;

		if(cells.contains(3) && cells.contains(4) && cells.contains(5))
	 		return true;

	 	if(cells.contains(6) && cells.contains(7) && cells.contains(8))
	  		return true;

		if(cells.contains(0) && cells.contains(4) && cells.contains(8))
			return true;

		if(cells.contains(2) && cells.contains(4) && cells.contains(6))
			return true;

		if(cells.contains(0) && cells.contains(3) && cells.contains(6))
			return true;

		if(cells.contains(1) && cells.contains(4) && cells.contains(7))
			return true;

		if(cells.contains(2) && cells.contains(5) && cells.contains(8))
			return true;

		return false;
	}

	/**
	 * The toJson function creates a json string and returns it.
	 * @return json string
	 */
	public String toJson()
	{
		String json = "[";
		json += table.toJson();
		json += ",{\"Player1\"";
		json += p1.toJson();
		json += ",{\"Player2\"";
		json += p2.toJson();
		json += ",{\"turn\":" + turn + "}";
		json += "]";

		return json;
	}
}