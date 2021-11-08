package agh.ics.oop;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RectangularMapTest {

    @Test
    void place() {
        //given
        RectangularMap map = new RectangularMap(10,10);
        Animal animal1 = new Animal(null,new Vector2d(1,1));
        Animal animal2 = new Animal(null,new Vector2d(2,2));
        Animal animal3 = new Animal(null,new Vector2d(3,3));
        Animal animal4 = new Animal(null,new Vector2d(2,2));
        Animal animal5 = new Animal(null,new Vector2d(5,5));
        Animal animal6 = new Animal(null,new Vector2d(5,5));
        //when
        boolean res1= map.place(animal1);
        boolean res2= map.place(animal2);
        boolean res3= map.place(animal3);
        boolean res4= map.place(animal4);
        boolean res5= map.place(animal5);
        boolean res6= map.place(animal6);
        //then
        assertTrue(res1);
        assertTrue(res2);
        assertTrue(res3);
        assertFalse(res4);
        assertTrue(res5);
        assertFalse(res6);
    }

    @Test
    void isOccupied() {
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
    void objectAt() {
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
        Assertions.assertEquals(animal1,res1);
        Assertions.assertEquals(animal2,res2);
        assertNull(res3);
    }
}