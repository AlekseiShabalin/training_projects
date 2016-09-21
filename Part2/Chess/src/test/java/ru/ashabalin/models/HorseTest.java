package ru.ashabalin.models;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * @author Aleksei Shabalin on 20.09.2016.
 */
public class HorseTest {

	Horse testHorseWhite = new Horse("Horse", "White");

	@Test
	public void whenHorseTryMove() throws Exception {
		boolean testStep = this.testHorseWhite.move(7, 1, 5, 2);

		boolean expect = true;

		assertEquals(expect, testStep);
	}

	@Test
	public void whenHorseTryMoveNotRightStep() throws Exception {
		boolean testStep = this.testHorseWhite.move(7, 1, 6, 2);

		boolean expect = false;

		assertEquals(expect, testStep);
	}

}