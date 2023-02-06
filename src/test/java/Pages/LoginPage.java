package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage extends BasePage {

    @FindBy (xpath = "//*[@id=\"app\"]/div/main/div")
    private WebElement loginForm;

    @FindBy (id = "email")
    private WebElement emailField;

    @FindBy (id = "password")
    private WebElement passwordField;

    @FindBy (xpath = "//*[@id=\"app\"]/div/main/div/div[2]/div/div/div[3]/span/form/div/div[3]/button")
    private WebElement buttonLogin;

    @FindBy (xpath = "//*[@id=\"app\"]/div/main/div/div[2]/div/div/div[3]/span/form/div/div[4]/a")
    private WebElement forgotPasswordLink;

    @FindBy (xpath = "//*[@id=\"app\"]/div[1]/main/div/div[2]/div/div/div[4]/div/div/div/div/div[1]")
    private WebElement errorLoginMessage;

    @FindBy (xpath = "//*[@id=\"app\"]/div[1]/main/div/div[2]/div/div/div[4]/div/div/div/div/div[1]/ul/li")
    private WebElement wrongPasswordMessage;




    public LoginPage(WebDriver driver, WebDriverWait driverWait) {
        super(driver, driverWait);
    }


    public boolean isLoginFormDisplayed () {
        return loginForm.isDisplayed();
    }

    public void inputEmail (String email) {
        this.emailField.clear();
        this.emailField.sendKeys(email);
    }

    public String getEmail () {
        return emailField.getAttribute("type");
    }

    public String getPassword () {
        return passwordField.getAttribute("type");
    }


    public String getWrongPasswordMessage () {
        return wrongPasswordMessage.getText();
    }

    public String getInvalidLogin () {
        return errorLoginMessage.getText();
    }

    public void inputPassword (String password) {
        this.passwordField.clear();
        this.passwordField.sendKeys(password);
    }


    public void performLogin (String email, String password) {
        inputEmail(email);
        inputPassword(password);
        buttonLogin.click();
    }


    public void goToSignUpFromLoginPage () {
        forgotPasswordLink.click();
    }
}
