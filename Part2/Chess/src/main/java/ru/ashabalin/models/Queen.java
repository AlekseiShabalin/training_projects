package ru.ashabalin.models;

/**
 * @author Aleksei Shabalin on 11.09.2016.
 */
public class Queen extends Figure {

    private boolean queenRightStep;

    public Queen(String name, String color) {
        super(name, color);
    }

    @Override
    public boolean move(int fromX, int fromY, int toX, int toY){

        this.queenRightStep = super.move(fromX, fromY, toX, toY);

        if(this.stepDiagonal(fromX, fromY, toX, toY) == true || this.validHorizontalVerticalStep(fromX, fromY, toX, toY) == true) {
            this.queenRightStep = true;
        }else {
                this.queenRightStep = false;
            }
        return queenRightStep;
    }

    /**
     * method validation diagonal step
     * @param fromX start horizontal coordinate x
     * @param fromY start vertical coordinate y
     * @param toX finish horizontal coordinate x
     * @param toY finish vertical coordinate y
     */
    private boolean stepDiagonal(int fromX, int fromY, int toX, int toY) {
        if(toX != fromX && toY != fromY && Math.abs(toX - fromX) ==  Math.abs(toY - fromY)) {
            this.queenRightStep = true;
        }else{
            this.queenRightStep = false;
        }
        return queenRightStep;
    }

    /**
     * method validation vertical and horizontal step
     * @param fromX start horizontal coordinate x
     * @param fromY start vertical coordinate y
     * @param toX finish horizontal coordinate x
     * @param toY finish vertical coordinate y
     */
    private boolean validHorizontalVerticalStep(int fromX, int fromY, int toX, int toY) {
        //validation horizontal step
        if(fromX == toX && fromY != toY){
            this.queenRightStep = true;
        }else {
            //validation vertical step
            if(fromX != toX && fromY == toY){
                this.queenRightStep = true;
            }else {
                this.queenRightStep = false;
            }
        }
        return queenRightStep;
    }

}
