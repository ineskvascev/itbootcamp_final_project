package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LocalePage extends BasePage {

    @FindBy(className = "btnLocaleActivation")
    private WebElement buttonLanguage;
    @FindBy(className = "btnES")
    private WebElement spanishLanguage;

    @FindBy (className = "btnEN")
    private WebElement englishLanguage;

    @FindBy (className = "btnFR")
    private WebElement frenchLanguage;

    @FindBy(className = "display-2")
    private WebElement headerMessage;



    public LocalePage(WebDriver driver, WebDriverWait driverWait) {
        super(driver, driverWait);
    }

    public String getHeaderMessage() {
        return headerMessage.getText();
    }

    public void chooseSpanishLanguage() {
        buttonLanguage.click();
        spanishLanguage.click();
    }

    public void chooseEnglishLanguage() {
        buttonLanguage.click();
        englishLanguage.click();
    }

    public void chooseFrenchLanguage() {
        buttonLanguage.click();
        frenchLanguage.click();
    }

}
