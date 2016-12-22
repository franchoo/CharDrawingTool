package com.hugeinc.java.chartool;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.Scanner;

import com.hugeinc.java.chartool.command.CharCommand;
import com.hugeinc.java.chartool.command.impl.CharCommandFactory;

/**
 * Char canvas drawing tool, get input from console or file.
 * 
 * @author Frank Cardona
 */
public class CharDrawing {

	public static void main(String[] args) {
		CharCanvas canvas = new CharCanvas();
		String file = args.length == 0 ? null : args[0];
		String cmd = null;
		try (Scanner scanner = file == null ? new Scanner(System.in) : new Scanner(Paths.get(file))) {
			while (file == null ? !"Q".equals(cmd) : scanner.hasNextLine()) {
				System.out.println();
				System.out.print("enter command: ");
				cmd = scanner.nextLine();
				if (file != null) {
					System.out.println(cmd);
				}
				try {
					CharCommand command = CharCommandFactory.generate(cmd);
					if (command != null) {
						command.exec(canvas);
						canvas.toStream(System.out);
					}
				} catch (Exception e) {
					System.out.println(e.getMessage());
				}
			}
		} catch (IOException e) {
			System.out.println("File not found: " + e.getMessage());
		}
	}

}
