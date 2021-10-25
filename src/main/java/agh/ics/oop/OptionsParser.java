package agh.ics.oop;

public class OptionsParser {


    public MoveDirection[] parse(String[] array) {
        int size = 0;
        for (String s : array) {
            if (s.equals("f") || s.equals("forward") || s.equals("b") || s.equals("backward") || s.equals("r") || s.equals("right") || s.equals("l") || s.equals("left")) {
                size += 1;
            }
        }
        MoveDirection[] result = new MoveDirection[size];
        int i = 0;
        for (String s : array) {
            switch (s) {
                case "f", "forward" -> {
                    result[i] = MoveDirection.FORWARD;
                    i += 1;
                }
                case "b", "backward" -> {
                    result[i] = MoveDirection.BACKWARD;
                    i += 1;
                }
                case "r", "right" -> {
                    result[i] = MoveDirection.RIGHT;
                    i += 1;
                }
                case "l", "left" -> {
                    result[i] = MoveDirection.LEFT;
                    i += 1;
                }
            }
        }
        return result;

    }
}
