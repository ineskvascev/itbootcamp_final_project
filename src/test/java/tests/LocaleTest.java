package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
public class LocaleTest extends BaseTest {

    @Test
    public void setLocaleToES() {
        //Postaviti jezik na ES:
        landingPage.chooseSpanishLanguage();

        //Verifikovati da se na stranici u hederu javlja tekst "Página de aterrizaje":
        Assert.assertEquals(landingPage.getHeaderMessage(), "Página de aterrizaje");
    }

    @Test  //Test #2:
    public void setLocaleToEN() {
        //Postaviti jezik na EN:
        landingPage.chooseEnglishLanguage();

        //Verifikovati da se na stranici u hederu javlja tekst "Landing":
        Assert.assertEquals(landingPage.getHeaderMessage(), "Landing");
    }

    @Test  //Test #3:
    public void setLocaleToFR() {
        //Postaviti jezik na FR:
        landingPage.chooseFrenchLanguage();

        //Verifikovati da se na stranici u hederu javlja tekst "Page d'atterrissage":
        Assert.assertEquals(landingPage.getHeaderMessage(), "Page d'atterrissage");
    }
}
