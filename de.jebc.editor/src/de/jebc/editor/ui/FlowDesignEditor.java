package de.jebc.editor.ui;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.gef.DefaultEditDomain;
import org.eclipse.gef.palette.PaletteRoot;
import org.eclipse.gef.ui.parts.GraphicalEditorWithFlyoutPalette;

import de.jebc.editor.controller.ControllerFactory;
import de.jebc.editor.model.utils.TestModelFactory;

public class FlowDesignEditor extends GraphicalEditorWithFlyoutPalette {

	
	public FlowDesignEditor() {
		super();
		setEditDomain(new DefaultEditDomain(this));
	}
	
	@Override
	protected void configureGraphicalViewer() {
		super.configureGraphicalViewer();
		getGraphicalViewer().setEditPartFactory(new ControllerFactory());
	}
	
	@Override
	protected void initializeGraphicalViewer() {
		super.initializeGraphicalViewer();
		getGraphicalViewer().setContents(TestModelFactory.create());
	}

	@Override
	protected PaletteRoot getPaletteRoot() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void doSave(IProgressMonitor monitor) {
		// TODO Auto-generated method stub

	}

}
