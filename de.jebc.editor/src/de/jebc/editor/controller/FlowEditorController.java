package de.jebc.editor.controller;

import java.util.ArrayList;
import java.util.List;

import de.jebc.editor.model.FlowDiagram;

import org.eclipse.draw2d.FreeformLayer;
import org.eclipse.draw2d.FreeformLayout;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.LineBorder;
import org.eclipse.gef.editparts.AbstractGraphicalEditPart;

import de.jebc.editor.model.ModelObject;

public class FlowEditorController extends AbstractGraphicalEditPart {

	@Override
	protected IFigure createFigure() {
		FreeformLayer layer = new FreeformLayer();
		layer.setLayoutManager(new FreeformLayout());
		layer.setBorder(new LineBorder(1));
		return layer;
	}

	@Override
	protected void createEditPolicies() {
	}

	@Override
	protected List<ModelObject> getModelChildren() {
		List<ModelObject> result = new ArrayList<ModelObject>();
		FlowDiagram model = (FlowDiagram) getModel();
		result.add(model.getObject());
		return result;
	}
}
