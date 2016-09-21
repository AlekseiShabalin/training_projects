package ru.ashabalin.models;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * @author Aleksei Shabalin on 20.09.2016.
 */
public class QueenTest {

	Queen testQueen = new Queen("Queen", "White");

	@Test
	public void whenQueenDoesRightStep() throws Exception {
		boolean testVerticalStep = this.testQueen.move(7, 3, 0, 3);
		boolean testHorizontalStep = this.testQueen.move(7, 3, 7, 0);
		boolean testDiagonalStep = this.testQueen.move(7, 3, 4, 0);

		boolean expect = true;

		assertEquals(expect, testVerticalStep);
		assertEquals(expect, testHorizontalStep);
		assertEquals(expect, testDiagonalStep);
	}

	@Test
	public void whenQueenTryNotRightStep() throws Exception {
		boolean testStep = this.testQueen.move(7, 3, 3, 0);

		boolean expect = false;

		assertEquals(expect, testStep);
	}

}