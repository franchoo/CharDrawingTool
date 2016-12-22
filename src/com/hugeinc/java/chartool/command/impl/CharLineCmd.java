package com.hugeinc.java.chartool.command.impl;

import java.awt.Point;
import java.util.PrimitiveIterator.OfInt;
import java.util.stream.IntStream;

import com.hugeinc.java.chartool.CharCanvas;
import com.hugeinc.java.chartool.command.CharCommand;

/**
 * Command to create line in {@link CharCanvas}.
 * 
 * @author Frank Cardona
 */
public class CharLineCmd implements CharCommand {
	private Point p1;
	private Point p2;

	CharLineCmd(Point p1, Point p2) {
		this.p1 = p1;
		this.p2 = p2;
	}

	@Override
	public void exec(CharCanvas canvas) {
		if (!canvas.contains(p1.x, p1.y) || !canvas.contains(p2.x, p2.y)) {
			throw new IllegalArgumentException("Point outside of canvas bounds.");
		}
		if (p1.y == p2.y) {
			OfInt xs = IntStream.of(p1.x, p2.x).sorted().iterator();
			IntStream.rangeClosed(xs.nextInt(), xs.nextInt()).parallel().forEach(x -> canvas.put(x, p1.y, 'x'));
		} else if (p1.x == p2.x) {
			OfInt ys = IntStream.of(p1.y, p2.y).sorted().iterator();
			IntStream.rangeClosed(ys.nextInt(), ys.nextInt()).parallel().forEach(y -> canvas.put(p1.x, y, 'x'));
		} else {
			throw new IllegalArgumentException("Currently only horizontal or vertical lines are supported.");
		}
	}

}
