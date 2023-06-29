package registrationForm.stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import registrationForm.pages.RegistirationPage;
import registrationForm.utilities.ConfigurationReader;
import registrationForm.utilities.Driver;

import java.util.concurrent.TimeUnit;

public class PositiveTesting {

   WebDriver driver = Driver.getDriver();
   RegistirationPage page = new RegistirationPage();
    @Given("I am on the registration page")
    public void i_am_on_the_registration_page() {
    driver.get(ConfigurationReader.get("url"));
    driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
    }
    @When("I fill in a valid email address {string}")
    public void i_fill_in_a_valid_email_address(String email) {
        page.email.sendKeys(email);
    }
    @When("I fill in a valid password {string}")
    public void i_fill_in_a_valid_password(String password) {
        page.password.sendKeys(password);
    }
    @When("I confirm the password {string}")
    public void i_confirm_the_password(String confirmPassword) {
        page.confirmPassword.sendKeys(confirmPassword);
    }
    @When("I check the start trial checkbox")
    public void i_check_the_start_trial_checkbox() {
        page.startTrial.click();
    }
    @When("I submit the form")
    public void i_submit_the_form() {
        page.registerButton.click();
    }
    @Then("I should see an alert box with the message {string}")
    public void i_should_see_an_alert_box_with_the_message(String msg) {
         String actual = driver.switchTo().alert().getText();
        Assert.assertEquals(msg, actual);
    }

    @Then("I should see a validation message {string}")
    public void i_should_see_a_validation_message(String exipreDate) {
       String actual=page.trialMsg.getText();
       Assert.assertEquals(exipreDate,actual);

    }

}
