package co.com.udea.calidad.reservas.moduloreservas.interactions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Enter;
import org.openqa.selenium.Keys;

import static co.com.udea.calidad.reservas.moduloreservas.userinterfaces.GoogleSearchPage.SEARCH_BAR;

public class EnterThe implements Interaction {

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(Enter.theValue("U de A").into(SEARCH_BAR).thenHit(Keys.ENTER));
    }

    public static EnterThe word(){
        return Tasks.instrumented(EnterThe.class);
    }
}