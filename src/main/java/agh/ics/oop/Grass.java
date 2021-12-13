package agh.ics.oop;

public class Grass implements IMapElement{
    private final Vector2d position;

    public Grass(Vector2d position){
        this.position = position;
    }

    @Override
    public Vector2d getPosition() {
        return position;
    }

    @Override
    public boolean isMovable(){
        return true;
    }

    @Override
    public void move(MoveDirection moveDirection){
    }

    @Override
    public void  addObserver(IPositionChangeObserver observer){
    }

    @Override
    public void removeObserver(IPositionChangeObserver observer){
    }

    @Override
    public String toString() {
        return "*";
    }

    @Override
    public String getResourceName() {
        return "src/main/resources/grass.png";
    }
}
