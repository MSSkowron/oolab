package agh.ics.oop;

import java.util.*;

import static java.lang.Math.sqrt;

public class GrassField extends AbstractWorldMap implements IWorldMap,IPositionChangeObserver {
    private final Map<Vector2d, Grass> grasses = new HashMap<>();
    private final Map<Vector2d, Animal> animals = new HashMap<>();

    public GrassField(int n){
        int counter = 0;
        Random r = new Random();
        while (counter != n){
            int x = r.nextInt((int) sqrt(n*10));
            int y = r.nextInt((int) sqrt(n*10));
            Vector2d position = new Vector2d(x,y);
            if(canPlaceGrass(position)){
                placeGrass(new Grass(position));
                counter += 1;
            }
        }
    }

    protected Vector2d getLowerLeftBorder() {
        Vector2d lowerLeftBorder = new Vector2d(0,0);
        for (Vector2d key : animals.keySet()) {
            if(key.precedes(lowerLeftBorder)){
                lowerLeftBorder=key;
            }
        }
        for (Vector2d key : grasses.keySet()) {
            if(key.precedes(lowerLeftBorder)){
                lowerLeftBorder=key;
            }
        }

        return lowerLeftBorder;
    }

    protected Vector2d getUpperRightBorder() {
        Vector2d upperRightBorder = new Vector2d(0,0);
        for (Vector2d key : animals.keySet()) {
            if(key.follows(upperRightBorder)){
                upperRightBorder=key;
            }
        }
        for (Vector2d key : grasses.keySet()) {
            if(key.follows(upperRightBorder)){
                upperRightBorder=key;
            }
        }
        return upperRightBorder;
    }

    private boolean canPlaceGrass(Vector2d position){
        return grasses.get(position) == null;
    }

    private void placeGrass(Grass g){
        grasses.put(g.getPosition(),g);
    }


    @Override
    public boolean canMoveTo(Vector2d position) {
        return !isOccupied(position);
    }

    @Override
    public boolean place(Animal animal) {
        if(!isOccupied(animal.getPosition())){
            animals.put(animal.getPosition(),animal);
            animal.addObserver(this);
            return true;
        }
        return false;
    }

    @Override
    public boolean isOccupied(Vector2d position) {
        return objectAt(position) instanceof Animal;
    }

    @Override
    public Object objectAt(Vector2d position) {
        Animal a = animals.get(position);
        if(a!=null){
            return a;
        }
        return grasses.get(position);
    }

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
