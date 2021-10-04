package com.iress.codechallenge.service;

import com.iress.codechallenge.constant.Direction;

/**
 * {@link RobotAdvice} to process user inputs
 */
public class RobotAdvice {

	/**
	 * Calls the appropriate RobotHelper method depending on input.
	 *
	 * @param input is the user command
	 * @return display Report value
	 */
	public String input(String input) {
		if (input != null) {
			input = input.trim().toLowerCase();

			switch (input) {
			case LEFT:
				helper.left();
				break;

			case RIGHT:
				helper.right();
				break;

			case MOVE:
				helper.move();
				break;

			case REPORT:
				return helper.report();

			default:
				if (validateInput(input)) {
					callPlaceCommand(input);
				} else {
					return INVALID_INPUT;
				}
			}
		}

		return "";
	}

	/**
	 * Parses the input and calls the PLACE command.
	 *
	 * @param input is user input
	 */
	private void callPlaceCommand(String input) {
		String[] args = input.replaceAll("place ", "").split(",");

		int x = Integer.parseInt(args[0]);
		int y = Integer.parseInt(args[1]);
		Direction facing = Direction.valueOf(args[2].toUpperCase());

		helper.place(x, y, facing);
	}

	/**
	 * Check matching of pattern
	 *
	 * @param input
	 * @return true if valid input
	 */
	private boolean validateInput(String input) {
		return input.matches("^place [0-9]+,[0-9]+,(north|south|east|west)");
	}

	private static final String LEFT = "left";
	private static final String RIGHT = "right";
	private static final String MOVE = "move";
	private static final String REPORT = "report";
	private static String INVALID_INPUT = "Invalid input";
	private RobotHelper helper;

	public RobotAdvice() {
		helper = new RobotHelper();
	}

	public void setRobot(RobotHelper robotHelper) {
		this.helper = robotHelper;
	}

}