package tests;

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
    public void editProfile () {
        Faker faker = new Faker();
        String name = faker.name().fullName();
        String phone = faker.phoneNumber().cellPhone();
        String city = faker.address().city();
        String country = faker.country().name();
        String twitterUrl = faker.internet().url();
        String githubUrl = faker.internet().url();

        profilePage.fillProfile(name, phone, city, country, twitterUrl, githubUrl);

        //Verifikovati da je prikazana poruka "Profile saved successfuly":
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
