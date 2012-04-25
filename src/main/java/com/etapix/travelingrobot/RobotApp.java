package com.etapix.travelingrobot;

import java.util.*;

/**
 * Hello world!
 *
 */
public class RobotApp {

    public static void main(String[] args) {
        Distance distances[] = {new Distance(1, 10), new Distance(2, 5), new Distance(3, 3),
            new Distance(5, 2), new Distance(10, 1)};

        Robot robot = new Robot(2, distances);
        int km = 43;

        for (int distance : robot.shortestTimeToTravelTo(km)) {
            System.out.println(distance);
        }
    }
}
