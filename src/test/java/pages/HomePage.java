package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage extends BasePage {

    @FindBy (css = "#app > div.v-application--wrap > div > header > div > div.v-toolbar__items > button.hidden-sm-and-down.btnLogout.v-btn.v-btn--text.theme--light.v-size--default")
    private WebElement buttonLogout;   //  //*[@id="app"]/div[1]/div/header/div/div[3]/button[2]
    @FindBy (xpath = "//*[@id=\"app\"]/div[1]/div/header/div/div[3]/a[3]")
    private WebElement openMyProfile;


    public HomePage(WebDriver driver, WebDriverWait driverWait) {
        super(driver, driverWait);
    }


    public boolean isButtonLogoutDisplayed () {
        return buttonLogout.isDisplayed();
    }

    public void logout () {
        buttonLogout.click();
    }

    public void openMyProfile() {
        openMyProfile.click();
    }
}
