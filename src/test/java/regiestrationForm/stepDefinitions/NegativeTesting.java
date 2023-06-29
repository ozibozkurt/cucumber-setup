package regiestrationForm.stepDefinitions;

import io.cucumber.java.en.*;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import regiestrationForm.pages.RegistirationPage;
import regiestrationForm.utilities.Driver;

public class NegativeTesting {
    RegistirationPage page = new RegistirationPage();
    @When("I fill in an invalid email address {string}")
    public void i_fill_in_an_invalid_email_address(String string) {
        page.email.sendKeys(string);
    }

    @Then("I should see a validation error with the message {string}")
    public void i_should_see_a_validation_error_with_the_message(String msg) {
    String actual = page.emailValidation.getText();
        Assert.assertEquals(msg, actual);
    }

    @Then("I should see a validation error with the message for the short password {string}")
    public void i_should_see_a_validation_error_with_the_message_for_the_short_password(String string) {
        String actual = page.passwordValidation.getText();
        Assert.assertEquals(string, actual);
    }

    @When("I fill in a password shorter characters {string}")
    public void i_fill_in_a_password_with_less_than_characters( String msg) {
        page.password.sendKeys(msg);
    }

    @When("I fill in a password without a special character {string}")
    public void i_fill_in_a_password_without_a_special_character(String msg) {
        page.password.sendKeys(msg);
    }
    @Then("I should see a validation error with the message for the special {string}")
    public void i_should_see_a_validation_error_with_the_message_for_the_special(String msg) {
        String actual = page.passwordValidation.getText();
        Assert.assertEquals(msg, actual);
    }

    @When("I confirm a different password {string}")
    public void i_confirm_a_different_password(String mismatchPassword) {
        page.confirmPassword.sendKeys(mismatchPassword);
    }

    @Then("I should see a validation error with the message for the mismatch {string}")
    public void i_should_see_a_validation_error_with_the_message_for_the_mismatch(String msg) {
        String actual = page.confirmPasswordValidation.getText();
        Assert.assertEquals(msg, actual);
    }

    @Then("I should see an alert box with the error message {string}")
    public void i_should_see_an_alert_box_with_the_error_message(String alertMsg) {
        String actual = Driver.getDriver().switchTo().alert().getText();
        Assert.assertEquals(alertMsg, actual);
    }


}
