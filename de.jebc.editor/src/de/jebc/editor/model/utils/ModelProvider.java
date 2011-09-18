package de.jebc.editor.model.utils;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.jdt.core.ICompilationUnit;
import org.eclipse.jdt.core.IMethod;
import org.eclipse.jdt.core.IType;
import org.eclipse.jdt.core.dom.AST;
import org.eclipse.jdt.core.dom.ASTParser;
import org.eclipse.jdt.core.dom.ASTVisitor;
import org.eclipse.jdt.core.dom.CompilationUnit;
import org.eclipse.jdt.core.dom.ITypeBinding;
import org.eclipse.jdt.core.dom.MethodDeclaration;
import org.eclipse.jdt.core.dom.Type;
import org.eclipse.jdt.core.dom.TypeDeclaration;
import org.eclipse.jdt.ui.IWorkingCopyManager;
import org.eclipse.jdt.ui.JavaUI;
import org.eclipse.ui.IEditorInput;

import de.jebc.editor.model.FlowDiagram;
import de.jebc.editor.model.InPin;
import de.jebc.editor.model.ModelObject;
import de.jebc.editor.model.OutPin;
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
			Process process;
			process = new Process(type.getFullyQualifiedName());
			process.addInPin(new InPin("Start"));
			process.addOutPin(new OutPin("Result"));
			model.setObject(process);

			FindPins pinVisitor = new FindPins();
			ast.accept(pinVisitor);
			Map<MethodDeclaration, String> pins = pinVisitor.getPins();

			for (MethodDeclaration method : pins.keySet()) {
				String typeName = pins.get(method);
				if (typeName.contains("InPin")) {
					process.addInPin(new InPin(method.getName().toString()));
				} else
					process.addOutPin(new OutPin(method.getName().toString()));
			}
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
		public boolean visit(TypeDeclaration node) {
			supertype = node.getSuperclassType();
			return false;
		}

		public Type getSupertype() {
			return supertype;
		}
	}

	private class FindPins extends ASTVisitor {

		private Map<MethodDeclaration, String> pinNodes = new HashMap<MethodDeclaration, String>();

		public boolean visit(MethodDeclaration node) {
			Type returnType = node.getReturnType2();
			ITypeBinding binding = returnType.resolveBinding();
			String name = binding.getBinaryName();
			if (name.equals("de.jebc.InPin") || name.equals("de.jebc.OutPin"))
				pinNodes.put(node, name);
			return false;
		}

		public Map<MethodDeclaration, String> getPins() {
			return pinNodes;
		}
	}
}
