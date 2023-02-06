package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LandingPage extends BasePage {

    @FindBy (xpath = "//*[@id=\"app\"]/div/div/header/div/div[3]/a[3]")
    private WebElement openLogin;

    @FindBy (xpath = "//*[@id=\"app\"]/div/div/header/div/div[3]/a[4]")
    private WebElement openSignUp;





    public LandingPage(WebDriver driver, WebDriverWait driverWait) {
        super(driver, driverWait);
    }



    public void openLoginPage() {
        openLogin.click();
    }

    public void openSignUpPage() {
        openSignUp.click();
    }



}
