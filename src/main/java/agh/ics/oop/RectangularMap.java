package agh.ics.oop;



public class RectangularMap extends AbstractWorldMap {
    private final Vector2d upperRightBorder;
    private final Vector2d lowerLeftBorder;

    public RectangularMap(int width,int height){
        upperRightBorder = new Vector2d(width,height);
        lowerLeftBorder = new Vector2d(0,0);
    }

    @Override
    public Vector2d getLowerLeftBorder() {
        return lowerLeftBorder;
    }

    @Override
    public Vector2d getUpperRightBorder() {
        return upperRightBorder;
    }

    @Override
    public boolean canMoveTo(Vector2d position) {
        return position.precedes(upperRightBorder) && position.follows(lowerLeftBorder) && !isOccupied(position);
    }

}
