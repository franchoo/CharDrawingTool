package com.hugeinc.java.chartool.command.impl;

import java.awt.Dimension;

import com.hugeinc.java.chartool.CharCanvas;
import com.hugeinc.java.chartool.command.CharCommand;

/**
 * Command to create a new {@link CharCanvas}.
 * 
 * @author Frank Cardona
 */
public class CharCanvasCmd implements CharCommand {
	private Dimension d;

	CharCanvasCmd(Dimension d) {
		this.d = d;
	}

	@Override
	public void exec(CharCanvas canvas) {
		canvas.setup(d.width, d.height);
	}

}
