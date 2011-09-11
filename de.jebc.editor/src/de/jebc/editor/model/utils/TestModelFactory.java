package de.jebc.editor.model.utils;

import de.jebc.editor.model.FlowDiagram;
import de.jebc.editor.model.ModelObject;
import de.jebc.editor.model.Process;

public final class TestModelFactory {

	public static ModelObject create() {
		FlowDiagram result = new FlowDiagram("Test");
		result.setObject(new Process("Setze Inhalte"));
		return result;
	}
}
