package com.hugeinc.java.chartool.command.impl;

import java.awt.Point;

import com.hugeinc.java.chartool.CharCanvas;
import com.hugeinc.java.chartool.command.CharCommand;

/**
 * Command to create rectangle in {@link CharCanvas}.
 * 
 * @author Frank Cardona
 */
public class CharRectangleCmd implements CharCommand {
	private Point p1;
	private Point p2;
	private Point p3;
	private Point p4;

	CharRectangleCmd(Point p1, Point p3) {
		this.p1 = p1;
		this.p2 = new Point(p3.x, p1.y);
		this.p3 = p3;
		this.p4 = new Point(p1.x, p3.y);
	}

	@Override
	public void exec(CharCanvas canvas) {
		if (!canvas.contains(p1.x, p1.y) || !canvas.contains(p3.x, p3.y)) {
			throw new IllegalArgumentException("Point outside of canvas bounds.");
		}
		new CharLineCmd(p1, p2).exec(canvas);
		new CharLineCmd(p2, p3).exec(canvas);
		new CharLineCmd(p3, p4).exec(canvas);
		new CharLineCmd(p4, p1).exec(canvas);
	}

}
