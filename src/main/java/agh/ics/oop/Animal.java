package agh.ics.oop;

import java.util.HashSet;

public class Animal{
    private MapDirection direction;
    private Vector2d position;
    private final IWorldMap map;
    public static final Vector2d STARTING_POINT = new Vector2d(4,4);
    private final HashSet<IPositionChangeObserver> observers = new HashSet<>();

    public Animal(IWorldMap map){
        this.map=map;
        direction = MapDirection.NORTH;
        position = STARTING_POINT;
    }
    public Animal(IWorldMap map,Vector2d initialPosition){
        this.map=map;
        direction=MapDirection.NORTH;
        position=initialPosition;
    }

    public MapDirection getDirection() {
        return direction;
    }

    public Vector2d getPosition() {
        return position;
    }

    public String toString() {
        return direction.toString();
    }

    private void moveForwardBackward(Vector2d vector){
        if(this.map.canMoveTo(vector)) {
            Vector2d oldPosition = this.position;
            this.position = vector;
            positionChanged(oldPosition,vector);
        }
    }

    public void move(MoveDirection step) {
        switch (step) {
            case LEFT -> direction=direction.previous();
            case RIGHT -> direction=direction.next();
            case BACKWARD  -> moveForwardBackward(this.position.subtract(this.direction.toUnitVector()));
            case FORWARD -> moveForwardBackward(this.position.add(this.direction.toUnitVector()));
        }
    }

    public void addObserver(IPositionChangeObserver observer){
        observers.add(observer);
    }
    public void removeObserver(IPositionChangeObserver observer){
        observers.remove(observer);
    }
    private void positionChanged(Vector2d oldPosition,Vector2d newPosition){
        for(IPositionChangeObserver observer : observers){
            observer.positionChanged(oldPosition,newPosition);
        }
    }
}

