package de.jebc.editor.model;

import java.util.ArrayList;
import java.util.Collection;

public abstract class Part extends ModelObject {

	public Part(String name) {
		super(name);
	}
	
	protected ArrayList<InPin> inputs = new ArrayList<InPin>();
	protected ArrayList<OutPin> outputs = new ArrayList<OutPin>();
	
	public Collection<InPin> getInPins() {
		return inputs;
	}

	public Collection<OutPin> getOutPins() {
		return outputs;
	}
}
