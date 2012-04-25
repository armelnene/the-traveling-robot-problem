package com.etapix.travelingrobot;

import java.util.*;

/**
 *
 * @author Armel
 */
public final class Robot {

    // used to store the distances that the robot can execute
    private Distance[] distances;
    // time required for the robot to recuperate before executing the instruction
    private int restTime;
    // stores fastest time to reach the final destination
    private int[] fastestTime;
    // stores the best path to reach the final destination
    private Distance[] bestPath;

    public Robot(int rest, Distance... distances) {
        this.restTime = rest;
        this.distances = distances;
    }

    /**
     * @return the distances
     */
    public Distance[] getDistances() {
        return distances;
    }

    /**
     * @return the restTime
     */
    public int getRestTime() {
        return restTime;
    }

    /**
     * This method implements a dynamic programming approach to calculating the 
     * the fastest time to a destination as explained http://en.wikipedia.org/wiki/Dynamic_programming
     * instead of using a recursive 
     * @param km - the destination length that the robot needs to travel to
     * @return 
     */
    public List<Integer> shortestTimeToTravelTo(int km) {
       
        bestPath = new Distance[km + 1];
        fastestTime = new int[km + 1];

        Arrays.fill(fastestTime, Integer.MAX_VALUE);
        fastestTime[0] = 0;

        for (int i = 0; i <= km; i++) {
            for (Distance dist : distances) {
                int j = i - dist.getDistance();

                if (j >= 0 && fastestTime[j] < Integer.MAX_VALUE
                        && fastestTime[i] > fastestTime[j] + dist.getTime() + restTime) {

                    fastestTime[i] = fastestTime[j] + dist.getTime() + restTime;
                    bestPath[i] = dist;
                }
            }
        }
        return getFastestPath(km);
    }

    private List<Integer> getFastestPath(int km) {
        Deque<Integer> dists = new ArrayDeque<Integer>();

        if (fastestTime[km] != Integer.MAX_VALUE) {
            int k = km;

            while (k > 0) {
                dists.addFirst(bestPath[k].getDistance());
                k -= bestPath[k].getDistance();
            }
        }

        return new ArrayList<Integer>(dists);
    }
}
