package agh.ics.oop;

import java.util.LinkedList;

public class Animal{
    private MapDirection direction;
    private Vector2d position;
    private final IWorldMap map;
    public static final Vector2d STARTING_POINT = new Vector2d(4,4);
    private final LinkedList<IPositionChangeObserver> observers = new LinkedList<>();

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


    private void moveForwadBackward(Vector2d vector){
        if(this.map.canMoveTo(vector)) {
            positionChanged(this.position,vector);
            this.position = vector;
        }
    }

    public void move(MoveDirection step) {
        switch (step) {
            case LEFT -> direction=direction.previous();
            case RIGHT -> direction=direction.next();
            case BACKWARD  -> moveForwadBackward(this.position.subtract(this.direction.toUnitVector()));
            case FORWARD -> moveForwadBackward(this.position.add(this.direction.toUnitVector()));
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

