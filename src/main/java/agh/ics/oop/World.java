package agh.ics.oop;

public class World {
    public static void main(String[] args) throws IllegalAccessException {
        MoveDirection[] directions = new OptionsParser().parse(args);
        IWorldMap map = new RectangularMap(10, 5);
        Vector2d[] positions = { new Vector2d(2,2), new Vector2d(3,4) };
        try {
            IEngine engine = new SimulationEngine(directions, map, positions);
            engine.run();
        }
        catch (IllegalArgumentException e){
            throw new IllegalAccessException(e.getMessage());
        }
    }
}

