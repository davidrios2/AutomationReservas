package co.com.udea.calidad.reservas.moduloreservas.tasks;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;

public class Open implements Task {
    private PageObject page;

    public Open(PageObject page) {
        this.page = page;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(net.serenitybdd.screenplay.actions.Open.browserOn(page));
    }

    public static Open browserOn(PageObject page) {
        return Tasks.instrumented(Open.class, page);
    }
}