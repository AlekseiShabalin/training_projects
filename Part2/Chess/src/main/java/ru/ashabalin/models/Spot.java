package ru.ashabalin.models;

/**
 * Created by Aleksei Shabalin.
 */
 
public class Spot {
	private int column;
	private int row;
	private Figure figure;

	public int getColumn() {
		return column;
	}

	public int getRow() {
		return row;
	}

	public Figure getFigure() {
		return figure;
	}

	public Spot(int x, int y) {
		this.figure = null;
		this.row = x;
		this.column = y;
	}

	/**
	 * Method add figure
	 */
	public void addFigure(Figure figure) {
		this.figure = figure;
	}

	/**
	 * Method for take cell
 	 * @param spot
 	 * @param toX horizontal coordinate final cell
 	 * @param toY vertical coordinate final cell
	 *
	 */

	public void takeSpot(Spot[][] spot, int toX, int toY) {

		try {
			boolean validStep = this.figure.move(this.row, this.column, spot[toX][toY].getRow(), spot[toX][toY].getColumn());

			if (this.figure.getName().equals("Horse") && validStep == true) {
				this.takeFinalCell(spot[toX][toY]);
			}else{
				if (validStep == true && this.column == spot[toX][toY].getColumn() && this.validateVerticalPath(spot, toX, toY) == true) {
					this.takeFinalCell(spot[toX][toY]);
				} else {
					if (validStep == true && this.row == spot[toX][toY].getRow() && this.validateHorizontalPath(spot, toX, toY) == true) {
						this.takeFinalCell(spot[toX][toY]);
					} else {
						if (validStep == true && this.row != spot[toX][toY].getRow() && this.column != spot[toX][toY].getColumn() && this.validateDiagonalPath(spot, toX, toY) == true) {
							this.takeFinalCell(spot[toX][toY]);
							}
						}
					}
				}
		}catch (WrongStepException wrongStep){
			System.out.println("You made a wrong step!");
		}

	}

	/**
	 * validate vertical path
	 * @param spot
	 * @param toX horizontal coordinate final cell
	 * @param toY vertical coordinate final cell
	 * @return path true or false
	 */
	private boolean validateVerticalPath(Spot[][] spot, int toX, int toY){
		boolean path = true;

		while(path == true && this.row < spot[toX][toY].getRow() - 1) {
			if(spot[++this.row][spot[toX][toY].getColumn()].getFigure() == null){
				path = true;
				row = row++;
			}else{
				path = false;
			}
		}
		return path;
	}

	/**
	 * validate horizontal path
	 * @param spot
	 * @param toX horizontal coordinate final cell
	 * @param toY vertical coordinate final cell
	 * @return path true or false
	 */
	private boolean validateHorizontalPath(Spot[][] spot, int toX, int toY){
		boolean path = true;

		while(path == true && this.column < spot[toX][toY].getColumn() - 1) {
			if(spot[spot[toX][toY].getRow()][++this.column].getFigure() == null){
				path = true;
				column = column++;
			}else{
				path = false;
			}
		}
		return path;
	}

	/**
	 * validate diagonal path
	 * @param spot
	 * @param toX horizontal coordinate final cell
	 * @param toY vertical coordinate final cell
	 * @return path true or false
	 */
	private boolean validateDiagonalPath(Spot[][] spot, int toX, int toY){
		boolean path = true;

		// when toX > fromX and toY > fromY
		if(toX > this.row && toY > this.column) {
			while (path == true && this.row < spot[toX][toY].getRow() - 1 && this.column < spot[toX][toY].getColumn() - 1) {
				if (spot[++this.row][++this.column].getFigure() == null) {
					path = true;
					row = row++;
					column = column++;
				} else {
					path = false;
				}
			}
		}

		// when toX > fromX and toY < fromY
		if(toX > this.row && toY < this.column) {
			while (path == true && this.row < spot[toX][toY].getRow() - 1 && this.column > spot[toX][toY].getColumn() + 1) {
				if (spot[++this.row][--this.column].getFigure() == null) {
					path = true;
					row = row + 1;
					column = column - 1;
				} else {
					path = false;
				}
			}
		}

		// when toX < fromX && toY < fromY
		if(toX < this.row && toY < this.column) {
			while (path == true && this.row > spot[toX][toY].getRow() + 1 && this.column > spot[toX][toY].getColumn() + 1) {
				if (spot[--this.row][--this.column].getFigure() == null) {
					path = true;
					row = row - 1;
					column = column - 1;
				} else {
					path = false;
				}
			}
		}

		// when toX < fromX && toY > fromY
		if(toX < this.row && toY > this.column) {
			while (path == true && this.row > spot[toX][toY].getRow() + 1 && this.column < spot[toX][toY].getColumn() - 1) {
				if (spot[--this.row][++this.column].getFigure() == null) {
					path = true;
					row = row - 1;
					column = column + 1;
				} else {
					path = false;
				}
			}
		}

		return path;
	}

	/**
	 * Method validate and take final cell
	 * @param spot
	 */
	private void takeFinalCell(Spot spot) {
		try {
//			if(spot.getFigure() == null) {
//				spot.addFigure(this.figure);
//				this.figure = null;
//			}else{
				if(spot.getFigure() != null && this.figure.getColor() != spot.getFigure().getColor() || spot.getFigure() == null) {
					spot.addFigure(this.figure);
					this.figure = null;
				}
//			}
		}catch(WrongStepException wrongStep) {
			System.out.println("You made a wrong step!");
		}
	}

}