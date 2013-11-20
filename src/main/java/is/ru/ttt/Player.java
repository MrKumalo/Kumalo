package is.ru.ttt;
import java.util.ArrayList;

public class Player
{
	private int turnCount;
	private String player;
	private Boolean myTurn;
	ArrayList<Integer> inserted = new ArrayList<Integer>();
	public Player(String playerName, Boolean turn)
	{
		player = playerName;
		myTurn = turn;
		turnCount = 0;
	}
	public String getPlayer()
	{
		return this.player;
	}
	
	public Boolean getTurn()
	{
		return this.myTurn;
	}
	public void turn()
	{
		myTurn = !myTurn;
	}
	public void insertIntoTable(int cell)
	{
		if(cell >= 0 && cell < 9)
		{
			if(!inserted.contains(cell))
			{
				inserted.add(cell);
			}
		}
	}
	public ArrayList<Integer> getInserted()
	{
		return inserted;
	}
}