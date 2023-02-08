package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pages.ProfilePage;
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
    public void editProfile() {
        String name = faker.name().fullName();
        String phone = faker.phoneNumber().cellPhone();
        String cityName = "New York";         // stavljen fiksni grad, jer ne moze da pronadje grad kad se pokrene test ako se koristi faker
        String country = faker.country().name();
        String twitterUrl = "https://" +  faker.internet().url().toLowerCase();
        String githubUrl = "https://" +  faker.internet().url().toLowerCase();
        profilePage.fillProfile(name, phone, cityName, country, twitterUrl, githubUrl);

        driverWait.until(ExpectedConditions.textToBePresentInElementLocated(By.xpath("//*[@id=\"app\"]/div[1]/main/div/div[2]/div/div/div[4]/div/div/div/div/div[1]"), "Profile saved successfuly"));

        // Verify that the message "Profile saved successfully" is displayed:
        Assert.assertTrue(profilePage.getMessageProfileSavedSuccessfully().contains("Profile saved successfuly"));

        // Verify that each input now for the 'value' attribute has the value entered within the form:
        Assert.assertEquals(profilePage.getInputNameProfile(), name);
        Assert.assertEquals(profilePage.getInputPhone(), phone);
        Assert.assertEquals(profilePage.getInputCity(), cityName);
        Assert.assertEquals(profilePage.getInputCountry(), country);
        Assert.assertEquals(profilePage.getInputUrlTwitter(), twitterUrl);
        Assert.assertEquals(profilePage.getInputUrlGithub(), githubUrl);
    }
}
