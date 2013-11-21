package is.ru.ttt;

import static org.junit.Assert.*;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.*;
import java.util.ArrayList;


import org.junit.Test;

public class PlayerTest{

	@Test
	public void playerNameTest()
	{
		Player player1 = new Player("Halli", true);
		 assertEquals("Halli", player1.getPlayerName());
	}

	@Test
	public void isMyTurnTest()
	{
		Player player2 = new Player("Bull", true);
		assertEquals(true, player2.getTurn());
	}

	@Test
	public void turnTwoPlayerTest()
	{
		Player player1 = new Player("p1", true);
		Player player2 = new Player("p2", false);
		assertTrue(player1.getTurn());
		assertFalse(player2.getTurn());
	}
	@Test
	public void defaultConsTest()
	{
		Player p1 = new Player();
		assertEquals(null, p1.getPlayerName());
		assertEquals(null, p1.getTurn());
		assertEquals(0, p1.getInserted().size());
	}
	@Test
	public void turnTest()
	{
		Player player1 = new Player("p1", true);
		Player player2 = new Player("p2", false);
		assertTrue(player1.getTurn());
		assertFalse(player2.getTurn());
		player1.turn();
		assertFalse(player1.getTurn());
		player2.turn();
		assertTrue(player2.getTurn());
	}

	@Test
	public void insertIntoTableTest()
	{
		try
		{
			Player p1 = new Player("p1", true);
			Player p2 = new Player("p2", false);
			ArrayList<Integer> test = new ArrayList<Integer>();
			test.add(1);
			p1.insertIntoTable(1);
			assertArrayEquals(test.toArray(), p1.getInserted().toArray());
			test.add(2);
			test.add(3);
			p1.insertIntoTable(2);
			p1.insertIntoTable(3);
			assertArrayEquals(test.toArray(), p1.getInserted().toArray());

			ArrayList<Integer> test2 = new ArrayList<Integer>();
			test2.add(1);
			p2.insertIntoTable(1);
			assertEquals(test2.toArray(), p2.getInserted().toArray());
			p2.insertIntoTable(1);
			assertEquals(test2.toArray(), p2.getInserted().toArray());
		}
		catch(OutOfBoundsException e)
		{
			System.out.println("This should not happen");
		}
		catch (AlreadyOccupiedException e)
  		{
  			System.out.println("This should not happen");
  		}
		
	}

	@Test
	public void outOfBoundsExceptionTest() 
	{
	  	try 
	  	{
	    	Player p1 = new Player("p1", true);
	    	p1.insertIntoTable(11);
	  	} 
	  	catch (OutOfBoundsException e) 
	  	{
	    	assertEquals(e.getMessage(), "Input out of bounds");
	  	}
	  	catch (AlreadyOccupiedException e)
	  	{
	  		System.out.println("This should not happen");
	  	}
	}
	@Test
	public void alreadyOccupiedExceptionTest() 
	{
	  	try 
	  	{
	    	Player p1 = new Player("p1", true);
	    	p1.insertIntoTable(1);
	    	p1.insertIntoTable(1);
	  	} 
	  	catch (OutOfBoundsException e) 
	  	{
	    	System.out.println("This should not happen");
	  	}
	  	catch (AlreadyOccupiedException e)
	  	{
	  		assertEquals(e.getMessage(), "Cell is already occupied");
	  	}
	}
	
	@Test
	public void toJsonTest()
	{
		Player p1 = new Player("Mario", true);
		String jsonTest = "{:\"Mario\"}";
		assertEquals(p1.toJson(), jsonTest);
	}

}