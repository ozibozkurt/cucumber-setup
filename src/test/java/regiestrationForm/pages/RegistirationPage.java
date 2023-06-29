package regiestrationForm.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import regiestrationForm.utilities.Driver;

public class RegistirationPage {
    public RegistirationPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }
    @FindBy(name = "email")
    public WebElement email;

    @FindBy(name = "password")
    public WebElement password;

    @FindBy(name = "confirm-password")
    public WebElement confirmPassword;

    @FindBy(id = "trial")
    public WebElement startTrial;

    @FindBy(xpath = "//button[@type='submit']")
    public WebElement registerButton;

    @FindBy(id = "email-validation")
    public WebElement emailValidation;

    @FindBy(id = "password-validation")
    public WebElement passwordValidation;

    @FindBy(id = "confirm-password-validation")
    public WebElement confirmPasswordValidation;

    @FindBy(id="trial-message")
    public WebElement trialMsg;


}
