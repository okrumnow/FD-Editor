package de.jebc.editor.model;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

import org.junit.Test;

public class TestModelObject {

	@Test
	public void testModelObjectNeedsNameOnCreation() throws Exception {
		ModelObject sut = new ModelObject("Hallo") {
		};
		assertThat(sut, is(not(equalTo(null))));
		assertThat(sut.getName(), is(equalTo("Hallo")));
	}
}
