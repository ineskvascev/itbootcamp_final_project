package tests;

import pages.AdminCitiesPage;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AdminCitiesTest extends BaseTest {
    private AdminCitiesPage adminCitiesPage;
    private String city;

    @BeforeClass
    @Override
    public void beforeClass() {
        super.beforeClass();
        adminCitiesPage = new AdminCitiesPage(driver, driverWait);
    }

    @BeforeMethod
    @Override
    public void beforeMethod() {
        super.beforeMethod();
        landingPage.openLoginPage();
        loginPage.performLogin(EMAIL, PASSWORD);
        adminCitiesPage.openCities();
        city = faker.address().cityName();
    }


    @Test //Test #1:
    public void visitsAdminCitiesPageAndListCities() {

        //Verify that the /admin/cities route appears in the url of the page:
        String actualLink = driver.getCurrentUrl();
        Assert.assertTrue(actualLink.contains("/admin/cities"));

        //Verify the existence of the 'logout' button:
        Assert.assertTrue(adminCitiesPage.isButtonLogoutDisplayed());
    }

    @Test //Test #2:
    public void createNewCity() {

        adminCitiesPage.addNewItem(city);

        //Verify that the message contains the text "Saved successfully":
        Assert.assertTrue(adminCitiesPage.getMessageSavedSuccessfully().contains("Saved successfully"));
    }

    @Test //Test #3:
    public void editCity() {

        adminCitiesPage.addNewItem(city);
        adminCitiesPage.editCity(city);

        //Verify that the message contains the text "Saved successfully""
        Assert.assertTrue(adminCitiesPage.getMessageSavedSuccessfully().contains("Saved successfully"));
    }

    @Test  //Test #4:
    public void searchCity() {

        adminCitiesPage.addNewItem(city);
        adminCitiesPage.searchCity(city);

        //Verify that the text from the search is in the 'Name' column of the first row:
        Assert.assertTrue(adminCitiesPage.getSearchedCityText().contains(city));
    }

    @Test //Test #5:
    public void deleteCity() {

        adminCitiesPage.addNewItem(city);
        adminCitiesPage.editCity(city);

        //Verify that the text from the search is in the 'Name' column of the first row:
        Assert.assertTrue(adminCitiesPage.getTableFieldName().contains(city));

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        adminCitiesPage.closeMessage();

        //Click on the 'Delete' button from the first row:
        adminCitiesPage.deleteCity();

        //Click on the 'Delete' button from the dialog:
        adminCitiesPage.confirmDeletingCity();

        //Wait for the message display popup to be visible:
        driverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"app\"]/div[1]/main/div/div[2]/div/div[3]/div/div/div/div/div[1]")));

        //Verify that the message contains the text "Deleted successfully":
        Assert.assertTrue(adminCitiesPage.getMessageDeletedSuccessfully().contains("Deleted successfully"));
        adminCitiesPage.closeMessage();
    }
}
