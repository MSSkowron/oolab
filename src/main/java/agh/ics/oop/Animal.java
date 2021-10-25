package agh.ics.oop;

public class Animal {
    private MapDirection direction = MapDirection.NORTH;
    private Vector2d position = new Vector2d(2, 2);

    public MapDirection getDirection() {
        return direction;
    }

    public void setDirection(MapDirection direction) {
        this.direction = direction;
    }

    public Vector2d getPosition() {
        return position;
    }

    public void setPosition(Vector2d position) {
        this.position = position;
    }

    public String toString() {
        return "Position: " + position.toString() + " Direction: " + direction.toString();
    }

    private void turnLeft() {
        direction = switch (direction) {
            case NORTH -> MapDirection.WEST;
            case WEST -> MapDirection.SOUTH;
            case EAST -> MapDirection.NORTH;
            case SOUTH -> MapDirection.EAST;
        };

    }

    private void turnRight() {
        direction = switch (direction) {
            case NORTH -> MapDirection.EAST;
            case WEST -> MapDirection.NORTH;
            case EAST -> MapDirection.SOUTH;
            case SOUTH -> MapDirection.WEST;
        };

    }

    private void moveUp() {
        if (position.y != 4) {
            position.y += 1;
        }
    }

    private void moveDown() {
        if (position.y != 0) {
            position.y -= 1;
        }

    }

    private void moveLeft() {
        if (position.x != 0) {
            position.x -= 1;
        }
    }

    private void moveRight() {
        if (position.x != 4) {
            position.x += 1;
        }

    }

    private void moveForward() {
        switch (direction) {
            case NORTH -> moveUp();
            case SOUTH -> moveDown();
            case WEST -> moveLeft();
            case EAST -> moveRight();
        }
    }

    private void moveBackwards() {
        switch (direction) {
            case NORTH -> moveDown();
            case SOUTH -> moveUp();
            case WEST -> moveRight();
            case EAST -> moveLeft();
        }

    }

    public void move(MoveDirection direction) {
        switch (direction) {
            case LEFT -> turnLeft();
            case RIGHT -> turnRight();
            case BACKWARD -> moveBackwards();
            case FORWARD -> moveForward();
        }

    }


}

