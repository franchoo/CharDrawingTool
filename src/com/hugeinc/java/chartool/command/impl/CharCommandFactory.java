package com.hugeinc.java.chartool.command.impl;

import java.awt.Dimension;
import java.awt.Point;
import java.security.InvalidParameterException;
import java.util.NoSuchElementException;
import java.util.Scanner;

import com.hugeinc.java.chartool.CharCanvas;
import com.hugeinc.java.chartool.command.CharCommand;

/**
 * Factory implementation for {@link CharCommand}.
 * 
 * @author Frank Cardona
 */
public final class CharCommandFactory {

	/** Generates {@link CharCanvas} command from input. */
	public static CharCommand generate(String cmd) {
		CharCommand command = null;
		try (Scanner scanner = new Scanner(cmd)) {
			switch (scanner.next()) {
			case "C":
				command = new CharCanvasCmd(new Dimension(scanner.nextInt(), scanner.nextInt()));
				break;
			case "L":
				command = new CharLineCmd(new Point(scanner.nextInt() - 1, scanner.nextInt() - 1),
						new Point(scanner.nextInt() - 1, scanner.nextInt() - 1));
				break;
			case "R":
				command = new CharRectangleCmd(new Point(scanner.nextInt() - 1, scanner.nextInt() - 1),
						new Point(scanner.nextInt() - 1, scanner.nextInt() - 1));
				break;
			case "B":
				command = new CharBucketCmd(new Point(scanner.nextInt() - 1, scanner.nextInt() - 1),
						scanner.next(".").charAt(0));
				break;
			case "Q":
				break;
			default:
				throw new UnsupportedOperationException("Command not recognized.");
			}
		} catch (NoSuchElementException e) {
			throw new InvalidParameterException("Invalid command parameter.");
		}
		return command;
	}

}
