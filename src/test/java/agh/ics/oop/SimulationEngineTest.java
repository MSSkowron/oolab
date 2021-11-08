package agh.ics.oop;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class SimulationEngineTest {
    @Test
    void simulationTest(){
        //given
        String[] array = {"f","b","r","l","f","f","r","r","f","f","f","f","f","f","f","f","f","f"};
        MoveDirection[] directions = new OptionsParser().parse(array);
        RectangularMap mapa = new RectangularMap(10, 10);
        IWorldMap map = mapa;
        Vector2d[] positions = { new Vector2d(2,2), new Vector2d(3,4) };
        Vector2d endPos1 = new Vector2d(2,0);
        MapDirection endDir1 = MapDirection.SOUTH;
        Vector2d endPos2 = new Vector2d(3,8);
        MapDirection endDir2 = MapDirection.NORTH;
        IEngine engine = new SimulationEngine(directions, map, positions);
        //when
        engine.run();
        Vector2d resP1 = mapa.getAnimal(0).getPosition();
        MapDirection resD1 = mapa.getAnimal(0).getDirection();
        Vector2d resP2 = mapa.getAnimal(1).getPosition();
        MapDirection resD2 = mapa.getAnimal(1).getDirection();
        //then
        Assertions.assertEquals(endPos1,resP1);
        Assertions.assertEquals(endDir1,resD1);
        Assertions.assertEquals(endPos2,resP2);
        Assertions.assertEquals(endDir2,resD2);

    }
}