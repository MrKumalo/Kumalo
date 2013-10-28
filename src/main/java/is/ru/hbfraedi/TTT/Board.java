package is.ru.hbfraedi.TTT;

public class Board
{
    private char[] board = new char[9];

    public Board()
    {
        reset();
    }

    public boolean setCell(int cellID, char XO)
    {
        if(isCellEmpty(cellID) && cellID > 0 && cellID < 10 && (XO == 'X'  || XO == 'O' || XO == 'x'  || XO == 'o'))
        {
            if(XO == 'X'  || XO == 'x' )
            {
                board[cellID-1] = 'X';
                return true;
            }
            else if(XO == 'O' || XO == 'o' )
            {
                board[cellID-1] = 'O';
                return true;
            }
        }
        return false;
    }

    public boolean isCellEmpty(int cellID)
    {
        if(board[cellID-1] == Character.forDigit(cellID, 10))
        {
            return true;
        }
        else
        {
            return false;
        }
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
        out += "\n";
        return out;
    }
}
