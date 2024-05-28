package co.com.udea.calidad.reservas.moduloreservas.interactions;


import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.actions.SelectFromOptions;
import net.serenitybdd.screenplay.targets.Target;

public class SelectFromDropdown implements Interaction {

    private final String option;
    private final Target target;

    public SelectFromDropdown(String option, Target target) {
        this.option = option;
        this.target = target;
    }

    public static SelectFromDropdown byVisibleText(Target target, String option) {
        return new SelectFromDropdown(option, target);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(SelectFromOptions.byVisibleText(option).from(target));
    }
}
