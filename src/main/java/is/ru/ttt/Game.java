package is.ru.ttt;

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
		if(turn != 1 || turn != 2)
			throw new IllegalTurnException("Turn must be either 1 (Player 1) or 2 (Player 2)");

		this.turn = turn;
	}

	public Game()
	{
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
		if(turn != 1 || turn != 2)
			throw new IllegalTurnException("Turn must be either 1 (Player 1) or 2 (Player 2)");

		this.turn = turn;
	}

	public String toJson()
	{
		String json = "[";
		json += table.toJson();
		json += ",";
		json += p1.toJson();
		json += ",";
		json += p2.toJson();
		json += ",{\"turn\":\"" + turn + "\"}";
		json += "]";

		return json;
	}
}