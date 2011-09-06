package de.jebc.editor.model;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class TestProcess {

	private Process sut;

	@Before public void setup() {
		sut = new Process("");
	}
	
	@Test public void canAddInPin() {
		
		sut.addInPin(new InPin(""));
		
		assertThat(sut.getInputPins().size(), is(1));
	}
	
	@Test public void cannAddMoreThanOneInPin() {
		sut.addInPin(new InPin(""));
		sut.addInPin(new InPin(""));
		
		assertThat(sut.getInputPins().size(), is(2));
	}
}
