package co.com.udea.calidad.reservas.moduloreservas.userinterfaces;

import net.serenitybdd.annotations.DefaultUrl;
import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;

@DefaultUrl("https://www.google.com")
public class GoogleSearchPage extends PageObject {

    public static final Target SEARCH_BAR = Target.the("Search bar").located(By.name("q"));

    public static final Target SEARCH_BUTTON = Target.the("Search button").locatedBy("/html/body/div[1]/div[3]/form/div[1]/div[1]/div[4]/center/input[1]");

    public static final Target UDEA_LINK = Target.the("UdeA link").locatedBy("//*[@id=\"rso\"]/div[1]/div/div/div/div/div/div/div/div[1]/div/span/a");

    public static final Target HOME_PAGE = Target.the("Home page").locatedBy("/html/body/div/div[1]/div/div[3]/div/div[2]/div/div[1]/section/div[2]/div[3]/div[1]/button[1]");
}
