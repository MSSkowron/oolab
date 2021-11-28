package agh.ics.oop;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RectangularMap extends AbstractWorldMap implements IWorldMap,IPositionChangeObserver {
    private final Vector2d upperRightBorder;
    private final Vector2d lowerLeftBorder;
    private final Map<Vector2d, Animal> animals = new HashMap<>();

    public RectangularMap(int width,int height){
        // Ignoruje sytuacje, gdzie użytkownik podaje niepoprawne wartości. Zakładam, że są OK.
        upperRightBorder = new Vector2d(width,height);
        lowerLeftBorder = new Vector2d(0,0);
    }
    @Override
    protected Vector2d getLowerLeftBorder() {
        return lowerLeftBorder;
    }

    @Override
    protected Vector2d getUpperRightBorder() {
        return upperRightBorder;
    }

    @Override
    public boolean canMoveTo(Vector2d position) {
        return position.precedes(upperRightBorder) && position.follows(lowerLeftBorder) && !isOccupied(position);
    }

    @Override
    public boolean place(Animal animal) {
        if (animal.getPosition().precedes(upperRightBorder) && animal.getPosition().follows(lowerLeftBorder)) {
            if (isOccupied(animal.getPosition())) {
                return false;
            }
            animals.put(animal.getPosition(),animal);
            animal.addObserver(this);
            return true;
        }
        else {
            return false;
        }
    }

    @Override
    public boolean isOccupied(Vector2d position) {
        return objectAt(position) != null;
    }

    @Override
    public Object objectAt(Vector2d position) {
        return animals.get(position);
    }

    @Override
    public String toString(){
        MapVisualiser visualiser = new MapVisualiser(this);
        return visualiser.draw(getLowerLeftBorder(),getUpperRightBorder());
    }

    @Override
    public void positionChanged(Vector2d oldPosition, Vector2d newPosition) {
        Animal animal = animals.get(oldPosition);
        animals.remove(oldPosition,animal);
        animals.put(newPosition,animal);
    }
}
