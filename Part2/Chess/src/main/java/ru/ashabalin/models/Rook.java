package ru.ashabalin.models;

/**
 * @author Aleksei Shabalin on 11.09.2016.
 */
public class Rook extends Figure {

    private boolean rookRightStep;

    public Rook(String name, String color) {
        super(name, color);
    }

    /**
     * method move for Rook
     * @param fromX start horizontal coordinate x
     * @param fromY start vertical coordinate y
     * @param toX finish horizontal coordinate x
     * @param toY finish vertical coordinate y
     */
    @Override
    public boolean move(int fromX, int fromY, int toX, int toY){
        this.rookRightStep = super.move(fromX, fromY, toX, toY);

        //validation horizontal step
        if(fromX == toX && fromY != toY) {
            this.rookRightStep = true;
        }else {
            //validation vertical step
            if (fromX != toX && fromY == toY) {
                this.rookRightStep = true;
            }else{
                this.rookRightStep = false;
            }
        }
        return rookRightStep;
    }
}
