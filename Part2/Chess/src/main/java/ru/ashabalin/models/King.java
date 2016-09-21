package ru.ashabalin.models;

import static java.lang.Math.pow;
import static java.lang.Math.sqrt;

/**
 * @author Aleksei Shabalin on 08.09.2016.
 */
public class King extends Figure {

    private boolean kingRightStep;

    public King(String name, String color) {
        super(name, color);
    }

    /**
     * method move for King
     * @param fromX start horizontal coordinate x
     * @param fromY start vertical coordinate y
     * @param toX finish horizontal coordinate x
     * @param toY finish vertical coordinate y
     */
    public boolean move(int fromX, int fromY, int toX, int toY){

        this.kingRightStep = super.move(fromX, fromY, toX, toY);

        double distance = sqrt(pow((toX - fromX), 2) + pow((toY - fromY), 2)); // distance step

        if(this.stepDiagonal(distance, fromX, fromY, toX, toY) == true) {
            this.kingRightStep = true;
        }else {
            if (this.validHorizontalVerticalStep(distance, fromX, fromY, toX, toY) == true) {
                this.kingRightStep = true;
            }else{
                this.kingRightStep = false;
            }
        }
        return kingRightStep;
    }

    /**
     * method validation diagonal step
     * @param fromX start horizontal coordinate x
     * @param fromY start vertical coordinate y
     * @param toX finish horizontal coordinate x
     * @param toY finish vertical coordinate y
     */
    private boolean stepDiagonal(double distance, int fromX, int fromY, int toX, int toY) {
        if(distance == sqrt(2) && toX != fromX && toY != fromY) {
            this.kingRightStep = true;
        }else{
            this.kingRightStep = false;
        }
        return kingRightStep;
    }

    /**
     * method validation vertical and horizontal step
     * @param distance - distance step
     * @param fromX start horizontal coordinate x
     * @param fromY start vertical coordinate y
     * @param toX finish horizontal coordinate x
     * @param toY finish vertical coordinate y
     */
    private boolean validHorizontalVerticalStep(double distance, int fromX, int fromY, int toX, int toY) {
        //validation vertical step
        if(distance == 1 && toY == fromY){
            this.kingRightStep = true;
        }else {
            //validation horizontal step
            if(distance == 1 && toX == fromX){
                this.kingRightStep = true;
            }else {
                this.kingRightStep = false;
            }
        }
        return kingRightStep;
    }

}
