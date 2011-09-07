package de.jebc.editor.model;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class TestProcess {

	private Process sut;

	@Before
	public void setup() {
		sut = new Process("");
	}

	@Test
	public void canAddInPin() {
		sut.addInPin(new InPin(""));

		assertThat(sut.getInputPins().size(), is(1));
	}

	@Test
	public void cannAddMoreThanOneInPin() {
		sut.addInPin(new InPin("a"));
		sut.addInPin(new InPin("b"));

		assertThat(sut.getInputPins().size(), is(2));
	}

	@Test(expected = IllegalArgumentException.class)
	public void canNotAddInPinWithExistingName() {
		sut.addInPin(new InPin("a"));
		sut.addInPin(new InPin("a"));
	}

	@Test
	public void canAddOutPin() {
		sut.addOutPin(new OutPin(""));

		assertThat(sut.getOutPins().size(), is(1));
	}

	@Test
	public void cannAddMoreThanOneOutPin() {
		sut.addOutPin(new OutPin("a"));
		sut.addOutPin(new OutPin("b"));

		assertThat(sut.getOutPins().size(), is(2));
	}

	@Test(expected = IllegalArgumentException.class)
	public void canNotAddOutPinWithExistingName() {
		sut.addOutPin(new OutPin("a"));
		sut.addOutPin(new OutPin("a"));
	}

}
