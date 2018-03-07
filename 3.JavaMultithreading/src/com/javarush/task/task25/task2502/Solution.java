package com.javarush.task.task25.task2502;

import java.util.*;

/* 
Машину на СТО не повезем!
*/
public class Solution {
    public static enum Wheel {
        FRONT_LEFT,
        FRONT_RIGHT,
        BACK_LEFT,
        BACK_RIGHT
    }

    public static class Car {
        protected List<Wheel> wheels;

        public Car() {
            wheels = new ArrayList<>();
            List<String> wheelNames = new ArrayList<>();
            for (Wheel wheel: Wheel.values()) {
                wheelNames.add(wheel.name());
            }

            String[] lwnfDb = loadWheelNamesFromDB();
            if (lwnfDb.length != 4) {
                throw new IllegalArgumentException("Колес больше или меньше четырех.");
            }
            for (String wheelName : lwnfDb) {
                Optional<String> founded = wheelNames.stream().filter(wheel -> wheel.equals(wheelName)).findFirst();
                if (founded.isPresent()) {
                    wheels.add(Wheel.valueOf(wheelName));
                } else {
                    throw new IllegalArgumentException("This [" + wheelName + "] is't wheel.");
                }
            }
        }

        protected String[] loadWheelNamesFromDB() {
            //this method returns mock data
            return new String[]{"FRONT_LEFT", "FRONT_RIGHT", "BACK_LEFT", "BACK_RIGHT"};
        }

        public List<Wheel> getWheels() {
            return wheels;
        }
    }

    public static void main(String[] args) {
        Car car = new Car();
    }
}
