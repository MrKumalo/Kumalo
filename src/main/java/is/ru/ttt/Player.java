package is.ru.ttt;

public class Player
{

	private String player;
	private Boolean myTurn;

	public Player(String playerName, Boolean turn)
	{
		player = playerName;
		myTurn = turn;
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

	
}