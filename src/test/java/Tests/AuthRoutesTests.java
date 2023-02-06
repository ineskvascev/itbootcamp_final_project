package Tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class AuthRoutesTests extends BaseTest {

    @Test   //Test #1:
    public void forbidsVisitsToHomeUrlIfNotAuthenticated() {
        //  Ucitati /home stranu kada korisnik nije ulogovan:
        driver.get("https://vue-demo.daniel-avellaneda.com" + "/home");


        //  Verifikovati da se u url-u stranice javlja ruta /login:
        String actualLink1 = driver.getCurrentUrl();
        Assert.assertTrue(actualLink1.contains("/login"));
    }

    @Test  //Test #2:
    public void forbidsVisitsToProfileUrlIfNotAuthenticated() {
        //Ucitati /profile stranu:
        driver.get("https://vue-demo.daniel-avellaneda.com" + "/profile");


        //Verifikovati da se u url-u stranice javlja ruta /login
        String actualLink1 = driver.getCurrentUrl();
        Assert.assertTrue(actualLink1.contains("/login"));
    }

    @Test  //Test #3:
    public void  forbidsVisitsToAdminCitiesUrlIfNotAuthenticated() {
       // Ucitati /admin/cities stranu:
        driver.get("https://vue-demo.daniel-avellaneda.com" + "/admin/cities");

       // Verifikovati da se u url-u stranice javlja ruta /login:
        String actualLink1 = driver.getCurrentUrl();
        Assert.assertTrue(actualLink1.contains("/login"));
    }

    @Test  //Test #4:
    public void  forbidsVisitsToAdminUsersUrlIfNotAuthenticated() {
       // Ucitati /admin/users stranu:
        driver.get("https://vue-demo.daniel-avellaneda.com" + "/admin/users");


      //  Verifikovati da se u url-u stranice javlja ruta /login:
        String actualLink1 = driver.getCurrentUrl();
        Assert.assertTrue(actualLink1.contains("/login"));
    }






}
