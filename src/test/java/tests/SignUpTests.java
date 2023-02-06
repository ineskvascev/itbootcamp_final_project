package tests;

import pages.SignUpPage;
import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SignUpTests extends BaseTest {

    private SignUpPage signUpPage;


    @Override
    @BeforeClass
    public void beforeClass() {
        super.beforeClass();
        signUpPage = new SignUpPage(driver, driverWait);
    }

    @BeforeMethod
    @Override
    public void beforeMethod() {
        super.beforeMethod();
        landingPage.openSignUpPage();
    }

    @Test //Test #1:
    public void visitSignUPage() {

        //Verifikovati da se u url-u stranice javlja /signup ruta
        String actualLink = driver.getCurrentUrl();
        Assert.assertTrue(actualLink.contains("/signup"));
    }

    @Test //Test #2:
    public void checkInputTypes() {

        // Verifikovati da polje za unos emaila za atribut type ima vrednost email
        String inputEmail = "email";
        Assert.assertEquals(signUpPage.getFieldEmailSignUp(), inputEmail);

        // Verifikovati da polje za unos lozinke za atribut type ima vrednost password
        String inputPassword = "password";
        Assert.assertEquals(signUpPage.getFieldPasswordSignUp(), inputPassword);

        // Verifikovati da polje za unos lozinke za potvrdu za atribut type ima vrednost password
        String inputConfirmePassword = "password";
        Assert.assertEquals(signUpPage.getFieldConfirmPasswordSignUp(), inputConfirmePassword);
    }

    @Test //Test #3:
    public void displaysErrorsWhenUserAlreadyExists() {

        String name = "Test Test";
        String email = "admin@admin.com";
        String password = "123654";
        String confirmPassword = "123654";
        signUpPage.performSignUp(name, email, password, confirmPassword);

        //Verifikovati da greska sadrzi poruku "E-mail already exists":
        driverWait.until(ExpectedConditions.textToBePresentInElementLocated(By.xpath("//*[@id=\"app\"]/div[1]/main/div/div[2]/div/div/div[3]/div/div/div/div/div[1]/ul/li"), "E-mail already exists"));
        Assert.assertEquals(signUpPage.getEmailMessage(), "E-mail already exists");

        //Verifikovati da se u url-u stranice javlja /signup ruta:
        String actualLink = driver.getCurrentUrl();
        Assert.assertTrue(actualLink.contains("/signup"));
    }

    @Test //Test #4:
    public void signUp() {

        Faker faker = new Faker();
        String name = faker.name().fullName();
        String emailTemplate = faker.internet().emailAddress();
        String password = faker.internet().password();
        String confirmPassword = password;
        signUpPage.performSignUp(name, emailTemplate, password, confirmPassword);

        // Verifikovati da dijalog za obavestenje sadrzi tekst "IMPORTANT: Verify your account" :
        driverWait.until(ExpectedConditions.textToBePresentInElementLocated(By.xpath("//*[@id=\"app\"]/div[4]/div/div/div[1]"), "IMPORTANT: Verify your account"));
        Assert.assertEquals(signUpPage.getVerifyYourAccountMessage(), "IMPORTANT: Verify your account");
    }
}
