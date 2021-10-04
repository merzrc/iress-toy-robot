package com.iress.codechallenge.service;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import com.iress.codechallenge.constant.Direction;

public class RobotHelperTest {
	public static final int SIZE = 5;
    private RobotHelper robotHelper;

    @Before
    public void before() {
        robotHelper = new RobotHelper();
    }

    @Test
    public void checkIfRobotMoveLeft() throws RobotException {
        robotHelper.place(0, 0, Direction.NORTH);
        robotHelper.left();
        assertEquals(robotHelper.report(), "0,0,WEST");
    }

    @Test
    public void checkIfRobotCanRotateLeft() throws RobotException {
        robotHelper.place(0, 0, Direction.NORTH);
        for (int i = 0; i < 4; i++) {
            robotHelper.left();
        }
        assertEquals(robotHelper.report(), "0,0,NORTH");
    }

    @Test
    public void checkIfRobotMoveRight() throws RobotException {
        robotHelper.place(0, 0, Direction.NORTH);
        robotHelper.right();
        assertEquals(robotHelper.report(), "0,0,EAST");
    }

    @Test
    public void checkIfRobotRorateRight() throws RobotException {
        robotHelper.place(0, 0, Direction.NORTH);
        for (int i = 0; i < 4; i++) {
            robotHelper.right();
        }
        assertEquals(robotHelper.report(), "0,0,NORTH");
    }

    @Test
    public void checkIfRobotCanMoveOnce() throws RobotException {
        robotHelper.place(0, 0, Direction.NORTH);
        robotHelper.move();
        assertEquals(robotHelper.report(), "0,1,NORTH");
    }

    @Test
    public void checkIfRobotMoveTwice() throws RobotException {
        robotHelper.place(0, 0, Direction.NORTH);
        robotHelper.move();
        robotHelper.move();
        assertEquals(robotHelper.report(), "0,2,NORTH");
    }

    @Test
    public void checkIfRobotCanMoveLeftTwice() throws RobotException {
        robotHelper.place(0, 0, Direction.NORTH);
        robotHelper.left();
        robotHelper.left();
        assertEquals(robotHelper.report(), "0,0,SOUTH");
    }

    @Test
    public void checkIfRobotCanMoveLeftThrice() throws RobotException {
        robotHelper.place(0, 0, Direction.NORTH);
        for (int i = 0; i < 3; i++) {
            robotHelper.left();
        }
        assertEquals(robotHelper.report(), "0,0,EAST");
    }

    @Test
    public void shouldIgnoreMovingOffTable() throws RobotException {
        robotHelper.place(0, 0, Direction.NORTH);
        for (int i = 0; i < SIZE + 1; i++) {
            robotHelper.move();
        }
        assertEquals(robotHelper.report(), "0,4,NORTH");
    }

    @Test
    public void shouldCombineMovingAndRotating() throws RobotException {
        robotHelper.place(1, 2, Direction.EAST);
        robotHelper.move();
        robotHelper.move();
        robotHelper.left();
        robotHelper.move();
        assertEquals(robotHelper.report(), "3,3,NORTH");
    }


    @Test
    public void shouldNotPlaceInNegativePosition() throws RobotException {
        robotHelper.place(-1, -1, Direction.NORTH);
        assertEquals(robotHelper.report(), "");
    }

    @Test
    public void shouldNotPlaceOffTable() throws RobotException {
        robotHelper.place(SIZE + 1, SIZE + 1, Direction.NORTH);
        assertEquals(robotHelper.report(), "");
    }

    @Test
    public void shouldIgnoreLeftIfNotPlaced() throws RobotException {
        robotHelper.left();
        assertEquals(robotHelper.report(), "");
    }

    @Test
    public void shouldIgnoreRightIfNotPlaced() throws RobotException {
        robotHelper.right();
        assertEquals(robotHelper.report(), "");
    }

    @Test
    public void shouldIgnoreIfNotPlaced() throws RobotException {
        robotHelper.report();
        assertEquals(robotHelper.report(), "");
    }

    @Test
    public void shouldPlaceOnTable() throws RobotException {
        robotHelper.place(0, 0, Direction.NORTH);
        assertEquals(robotHelper.report(), "0,0,NORTH");
    }

    @Test
    public void shouldReplaceOnTable() throws RobotException {
        robotHelper.place(0, 0, Direction.NORTH);
        robotHelper.place(3, 3, Direction.SOUTH);
        assertEquals(robotHelper.report(), "3,3,SOUTH");
    }

    @Test
    public void shouldIgnoreMovingOffTableAllSides() throws RobotException {
        robotHelper.place(0, 0, Direction.NORTH);

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < SIZE + 1; j++) {
                robotHelper.move();
            }

            robotHelper.right();
        }

        assertEquals(robotHelper.report(), "0,0,NORTH");
    }
}