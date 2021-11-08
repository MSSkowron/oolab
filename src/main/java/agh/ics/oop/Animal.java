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
        position=initialPosition;
        direction=MapDirection.NORTH;
        this.map=map;
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

    public void move(MoveDirection step) {
        switch (step) {
            case LEFT -> direction=direction.previous();
            case RIGHT -> direction=direction.next();
            case BACKWARD  -> {
                if(this.map.canMoveTo(this.position.subtract(this.direction.toUnitVector()))){
                    this.position = this.position.subtract(this.direction.toUnitVector());
                }
            }
            case FORWARD -> {
                if(this.map.canMoveTo(this.position.add(this.direction.toUnitVector()))){
                    this.position=this.position.add(this.direction.toUnitVector());
                }
            }
        }
    }

    @Override
    public boolean canMoveTo(Vector2d position) {
        RectangularMap mainMap = (RectangularMap) this.map;
        return position.precedes(mainMap.getUpperRightBorder()) && position.follows(mainMap.getLowerLeftBorder());
    }

    @Override
    public boolean place(Animal animal) {
        return false;
    }

    @Override
    public boolean isOccupied(Vector2d position) {
        return false;
    }

    @Override
    public Object objectAt(Vector2d position) {
        return null;
    }
}

