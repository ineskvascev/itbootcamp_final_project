package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class AuthRoutesTest extends BaseTest {

    @Test   //Test #1:
    public void forbidsVisitsToHomeUrlIfNotAuthenticated() {

        // Load the /home page when the user is not logged in:
        driver.get("https://vue-demo.daniel-avellaneda.com" + "/home");

        // Verify that the route /login appears in the url of the page:
        String actualLink1 = driver.getCurrentUrl();
        Assert.assertTrue(actualLink1.contains("/login"));
    }

    @Test  //Test #2:
    public void forbidsVisitsToProfileUrlIfNotAuthenticated() {

        // Load /profile page:
        driver.get("https://vue-demo.daniel-avellaneda.com" + "/profile");

        // Verify that the route /login appears in the url of the page:
        String actualLink1 = driver.getCurrentUrl();
        Assert.assertTrue(actualLink1.contains("/login"));
    }

    @Test  //Test #3:
    public void  forbidsVisitsToAdminCitiesUrlIfNotAuthenticated() {

       // Load the /admin/cities page:
        driver.get("https://vue-demo.daniel-avellaneda.com" + "/admin/cities");

       // Verify that the route /login appears in the url of the page:
        String actualLink1 = driver.getCurrentUrl();
        Assert.assertTrue(actualLink1.contains("/login"));
    }

    @Test  //Test #4:
    public void  forbidsVisitsToAdminUsersUrlIfNotAuthenticated() {

       // Load the /admin/users page:
        driver.get("https://vue-demo.daniel-avellaneda.com" + "/admin/users");


      // Verify that the route /login appears in the url of the page:
        String actualLink1 = driver.getCurrentUrl();
        Assert.assertTrue(actualLink1.contains("/login"));
    }
}
