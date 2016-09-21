package ru.ashabalin.models;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * @author Aleksei Shabalin on 20.09.2016.
 */
public class KingTest {

	King testWhiteKing = new King("King", "White");

	@Test
	public void whenKingMoveRightStep() throws Exception {
		boolean testVerticalStep = this.testWhiteKing.move(7, 4, 6, 4);
		boolean testHorizontalStep = this.testWhiteKing.move(7, 4, 7, 5);
		boolean testDiagonalStep = this.testWhiteKing.move(7, 4, 6, 5);

		boolean expect = true;

		assertEquals(expect, testVerticalStep);
		assertEquals(expect, testHorizontalStep);
		assertEquals(expect, testDiagonalStep);
	}

	@Test
	public void whenKingMoveTryNotRightStep() throws Exception {
		boolean testVerticalStep = this.testWhiteKing.move(7, 4, 5, 4);
		boolean testHorizontalStep = this.testWhiteKing.move(7, 4, 7, 6);
		boolean testDiagonalStep = this.testWhiteKing.move(7, 4, 5, 6);

		boolean expect = false;

		assertEquals(expect, testVerticalStep);
		assertEquals(expect, testHorizontalStep);
		assertEquals(expect, testDiagonalStep);
	}

}