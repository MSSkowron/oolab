package agh.ics.oop;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static agh.ics.oop.MapDirection.*;

class MapDirectionTest {

    @Test
    void next() {
        //given
        MapDirection n = NORTH;
        MapDirection s = SOUTH;
        MapDirection e = EAST;
        MapDirection w = WEST;

        //when
        MapDirection res_n = n.next();
        MapDirection res_s = s.next();
        MapDirection res_e = e.next();
        MapDirection res_w = w.next();

        //then
        Assertions.assertEquals(EAST, res_n);
        Assertions.assertEquals(WEST, res_s);
        Assertions.assertEquals(SOUTH, res_e);
        Assertions.assertEquals(NORTH, res_w);
    }

    @Test
    void previous() {
        //given
        MapDirection n = NORTH;
        MapDirection s = SOUTH;
        MapDirection e = EAST;
        MapDirection w = WEST;

        //when
        MapDirection res_n = n.previous();
        MapDirection res_s = s.previous();
        MapDirection res_e = e.previous();
        MapDirection res_w = w.previous();

        //then
        Assertions.assertEquals(WEST, res_n);
        Assertions.assertEquals(EAST, res_s);
        Assertions.assertEquals(NORTH, res_e);
        Assertions.assertEquals(SOUTH, res_w);
    }
}