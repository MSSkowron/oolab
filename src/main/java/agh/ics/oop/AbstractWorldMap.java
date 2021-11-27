package agh.ics.oop;

import java.util.ArrayList;

abstract class AbstractWorldMap {
    protected ArrayList<Animal> animals;

    public AbstractWorldMap(){
        this.animals = new ArrayList<>();
    }
    public abstract Object objectAt(Vector2d position);

    public abstract boolean canMoveTo(Vector2d position);

    public abstract boolean place(Animal animal);

    protected abstract Vector2d getLowerLeftBorder();

    protected abstract Vector2d getUpperRightBorder();

    public String toString(){
        MapVisualiser visualiser = new MapVisualiser((IWorldMap) this);
        return visualiser.draw(getLowerLeftBorder(),getUpperRightBorder());
    }
}
