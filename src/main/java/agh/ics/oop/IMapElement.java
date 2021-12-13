package agh.ics.oop;

public interface IMapElement {
    Vector2d getPosition();

    boolean isMovable();

    void move(MoveDirection moveDirection);

    void addObserver(IPositionChangeObserver observer);

    void removeObserver(IPositionChangeObserver observer);

    @Override
    String toString();

    String getResourceName();
}
