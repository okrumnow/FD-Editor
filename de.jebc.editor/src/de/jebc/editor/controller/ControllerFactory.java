package de.jebc.editor.controller;

import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPartFactory;

import de.jebc.editor.model.FlowDiagram;
import de.jebc.editor.model.Process;

public class ControllerFactory implements EditPartFactory {

	@Override
	public EditPart createEditPart(EditPart context, Object model) {
		EditPart result = null;
		
		if (model instanceof FlowDiagram)
			result = new FlowEditorController();
		else if (model instanceof Process)
			result = new ProcessController();
		
		if (result != null)
			result.setModel(model);
		
		return result;
	}

}
