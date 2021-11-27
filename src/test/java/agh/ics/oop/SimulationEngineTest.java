package agh.ics.oop;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class SimulationEngineTest {
    @Test
    void simulationTest() {
        //given
        OptionsParser parser = new OptionsParser();
        RectangularMap mapa1 = new RectangularMap(3,3);
        IWorldMap map1 = mapa1;
        Vector2d[] p1 = {new Vector2d(0, 0), new Vector2d(1, 0), new Vector2d(2, 0)};
        String[] m1 = {"f", "f", "f", "f", "f", "f", "f", "f", "f","l","f","r"};
        SimulationEngine engine = new SimulationEngine(parser.parse(m1), map1, p1);
        //when
        System.out.println("BEFORE:");
        System.out.println(mapa1.toString());
        engine.run();
        System.out.println("AFTER:");
        System.out.println(mapa1.toString());
        //then
        LinkedList<Animal> a = engine.getAnimals();
        assertEquals(a.get(0).getPosition(), new Vector2d(0, 3));
        assertEquals(a.get(1).getPosition(), new Vector2d(1, 3));
        assertEquals(a.get(2).getPosition(), new Vector2d(2, 3));



    }
}