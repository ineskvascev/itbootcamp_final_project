package Tests;

import Pages.AdminCitiesPage;
import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AdminCitiesTests extends BaseTest {

    private AdminCitiesPage adminCitiesPage;

    Faker faker = new Faker();
    String city = faker.address().city();

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
    }


    @Test //Test #1:
    public void visitsAdminCitiesPageAndListCities() {

        //Verifikovati da se u url-u stranice javlja /admin/cities ruta:
        String actualLink = driver.getCurrentUrl();
        Assert.assertTrue(actualLink.contains("/admin/cities"));

        //Verifikovati postojanje logout dugmeta:
        Assert.assertTrue(adminCitiesPage.isButtonLogoutDisplayed());
    }

    @Test //Test #2:
    public void createNewCity() {

        adminCitiesPage.addNewItem(city);

        //Verifikovati da poruka sadrzi tekst "Saved successfully":
        Assert.assertTrue(adminCitiesPage.getMessageSavedSuccessfully().contains("Saved successfully"));
    }


    @Test //Test #3:  PROVERITI
    public void editCity() {
        adminCitiesPage.addNewItem(city);
        adminCitiesPage.searchCity(city);
        adminCitiesPage.editCity(city);

        //Verifikovati da poruka sadrzi tekst "Saved successfully"
        Assert.assertTrue(adminCitiesPage.getMessageSavedSuccessfully().contains("Saved successfully"));
    }


    @Test  //Test #4:   PROVERITI
    public void searchCity() {
        adminCitiesPage.addNewItem(city);
        adminCitiesPage.searchCity(city);


        //Verifikovati da se u Name koloni prvog reda nalazi tekst iz pretrage:
        Assert.assertTrue(adminCitiesPage.getSearchedCityText().contains(city));
    }


    @Test //Test #5:
    public void deleteCity() {

        adminCitiesPage.addNewItem(city);
        adminCitiesPage.closeMessage();

        // U polje za pretragu uneti staro ime grada:
        adminCitiesPage.searchCity(city);

        // Sacekati da broj redova u tabeli bude 1:
        // driverWait.until(ExpectedConditions.numberOfElementsToBe(By.xpath("/html/body/div/div[1]/main/div/div[2]/div/div[1]/div[2]/table/tbody/tr/td[2]"), 1));

        //Verifikovati da se u Name koloni prvog reda nalazi tekst iz pretrage:
        Assert.assertTrue(adminCitiesPage.getTableFieldName().contains(city));

        //Kliknuti na dugme Delete iz prvog reda:
        adminCitiesPage.deleteCity();

        //Sacekati da se dijalog za brisanje pojavi
        //  driverWait.until(ExpectedConditions.textToBePresentInElementLocated(By.xpath("//*[@id=\"app\"]/div[14]/div/div/div[1]"), "Do you really want to delete this item?"));

        //Kliknuti na dugme Delete iz dijaloga
        adminCitiesPage.confirmDeletingCity();

        //Sacekati da pop za prikaz poruke bude vidljiv
        driverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"app\"]/div[1]/main/div/div[2]/div/div[3]/div/div/div/div/div[1]")));

        //Verifikovati da poruka sadrzi tekst "Deleted successfully":
        System.out.println(adminCitiesPage.getMessageDeletedSuccessfully());
        Assert.assertTrue(adminCitiesPage.getMessageDeletedSuccessfully().contains("Deleted successfully"));
    }


    @AfterMethod
    @Override
    public void afterMethod() {
        super.afterMethod();
        homePage.logout();
    }


}
