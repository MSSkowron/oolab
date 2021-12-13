package agh.ics.oop;

import agh.ics.oop.gui.App;

import java.util.LinkedList;

public class SimulationEngine implements IEngine,Runnable {
    private MoveDirection[] moves;
    private final IWorldMap map;
    private App observer;
    private int animalCounter = 0;
    private final LinkedList<Animal> animals;

    public SimulationEngine(IWorldMap map, Vector2d[] positions) throws IllegalArgumentException{
        this.map = map;
        animals = new LinkedList<>();
        for (Vector2d vector : positions) {
            Animal animal = new Animal(map, vector);
            map.place(animal);
            animalCounter += 1;
            animals.addLast(animal);
        }
    }

    public void setObserver(App observer){
        this.observer = observer;
    }

    public void observerUpdate(IWorldMap map) throws InterruptedException {
        this.observer.update(map);
    }

    public void setDirections(MoveDirection[] moveDirections){
        moves = moveDirections;
    }

    public LinkedList<Animal> getAnimals(){
        return  animals;
    }

    @Override
    public void run() {
        int n = moves.length;
        for (int i = 0; i < n; i++) {
            (animals.get(i % animalCounter)).move(moves[i]);
            try {
                observerUpdate(map);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
