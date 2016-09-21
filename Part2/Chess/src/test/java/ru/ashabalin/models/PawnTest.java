package ru.ashabalin.models;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author Aleksei Shabalin on 15.09.2016.
 */
public class PawnTest {

    Pawn pawnWhite = new Pawn("Pawn", "White");
    Pawn pawnBlack = new Pawn("Pawn", "Black");

    @Test
    public void whenDoNotMoveFirstStep() throws Exception {
        boolean testStep = this.pawnWhite.move(7, 0, 5, 0);

        boolean expect = true;

        assertEquals(expect, testStep);
    }

    @Test
    public void whenDoMoveFirstStep() throws Exception {
        this.pawnWhite.move(7, 0, 5, 0);
        boolean testStep = this.pawnWhite.move(5, 0, 3, 0);

        boolean expect = false;

        assertEquals(expect, testStep);
    }

    @Test
    public void whenWhitePawnTryBackStep() throws Exception {
        boolean testStep = this.pawnWhite.move(6, 0, 7, 0);

        boolean expect = false;

        assertEquals(expect, testStep);
    }

    @Test
    public void whenBlackPawnTryBackStep() throws Exception {
        boolean testStep = this.pawnBlack.move(1, 0, 0, 0);

        boolean expect = false;

        assertEquals(expect, testStep);
    }

    @Test
    public void whenWhitePawnTryDiagonalStep() throws Exception {
        boolean testRightStep = this.pawnWhite.move(6, 0, 5, 1);
        boolean testNotRightStep = this.pawnWhite.move(6, 0, 7, 1);

        boolean expectRightStep = true;
        boolean expectNotRightStep = false;

        assertEquals(expectRightStep, testRightStep);
        assertEquals(expectNotRightStep, testNotRightStep);
    }

    @Test
    public void whenBlacPawnTryDiagonalStep() throws Exception {
        boolean testRightStep = this.pawnBlack.move(1, 3, 2, 2);
        boolean testNotRightStep = this.pawnBlack.move(1, 3, 0, 4);

        boolean expectRightStep = true;
        boolean expectNotRightStep = false;

        assertEquals(expectRightStep, testRightStep);
        assertEquals(expectNotRightStep, testNotRightStep);
    }


}