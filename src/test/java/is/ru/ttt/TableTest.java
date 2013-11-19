package is.ru.ttt;


import static org.junit.Assert.assertEquals;


import org.junit.Test;

public class TableTest{

	@Test
	public void TestInitializeTable(){
		Table table = new Table();
		char[] testTable = new char[9];
		for (int i = 0; i < 9; i++) {
			testTable[i] = "E";
		}
		assertEquals(testTable, table.InitializeTable());
	}
}