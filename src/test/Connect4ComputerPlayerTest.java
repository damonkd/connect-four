package test;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import core.*;

import core.Connect4;

class Connect4ComputerPlayerTest {
	private static Connect4ComputerPlayer c1,c2,c3;
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		Connect4 c1 = new Connect4();
		Connect4 c2 = new Connect4();
		Connect4 c3 = new Connect4();
	
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
		c1 = null;
		c2 = null;
		c3 = null;
	
	}

	@BeforeEach
	void setUp() throws Exception {
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	final void testIsComputerPlay() {
		assertTrue(c1.isComputerPlay() == false);
		assertTrue(c2.isComputerPlay() == false);// TODO
	}

	@Test
	final void testSetIsComputerPlay() {
		c1.setIsComputerPlay(); // TODO
	}

	@Test
	final void testCheck3InRow() {
		assertTrue(c1.check3InRow() == 20);
		assertTrue(c2.check3InRow() == 20); // TODO
	}

	@Test
	final void testWin3InRow() {
		assertTrue(c1.win3InRow() == 20);
		assertTrue(c2.win3InRow() == 20);// TODO
	}

	@Test
	final void testComputerMove() {
		assertTrue(c1.computerMove() == 4);
	}

	@Test
	final void testConnect4() {
		assertNotNull(c1);
		assertNotNull(c2);
		assertNotNull(c3);
	}

	@Test
	final void testPrintGame() {
		fail("Junit does not contain a method to handle print to console");
	}

	@Test
	final void testMove() {
		c1.move(2, 2);
		c2.move(1, 1);
		c3.move(5, 2);// TODO
	}

	@Test
	final void testMoveGUI() {
		assertTrue(c1.moveGUI(2,1) == 5);
		assertTrue(c1.moveGUI(2,2) == 4);// TODO
	}

	@Test
	final void testWinner() {
		assertTrue(c1.winner(2) == false); 
		assertTrue(c2.winner(1) == false);// TODO
	}

	@Test
	final void testColumnFull() {
		assertTrue(c2.columnFull(1) == false);
		assertTrue(c2.columnFull(3) == false);
		assertTrue(c2.columnFull(5) == false);// TODO
	}

	@Test
	final void testColumnHeight() {
		assertTrue(c2.columnHeight(3) == 5);
		assertTrue(c3.columnHeight(5) == 5);
		assertTrue(c3.columnHeight(1) == 5);// TODO
	}

	@Test
	final void testBoardFull() {
		assertTrue(c1.boardFull() == false);
		assertTrue(c2.boardFull() == false);
		assertTrue(c3.boardFull() == false);// TODO
	}

	@Test
	final void testGetBoard() {
		assertNotNull(c1.getBoard());
		assertNotNull(c2.getBoard());
		assertNotNull(c3.getBoard());// TODO
	}

}
