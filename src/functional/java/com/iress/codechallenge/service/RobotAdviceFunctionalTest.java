package com.iress.codechallenge.service;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class RobotAdviceFunctionalTest {

    private RobotAdvice advice;

    @Before
    public void before() {
        advice = new RobotAdvice();
    }

    @Test
    public void shouldMoveAndRotate() throws Exception {
        advice.input("PLACE 1,2,EAST");
        advice.input("MOVE");
        advice.input("MOVE");
        advice.input("LEFT");
        advice.input("MOVE");
        assertEquals("3,3,NORTH", advice.input("REPORT"));
    }

    @Test
    public void shouldIgnoreInputsBeforeValidPlace() throws Exception {
        advice.input("PLACE -1,0,NORTH");
        advice.input("LEFT");
        assertEquals("", advice.input("REPORT"));
    }

    @Test
    public void shouldNotFallOffTable() throws Exception {
        advice.input("PLACE 10,2,EAST");
        advice.input("MOVE");
        advice.input("PLACE 4,4,NORTH");
        advice.input("MOVE");
        advice.input("LEFT");

        for (int i = 0; i < 7; i++) {
            advice.input("MOVE");
        }

        assertEquals("0,4,WEST", advice.input("REPORT"));
    }

    @Test
    public void shouldPlace() throws Exception {
        advice.input("PLACE 0,0,NORTH");
        assertEquals("0,0,NORTH", advice.input("REPORT"));
    }

    @Test
    public void shouldPlaceAndMove() throws Exception {
        advice.input("PLACE 0,0,NORTH");
        advice.input("MOVE");
        assertEquals("0,1,NORTH", advice.input("REPORT"));
    }

    @Test
    public void shouldPlaceAndRotate() throws Exception {
        advice.input("PLACE 0,0,NORTH");
        advice.input("LEFT");
        assertEquals("0,0,WEST", advice.input("REPORT"));
    }

    @Test
    public void shouldPlaceAndReplace() throws Exception {
        advice.input("PLACE 0,0,NORTH");
        advice.input("MOVE");
        advice.input("PLACE 3,4,SOUTH");
        assertEquals("3,4,SOUTH", advice.input("REPORT"));
    }

    @Test
    public void shouldReturnEmptyStringOnPlace() throws Exception {
        assertEquals("", advice.input("PLACE 0,0,NORTH"));
    }

    @Test
    public void shouldReturnEmptyStringOnLeft() throws Exception {
        assertEquals("", advice.input("LEFT"));
    }

    @Test
    public void shouldReturnEmptyStringOnRight() throws Exception {
        assertEquals("", advice.input("RIGHT"));
    }

    @Test
    public void shouldReturnEmptyStringOnMOVE() throws Exception {
        assertEquals("", advice.input("MOVE"));
    }
}
