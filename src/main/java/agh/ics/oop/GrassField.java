package agh.ics.oop;


import java.util.*;

import static java.lang.Math.sqrt;

public class GrassField extends AbstractWorldMap{
    private final Map<Vector2d, Grass> grasses = new HashMap<>();

    public GrassField(int n){
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

    private Vector2d findMaximum(Set<Vector2d> positions){
        Vector2d upperRightBorder = new Vector2d(0,0);
        for (Vector2d position : positions) {
            if(position.follows(upperRightBorder)){
                upperRightBorder=position;
            }
        }
        return upperRightBorder;
    }

    private Vector2d findMinimum(Set<Vector2d> positions){
        Vector2d lowerLeftBorder = new Vector2d(0,0);
        for (Vector2d position : positions) {
            if(position.precedes(lowerLeftBorder)){
                lowerLeftBorder=position;
            }
        }
        return lowerLeftBorder;
    }

    private void placeGrass(Grass g){
        grasses.put(g.getPosition(),g);
    }

    @Override
    protected Vector2d getLowerLeftBorder() {
        Vector2d lowerLeftBorder = new Vector2d(0,0);
        Vector2d animalsMinPosition = findMinimum(animals.keySet());
        Vector2d grassesMinPosition = findMinimum(grasses.keySet());
        if (animalsMinPosition.precedes(lowerLeftBorder)){
            lowerLeftBorder = animalsMinPosition;
        }
        if (grassesMinPosition.precedes(lowerLeftBorder)){
            lowerLeftBorder = grassesMinPosition;
        }
        return lowerLeftBorder;
    }

    @Override
    protected Vector2d getUpperRightBorder() {
        Vector2d upperRightBorder = new Vector2d(0,0);
        Vector2d animalsMaxPosition = findMaximum(animals.keySet());
        Vector2d grassesMaxPosition = findMaximum(grasses.keySet());
        if (animalsMaxPosition.follows(upperRightBorder)){
            upperRightBorder = animalsMaxPosition;
        }
        if (grassesMaxPosition.follows(upperRightBorder)){
            upperRightBorder = grassesMaxPosition;
        }
        return upperRightBorder;
    }

    @Override
    public boolean canMoveTo(Vector2d position) {
        return  !(objectAt(position) instanceof Animal);
    }

    @Override
    public Object objectAt(Vector2d position) {
        Animal a = animals.get(position);
        if(a!=null){
            return a;
        }
        return grasses.get(position);
    }
}
