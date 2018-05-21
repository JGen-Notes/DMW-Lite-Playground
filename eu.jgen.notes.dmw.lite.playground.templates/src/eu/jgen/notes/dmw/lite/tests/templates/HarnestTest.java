package eu.jgen.notes.dmw.lite.tests.templates;

import org.junit.Test;

public class HarnestTest {

	@Test
	public void test() {

		// Create instance of widget
		LogWidget logWidget = LogWidget.getInstance();

		// Create import structure
		logWidget.impLog = logWidget.new Log();

		// Initialize import stucture
		logWidget.impLog.init();

		// Create export structure
		logWidget.expLog = logWidget.new Log();

		// Initialize import stucture
		logWidget.expLog.init();

		// Populate import structure
		logWidget.impLog.counter.value = 2000;

		// Start widget
		logWidget.start();
		
		// Show results
		System.out.println(logWidget.expLog.counter.value);

	}

}
