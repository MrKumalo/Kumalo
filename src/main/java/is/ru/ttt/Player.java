package is.ru.ttt;
import java.util.ArrayList;

public class Player
{

	private int turnCount;
	private String playerName;
	private Boolean myTurn;
	ArrayList<Integer> inserted = new ArrayList<Integer>();
	public Player(String name, Boolean turn)
	{
		playerName = name;
		myTurn = turn;
		turnCount = 0;
	}
	public String getPlayerName()
	{
		return this.playerName;
	}
	
	public Boolean getTurn()
	{
		return this.myTurn;
	}
	public void turn()
	{
		myTurn = !myTurn;
	}
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
	public ArrayList<Integer> getInserted()
	{
		return inserted;
	}

	public String toJson()
	{
		String json = "{\"Player1\":\"" + playerName + "\"}";
		return json;
	}
}