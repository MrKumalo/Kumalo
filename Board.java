public class Board
{
    private char[] board = new char[9];

    public Board()
    {
        reset();
    }

    public boolean setCell(int cellID, char XO)
    {
        if(board[cellID] != ' ')
        {
            board[cellID] = XO;
            return true;
        }
        return false;
    }

    public void reset()
    {
        for(int i=0; i < 10; i++)
        {
            board[i] =  ' ';
        }
    }

    @Override
    public String toString()
    {
        String out = "";
        for(int i=0; i < 10; i++)
        {
            out += board[i];
            if(i % 3 == 0)
            {
                out += "\n";
            }
        }
        return out;
    }
}
