package com.iress.codechallenge.service;

import com.iress.codechallenge.constant.Direction;

/**
 *
 */
public class RobotHelper {

	/**
	 * Move RobotHelper based on direction
	 */
	private void moveForward() {
		switch (dir) {
		case EAST:
			if (onTable(x + 1)) {
				x++;
			}
			break;
		case WEST:
			if (onTable(x - 1)) {
				x--;
			}
			break;
		case NORTH:
			if (onTable(y + 1)) {
				y++;
			}
			break;
		case SOUTH:
			if (onTable(y - 1)) {
				y--;
			}
			break;
		}
	}

	public String report() {
		return placed ? (x + "," + y + "," + dir).toUpperCase() : "";
	}

	public void left() {
		if (placed) {
			dir = dir.moveLeft();
		}
	}

	public void right() {
		if (placed) {
			dir = dir.moveRight();
		}
	}

	public void move() {
		if (placed) {
			moveForward();
		}
	}

	/**
	 * Checks if position is on the table.
	 *
	 * @param place Proposed position
	 * @return true if position is on the table
	 */
	private static boolean onTable(int place) {
		return place >= 0 && place < SIZE ? true : false;
	}

	public void place(int x, int y, Direction facing) {
		if (onTable(x) && onTable(y)) {
			this.x = x;
			this.y = y;
			this.dir = facing;
			placed = true;
		}
	}

	public static final int SIZE = 5;
	private int x, y;
	private Direction dir;
	private boolean placed;

}
