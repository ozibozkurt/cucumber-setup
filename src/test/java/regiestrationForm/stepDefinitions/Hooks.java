package regiestrationForm.stepDefinitions;

import com.cucumberFramework.utilities.DBUtils;
import com.cucumberFramework.utilities.Driver;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.util.concurrent.TimeUnit;


public class Hooks {

	@Before("@db")
	public void dbHook() {
		System.out.println("creating database connection");
		DBUtils.createConnection();
	}

	@After("@db")
	public void afterDbHook() {
		System.out.println("closing database connection");
		DBUtils.destroyConnection();

	}

	@Before("@ui")
	public void setUp() {
		// we put a logic that should apply to every scenario
		Driver.get().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		// for example: setting up driver, maximizing browser, setting up implicit wait



	}

	@After
	public void tearDown(Scenario scenario) {
		if (scenario.isFailed()) {
			final byte[] screenShot = ((TakesScreenshot) Driver.get()).getScreenshotAs(OutputType.BYTES);
			scenario.attach(screenShot, "image/png", "screenshot");
		}

		Driver.get().manage().deleteAllCookies();
		Driver.closeDriver();


	}
}