package com.iress.codechallenge.constant;

/**
 * {@link Direction} enum
 */
public enum Direction {
	NORTH, EAST, SOUTH, WEST;

	/**
	 * Moves through right of enum.
	 *
	 * @return the next enum
	 */
	public Direction moveRight() {
		return (this.ordinal() < Direction.values().length - 1) ? Direction.values()[this.ordinal() + 1]
				: Direction.values()[0];
	}

	/**
	 *  Moves through left of enum.
	 *
	 * @return the previous enum
	 */
	public Direction moveLeft() {
		return (this.ordinal() == 0) ? Direction.values()[Direction.values().length - 1]
				: Direction.values()[this.ordinal() - 1];
	}
}
