package ru.ashabalin.models;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * @author Aleksei Shabalin on 20.09.2016.
 */
public class RookTest {

	Rook testRookWhite = new Rook("Rook", "White");
	Rook testRookBlack = new Rook("Rook", "Black");

	@Test
	public void whenMoveWhiteRookVertical() throws Exception {

		boolean testStep = this.testRookWhite.move(7, 0, 0, 0);

		boolean expect = true;

		assertEquals(expect, testStep);
	}

	@Test
	public void whenMoveWhiteRookHorizontal() throws Exception {

		boolean testStep = this.testRookWhite.move(7, 0, 7, 7);

		boolean expect = true;

		assertEquals(expect, testStep);
	}

	@Test
	public void whenMoveWhiteRookDiagonal() throws Exception {

		boolean testStep = this.testRookWhite.move(7, 0, 0, 7);

		boolean expect = false;

		assertEquals(expect, testStep);
	}

	@Test
	public void whenMoveBlackRookVertical() throws Exception {

		boolean testStep = this.testRookBlack.move(0, 0, 7, 0);

		boolean expect = true;

		assertEquals(expect, testStep);
	}

	@Test
	public void whenMoveBlackRookHorizontal() throws Exception {

		boolean testStep = this.testRookBlack.move(0, 0, 0, 7);

		boolean expect = true;

		assertEquals(expect, testStep);
	}

	@Test
	public void whenMoveBlackRookDiagonal() throws Exception {

		boolean testStep = this.testRookBlack.move(0, 0, 7, 7);

		boolean expect = false;

		assertEquals(expect, testStep);
	}

}