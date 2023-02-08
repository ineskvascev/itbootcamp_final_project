package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
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

        // Verify that the route /login appears in the url of the page:
        String actualLink = driver.getCurrentUrl();
        Assert.assertTrue(actualLink.contains("/login"));
    }

    @Test //Test #2
    public void checksInputTypes() {

        // Verify that the email input field for the "type" attribute has the value 'email':
        String emailValue = "email";
        Assert.assertEquals(loginPage.getEmail(), emailValue);

        // Verify that the password entry field for the "type" attribute has the value 'password':
        String passwordValue = "password";
        Assert.assertEquals(loginPage.getPassword(), passwordValue);
    }

    @Test //Test #3
    public void displaysErrorsWhenUserDoesNotExist() {

        String fakeEmail = faker.internet().emailAddress();
        String fakePassword = faker.internet().password();
        loginPage.performLogin(fakeEmail, fakePassword);

        // Verify that the error contains the message "User does not exist":
        Assert.assertTrue(loginPage.getInvalidLogin().contains("User does not exist"));

        // Verify that the /login route appears in the url of the page:
        String actualLink = driver.getCurrentUrl();
        Assert.assertTrue(actualLink.contains("/login"));
    }

    @Test //Test #4:
    public void displaysErrorsWhenPasswordIsWrong() {

        String invalidPassword = "54321";
        loginPage.performLogin(EMAIL, invalidPassword);

        // Verify that the error contains the message "Wrong password":
        driverWait.until(ExpectedConditions.textToBePresentInElementLocated(By.xpath("//*[@id=\"app\"]/div[1]/main/div/div[2]/div/div/div[4]/div/div/div/div/div[1]/ul/li"), "Wrong password"));
        Assert.assertEquals(loginPage.getWrongPasswordMessage(), "Wrong password");

        // Verify that the /login route appears in the url of the page:
        String actualLink = driver.getCurrentUrl();
        Assert.assertTrue(actualLink.contains("/login"));
    }

    @Test //Test #5:
    public void login() throws InterruptedException {

        loginPage.performLogin(EMAIL,PASSWORD);

        Thread.sleep(1000);

        // Verify that the /home route appears in the url of the page:
        String actualLink = driver.getCurrentUrl();
        driverWait.until(ExpectedConditions.urlContains("/home"));
        Assert.assertTrue(actualLink.contains("/home"));
    }

    @Test //Test #6:
    public void logout() {

        // Verify that the logout button is visible on the page:
        loginPage.performLogin(EMAIL, PASSWORD);
        Assert.assertTrue(homePage.isButtonLogoutDisplayed());

        // Verify that the /login route appears in the url of the page:
        homePage.logout();
        String actualLink = driver.getCurrentUrl();
        driverWait.until(ExpectedConditions.urlContains("/login"));
        Assert.assertTrue(actualLink.contains("/login"));

        // Verify that after trying to open the /home route, the /login route appears in the url of the page:
        driver.get("https://vue-demo.daniel-avellaneda.com" + "/home");
        String actualLink1 = driver.getCurrentUrl();
        Assert.assertTrue(actualLink1.contains("/login"));
    }
}
