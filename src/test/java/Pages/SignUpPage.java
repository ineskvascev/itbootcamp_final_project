package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SignUpPage extends BasePage {

    @FindBy(id = "name")
    private WebElement fieldSignUpName;

    @FindBy (id = "email")
    private WebElement fieldEmailSignUp;

    @FindBy (id = "password")
    private WebElement fieldPasswordSignUp;

    @FindBy (id = "confirmPassword")
    private WebElement fieldConfirmPasswordSignUp;

    @FindBy (xpath = "//*[@id=\"app\"]/div/main/div/div[2]/div/div/div[2]/span/form/div/div[5]/button")
    private WebElement buttonSignMeUp;

    @FindBy (xpath = "//*[@id=\"app\"]/div[1]/main/div/div[2]/div/div/div[3]/div/div/div/div/div[1]/ul/li")
    private WebElement emailAlreadyExistMessage;

    @FindBy ( xpath = "//*[@id=\"app\"]/div[4]/div/div/div[1]")
    private WebElement verifyYourAccountMessage;   // className = v-snack__content  ????




    public SignUpPage(WebDriver driver, WebDriverWait driverWait) {
        super(driver, driverWait);
    }


    public String getFieldEmailSignUp () {
        return fieldEmailSignUp.getAttribute("type");
    }

    public String getFieldPasswordSignUp () {
        return fieldPasswordSignUp.getAttribute("type");
    }

    public String getFieldConfirmPasswordSignUp () {
        return fieldConfirmPasswordSignUp.getAttribute("type");
    }

    public String getEmailMessage () {
        return emailAlreadyExistMessage.getText();
    }


    public String getVerifyYourAccountMessage() {
        return verifyYourAccountMessage.getText();
    }

    public void inputSignUpName (String name) {
        this.fieldSignUpName.clear();
        this.fieldSignUpName.sendKeys(name);
    }

    public void inputSignUpEmail (String email) {
        this.fieldEmailSignUp.clear();
        this.fieldEmailSignUp.sendKeys(email);
    }

    public void inputSignUpPassword (String password) {
        this.fieldPasswordSignUp.clear();
        this.fieldPasswordSignUp.sendKeys(password);
    }

    public void confirmPasswordSignUp (String password) {
        this.fieldConfirmPasswordSignUp.clear();
        this.fieldConfirmPasswordSignUp.sendKeys(password);
    }

    public void performSignUp (String name, String email, String password, String passwordAgain) {
        inputSignUpName(name);
        inputSignUpEmail(email);
        inputSignUpPassword(password);
        confirmPasswordSignUp(passwordAgain);
        buttonSignMeUp.click();
    }

}
