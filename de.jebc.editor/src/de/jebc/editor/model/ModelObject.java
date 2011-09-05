package de.jebc.editor.model;

public abstract class ModelObject {

	private String name;

	public ModelObject(String name) {
		super();
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}