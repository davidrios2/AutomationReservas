package co.com.udea.calidad.reservas.moduloreservas.tasks;

import co.com.udea.calidad.reservas.moduloreservas.interactions.EnterThe;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;

public class Find implements Task {

    public Find() {
    }

    public static Find word() {
        return Tasks.instrumented(Find.class);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(EnterThe.word());
    }
}
