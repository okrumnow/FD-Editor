package de.jebc.editor.model.utils;

import de.jebc.editor.model.ModelObject;
import de.jebc.editor.model.Process;

public final class TestModelFactory {

	public static ModelObject create() {
		ModelObject result = new Process("Test");
		return result;
	}
}
