package de.jebc.editor.model.utils;

import org.eclipse.ui.IEditorInput;

import de.jebc.editor.model.FlowDiagram;
import de.jebc.editor.model.ModelObject;
import de.jebc.editor.model.Process;

public class ModelProvider {

	private final IEditorInput input;
	private FlowDiagram model;

	public ModelProvider(IEditorInput input) {
		this.input = input;
	}

	public ModelObject getModel() {
		if (model == null) {
			buildModel();
		}
		return model;
	}

	private void buildModel() {
		model = new FlowDiagram(input.getName());
		model.setObject(new Process(input.getName()));
	}

}
