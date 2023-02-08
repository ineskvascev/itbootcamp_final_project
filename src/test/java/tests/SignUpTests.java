package tests;

import pages.SignUpPage;
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

        // Verify that the /signup route appears in the url of the page:
        String actualLink = driver.getCurrentUrl();
        Assert.assertTrue(actualLink.contains("/signup"));
    }

    @Test //Test #2:
    public void checkInputTypes() {

        // Verify that the email input field for the "type" attribute has the value email:
        String inputEmail = "email";
        Assert.assertEquals(signUpPage.getFieldEmailSignUp(), inputEmail);

        // Verify that the password entry field for the "type" attribute has the value password:
        String inputPassword = "password";
        Assert.assertEquals(signUpPage.getFieldPasswordSignUp(), inputPassword);

        // Verify that the confirmation password input field for the "type" attribute has the value password:
        String inputConfirmPassword = "password";
        Assert.assertEquals(signUpPage.getFieldConfirmPasswordSignUp(), inputConfirmPassword);
    }

    @Test //Test #3:
    public void displaysErrorsWhenUserAlreadyExists() {

        String name = "Test Test";
        String email = "admin@admin.com";
        String password = "123654";
        String confirmPassword = "123654";
        signUpPage.performSignUp(name, email, password, confirmPassword);

        // Verify that the error contains the message "E-mail already exists":
        driverWait.until(ExpectedConditions.textToBePresentInElementLocated(By.xpath("//*[@id=\"app\"]/div[1]/main/div/div[2]/div/div/div[3]/div/div/div/div/div[1]/ul/li"), "E-mail already exists"));
        Assert.assertEquals(signUpPage.getEmailMessage(), "E-mail already exists");

        // Verify that the /signup route appears in the url of the page:
        String actualLink = driver.getCurrentUrl();
        Assert.assertTrue(actualLink.contains("/signup"));
    }

    @Test //Test #4:
    public void signUp() {

        String name = faker.name().fullName();
        String email = faker.internet().emailAddress();
        String password = faker.internet().password();
        String confirmPassword = password;
        signUpPage.performSignUp(name, email, password, confirmPassword);

        // Verify that the notification dialog contains the text "IMPORTANT: Verify your account":
        driverWait.until(ExpectedConditions.textToBePresentInElementLocated(By.xpath("//*[@id=\"app\"]/div[4]/div/div/div[1]"), "IMPORTANT: Verify your account"));
        Assert.assertEquals(signUpPage.getVerifyYourAccountMessage(), "IMPORTANT: Verify your account");
        signUpPage.closeMessage();
    }
}
