package tests;

import pages.LocalePage;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class LocaleTest extends BaseTest {

    private LocalePage localePage;

    @BeforeClass
    @Override
    public void beforeClass() {
        super.beforeClass();
        localePage = new LocalePage(driver, driverWait);
    }


    @Test
    public void setLocaleToES() {
        //Postaviti jezik na ES:
        localePage.chooseSpanishLanguage();

        //Verifikovati da se na stranici u hederu javlja tekst "Página de aterrizaje":
        Assert.assertEquals(localePage.getHeaderMessage(), "Página de aterrizaje");
    }

    @Test  //Test #2:
    public void setLocaleToEN() {
        //Postaviti jezik na EN:
        localePage.chooseEnglishLanguage();

        //Verifikovati da se na stranici u hederu javlja tekst "Landing":
        Assert.assertEquals(localePage.getHeaderMessage(), "Landing");
    }

    @Test  //Test #3:
    public void setLocaleToFR() {
        //Postaviti jezik na FR:
        localePage.chooseFrenchLanguage();

        //Verifikovati da se na stranici u hederu javlja tekst "Page d'atterrissage":
        Assert.assertEquals(localePage.getHeaderMessage(), "Page d'atterrissage");
    }


}
