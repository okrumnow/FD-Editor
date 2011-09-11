package de.jebc.editor.controller;

import java.util.Random;

import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.gef.editparts.AbstractGraphicalEditPart;

import de.jebc.editor.model.Process;
import de.jebc.editor.ui.figures.ProcessFigure;

public class ProcessController extends AbstractGraphicalEditPart {

	Random rand = new Random();
	
	@Override
	protected IFigure createFigure() {
		return new ProcessFigure();
	}

	@Override
	protected void createEditPolicies() {
	}

	@Override
	protected void refreshVisuals() {
		super.refreshVisuals();
		ProcessFigure processFigure = (ProcessFigure) getFigure();
		Process model = (Process) getModel();
		FlowEditorController parent = (FlowEditorController) getParent();

		processFigure.getLabel().setText(model.getName());
		Rectangle layout = new Rectangle(rand.nextInt(300), rand.nextInt(300), 50, 50);
		parent.setLayoutConstraint(this, processFigure, layout);
	}
}
