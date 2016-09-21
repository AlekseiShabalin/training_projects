package ru.ashabalin.models;

/**
 * Created by Aleksei Shabalin.
 */

import static java.lang.Math.*;

/**
 * Class Pawn
 */

public class Pawn extends Figure {

	private boolean firstStep; // it`s first step of Pawn: false - fisrt step doesn`t do, true - first step to do
	private boolean pawnRightStep;

	public Pawn(String name, String color) {
		super(name, color);
	}

	/**
	 * method move for Pawn
	 * @param fromX start horizontal coordinate x
	 * @param fromY start vertical coordinate y
	 * @param toX finish horizontal coordinate x
	 * @param toY finish vertical coordinate y
	 */
	@Override
	public boolean move(int fromX, int fromY, int toX, int toY){

		this.pawnRightStep = super.move(fromX, fromY, toX, toY);

		double distance = sqrt(pow((toX - fromX), 2) + pow((toY - fromY), 2)); // distance step

		if(this.stepDiagonal(distance) == true && this.banStepBack(fromX, toX) == true) {
			this.pawnRightStep = true;
		}else {
			if (this.banStepBack(fromX, toX) == true && this.validStep(distance, fromY, toY) == true) {
				this.pawnRightStep = true;
			}else{
				this.pawnRightStep = false;
			}
		}
		return pawnRightStep;
	}

	/**
	 * method ban step back for Pawn
	 * @param fromX start horizontal coordinate x
	 * @param toX finish horizontal coordinate x
	 */
	private boolean banStepBack(int fromX, int toX) {
		if((super.getColor().equals("White") && (fromX > toX)) || (super.getColor().equals("Black") && (fromX < toX))) {
			this.pawnRightStep = true;
		}else{
			this.pawnRightStep = false;
		}

		return pawnRightStep;
	}

	/**
	 * method validation diagonal step for take the figure enemy
	 */
	private boolean stepDiagonal(double distance) {

		if(distance == sqrt(2)) {
			this.pawnRightStep = true;
		}else{
			this.pawnRightStep = false;
		}

		return pawnRightStep;
	}

	/**
	 * method validation step
	 * @param fromY start vertical coordinate y
	 * @param toY finish vertical coordinate y
	 * @param distance - distance step
	 */
	private boolean validStep(double distance, int fromY, int toY) {
		if(this.firstStep == true && distance == 1 && (toY - fromY) == 0){
			this.pawnRightStep = true;
		}else {
			if(this.firstStep == false && distance <= 2 && (toY - fromY) == 0) {
				this.firstStep = true;
				this.pawnRightStep = true;
			}else {
				this.pawnRightStep = false;
			}
		}
		return pawnRightStep;
	}

}