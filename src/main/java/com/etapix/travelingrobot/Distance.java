package com.etapix.travelingrobot;

/**
 *
 * @author Armel
 */
public class Distance {
    private int distance;
    private int time;
    
    public Distance(int distance, int time){
        this.distance = distance;
        this.time = time;
    }

    /**
     * @return the distance
     */
    public int getDistance() {
        return distance;
    }

    /**
     * @return the time
     */
    public int getTime() {
        return time;
    }
}
