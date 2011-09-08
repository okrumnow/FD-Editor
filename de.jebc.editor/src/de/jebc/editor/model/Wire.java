package de.jebc.editor.model;

import java.lang.reflect.Type;

public class Wire extends ModelObject {

	public Wire(String name) {
		super(name);
	}

	private OutPin startPoint;

	public OutPin getStartPoint() {
		return startPoint;
	}

	public void setStartPoint(OutPin startPoint) {
		this.startPoint = startPoint;
	}

	public InPin getEndPoint() {
		return endPoint;
	}

	public void setEndPoint(InPin endPoint) {
		this.endPoint = endPoint;
	}

	public Type getDataType() {
		return dataType;
	}

	public void setDataType(Type dataType) {
		this.dataType = dataType;
	}

	private InPin endPoint;
	private Type dataType;

}
