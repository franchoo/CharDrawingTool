package com.hugeinc.java.chartool.command;

import com.hugeinc.java.chartool.CharCanvas;

/**
 * Command interface for use with {@link CharCanvas}.
 * 
 * @author Frank Cardona
 */
public interface CharCommand {

	/** Execute command on {@code canvas}. */
	void exec(CharCanvas canvas);

}
