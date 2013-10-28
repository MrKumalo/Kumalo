public class XOException extends Exception 
{
	public XOException()
	{

	}	

	public XOException(String s)
	{
		super(s);
	}

	public XOException(String s, Throwable throwable)
	{
		super(s, throwable);
	}
}