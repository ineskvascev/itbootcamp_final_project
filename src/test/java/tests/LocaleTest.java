package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
public class LocaleTest extends BaseTest {

    @Test
    public void setLocaleToES() {
        // Set language to ES:
        landingPage.chooseSpanishLanguage();

        // Verify that the text "Página de aterrizaje" appears in the header of the page:
        Assert.assertEquals(landingPage.getHeaderMessage(), "Página de aterrizaje");
    }

    @Test  //Test #2:
    public void setLocaleToEN() {
        // Set the language to EN:
        landingPage.chooseEnglishLanguage();

        // Verify that the text "Landing" appears in the header of the page:
        Assert.assertEquals(landingPage.getHeaderMessage(), "Landing");
    }

    @Test  //Test #3:
    public void setLocaleToFR() {
        // Set language to FR:
        landingPage.chooseFrenchLanguage();

        // Verify that the text "Page d'atterrissage" appears in the header of the page:
        Assert.assertEquals(landingPage.getHeaderMessage(), "Page d'atterrissage");
    }
}
