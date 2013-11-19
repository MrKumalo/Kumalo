package is.ru.ttt;

public class Player{

	private String player;
	private Boolean myTurn;

	public Player(String playerName, Boolean turn)
	{
		player = playerName;
		myTurn = turn;
	}
	public String getPlayer()
	{
		return player;
	}
	
	public Boolean getTurn()
	{
		return myTurn;
	}
	
}