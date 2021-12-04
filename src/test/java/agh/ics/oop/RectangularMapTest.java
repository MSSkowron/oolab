package agh.ics.oop;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RectangularMapTest {

    @Test
    void placeTest() {
        //given
        RectangularMap map = new RectangularMap(10,10);
        Animal animal1 = new Animal(null,new Vector2d(1,1));
        Animal animal2 = new Animal(null,new Vector2d(1,1));
        //when
        boolean res1= map.place(animal1);
        try {
            map.place(animal2);
        }
        catch (IllegalArgumentException  exception){
            Assertions.assertEquals("Cannot place animal on position :"+animal2.getPosition().toString(),exception.getMessage());
        }
        //then
        assertTrue(res1);
    }

    @Test
    void isOccupiedTest() {
        //given
        RectangularMap map = new RectangularMap(10,10);
        Animal animal1 = new Animal(null,new Vector2d(1,1));
        Vector2d pos1 = new Vector2d(1,1);
        Animal animal2 = new Animal(null,new Vector2d(2,2));
        Vector2d pos2 = new Vector2d(2,2);
        //when
        boolean res1 = map.isOccupied(pos1);
        boolean res2 = map.isOccupied(pos2);
        map.place(animal1);
        boolean res3 = map.isOccupied(pos1);
        map.place(animal2);
        boolean res4 = map.isOccupied(pos2);
        //then
        assertFalse(res1);
        assertFalse(res2);
        assertTrue(res3);
        assertTrue(res4);
    }

    @Test
    void objectAtTest() {
        //given
        RectangularMap map = new RectangularMap(10,10);
        Animal animal1 = new Animal(null,new Vector2d(1,1));
        Animal animal2 = new Animal(null,new Vector2d(2,2));
        Vector2d pos1 = new Vector2d(1,1);
        Vector2d pos2 = new Vector2d(2,2);
        Vector2d pos3 = new Vector2d(5,5);
        //when
        map.place(animal1);
        map.place(animal2);
        Object res1 = map.objectAt(pos1);
        Object res2 = map.objectAt(pos2);
        Object res3 = map.objectAt(pos3);
        //then
        assertEquals(animal1,res1);
        assertEquals(animal2,res2);
        assertNull(res3);
    }

    @Test
    void canMoveToTest() {
        //given
        IWorldMap map = new RectangularMap(10, 10);
        Animal animal1 = new Animal(map,new Vector2d(2,1));
        Animal animal2 = new Animal(map,new Vector2d(2,2));
        Vector2d pos1 = new Vector2d(2,1);
        Vector2d pos2 = new Vector2d(2,2);
        //when
        map.place(animal1);
        map.place(animal2);
        boolean res1 = map.canMoveTo(pos2);
        boolean res2 = map.canMoveTo(pos1);
        //then
        assertFalse(res1);
        assertFalse(res2);
    }
}