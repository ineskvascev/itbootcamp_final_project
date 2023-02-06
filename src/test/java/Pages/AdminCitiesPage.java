package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class AdminCitiesPage extends BasePage {

    @FindBy (className = "btnAdmin")
    private WebElement buttonAdmin;
    @FindBy (className = "btnAdminCities")
    private WebElement buttonCities;

    @FindBy (xpath = "//*[@id=\"app\"]/div[1]/div/header/div/div[3]/button[2]")
    private WebElement buttonLogout;

    @FindBy (xpath = "//*[@id=\"app\"]/div[1]/main/div/div[2]/div/div[1]/div[1]/div[3]/form/div[1]/button")
    private WebElement buttonNewItem;

    @FindBy (id = "name")
    private WebElement inputNewItemName;

    @FindBy (className = "btnSave")
    private WebElement buttonSave;

    @FindBy (xpath = "//*[@id=\"app\"]/div[1]/main/div/div[2]/div/div[3]/div/div/div/div/div[1]")
    private WebElement messageSavedSuccessfully;

    @FindBy (id = "edit")
    private WebElement buttonEdit;

    @FindBy (id = "name")
    private WebElement inputEditName;

    @FindBy (id = "search")
     private WebElement inputSearch;

    @FindBy (xpath = "/html/body/div/div[1]/main/div/div[2]/div/div[1]/div[2]/table/tbody/tr/td[2]")
    private WebElement tableFieldName;

    @FindBy (xpath = "//*[@id=\"app\"]/div[1]/main/div/div[2]/div/div[1]/div[2]/table/body/tr")
    private List<WebElement> tableCities;

    @FindBy (id = "delete")
    private WebElement buttonDeleteCity;

    @FindBy (xpath = "//*[@id=\"app\"]/div[14]/div/div/div[1]")
    private WebElement messageWarning;

    @FindBy (css = "#app > div.v-dialog__content.v-dialog__content--active > div > div > div.v-card__actions > button.v-btn.v-btn--text.theme--light.v-size--default.red--text.text--lighten3")
    private WebElement buttonInWarningMessageDeleteCity;

    @FindBy (xpath = "//*[@id=\"app\"]/div[1]/main/div/div[2]/div/div[3]/div/div/div/div/div[1]")
    private WebElement messageDeletedSuccessfully;

    @FindBy(xpath = "/html/body/div/div[1]/main/div/div[2]/div/div[3]/div/div/div/div/div[1]/button/span")
    private WebElement buttonClose;



    public AdminCitiesPage(WebDriver driver, WebDriverWait driverWait) {
        super(driver, driverWait);

    }


    public String getMessageSavedSuccessfully () {
        return messageSavedSuccessfully.getText();
    }

    public String getTableFieldName () {
        return tableFieldName.getText();
    }

    public String getMessageDeletedSuccessfully() {
        return messageDeletedSuccessfully.getText();
    }

    public String getSearchedCityText () {
        return inputSearch.getText();
    }


    public void openCities () {
        buttonAdmin.click();
        buttonCities.click();
    }

    public boolean isButtonLogoutDisplayed () {
        return buttonLogout.isDisplayed();
    }

    public void addNewItem (String city) {
        buttonNewItem.click();
        inputNewItemName.clear();

        inputNewItemName.sendKeys(city);
        buttonSave.click();
    }

    public void closeMessage() {
        buttonClose.click();
    }

    public void searchCity (String city) {
        inputSearch.click();
        inputSearch.sendKeys(Keys.CONTROL + "a");
        inputSearch.sendKeys(Keys.ENTER);
        inputSearch.sendKeys(city);
    }

    public void editCity (String city) {
        searchCity(city);
        buttonEdit.click();
        inputEditName.sendKeys(" - edited");
        buttonSave.click();
    }

    public void deleteCity () {
        buttonDeleteCity.click();
    }

    public void confirmDeletingCity() {
        buttonInWarningMessageDeleteCity.click();
    }

}
