package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pages.ProfilePage;
import com.github.javafaker.Faker;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ProfileTests extends BaseTest {
    private ProfilePage profilePage;

    @BeforeClass
    @Override
    public void beforeClass() {
        super.beforeClass();
        profilePage = new ProfilePage(driver, driverWait);
    }

    @BeforeMethod
    @Override
    public void beforeMethod() {
        super.beforeMethod();
        landingPage.openLoginPage();
        loginPage.performLogin(EMAIL, PASSWORD);
        homePage.openMyProfile();
    }

    @Test   //Test #1:
    public void editProfile () throws InterruptedException {
        Faker faker = new Faker();
        String name = faker.name().fullName();
        String phone = faker.phoneNumber().cellPhone();
        //String city = faker.address().city();
        String city = "New York";
        String country = faker.country().name();
        String twitterUrl = "https://" +  faker.internet().url().toLowerCase();
        String githubUrl = "https://" + faker.internet().url().toLowerCase();

        profilePage.fillProfile(name, phone, city, country, twitterUrl, githubUrl);

        // ne znam koji wait umesto thread sleep
        Thread.sleep(2000);
        //Verifikovati da je prikazana poruka "Profile saved successfuly":
        //driverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("\"//*[@id=\\\"app\\\"]/div[1]/main/div/div[2]/div/div/div[4]/div/div/div/div/div[1]")));
        Assert.assertTrue(profilePage.getMessageProfileSavedSuccessfully().contains("Profile saved successfuly"));

        //Verifikovati da svaki input sada za atribut 'value' ima vrednost koja je uneta u okviru forme:
        Assert.assertEquals(profilePage.getInputNameProfile(), name);
        Assert.assertEquals(profilePage.getInputPhone(), phone);
        Assert.assertEquals(profilePage.getInputCity(), city);
        Assert.assertEquals(profilePage.getInputCountry(), country);
        Assert.assertEquals(profilePage.getInputUrlTwitter(), twitterUrl);
        Assert.assertEquals(profilePage.getInputUrlGithub(), githubUrl);
    }
}
