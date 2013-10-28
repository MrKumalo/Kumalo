package is.ru.hbfraedi.TTT;
import is.ru.hbfraedi.TTT.Exception.XOException;

public class Player 
{
	char x_o;
	String name;

	public Player(char x_o, String name) throws XOException
	{
		if(x_o == 'x' || x_o == 'o' || x_o == 'X' || x_o == 'O')
			this.x_o = x_o;
		else
			throw new XOException("Illegal X/O value");
		this.name = name;
	}	

	public void setXo(char x_o) throws XOException
	{
		if(x_o == 'x' || x_o == 'o' || x_o == 'X' || x_o == 'O')
			this.x_o = x_o;
		else
			throw new XOException("Illegal X/O value");
	}

	public char getXo()
	{
		return this.x_o;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public String getName()
	{
		return this.name;
	}
}