package de.jebc.editor.model.utils;

import org.eclipse.ui.IEditorInput;

import de.jebc.editor.model.ModelObject;

public class ModelProvider {

	private final IEditorInput input;
	private ModelObject model;

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
	}

}
