package agh.ics.oop;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Vector2dTest {

    @Test
    void testToStringTest() {
        //given
        Vector2d vector = new Vector2d(1, 1);

        //when
        String result = vector.toString();

        //then
        Assertions.assertEquals("Vector2d{" + "x=" + 1 + ", y=" + 1 + '}', result);

    }

    @Test
    void precedesTest() {
        //given
        Vector2d vector = new Vector2d(1, 1);
        Vector2d vector_t = new Vector2d(0, 0);
        Vector2d vector_f = new Vector2d(2, 2);
        Vector2d vector_s = new Vector2d(1, 1);
        Vector2d wrong_arg = null;

        //when
        Boolean result_t = vector.precedes(vector_t);
        Boolean result_f = vector.precedes(vector_f);
        Boolean result_s = vector.precedes(vector_s);
        //then
        Assertions.assertEquals(false, result_t);
        Assertions.assertEquals(true, result_f);
        Assertions.assertEquals(true, result_s);
    }

    @Test
    void followsTest() {
        //given
        Vector2d vector = new Vector2d(1, 1);
        Vector2d vector_t = new Vector2d(0, 0);
        Vector2d vector_f = new Vector2d(2, 2);
        Vector2d vector_s = new Vector2d(1, 1);
        Vector2d wrong_arg = null;

        //when
        Boolean result_t = vector.follows(vector_t);
        Boolean result_f = vector.follows(vector_f);
        Boolean result_s = vector.follows(vector_s);
        //then
        Assertions.assertEquals(true, result_t);
        Assertions.assertEquals(false, result_f);
        Assertions.assertEquals(true, result_s);
    }

    @Test
    void upperRightTest() {
        //given
        Vector2d vector = new Vector2d(1, 1);
        Vector2d vector2 = new Vector2d(2, 2);
        Vector2d wrong_arg = null;

        //when
        Vector2d result = vector.upperRight(vector2);
        //then
        Assertions.assertEquals(new Vector2d(2, 2), result);
    }

    @Test
    void lowerLeftTest() {
        //given
        Vector2d vector = new Vector2d(1, 1);
        Vector2d vector2 = new Vector2d(2, 2);
        Vector2d wrong_arg = null;

        //when
        Vector2d result = vector.lowerLeft(vector2);
        //then
        Assertions.assertEquals(new Vector2d(1, 1), result);
    }

    @Test
    void addTest() {
        //given
        Vector2d vector = new Vector2d(1, 1);
        Vector2d vector2 = new Vector2d(2, 2);
        Vector2d wrong_arg = null;

        //when
        Vector2d result = vector.add(vector2);
        //then
        Assertions.assertEquals(new Vector2d(3, 3), result);
    }

    @Test
    void subtractTest() {
        //given
        Vector2d vector = new Vector2d(1, 1);
        Vector2d vector2 = new Vector2d(2, 2);
        Vector2d wrong_arg = null;

        //when
        Vector2d result = vector.subtract(vector2);
        //then
        Assertions.assertEquals(new Vector2d(-1, -1), result);
    }


    @Test
    void testEqualsTest() {
        //given
        Vector2d vector = new Vector2d(1, 1);
        Vector2d vector_same = new Vector2d(1, 1);
        Vector2d vector_other = new Vector2d(2, 1);

        //when
        Boolean r_same = vector.equals(vector_same);
        Boolean r_diff_class = false;
        Boolean r_diff_vec = vector.equals(vector_other);


        //then
        Assertions.assertEquals(true, r_same);
        Assertions.assertEquals(false, r_diff_class);
        Assertions.assertEquals(false, r_diff_vec);
    }

    @Test
    void oppositeTest() {
        //given
        Vector2d vector_p_p = new Vector2d(1, 1);
        Vector2d vector_p_n = new Vector2d(1, -1);
        Vector2d vector_n_p = new Vector2d(-1, 1);
        Vector2d vector_n_n = new Vector2d(-1, -1);
        Vector2d vector_p_z = new Vector2d(1, 0);
        Vector2d vector_z_p = new Vector2d(0, 1);
        Vector2d vector_z_z = new Vector2d(0, 0);

        //when
        Vector2d o_p_p = vector_p_p.opposite();
        Vector2d o_p_n = vector_p_n.opposite();
        Vector2d o_n_p = vector_n_p.opposite();
        Vector2d o_n_n = vector_n_n.opposite();
        Vector2d o_p_z = vector_p_z.opposite();
        Vector2d o_z_p = vector_z_p.opposite();
        Vector2d o_z_z = vector_z_z.opposite();

        //then
        Assertions.assertEquals(new Vector2d(-1, -1), o_p_p);
        Assertions.assertEquals(new Vector2d(-1, 1), o_p_n);
        Assertions.assertEquals(new Vector2d(1, -1), o_n_p);
        Assertions.assertEquals(new Vector2d(1, 1), o_n_n);
        Assertions.assertEquals(new Vector2d(-1, 0), o_p_z);
        Assertions.assertEquals(new Vector2d(0, -1), o_z_p);
        Assertions.assertEquals(new Vector2d(0, 0), o_z_z);
    }
}