package ru.ashabalin.models;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * @author Aleksei Shabalin on 15.09.2016.
 */
public class FigureTest {
    Figure figure = new Figure("Figure", "White");

    @Test
    public void TestFigureWhenInputCoordinatsMoreSizeBoard() throws Exception{

        boolean expect = false;

        assertEquals(expect, this.figure.move(1, 8, 6, 4));
        assertEquals(expect, this.figure.move(1, 3, 1, 3));
    }

    @Test
    public void TestFigureWhenInputCoordinatsLessSizeBoard() throws Exception{

        boolean expect = true;

        assertEquals(expect, this.figure.move(1, 4, 6, 4));
    }

}