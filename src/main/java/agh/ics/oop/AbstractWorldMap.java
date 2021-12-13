package agh.ics.oop;

import java.util.HashMap;
import java.util.Map;

public abstract class AbstractWorldMap implements IWorldMap,IPositionChangeObserver{
    Map<Vector2d, Animal> animals = new HashMap<>();
    Map<Vector2d, Grass> grasses = new HashMap<>();
    MapVisualiser visualiser = new MapVisualiser(this);

    public Map<Vector2d, Animal> getAnimals() {
        return animals;
    }

    public  Map<Vector2d, Grass> getGrasses(){
        return grasses;
    }

    public abstract Vector2d getLowerLeftBorder();

    public abstract Vector2d getUpperRightBorder();

    public boolean place(Animal animal){
        if(canMoveTo(animal.getPosition())){
            return putAnimal(animal);
        }else {
            throw new IllegalArgumentException("Cannot place animal on position :"+animal.getPosition().toString());
        }
    }

    public boolean putAnimal(Animal animal){
        animals.put(animal.getPosition(),animal);
        animal.addObserver(this);
        return true;
    }

    public boolean isOccupied(Vector2d position) {
        return objectAt(position)!=null;
    }

    public Object objectAt(Vector2d position) {
        Animal a = animals.get(position);
        if(a==null){
            return grasses.get(position);
        }
        return a;
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
