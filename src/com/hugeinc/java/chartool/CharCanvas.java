package com.hugeinc.java.chartool;

import java.awt.Rectangle;
import java.io.PrintStream;
import java.util.Arrays;

/**
 * Character represented canvas.
 * 
 * @author Frank Cardona
 */
public class CharCanvas {
	private char[][] canvas;
	private Rectangle bounds = new Rectangle();

	/** Validates if point{@code (x,y)} is inside of bounds. */
	public boolean contains(int x, int y) throws UnsupportedOperationException {
		if (bounds.isEmpty()) {
			throw new UnsupportedOperationException("No canvas defined, create one first.");
		}
		return bounds.contains(x, y);
	}

	/** Gets character at point{@code (x,y)}. */
	public char get(int x, int y) {
		return canvas[y][x];
	}

	/** Puts character {@code c} at point{@code (x,y)} if it isn't {@code c}. */
	public boolean put(int x, int y, char c) {
		return canvas[y][x] != c && (canvas[y][x] = c) == c;
	}

	/** Replaces character {@code c} at point{@code (x,y)} if it's {@code t}. */
	public boolean replace(int x, int y, char c, char t) {
		return get(x, y) == t && put(x, y, c);
	}

	/** Sets up the new canvas and dimensions{@code (w*h)}. */
	public void setup(int w, int h) throws IllegalArgumentException {
		if (w < 1 || h < 1) {
			throw new IllegalArgumentException("Width and Height should be positive values.");
		}
		bounds.setSize(w, h);
		canvas = new char[h][w];
		for (char[] row : canvas) {
			Arrays.fill(row, ' ');
		}
	}

	/** Sends content to {@code stream}. */
	public void toStream(PrintStream stream) {
		char[] lines = new char[canvas[0].length + 2];
		Arrays.fill(lines, '-');
		stream.println(lines);
		Arrays.stream(canvas).forEachOrdered(row -> {
			stream.print('|');
			stream.print(row);
			stream.println('|');
		});
		stream.println(lines);
	}

}
