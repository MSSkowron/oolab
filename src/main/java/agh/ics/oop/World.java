package agh.ics.oop;

public class World {
    public static void main(String[] args) {
        String[] array = new String[4];
        array[0] = "f";
        array[1] = "f";
        array[2] = "r";
        array[3] = "x";

        Direction[] enumArray = new Direction[array.length];
        for (int i = 0; i < array.length; i++) {
            enumArray[i] = switch (array[i]) {
                case "f" -> Direction.FORWARD;
                case "b" -> Direction.BACKWARD;
                case "r" -> Direction.RIGHT;
                case "l" -> Direction.LEFT;
                default -> Direction.NOTHING;
            };
        }
        System.out.println("System wystartował.");
        run(enumArray);
        System.out.println("System zakończył działanie.");
    }


    public static void run(Direction[] array) {
        for (Direction direction : array) {
            switch (direction) {
                case FORWARD -> forward();
                case BACKWARD -> backward();
                case RIGHT -> right();
                case LEFT -> left();
                case NOTHING -> doNothing();
            }
        }
    }

    public static void forward() {
        System.out.println("Zwierzak idzie do przodu.");
    }

    public static void backward() {
        System.out.println("Zwierzak się cofa.");
    }

    public static void left() {
        System.out.println("Zwierzak skręca w lewo.");
    }

    public static void right() {
        System.out.println("Zwierzak skręca w prawo.");
    }

    public static void doNothing() {
        //Does nothing.
    }
}

