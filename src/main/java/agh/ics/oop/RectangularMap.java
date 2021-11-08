package agh.ics.oop;

import java.util.ArrayList;
import java.util.List;

public class RectangularMap implements IWorldMap {
    private final Vector2d upperRightBorder;
    private final Vector2d lowerLeftBorder;
    private final MapVisualiser mapVisualiser = new MapVisualiser(null);
    private final List<Animal> animals = new ArrayList<>();

    public RectangularMap(int width,int height){
        // Ignoruje sytuacje, gdzie użytkownik podaje niepoprawne wartości. Zakładam, że są OK.
        upperRightBorder = new Vector2d(width,height);
        lowerLeftBorder = new Vector2d(0,0);
    }

    public Vector2d getLowerLeftBorder() {
        return lowerLeftBorder;
    }

    public Vector2d getUpperRightBorder() {
        return upperRightBorder;
    }

    public Animal getAnimal(int i) {
        return animals.get(i);
    }

    @Override
    public String toString() {
        return mapVisualiser.draw(lowerLeftBorder,upperRightBorder);
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
            animals.add(animal);
            return true;
        }
        else {
            return false;
        }
    }

    @Override
    public boolean isOccupied(Vector2d position) {
        for(Animal animal:animals){
            if(animal.getPosition().equals(position)){
                return true;
            }
        }
        return false;
    }

    @Override
    public Object objectAt(Vector2d position) {
        if(animals.size()==0){
            return null;
        }
        for(Animal animal:animals){
            if(animal.getPosition().equals(position)){
                return animal;
            }
        }
        return null;
    }
}
