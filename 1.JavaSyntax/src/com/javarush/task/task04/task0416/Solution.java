package com.javarush.task.task04.task0416;

/* 
Переходим дорогу вслепую
*/

import java.io.*;

public class Solution {
    public enum TrafficLight {
        GREEN,
        YELLOW,
        RED,
    }

    public static void main(String[] args) throws Exception {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            Double time = Double.valueOf(reader.readLine());
            Double start = 0.0;

            boolean continued = true;
            TrafficLight trafficLight = TrafficLight.GREEN;
            while (continued) {
                switch (trafficLight) {
                    case GREEN:
                        start += 3.0;
                        trafficLight = TrafficLight.YELLOW;
                        break;
                    case YELLOW:
                        start += 1.0;
                        trafficLight = TrafficLight.RED;
                        break;
                    case RED:
                        start += 1.0;
                        trafficLight = TrafficLight.GREEN;
                        break;
                }
                if (start > time) {
                    continued = false;
                }
            }

            switch (trafficLight) {
                case GREEN:
                    System.out.println("красный");
                    break;
                case YELLOW:
                    System.out.println("зелёный");
                    break;
                case RED:
                    System.out.println("жёлтый");
                    break;
            }
        }
    }
}
