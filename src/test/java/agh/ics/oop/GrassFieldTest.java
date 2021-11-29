package agh.ics.oop;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GrassFieldTest {

    @Test
    void canMoveToTest() {
        //given
        IWorldMap map = new GrassField(10);
        Animal animal1 = new Animal(map,new Vector2d(2,1));
        Animal animal2 = new Animal(map,new Vector2d(2,2));
        Vector2d pos1 = new Vector2d(2,1);
        Vector2d pos2 = new Vector2d(2,2);
        Vector2d pos3 = new Vector2d(2,3);
        //when
        map.place(animal1);
        map.place(animal2);
        boolean res1 = map.canMoveTo(pos2);
        boolean res2 = map.canMoveTo(pos1);
        boolean res3 = map.canMoveTo(pos3);
        //then
        assertFalse(res1);
        assertFalse(res2);
        assertTrue(res3);
    }

    @Test
    void placeTest() {
        //given
        IWorldMap map = new GrassField(10);
        Animal animal1 = new Animal(map,new Vector2d(2,1));
        Animal animal2 = new Animal(map,new Vector2d(2,2));
        Animal animal3 = new Animal(map,new Vector2d(2,2));
        //when
        boolean res1 = map.place(animal1);
        boolean res2 = map.place(animal2);
        boolean res3 = map.place(animal3);
        //then
        assertTrue(res1);
        assertTrue(res2);
        assertFalse(res3);
    }

    @Test
    void isOccupiedTest() {
        //given
        IWorldMap map = new GrassField(10);
        Animal animal1 = new Animal(map,new Vector2d(2,1));
        Animal animal2 = new Animal(map,new Vector2d(2,2));
        Vector2d pos1 = new Vector2d(2,1);
        Vector2d pos2 = new Vector2d(2,2);

        //when
        map.place(animal1);
        map.place(animal2);
        boolean res1 = map.isOccupied(pos1);
        boolean res2 = map.isOccupied(pos2);
        //then
        assertTrue(res1);
        assertTrue(res2);
    }

    @Test
    void objectAtTest() {
        //given
        IWorldMap map = new GrassField(10);
        Animal animal1 = new Animal(map,new Vector2d(2,1));
        Animal animal2 = new Animal(map,new Vector2d(2,2));
        Vector2d pos1 = new Vector2d(2,1);
        Vector2d pos2 = new Vector2d(2,2);
        //when
        map.place(animal1);
        map.place(animal2);
        Object res1 = map.objectAt(pos1);
        Object res2 = map.objectAt(pos2);
        //then
        assertEquals(animal1,res1);
        assertEquals(animal2,res2);
    }
}