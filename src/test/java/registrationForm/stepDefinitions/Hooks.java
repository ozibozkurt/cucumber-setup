package registrationForm.stepDefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import registrationForm.utilities.Driver;

import java.util.concurrent.TimeUnit;


public class Hooks {



	@Before()
	public void setUp() {
		// we put a logic that should apply to every scenario
		// for example: setting up driver, maximizing browser, setting up implicit wait
		Driver.getDriver().manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
		Driver.getDriver().manage().window().maximize();

	}

	@After
	public void tearDown(Scenario scenario) {
		if (scenario.isFailed()) {
			final byte[] screenShot = ((TakesScreenshot) Driver.getDriver()).getScreenshotAs(OutputType.BYTES);
			scenario.attach(screenShot, "image/png", "screenshot");
		}

		Driver.closeDriver();
	}
}