package com.etapix.travelingrobot;

import com.etapix.travelingrobot.Distance;
import com.etapix.travelingrobot.Robot;
import java.util.ArrayList;
import java.util.List;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */
public class RobotAppTest
        extends TestCase {

    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public RobotAppTest(String testName) {
        super(testName);
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite() {
        return new TestSuite(RobotAppTest.class);
    }

    public void testWhenGiven43KMFindQuickestTravelTime() {

        Distance distances[] = {new Distance(1, 10), new Distance(2, 5), new Distance(3, 3),
            new Distance(5, 2), new Distance(10, 1)};

        Robot robot = new Robot(2, distances);
        int km = 43;
       

        List<Integer> expectedValues = new ArrayList<Integer>() {

            {

                add(10);
                add(10);
                add(10);
                add(10);
                add(3);

            }
        };

        assertEquals(expectedValues, robot.shortestTimeToTravelTo(km));
    }
}
