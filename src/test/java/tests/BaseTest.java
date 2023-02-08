package tests;

import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import pages.HomePage;
import pages.LandingPage;
import pages.LoginPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;

public abstract class BaseTest {
    protected WebDriver driver;
    protected WebDriverWait driverWait;
    protected LandingPage landingPage;
    protected LoginPage loginPage;
    protected HomePage homePage;
    protected Faker faker;
    protected String baseUrl= "https://vue-demo.daniel-avellaneda.com/";

    protected final String EMAIL = "admin@admin.com";
    protected final String PASSWORD = "12345";


    @BeforeClass
    public void beforeClass() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Ina\\Desktop\\Selenium\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driverWait = new WebDriverWait(driver, Duration.ofSeconds(10));
        landingPage = new LandingPage(driver, driverWait);
        loginPage = new LoginPage(driver, driverWait);
        homePage = new HomePage(driver, driverWait);
        faker = new Faker();
    }

    @BeforeMethod
    public void beforeMethod() {
        driver.get(baseUrl);
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(5));
    }

    @AfterMethod
    public void afterMethod() {

        if (!driver.getCurrentUrl().equals(baseUrl) && !driver.getCurrentUrl().endsWith("/login") && !driver.getCurrentUrl().endsWith("/signup")) {
            WebElement buttonLogout = driver.findElement(By.cssSelector("#app > div.v-application--wrap > div > header > div > div.v-toolbar__items > button.hidden-sm-and-down.btnLogout.v-btn.v-btn--text.theme--light.v-size--default"));
            if (buttonLogout.isDisplayed() && buttonLogout.getText().equalsIgnoreCase("logout")) {
                buttonLogout.click();
            }
        }
    }

    @AfterClass
    public void afterClass() {
        driver.quit();
    }
}

