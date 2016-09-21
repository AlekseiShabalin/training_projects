package ru.ashabalin.models;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author Aleksei Shabalin on 08.09.2016.
 */
public class BoardTest {

    Board testBoard = new Board();

    @Test
    public void testFillBoard() throws Exception {
        testBoard.fillBoard();


        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
               assertNotNull(testBoard.getSpots()[i][j]);
            }
        }
    }

    @Test
    public void testTakeCell()  throws Exception {
        testBoard.fillBoard();
        testBoard.getSpots()[1][1].takeSpot(testBoard.getSpots(), 3, 1);

        assertNull(testBoard.getSpots()[1][1].getFigure());
        assertNotNull(testBoard.getSpots()[3][1].getFigure());
    }

    @Test
    public void testCheckPositionWhiteFigure() {
        testBoard.fillBoard();

        String testColorFigure = "White";
        String testFigureRook = "Rook";
        String testFigureHorse = "Horse";
        String testFigureBishop = "Bishop";
        String testFigureQueen = "Queen";
        String testFigureKing = "King";
        String testFigurePawn = "Pawn";

        for (int i = 7; i < 5; i--) {
            for (int j = 0; j < 8; j++) {
                assertEquals(testColorFigure, testBoard.getSpots()[i][j].getFigure().getColor());
            }
        }

        for (int i = 0; i < 8; i++) {
            assertEquals(testFigurePawn, testBoard.getSpots()[6][i].getFigure().getName());
            }

        assertEquals(testFigureRook, testBoard.getSpots()[7][0].getFigure().getName(), testBoard.getSpots()[7][7].getFigure().getName());
        assertEquals(testFigureHorse, testBoard.getSpots()[7][1].getFigure().getName(), testBoard.getSpots()[7][6].getFigure().getName());
        assertEquals(testFigureBishop, testBoard.getSpots()[7][2].getFigure().getName(), testBoard.getSpots()[7][5].getFigure().getName());
        assertEquals(testFigureQueen, testBoard.getSpots()[7][3].getFigure().getName());
        assertEquals(testFigureKing, testBoard.getSpots()[7][4].getFigure().getName());
    }

    @Test
    public void testCheckPositionBlackFigure() throws Exception{
        testBoard.fillBoard();

        String testColorFigure = "Black";
        String testFigureRook = "Rook";
        String testFigureHorse = "Horse";
        String testFigureBishop = "Bishop";
        String testFigureQueen = "Queen";
        String testFigureKing = "King";
        String testFigurePawn = "Pawn";

        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 8; j++) {
                assertEquals(testColorFigure, testBoard.getSpots()[i][j].getFigure().getColor());
            }
        }

        for (int i = 0; i < 8; i++) {
            assertEquals(testFigurePawn, testBoard.getSpots()[1][i].getFigure().getName());
            }

        assertEquals(testFigureRook, testBoard.getSpots()[0][0].getFigure().getName(), testBoard.getSpots()[0][7].getFigure().getName());
        assertEquals(testFigureHorse, testBoard.getSpots()[0][1].getFigure().getName(), testBoard.getSpots()[0][6].getFigure().getName());
        assertEquals(testFigureBishop, testBoard.getSpots()[0][2].getFigure().getName(), testBoard.getSpots()[0][5].getFigure().getName());
        assertEquals(testFigureQueen, testBoard.getSpots()[0][3].getFigure().getName());
        assertEquals(testFigureKing, testBoard.getSpots()[0][4].getFigure().getName());
    }

    @Test
    public void whenFigureMoveAndTakeEnemyFigure()throws Exception{
        testBoard.fillBoard();

        // move White Pawn
        testBoard.getSpots()[6][1].takeSpot(testBoard.getSpots(), 4, 1);

        assertNull(testBoard.getSpots()[6][1].getFigure());
        assertNotNull(testBoard.getSpots()[4][1].getFigure());
        assertEquals("White", testBoard.getSpots()[4][1].getFigure().getColor());

        // move Black Pawn
        testBoard.getSpots()[1][0].takeSpot(testBoard.getSpots(), 3, 0);

        assertNull(testBoard.getSpots()[1][0].getFigure());
        assertNotNull(testBoard.getSpots()[3][0].getFigure());
        assertEquals("Black", testBoard.getSpots()[3][0].getFigure().getColor());

        // move White Pawn and take Black Pawn
        testBoard.getSpots()[4][1].takeSpot(testBoard.getSpots(), 3, 0);

        assertNull(testBoard.getSpots()[4][1].getFigure());
        assertNotNull(testBoard.getSpots()[3][0].getFigure());
        assertEquals("White", testBoard.getSpots()[3][0].getFigure().getColor());

        // move Black Rook and take White Pawn
        testBoard.getSpots()[0][0].takeSpot(testBoard.getSpots(), 3, 0);

        assertNull(testBoard.getSpots()[0][0].getFigure());
        assertNotNull(testBoard.getSpots()[3][0].getFigure());
        assertEquals("Black", testBoard.getSpots()[3][0].getFigure().getColor());
        assertEquals("Rook", testBoard.getSpots()[3][0].getFigure().getName());
    }

    @Test
    public void whenMoveHorse()throws Exception {
        testBoard.fillBoard();

        // move White Horse
        testBoard.getSpots()[7][6].takeSpot(testBoard.getSpots(), 5, 5);

        assertNull(testBoard.getSpots()[7][6].getFigure());
        assertNotNull(testBoard.getSpots()[5][5].getFigure());
        assertEquals("White", testBoard.getSpots()[5][5].getFigure().getColor());
        assertEquals("Horse", testBoard.getSpots()[5][5].getFigure().getName());
    }

    @Test
    public void whenFigureTryTakeFigureTheSameColor() {
        testBoard.fillBoard();

        String expectMessage = "You made a wrong step!";

        // move White Horse
        testBoard.getSpots()[7][6].takeSpot(testBoard.getSpots(), 5, 5);

        // move White Pawn and take White Horse
        testBoard.getSpots()[6][4].takeSpot(testBoard.getSpots(), 5, 5);

        assertEquals(expectMessage, "You made a wrong step!");
    }

}