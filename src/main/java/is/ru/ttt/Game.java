/*
* @(#)Game.java 1, 18 Nov 2013
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
public class Game {
	private Player p1;
	private Player p2;
	private Table table;
	private int turn;

	public Game(Player p1, Player p2, Table table, int turn) throws IllegalTurnException
	{
		this.p1 = p1;
		this.p2 = p2;
		this.table = table;
		if(turn != 1 && turn != 2)
			throw new IllegalTurnException("Turn must be either 1 (Player 1) or 2 (Player 2)");

		this.turn = turn;
	}

	public Game()
	{
		p1 = null;
		p2 = null;
		table = null;
		turn = -1;
	}

	public Player getP1()
	{
		return this.p1;
	}

	public Player getP2()
	{
		return this.p2;
	}

	public Table getTable()
	{
		return this.table;
	}

	public int getTurn()
	{
		return this.turn;
	}

	public void setP1(Player p1)
	{
		this.p1 = p1;
	}

	public void setP2(Player p2)
	{
		this.p2 = p2;
	}

	public void setTable(Table table)
	{
		this.table = table;
	}	

	public void setTurn(int turn) throws IllegalTurnException
	{
		if(turn != 1 && turn != 2)
			throw new IllegalTurnException("Turn must be either 1 (Player 1) or 2 (Player 2)");

		this.turn = turn;
	}

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

	public String toJson()
	{
		String json = "[";
		json += table.toJson();
		json += ",{\"Player1\"";
		json += p1.toJson();
		json += ",{\"Player2\"";
		json += p2.toJson();
		json += ",{\"turn\":\"" + turn + "\"}";
		json += "]";

		return json;
	}
}