package de.jebc.editor.model.utils;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.jdt.core.ICompilationUnit;
import org.eclipse.jdt.core.IType;
import org.eclipse.jdt.core.JavaModelException;
import org.eclipse.jdt.ui.IWorkingCopyManager;
import org.eclipse.jdt.ui.JavaUI;
import org.eclipse.ui.IEditorInput;

import de.jebc.editor.model.FlowDiagram;
import de.jebc.editor.model.ModelObject;
import de.jebc.editor.model.Process;

public class ModelProvider {

	private final IEditorInput input;
	private FlowDiagram model;
	private IWorkingCopyManager wcm;

	public ModelProvider(IEditorInput input) {
		this.input = input;
	}

	public ModelObject getModel() {
		if (model == null) {
			wcm = JavaUI.getWorkingCopyManager();
			try {
				wcm.connect(input);
				buildModel();
			} catch (CoreException e) {
				e.printStackTrace();
			} finally {
				wcm.disconnect(input);
			}
		}
		return model;
	}

	private void buildModel() throws CoreException {
		ICompilationUnit wc = wcm.getWorkingCopy(input);
		
		IType[] types = wc.getAllTypes();
				
		model = new FlowDiagram("TEST");
		model.setObject(new Process(types[0].getFullyQualifiedName()));
	}

}
