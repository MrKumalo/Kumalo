package is.ru.ttt;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.*;

import org.junit.Test;


public class TableTest {


    @Test
    public void EmptyTable() {
    	Table t = new Table();
       	for(int i = 0; i < 9; i++)
       	{
       		assertEquals('E', t.getTable(i));
       	}
    }

    @Test
    public void EmptyTableWhole() {
    	Table t = new Table();
    	char[] test = new char[9];

    	for(int i = 0; i < 9; i++)
		{
			test[i] = 'E';
		}
       	assertArrayEquals(test,t.getFullTable());
    }

    @Test
    public void TableInsert() {
    	Table t = new Table();
    	char[] test = new char[9];

    	for(int i = 0; i < 9; i++)
		{
			if(i == 1 || i == 4 || i == 7)
			{
				test[i] = 'X';
			}
			else 
			{
				test[i] = 'E';
			}
		}

    	t.setX('X', 1);
    	t.setX('X', 4);
    	t.setX('X', 7);
       	assertArrayEquals(test,t.getFullTable());
    }

}