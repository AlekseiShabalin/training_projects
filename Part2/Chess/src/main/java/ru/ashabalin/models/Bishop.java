package ru.ashabalin.models;

/**
 * @author Aleksei Shabalin on 11.09.2016.
 */
public class Bishop extends Figure {

    private boolean bishopRightStep;

    public Bishop(String name, String color) {
        super(name, color);
    }

    @Override
    public boolean move(int fromX, int fromY, int toX, int toY){

        this.bishopRightStep = super.move(fromX, fromY, toX, toY);

        if(toX != fromX && toY != fromY && Math.abs(toX - fromX) ==  Math.abs(toY - fromY)) {
            this.bishopRightStep = true;
        }else{
            this.bishopRightStep = false;
        }
        return bishopRightStep;
    }
}
