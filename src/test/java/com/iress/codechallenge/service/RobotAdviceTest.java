package com.iress.codechallenge.service;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;

import com.iress.codechallenge.constant.Direction;

public class RobotAdviceTest {

    private RobotAdvice advice;
    private RobotHelper helper;

    @Before
    public void before() {
        advice = new RobotAdvice();
        helper = mock(RobotHelper.class);
        advice.setRobot(helper);
    }

    @Test
    public void checkIfRobotCanMove() throws RobotException {
        advice.input("MOVE");
        verify(helper).move();
    }

    @Test
    public void checkIfCaseInsensitive() throws RobotException {
        advice.input("LEFt");
        verify(helper).left();
    }

    @Test
    public void checkIfRobotCanPlace() throws RobotException {
        advice.input("PLACE 00,11,NORTH");
        verify(helper).place(00,11, Direction.NORTH);
    }

    @Test
    public void checkIfRobotCanCallLeft() throws RobotException {
        advice.input("LEFT");
        verify(helper).left();
    }

    @Test
    public void checkIfRobotCanCallRight() throws RobotException {
        advice.input("RIGHT");
        verify(helper).right();
    }

    @Test
    public void checkIfRobotCanCallReport() throws RobotException {
        when(helper.report()).thenReturn(MOCK_REPORT);
        assertEquals(MOCK_REPORT, advice.input("REPORT"));
    }

    @Test
    public void checkIfValidPlaceCommand() throws RobotException {
        assertEquals(INVALID_INPUT, advice.input("PLACE FOO,1,NORTH"));
    }

    @Test
    public void checkIfValidArgumentForPlaceCommand() throws RobotException {
        assertEquals(INVALID_INPUT, advice.input("PLACE 1,1,FOO"));
    }

    @Test
    public void shouldThrowErrorMessage() throws RobotException {
        assertEquals(INVALID_INPUT, advice.input("FOO BAR"));
    }

    @Test
    public void shouldThrowErrorWhenNoInputGiven() throws RobotException {
        assertEquals(INVALID_INPUT, advice.input(""));
    }

    private static String INVALID_INPUT = "Invalid input";
    private static String MOCK_REPORT = "mock report";

}