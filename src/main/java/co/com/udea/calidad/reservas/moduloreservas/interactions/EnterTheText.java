package co.com.udea.calidad.reservas.moduloreservas.interactions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.targets.Target;

public class EnterTheText implements Interaction {

    private final String text;
    private final Target target;

    public EnterTheText(String text, Target target) {
        this.text = text;
        this.target = target;
    }

    public static EnterTheText into(Target target, String text) {
        return new EnterTheText(text, target);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(Enter.theValue(text).into(target));
    }
}