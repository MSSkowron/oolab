package agh.ics.oop;

import java.util.LinkedList;

public class OptionsParser {


    public MoveDirection[] parse(String[] array) throws IllegalArgumentException{
        LinkedList<MoveDirection> directions = new LinkedList<>();

        for (String s : array) {
            switch (s) {
                case "f","F", "forward" -> directions.add(MoveDirection.FORWARD);

                case "b","B", "backward" -> directions.add(MoveDirection.BACKWARD);

                case "r","R", "right" -> directions.add(MoveDirection.RIGHT);

                case "l","L", "left" -> directions.add(MoveDirection.LEFT);

                default -> throw new IllegalArgumentException(s + " is not legal move specification");
            }
        }
        MoveDirection[] result = new MoveDirection[directions.size()];
        int i = 0;
        for (MoveDirection direction:directions){
            result[i]=direction;
            i+=1;
        }
        return result;
    }
}
