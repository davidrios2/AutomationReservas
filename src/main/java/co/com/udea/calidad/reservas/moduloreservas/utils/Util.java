package co.com.udea.calidad.reservas.moduloreservas.utils;

import net.serenitybdd.model.exceptions.SerenityManagedException;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.matchers.WebElementStateMatchers;
import net.serenitybdd.screenplay.waits.WaitUntil;
import org.openqa.selenium.Keys;

import static co.com.udea.calidad.reservas.moduloreservas.userinterfaces.GoogleSearchPage.SEARCH_BAR;
import static co.com.udea.calidad.reservas.moduloreservas.userinterfaces.GoogleSearchPage.SEARCH_BUTTON;

public class Util {
    private Util(){}

    public static Performable searchOnGoogle(Actor user, String string){
        try {
            user.attemptsTo(
                    WaitUntil.the(SEARCH_BUTTON, WebElementStateMatchers.isVisible()).forNoMoreThan(10).seconds(),
                    Click.on(SEARCH_BUTTON)
            );
        } catch (SerenityManagedException e) {
            user.attemptsTo(
                    Enter.theValue(string).into(SEARCH_BAR).thenHit(Keys.ENTER)
            );
        }
        return null;
    }


}