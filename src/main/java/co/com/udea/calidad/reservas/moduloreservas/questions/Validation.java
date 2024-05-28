package co.com.udea.calidad.reservas.moduloreservas.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.questions.WebElementQuestion;

import static co.com.udea.calidad.reservas.moduloreservas.userinterfaces.FrontEndLocal.*;
import static co.com.udea.calidad.reservas.moduloreservas.userinterfaces.GoogleSearchPage.HOME_PAGE;

public class Validation implements Question<String> {
    public Validation(){}

    @Override
    public String answeredBy(Actor actor) {
        return BrowseTheWeb.as(actor).find(HOME_PAGE).getText();
    }

    public static Validation isOnPage(){
        return new Validation();
    }

    public static Question<Boolean> isBookingVisible() {
        return actor -> WebElementQuestion.the(pasajero(0)).answeredBy(actor).isCurrentlyVisible();
    }

}