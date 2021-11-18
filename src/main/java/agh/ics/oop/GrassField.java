package agh.ics.oop;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static java.lang.Math.sqrt;

public class GrassField extends AbstractWorldMap implements IWorldMap {
    private final List<Grass> grasses = new ArrayList<>();
    private final List<Animal> animals = new ArrayList<>();

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
        for(Animal animal:animals){
            if(animal.getPosition().precedes(lowerLeftBorder)){
                lowerLeftBorder=animal.getPosition();
            }
        }
        for(Grass g:grasses){
            if(g.getPosition().precedes(lowerLeftBorder)){
                lowerLeftBorder=g.getPosition();
            }
        }

        return lowerLeftBorder;
    }

    protected Vector2d getUpperRightBorder() {
        Vector2d upperRightBorder = new Vector2d(0,0);
        for(Animal animal:animals){
            if(animal.getPosition().follows(upperRightBorder)){
                upperRightBorder=animal.getPosition();
            }
        }
        for(Grass g:grasses){
            if(g.getPosition().follows(upperRightBorder)){
                upperRightBorder=g.getPosition();
            }
        }
        return upperRightBorder;
    }

    protected Animal getAnimal(int i) {
        return animals.get(i);
    }


    private boolean canPlaceGrass(Vector2d position){
        for(Grass g:grasses){
            if(position.equals(g.getPosition())){
                return false;
            }
        }
        return true;
    }

    private void placeGrass(Grass g){
        grasses.add(g);
    }


    @Override
    public boolean canMoveTo(Vector2d position) {
        return !isOccupied(position);
    }

    @Override
    public boolean place(Animal animal) {
        if(!isOccupied(animal.getPosition())){
            animals.add(animal);
            return true;
        }
        return false;
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
        for(Animal animal:animals){
            if(animal.getPosition().equals(position)){
                return animal;
            }
        }
        for(Grass g:grasses){
            if(g.getPosition().equals(position)){
                return g;
            }
        }
        return null;
    }
}
