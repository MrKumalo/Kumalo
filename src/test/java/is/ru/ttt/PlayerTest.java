package is.ru.ttt;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.*;
import java.util.ArrayList;


import org.junit.Test;

public class PlayerTest{

	@Test
	public void playerName()
	{
		Player player1 = new Player("Halli", true);
		 assertEquals("Halli", player1.getPlayer());
	}
	@Test
	public void isMyTurn()
	{
		Player player2 = new Player("Bull", true);
		assertEquals(true, player2.getTurn());
	}
	@Test
	public void TurnTwoPlayer()
	{
		Player player1 = new Player("p1", true);
		Player player2 = new Player("p2", false);
		assertTrue(player1.getTurn());
		assertFalse(player2.getTurn());
	}
	@Test
	public void TurnTest()
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
		p1.insertIntoTable(10);
		assertEquals(test.toArray(), p1.getInserted().toArray());


		ArrayList<Integer> test2 = new ArrayList<Integer>();
		test2.add(1);
		p2.insertIntoTable(1);
		assertEquals(test2.toArray(), p2.getInserted().toArray());
		p2.insertIntoTable(1);
		assertEquals(test2.toArray(), p2.getInserted().toArray());
	}
}