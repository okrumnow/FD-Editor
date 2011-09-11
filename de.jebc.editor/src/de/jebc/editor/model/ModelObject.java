package de.jebc.editor.model;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.ArrayList;
import java.util.Collection;

public abstract class ModelObject {

	private static final String NAME_PROPERTY = "name";
	private String name;
	protected PropertyChangeSupport listeners;

	public ModelObject(String name) {
		super();
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String newName) {
		String old = this.name;
		this.name = newName;
		listeners.firePropertyChange(NAME_PROPERTY, old, newName);
	}
	
	public void addPropertyChangeListener(PropertyChangeListener newListener) {
		listeners.addPropertyChangeListener(newListener);
	}
	
	public void removePropertyChangeListeer(PropertyChangeListener oldListener) {
		listeners.removePropertyChangeListener(oldListener);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ModelObject other = (ModelObject) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

}