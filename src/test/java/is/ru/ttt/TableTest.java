package is.ru.ttt;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.*;

import org.junit.Test;

public class TableTest {

    @Test
    public void EmptyTable() 
    {
    	Table t = new Table();
       	for(int i = 0; i < 9; i++)
       	{
       		assertEquals('E', t.getTable(i));
       	}
    }

    @Test
    public void EmptyTableWhole() 
    {
    	Table t = new Table();
    	char[] test = new char[9];

    	for(int i = 0; i < 9; i++)
  		{
  		  test[i] = 'E';
  		}
        assertArrayEquals(test,t.getFullTable());
      }

    @Test
    public void TableInsert() 
    {
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

    @Test
    public void toJsonTest()
    {
      Table t = new Table();

      for (int i = 0; i < 9; i++) 
      {
        if(i == 1)
        {
          t.setX('X', i);
        } 
        else
        {
          t.setX('E', i);
        }
      }
      String jsonTest = "{\"cell0\":\"E\"},{\"cell1\":\"X\"},{\"cell2\":\"E\"},{\"cell3\":\"E\"},{\"cell4\":\"E\"},{\"cell5\":\"E\"},{\"cell6\":\"E\"},{\"cell7\":\"E\"},{\"cell8\":\"E\"}";
      assertEquals(jsonTest, t.toJson());
    }

    @Test
    public void toJsonFullTest()
    {
      Table t = new Table();

      for (int i = 0; i < 9; i++) 
      {
        if(i == 1)
        {
          t.setX('X', i);
        } 
        else if(i == 2)
        {
          t.setX('O', i);
        }
        else
        {
          t.setX('E', i);
        }
      }
      String jsonTest = "{\"cell0\":\"E\"},{\"cell1\":\"X\"},{\"cell2\":\"O\"},{\"cell3\":\"E\"},{\"cell4\":\"E\"},{\"cell5\":\"E\"},{\"cell6\":\"E\"},{\"cell7\":\"E\"},{\"cell8\":\"E\"}";
      assertEquals(jsonTest, t.toJson());
    }

    @Test
    public void toJsonExtraTest()
    {
      Table t = new Table();

      for (int i = 0; i < 9; i++) 
      {
        if(i == 0 || i == 4 || i == 8)
        {
          t.setX('X', i);
        } 
        else if(i == 2 || i == 5 || i == 6)
        {
          t.setX('O', i);
        }
        else
        {
          t.setX('E', i);
        }
      }
      String jsonTest = "{\"cell0\":\"X\"},{\"cell1\":\"E\"},{\"cell2\":\"O\"},{\"cell3\":\"E\"},{\"cell4\":\"X\"},{\"cell5\":\"O\"},{\"cell6\":\"O\"},{\"cell7\":\"E\"},{\"cell8\":\"X\"}";
      assertEquals(jsonTest, t.toJson());
    }
}
