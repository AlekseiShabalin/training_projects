package ru.ashabalin.models;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * @author Aleksei Shabalin on 20.09.2016.
 */
public class BishopTest {

	Bishop testBishopWhite = new Bishop("Bishop", "White");

	@Test
	public void whenMoveWhiteBishopDiagonal() throws Exception {
		boolean testStep1 = this.testBishopWhite.move(7, 2, 2, 7);
		boolean testStep2 = this.testBishopWhite.move(7, 2, 5, 0);

		boolean expect = true;

		assertEquals(expect, testStep1);
		assertEquals(expect, testStep2);

	}

	@Test
	public void whenWhiteBishopTryMoveVerticalOrHorizontal() throws Exception {
		boolean testStepVertical = this.testBishopWhite.move(7, 5, 0, 5);
		boolean testStepHorizontal = this.testBishopWhite.move(7, 5, 7, 0);

		boolean expect = false;

		assertEquals(expect, testStepVertical);
		assertEquals(expect, testStepHorizontal);

	}

}