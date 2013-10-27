public class Board
{
    private char[] board = new char[9];

    public Board()
    {
        reset();
    }

    public boolean setCell(int cellID, char XO)
    {
        if(board[cellID] != ' ' && cellID > 0 && cellID < 10 && (XO == 'X'  || XO == 'O'))
        {
            board[cellID-1] = XO;
            return true;
        }
        return false;
    }

    public void reset()
    {
        for(int i=0; i < 9; i++)
        {
            board[i] =  Character.forDigit(i+1, 10);
        }
    }

    @Override
    public String toString()
    {
        String out = "";
        for(int i=0; i < 9; i++)
        {
            out += board[i];
            out += ' ';
            if(i == 2 || i == 5 )
            {
                out += "\n";
            }
        }
        return out;
    }
}
