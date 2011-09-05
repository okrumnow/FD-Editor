package de.jebc.editor.model;

import java.util.ArrayList;

public abstract class Part extends ModelObject {

	public Part(String name) {
		super(name);
	}
	private ArrayList<InPin> inputs = new ArrayList<InPin>();
	private ArrayList<OutPin> outputs = new ArrayList<OutPin>();
	
}
