package agh.ics.oop;

public class SimulationEngine implements IEngine {
    private final MoveDirection[] moves;
    private final IWorldMap map;
    private int animalCounter = 0;

    public SimulationEngine(MoveDirection[] moves,IWorldMap map,Vector2d[] positions){
        this.moves = moves;
        this.map = map;
        for(Vector2d vector:positions) {
            if (map.place(new Animal(map, vector))) {
                animalCounter += 1;
            }
        }
    }

    @Override
    public void run() {
        RectangularMap mainMap = (RectangularMap) this.map;
        int n = moves.length;
        for(int i = 0 ; i <n ;i++){
            mainMap.getAnimal(i % animalCounter).move(moves[i]);
        }
    }
}
