package agh.ics.oop;

import java.util.Comparator;
import java.util.SortedSet;
import java.util.TreeSet;

public class MapBoundary implements IPositionChangeObserver{
    Comparator<Vector2d> comparatorX = (o1, o2) -> {
        if(o1.x - o2.x == 0){
            if(o1.y - o2.y ==0){
                return 0;
            }else {
                return  o1.y - o2.y;
            }
        }
        return  o1.x - o2.x;
    };

    Comparator<Vector2d> comparatorY = (o1, o2) -> {
        if(o1.y - o2.y == 0){
            if(o1.x - o2.x ==0){
                return 0;
            }else {
                return  o1.x - o2.x;
            }
        }
        return  o1.y - o2.y;
    };

    SortedSet<Vector2d> xAnimals = new TreeSet<>(comparatorX);
    SortedSet<Vector2d> yAnimals = new TreeSet<>(comparatorY);
    SortedSet<Vector2d> xGrasses = new TreeSet<>(comparatorX);
    SortedSet<Vector2d> yGrasses = new TreeSet<>(comparatorY);

    public void addAnimal(Vector2d vector){
        xAnimals.add(vector);
        yAnimals.add(vector);
    }

    public void addGrass(Vector2d vector){
        xGrasses.add(vector);
        yGrasses.add(vector);
    }

    @Override
    public void positionChanged(Vector2d oldPosition, Vector2d newPosition) {
        xAnimals.remove(oldPosition);
        xAnimals.add(newPosition);
        yAnimals.remove(oldPosition);
        yAnimals.add(newPosition);
    }

    public Vector2d getLowerLeft(){
        return new Vector2d(Math.min(xAnimals.first().x, xGrasses.first().x),Math.max(yAnimals.first().y, yGrasses.first().y));
    }

    public Vector2d getUpperRight(){
        return new Vector2d(Math.max(xAnimals.last().x, xGrasses.last().x),Math.max(yAnimals.last().y, yGrasses.last().y));
    }
}
