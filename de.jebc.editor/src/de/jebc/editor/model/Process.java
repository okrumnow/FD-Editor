package de.jebc.editor.model;

public class Process extends Part {

	public Process(String name) {
		super(name);
	}

	public void addInPin(InPin inPin) {
		inputs.add(inPin);
	}

}
