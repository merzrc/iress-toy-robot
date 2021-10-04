package com.iress.codechallenge.model;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.iress.codechallenge.constant.Direction;
import com.iress.codechallenge.service.RobotException;

public class DirectionTest {

    @Test
    public void checkifRobotMovesLeft() throws RobotException {
        assertEquals(Direction.EAST, Direction.SOUTH.moveLeft());
    }

    @Test
    public void checkIfRobotMovesToLastElementWhenAtFirstElement() throws RobotException {
        assertEquals(Direction.WEST, Direction.NORTH.moveLeft());
    }

    @Test
    public void checkIfRobotMovesRight() throws RobotException {
        assertEquals(Direction.EAST, Direction.NORTH.moveRight());
    }

    @Test
    public void checkIfRobotMovesToFirstElementWhenAtLastElement() throws RobotException {
        assertEquals(Direction.NORTH, Direction.WEST.moveRight());
    }

}