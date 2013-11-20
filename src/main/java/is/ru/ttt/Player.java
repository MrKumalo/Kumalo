package is.ru.ttt;

public class Player
{
	private int turnCount;
	private String player;
	private Boolean myTurn;

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
		turnCount++;
		myTurn = !myTurn;
	}
	public int getTurnCount()
	{
		return turnCount;
	}
}