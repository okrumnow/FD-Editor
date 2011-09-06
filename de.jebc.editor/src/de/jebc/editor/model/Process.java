package de.jebc.editor.model;

public class Process extends Part {

	public Process(String name) {
		super(name);
	}

	public void addInPin(InPin inPin) {
		if (inputs.contains(inPin))
			throw new IllegalArgumentException("InPin with name "
					+ inPin.getName() + "already erxists for Process "
					+ getName());
		inputs.add(inPin);
	}

}
