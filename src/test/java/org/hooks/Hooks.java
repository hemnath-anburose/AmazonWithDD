package org.hooks;

import org.config.ConfigReader;

import io.cucumber.java.Before;

public class Hooks extends ConfigReader{
	@Before
	public void beforeScenario() {
		loadReader();
	}

}
