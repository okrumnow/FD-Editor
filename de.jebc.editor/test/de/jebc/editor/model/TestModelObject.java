package de.jebc.editor.model;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

import org.junit.Test;

public class TestModelObject {

	@Test
	public void needsNameOnCreation() throws Exception {
		ModelObject sut = new ModelObject("Hallo") {
		};
		assertThat(sut, is(not(equalTo(null))));
		assertThat(sut.getName(), is(equalTo("Hallo")));
	}
	
	@Test public void canChangeNameAfterCreation() {
		ModelObject sut = new ModelObject("Hallo") {
		};
		
		sut.setName("NewName");
		
		assertThat(sut.getName(), is(equalTo("NewName")));
	}
}
