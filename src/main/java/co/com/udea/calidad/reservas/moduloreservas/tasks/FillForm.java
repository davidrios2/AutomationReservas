package co.com.udea.calidad.reservas.moduloreservas.tasks;


import co.com.udea.calidad.reservas.moduloreservas.interactions.EnterTheText;
import co.com.udea.calidad.reservas.moduloreservas.interactions.SelectFromDropdown;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.SelectFromOptions;

import static co.com.udea.calidad.reservas.moduloreservas.userinterfaces.FrontEndLocal.*;

public class FillForm implements Task {

    private final String tipoPasajero;
    private final String nombre;
    private final String apellido;
    private final String tipoDocumento;
    private final String numeroDocumento;

    public FillForm(String tipoPasajero, String nombre, String apellido, String tipoDocumento, String numeroDocumento) {
        this.tipoPasajero = tipoPasajero;
        this.nombre = nombre;
        this.apellido = apellido;
        this.tipoDocumento = tipoDocumento;
        this.numeroDocumento = numeroDocumento;
    }

    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                new SelectFromDropdown(tipoPasajero, TIPO_PASAJERO),
                new EnterTheText(nombre, NOMBRE),
                new EnterTheText(apellido, APELLIDO),
                new SelectFromDropdown(tipoDocumento, TIPO_DOCUMENTO),
                new EnterTheText(numeroDocumento, NUMERO_DOCUMENTO),
                Click.on(AGREGAR_PASAJERO)
        );
    }
}