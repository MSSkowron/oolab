package agh.ics.oop;

import java.util.LinkedList;

public class SimulationEngine implements IEngine {
    private final MoveDirection[] moves;
    private int animalCounter = 0;
    private final LinkedList<Animal> animals;

    public SimulationEngine(MoveDirection[] moves, IWorldMap map, Vector2d[] positions){
        this.moves = moves;
        animals = new LinkedList<>();
        for (Vector2d vector : positions) {
            Animal animal = new Animal(map, vector);
            if (map.place(animal)) {
                animalCounter += 1;
                animals.addLast(animal);
            }
        }
    }

    public LinkedList<Animal> getAnimals(){
        return  animals;
    }

    @Override
    public void run() {
        int n = moves.length;
        for (int i = 0; i < n; i++) {
            (animals.get(i % animalCounter)).move(moves[i]);
        }
    }
}
