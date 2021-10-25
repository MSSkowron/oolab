package agh.ics.oop;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AnimalTest {

    @Test
    void orientationTest() {
        //given
        Animal myAnimal_1 = new Animal();
        MoveDirection[] a1 = {MoveDirection.LEFT, MoveDirection.FORWARD, MoveDirection.FORWARD, MoveDirection.RIGHT, MoveDirection.FORWARD, MoveDirection.RIGHT};
        Animal myAnimal_2 = new Animal();
        MoveDirection[] a2 = {MoveDirection.BACKWARD, MoveDirection.BACKWARD, MoveDirection.LEFT};
        Animal myAnimal_3 = new Animal();
        MoveDirection[] a3 = {MoveDirection.RIGHT, MoveDirection.RIGHT, MoveDirection.RIGHT, MoveDirection.LEFT};

        //when
        for (MoveDirection direction : a1) {
            myAnimal_1.move(direction);
        }

        for (MoveDirection direction : a2) {
            myAnimal_2.move(direction);
        }
        for (MoveDirection direction : a3) {
            myAnimal_3.move(direction);
        }

        //then
        Assertions.assertEquals(MapDirection.EAST, myAnimal_1.getDirection());
        Assertions.assertEquals(MapDirection.WEST, myAnimal_2.getDirection());
        Assertions.assertEquals(MapDirection.SOUTH, myAnimal_3.getDirection());
    }

    @Test
    void positionTest() {
        //given
        Animal myAnimal_1 = new Animal();
        MoveDirection[] a1 = {MoveDirection.LEFT, MoveDirection.FORWARD, MoveDirection.FORWARD, MoveDirection.RIGHT, MoveDirection.FORWARD, MoveDirection.RIGHT};
        Animal myAnimal_2 = new Animal();
        MoveDirection[] a2 = {MoveDirection.BACKWARD, MoveDirection.BACKWARD, MoveDirection.LEFT};
        Animal myAnimal_3 = new Animal();
        MoveDirection[] a3 = {MoveDirection.RIGHT, MoveDirection.RIGHT, MoveDirection.RIGHT, MoveDirection.LEFT};

        //when
        for (MoveDirection direction : a1) {
            myAnimal_1.move(direction);
        }

        for (MoveDirection direction : a2) {
            myAnimal_2.move(direction);
        }
        for (MoveDirection direction : a3) {
            myAnimal_3.move(direction);
        }

        //then
        Assertions.assertEquals(new Vector2d(0, 3), myAnimal_1.getPosition());
        Assertions.assertEquals(new Vector2d(2, 0), myAnimal_2.getPosition());
        Assertions.assertEquals(new Vector2d(2, 2), myAnimal_3.getPosition());

    }

    @Test
    void mapBorderTest() {
        //given
        Animal myAnimal_1 = new Animal();
        MoveDirection[] a1 = {MoveDirection.FORWARD, MoveDirection.FORWARD, MoveDirection.FORWARD, MoveDirection.FORWARD, MoveDirection.FORWARD, MoveDirection.FORWARD};
        Animal myAnimal_2 = new Animal();
        MoveDirection[] a2 = {MoveDirection.BACKWARD, MoveDirection.BACKWARD, MoveDirection.BACKWARD};
        Animal myAnimal_3 = new Animal();
        MoveDirection[] a3 = {MoveDirection.RIGHT, MoveDirection.FORWARD, MoveDirection.FORWARD, MoveDirection.FORWARD};

        //when
        for (MoveDirection direction : a1) {
            myAnimal_1.move(direction);
        }

        for (MoveDirection direction : a2) {
            myAnimal_2.move(direction);
        }
        for (MoveDirection direction : a3) {
            myAnimal_3.move(direction);
        }

        //then
        Assertions.assertEquals(new Vector2d(2, 4), myAnimal_1.getPosition());
        Assertions.assertEquals(new Vector2d(2, 0), myAnimal_2.getPosition());
        Assertions.assertEquals(new Vector2d(4, 2), myAnimal_3.getPosition());

    }

    @Test
    void inputArrayInterpretationTest() {
        //given
        OptionsParser pars = new OptionsParser();
        String[] inputArray = {"r", "right", "b", "somethingelse", "left", "b", "nothing", "r", "f", "F", "l", "forward", "backward"};
        MoveDirection[] directionArray = {MoveDirection.RIGHT, MoveDirection.RIGHT, MoveDirection.BACKWARD, MoveDirection.LEFT, MoveDirection.BACKWARD, MoveDirection.RIGHT, MoveDirection.FORWARD, MoveDirection.LEFT, MoveDirection.FORWARD, MoveDirection.BACKWARD};
        //when
        MoveDirection[] moves = pars.parse(inputArray);
        //then
        Assertions.assertArrayEquals(directionArray, moves);

    }
}