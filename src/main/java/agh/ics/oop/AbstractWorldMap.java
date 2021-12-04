package agh.ics.oop;

import java.util.HashMap;
import java.util.Map;

abstract class AbstractWorldMap implements IWorldMap,IPositionChangeObserver{
    Map<Vector2d, Animal> animals = new HashMap<>();
    MapVisualiser visualiser = new MapVisualiser(this);

    abstract Vector2d getLowerLeftBorder();

    abstract Vector2d getUpperRightBorder();

    public boolean place(Animal animal) throws IllegalArgumentException {
        if(canMoveTo(animal.getPosition())){
            return putAnimal(animal);
        }else {
            throw new IllegalArgumentException("Cannot place animal on position :"+animal.getPosition().toString());
        }
    }

    public boolean isOccupied(Vector2d position) {
        return objectAt(position)!=null;
    }

    public boolean putAnimal(Animal animal){
        animals.put(animal.getPosition(),animal);
        animal.addObserver(this);
        return true;
    }

    @Override
    public String toString(){
        return visualiser.draw(getLowerLeftBorder(),getUpperRightBorder());
    }

    public void positionChanged(Vector2d oldPosition, Vector2d newPosition) {
        Animal animal = animals.remove(oldPosition);
        animals.put(newPosition,animal);
    }
}
