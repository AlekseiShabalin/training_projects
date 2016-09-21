package ru.ashabalin.models;

/**
 * @author Aleksei Shabalin on 11.09.2016.
 */
public class Horse extends Figure {

    private boolean horseRightStep;

    public Horse(String name, String color) {
        super(name, color);
    }

    @Override
    public boolean move(int fromX, int fromY, int toX, int toY){
        horseRightStep = super.move(fromX, fromY, toX, toY);

        if(Math.abs((toX - fromX)/(toY - fromY)) == 0.5 || Math.abs((toX - fromX)/(toY - fromY)) == 2) {
            horseRightStep = true;
        }else{
            horseRightStep = false;
        }

        return horseRightStep;
    }
}
