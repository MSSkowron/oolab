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
        int n = moves.length;
        if(this.map instanceof RectangularMap mainMap){
            for(int i = 0 ; i <n ;i++){
                mainMap.getAnimal(i % animalCounter).move(moves[i]);
            }
        }
        else if (this.map instanceof GrassField mainMap) {
            for(int i = 0 ; i <n ;i++){
                mainMap.getAnimal(i % animalCounter).move(moves[i]);
            }
        }

    }
}
