package com.hugeinc.java.chartool.command.impl;

import java.awt.Point;
import java.util.stream.IntStream;

import com.hugeinc.java.chartool.CharCanvas;
import com.hugeinc.java.chartool.command.CharCommand;

/**
 * Command to create bucket fill in {@link CharCanvas}.
 * 
 * @author Frank Cardona
 */
public class CharBucketCmd implements CharCommand {
	private Point p;
	private char c;

	CharBucketCmd(Point p, char c) {
		this.p = p;
		this.c = c;
	}

	@Override
	public void exec(CharCanvas canvas) {
		if (!canvas.contains(p.x, p.y)) {
			throw new IllegalArgumentException("Point outside of canvas bounds.");
		}
		fill(canvas, p.x, p.y, c, canvas.get(p.x, p.y));
	}

	private static void fill(CharCanvas canvas, int x, int y, char c, char t) {
		if (canvas.contains(x, y) && canvas.replace(x, y, c, t)) {
			// find the left side, filling along the way
			int left = x;
			while (canvas.contains(--left, y) && canvas.replace(left, y, c, t))
				;
			// find the right side, filling along the way
			int right = x;
			while (canvas.contains(++right, y) && canvas.replace(right, y, c, t))
				;
			// checks if applicable up or down
			IntStream.rangeClosed(++left, --right).parallel()
					.forEach(i -> IntStream.of(y - 1, y + 1).parallel().forEach(j -> fill(canvas, i, j, c, t)));
		}
	}

}
