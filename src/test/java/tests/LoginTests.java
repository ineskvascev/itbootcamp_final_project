package tests;

import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTests extends BaseTest {

    @BeforeMethod
    @Override
    public void beforeMethod() {
        super.beforeMethod();
        landingPage.openLoginPage();
    }


    @Test   //Test #1:
    public void visitLoginPage() {

        //Verifikovati da se u url-u stranice javlja ruta /login
        String actualLink = driver.getCurrentUrl();
        Assert.assertTrue(actualLink.contains("/login"));
    }

    @Test //Test #2
    public void checksInputTypes() {

        // Verifikovati da polje za unos emaila za atribut "type" ima vrednost email:
        String emailValue = "email";
        Assert.assertEquals(loginPage.getEmail(), emailValue);

        // Verifikovati da polje za unos lozinke za atribut "type" ima vrednost password:
        String passwordValue = "password";
        Assert.assertEquals(loginPage.getPassword(), passwordValue);
    }

    @Test //Test #3
    public void displaysErrorsWhenUserDoesNotExist() {

        String fakeEmail = faker.internet().emailAddress();
        String fakePassword = faker.internet().password();
        loginPage.performLogin(fakeEmail, fakePassword);

        //Verifikovati da greska sadrzi poruku "User does not exists":
        Assert.assertTrue(loginPage.getInvalidLogin().contains("User does not exist"));

        //Verifikovati da se u url-u stranice javlja /login ruta:
        String actualLink = driver.getCurrentUrl();
        Assert.assertTrue(actualLink.contains("/login"));
    }

    @Test //Test #4:
    public void displaysErrorsWhenPasswordIsWrong() {

        String invalidPassword = "54321";
        loginPage.performLogin(EMAIL, invalidPassword);

        //Verifikovati da greska sadrzi poruku "Wrong password":
        driverWait.until(ExpectedConditions.textToBePresentInElementLocated(By.xpath("//*[@id=\"app\"]/div[1]/main/div/div[2]/div/div/div[4]/div/div/div/div/div[1]/ul/li"), "Wrong password"));
        Assert.assertEquals(loginPage.getWrongPasswordMessage(), "Wrong password");

        //Verifikovati da se u url-u stranice javlja /login ruta:
        String actualLink = driver.getCurrentUrl();
        Assert.assertTrue(actualLink.contains("/login"));
    }

    @Test //Test #5:
    public void login() throws InterruptedException {

        loginPage.performLogin(EMAIL,PASSWORD);

        Thread.sleep(1000);

        //Verifikovati da se u url-u stranice javlja /home ruta:
        String actualLink = driver.getCurrentUrl();
        driverWait.until(ExpectedConditions.urlContains("/home"));
        Assert.assertTrue(actualLink.contains("/home"));
    }

    @Test //Test #6:
    public void logout() {

        //Verifikovati da je dugme logout vidljivo na stranici:
        loginPage.performLogin(EMAIL, PASSWORD);
        Assert.assertTrue(homePage.isButtonLogoutDisplayed());

        //Verifikovati da se u url-u stranice javlja /login ruta:
        homePage.logout();
        String actualLink = driver.getCurrentUrl();
        driverWait.until(ExpectedConditions.urlContains("/login"));
        Assert.assertTrue(actualLink.contains("/login"));

        //Verifikovati da se nakon pokušaja otvaranja /home rute, u url-u stranice javlja /login ruta
        //(otvoriti sa driver.get home page i proveriti da li vas redirektuje na login):
        driver.get("https://vue-demo.daniel-avellaneda.com" + "/home");
        String actualLink1 = driver.getCurrentUrl();
        Assert.assertTrue(actualLink1.contains("/login"));
    }
}
