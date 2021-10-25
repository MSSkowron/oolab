package agh.ics.oop;

import java.util.Arrays;

public class World {
    public static void main(String[] args) {
        Animal animal = new Animal();
        OptionsParser pars = new OptionsParser();
        MoveDirection[] moves = pars.parse(args);
        for (MoveDirection step : moves) {
            animal.move(step);
        }
        System.out.println(animal.getPosition());
    }
}

