package agh.ics.oop;

abstract class AbstractWorldMap {
    private MapVisualiser mapVisualiser;

    protected abstract Vector2d getLowerLeftBorder();

    protected abstract Vector2d getUpperRightBorder();

    protected abstract Animal getAnimal(int i);

    @Override
    public String toString(){
        Vector2d upperRightBorder= getUpperRightBorder();
        Vector2d lowerLeftBorder = getLowerLeftBorder();
        return mapVisualiser.draw(lowerLeftBorder,upperRightBorder);
    }
}
