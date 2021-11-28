package agh.ics.oop;

abstract class AbstractWorldMap implements IWorldMap{
    protected abstract Vector2d getLowerLeftBorder();

    protected abstract Vector2d getUpperRightBorder();

    @Override
    public String toString(){
        MapVisualiser visualiser = new MapVisualiser(this);
        return visualiser.draw(getLowerLeftBorder(),getUpperRightBorder());
    }
}
