package com.iress.codechallenge;

import java.util.Scanner;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.iress.codechallenge.service.RobotAdvice;

@SpringBootApplication
public class Application implements CommandLineRunner {


	public static final String EXIT = "exit";

	public static void main(String... args) {
		System.out.println("Toy RobotHelper Simulator\n");
		System.out.println("Enter Command: (PLACE X,Y,F, MOVE, LEFT, RIGHT, REPORT, EXIT (to exit))");
		SpringApplication.run(Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		RobotAdvice advice = new RobotAdvice();
		try (Scanner scanner = new Scanner(System.in)) {
			String input;
			do {
				input = scanner.nextLine();
				System.out.println(advice.input(input));
			} while (!EXIT.equalsIgnoreCase(input));
		}
	}
}