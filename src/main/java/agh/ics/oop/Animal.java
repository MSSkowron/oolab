package agh.ics.oop;

public class Animal implements IWorldMap{
    private MapDirection direction;
    private Vector2d position;
    private final IWorldMap map;
    public static final Vector2d STARTING_POINT = new Vector2d(4,4);

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
        return switch (direction){
            case NORTH -> "N";
            case SOUTH -> "S";
            case EAST -> "E";
            case WEST -> "W";
        };
    }


    private void moveForBac(Vector2d vector){
        if(this.map.canMoveTo(vector)) {
            this.position = vector;
        }
    }

    public void move(MoveDirection step) {
        switch (step) {
            case LEFT -> direction=direction.previous();
            case RIGHT -> direction=direction.next();
            case BACKWARD  -> moveForBac(this.position.subtract(this.direction.toUnitVector()));
            case FORWARD -> moveForBac(this.position.add(this.direction.toUnitVector()));
        }
    }

    @Override
    public boolean canMoveTo(Vector2d position) {
        return this.map.canMoveTo(position);
    }

    @Override
    public boolean place(Animal animal) {
        return this.map.place(animal);
    }

    @Override
    public boolean isOccupied(Vector2d position) {
        return this.map.isOccupied(position);
    }

    @Override
    public Object objectAt(Vector2d position) {
        return this.map.objectAt(position);
    }
}

