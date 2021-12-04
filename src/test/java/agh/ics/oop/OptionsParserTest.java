package agh.ics.oop;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OptionsParserTest {

    @Test
    void parse() {
        String[] m1 = {"f", "f", "f"};
        String[] m2 = {"f", "f", "wrongParameter"};
        MoveDirection[] directionArray = {MoveDirection.FORWARD,MoveDirection.FORWARD,MoveDirection.FORWARD};
        OptionsParser parser = new OptionsParser();
        try {
            MoveDirection[] directions2 = parser.parse(m2);
        }
        catch (IllegalArgumentException exception){
            Assertions.assertEquals("wrongParameter" + " is not legal move specification",exception.getMessage());
        }

        MoveDirection[] directions1 = parser.parse(m1);
        Assertions.assertArrayEquals(directionArray, directions1);
    }
}