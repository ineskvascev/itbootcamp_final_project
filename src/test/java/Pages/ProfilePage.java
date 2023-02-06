package Pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProfilePage extends BasePage {

    @FindBy(id = "name")
    private WebElement inputName;

    @FindBy(id = "phone")
    private WebElement inputPhone;

    @FindBy(className = "v-select__slot")
    private WebElement inputCity;

    @FindBy(id = "country")
    private WebElement inputCountry;

    @FindBy(id = "urlTwitter")
    private WebElement inputUrlTwitter;

    @FindBy(id = "urlGitHub")
    private WebElement inputUrlGitHub;

    @FindBy(className = "btn")
    private WebElement buttonSave;

    @FindBy (className = "v-snack__content")
    private WebElement messageProfileSavedSuccessfully;

    public ProfilePage(WebDriver driver, WebDriverWait driverWait) {
        super(driver, driverWait);
    }

    public String getInputNameProfile() {
        return inputName.getAttribute("value");
    }

    public String getInputPhone() {
        return inputPhone.getAttribute("value");
    }

    public String getInputCity() {
        return inputCity.getAttribute("value");
    }

    public String getInputCountry() {
        return inputCountry.getAttribute("value");
    }

    public String getInputUrlTwitter() {
        return inputUrlTwitter.getAttribute("value");
    }

    public String getInputUrlGithub() {
        return inputUrlGitHub.getAttribute("value");
    }

    public String getMessageProfileSavedSuccessfully () {
        return messageProfileSavedSuccessfully.getText();
    }


    public void enterNameProfile(String name) {
        inputName.click();
        inputName.sendKeys(Keys.SPACE);
        inputName.sendKeys(Keys.CONTROL + "a");
        inputName.sendKeys(name);
    }

    public void enterPhoneNumberProfile(String number) {
        inputPhone.click();
        inputPhone.sendKeys(Keys.SPACE);
        inputPhone.sendKeys(Keys.CONTROL + "a");
        inputPhone.sendKeys(number);
    }

    //cityField.sendKeys(Keys.ENTER, Keys.ARROW_DOWN, Keys.ENTER);

    public void enterCityProfile(String city) {
        inputCity.click();
        inputCity.clear();
        inputCity.sendKeys(Keys.SPACE);
        inputCity.sendKeys(Keys.CONTROL + "a");
        inputCity.sendKeys(city);
        inputCity.sendKeys(Keys.ARROW_DOWN);
        inputCity.sendKeys(Keys.ENTER);
    }

    public void enterCountryProfile (String country) {
        inputCountry.click();
        inputCountry.clear();
        inputCountry.sendKeys(country);
    }

    public void enterUrlTwitter (String twitterUrl) {
        inputUrlTwitter.click();
        inputUrlTwitter.clear();
        inputUrlTwitter.sendKeys(twitterUrl);
    }

    public void enterUrlGithub (String githubUrl) {
        inputUrlGitHub.click();
        inputUrlGitHub.clear();
        inputUrlGitHub.sendKeys(githubUrl);
    }

    public void fillProfile (String name, String phoneNumber, String city, String country, String twitterUrl, String githubUrl) {
        enterNameProfile(name);
        enterPhoneNumberProfile(phoneNumber);
        enterCityProfile(city);
        enterCountryProfile(country);
        enterUrlTwitter(twitterUrl);
        enterUrlGithub(githubUrl);
        buttonSave.click();
    }
}
