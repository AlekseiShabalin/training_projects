package ru.ashabalin.models;

/**
 * Created by Aleksei Shabalin.
 */
 
public class Board {
	private final static int BOARD_SIZE = 8;

	//create game field
	private Spot[][] spots = new Spot[BOARD_SIZE][BOARD_SIZE];

	public Spot[][] getSpots() {
		return spots;
	}

	/**
	 * Method fill game field
 	 */

	public void fillBoard() {

		// add Spot
		for (int i = 0; i < spots.length; i++) {
			for (int j = 0; j < spots.length; j++) {
				spots[i][j] = new Spot(i, j);
			}
		}

		// add white Pawn
		for (int i = 0; i < spots.length; i++) {
			spots[6][i].addFigure(new Pawn("Pawn", "White"));
		}

		// add white Rooks
		spots[7][0].addFigure(new Rook("Rook", "White"));
		spots[7][7].addFigure(new Rook("Rook", "White"));

		// add white Horses
		spots[7][1].addFigure(new Horse("Horse", "White"));
		spots[7][6].addFigure(new Horse("Horse", "White"));

		// add white Bishops
		spots[7][2].addFigure(new Bishop("Bishop", "White"));
		spots[7][5].addFigure(new Bishop("Bishop", "White"));

		// add white Queen
		spots[7][3].addFigure(new Queen("Queen", "White"));

		// add white King
		spots[7][4].addFigure(new King("King", "White"));


		// add black Pawn
		for (int i = 0; i < spots.length; i++) {
			spots[1][i].addFigure(new Pawn("Pawn", "Black"));
		}

		// add black Rooks
		spots[0][0].addFigure(new Rook("Rook", "Black"));
		spots[0][7].addFigure(new Rook("Rook", "Black"));

		// add black Horses
		spots[0][1].addFigure(new Horse("Horse", "Black"));
		spots[0][6].addFigure(new Horse("Horse", "Black"));

		// add black Bishops
		spots[0][2].addFigure(new Bishop("Bishop", "Black"));
		spots[0][5].addFigure(new Bishop("Bishop", "Black"));

		// add black Queen
		spots[0][3].addFigure(new Queen("Queen", "Black"));

		// add black King
		spots[0][4].addFigure(new King("King", "Black"));

	}
}