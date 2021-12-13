package agh.ics.oop;

import java.util.*;

import static java.lang.Math.sqrt;

public class GrassField extends AbstractWorldMap{
    private final MapBoundary mapBoundary = new MapBoundary();

    public GrassField(int n){
        randomGrassPlacement(n);
    }

    private void randomGrassPlacement(int n){
        Random r = new Random();
        LinkedList<Vector2d> positions = new LinkedList<>();
        int x = (int) sqrt(n*10);
        int y = (int) sqrt(n*10);
        for(int i=0;i<=y;i++){
            for (int j=0;j<=x;j++){
                positions.add(new Vector2d(j,i));
            }
        }
        for(int i = 0;i<n;i++){
            int len = positions.size();
            int index = r.nextInt(len);
            Vector2d position = positions.get(index);
            positions.remove(index);
            placeGrass(new Grass(position));
        }
    }

    private void placeGrass(Grass g){
        grasses.put(g.getPosition(),g);
        mapBoundary.addGrass(g.getPosition());
    }

    @Override
    public Vector2d getLowerLeftBorder() {
        return mapBoundary.getLowerLeft();
    }

    @Override
    public Vector2d getUpperRightBorder() {
        return mapBoundary.getUpperRight();
    }

    @Override
    public boolean putAnimal(Animal animal){
        animals.put(animal.getPosition(),animal);
        mapBoundary.addAnimal(animal.getPosition());
        animal.addObserver(this);
        animal.addObserver(mapBoundary);
        return true;
    }

    @Override
    public boolean canMoveTo(Vector2d position) {
        Object object = objectAt(position);
        if(object == null){
            return true;
        }
        else {
            return ((IMapElement) object).isMovable();
        }
    }
}
