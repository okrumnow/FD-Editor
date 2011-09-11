package de.jebc.editor.model;

public class FlowDiagram extends ModelObject {

	private ModelObject obj;

	public FlowDiagram(String name) {
		super(name);
	}

	public ModelObject getObject() {
		return obj;
	}

	public void setObject(ModelObject base) {
		obj = base;
	}
}
