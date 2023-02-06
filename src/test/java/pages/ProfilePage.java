package pages;

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

    @FindBy(id = "city")
    private WebElement inputCity;

    @FindBy(id = "country")
    private WebElement inputCountry;

    @FindBy(id = "urlTwitter")
    private WebElement inputUrlTwitter;

    @FindBy(id = "urlGitHub")
    private WebElement inputUrlGitHub;

    @FindBy(className = "btnSave")
    private WebElement buttonSave;

    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/main/div/div[2]/div/div/div[4]/div/div/div/div/div[1]")
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

    public String getMessageProfileSavedSuccessfully() {
        return messageProfileSavedSuccessfully.getText();
    }


    public void enterNameProfile(String name) {
        //inputName.sendKeys(Keys.SPACE);
        inputName.click();
        inputName.sendKeys(Keys.CONTROL + "a");
        inputName.sendKeys(Keys.DELETE);
        inputName.sendKeys(name);
    }

    public void enterPhoneNumberProfile(String number) {
        //inputPhone.sendKeys(Keys.SPACE);
        inputPhone.click();
        inputPhone.sendKeys(Keys.CONTROL + "a");
        inputPhone.sendKeys(Keys.DELETE);
        inputPhone.sendKeys(number);

    }

    public void enterCityProfile(String city) {
        inputCity.click();
        inputCity.sendKeys(Keys.CONTROL + "a");
        inputCity.sendKeys(city);
        inputCity.sendKeys(Keys.ARROW_DOWN, Keys.ENTER);
    }

    public void enterCountryProfile(String country) {
        inputCountry.sendKeys(Keys.SPACE);
        inputCountry.sendKeys(Keys.CONTROL + "a");
        inputCountry.sendKeys(Keys.DELETE);
        inputCountry.sendKeys(country);
    }

    public void enterUrlTwitter(String twitterUrl) {
        inputUrlTwitter.sendKeys(Keys.CONTROL + "a");
        inputUrlTwitter.sendKeys(Keys.DELETE);
        inputUrlTwitter.sendKeys(twitterUrl);
    }

    public void enterUrlGithub(String githubUrl) {
        inputUrlGitHub.sendKeys(Keys.CONTROL + "a");
        inputUrlGitHub.sendKeys(Keys.DELETE);
        inputUrlGitHub.sendKeys(githubUrl);
    }

    public void fillProfile(String name, String phoneNumber, String city, String country, String twitterUrl, String githubUrl) {
        enterNameProfile(name);
        enterPhoneNumberProfile(phoneNumber);
        enterCityProfile(city);
        enterCountryProfile(country);
        enterUrlTwitter(twitterUrl);
        enterUrlGithub(githubUrl);
        buttonSave.click();
    }
}