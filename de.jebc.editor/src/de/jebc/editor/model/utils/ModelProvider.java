package de.jebc.editor.model.utils;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.jdt.core.ICompilationUnit;
import org.eclipse.jdt.core.IType;
import org.eclipse.jdt.core.dom.AST;
import org.eclipse.jdt.core.dom.ASTParser;
import org.eclipse.jdt.core.dom.ASTVisitor;
import org.eclipse.jdt.core.dom.CompilationUnit;
import org.eclipse.jdt.core.dom.ITypeBinding;
import org.eclipse.jdt.core.dom.Type;
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
		
		IType type = wc.getAllTypes()[0];
		
		CompilationUnit ast = parse(wc);
		
		FindSupertype visitor = new FindSupertype();
		ast.accept(visitor);
		Type supertype = visitor.getSupertype();
		
		ITypeBinding binding = supertype.resolveBinding();
		
		String name = binding.getBinaryName();

		if (name.equals("de.jebc.Process")) {
			model = new FlowDiagram("TEST");
			model.setObject(new Process(type.getFullyQualifiedName()));
		}
	}
	
	private static CompilationUnit parse(ICompilationUnit unit) {
		ASTParser parser = ASTParser.newParser(AST.JLS3);
		parser.setKind(ASTParser.K_COMPILATION_UNIT);
		parser.setSource(unit);
		parser.setResolveBindings(true);
		return (CompilationUnit) parser.createAST(null); // parse
	}

	private class FindSupertype extends ASTVisitor {
		
		private Type supertype;

		@Override
		public boolean visit(org.eclipse.jdt.core.dom.TypeDeclaration node) {
			supertype = node.getSuperclassType();
			return false;
		}

		public Type getSupertype() {
			return supertype;
		}

	}
}
