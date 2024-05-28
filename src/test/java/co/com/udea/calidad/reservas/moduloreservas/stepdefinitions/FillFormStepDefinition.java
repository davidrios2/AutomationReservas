package co.com.udea.calidad.reservas.moduloreservas.stepdefinitions;

import co.com.udea.calidad.reservas.moduloreservas.tasks.FillForm;
import io.cucumber.java.Before;
import io.cucumber.java.en.*;
import net.serenitybdd.annotations.Managed;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Open;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import org.openqa.selenium.WebDriver;

import static co.com.udea.calidad.reservas.moduloreservas.questions.Validation.isBookingVisible;
import static co.com.udea.calidad.reservas.moduloreservas.userinterfaces.FrontEndLocal.*;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;

public class FillFormStepDefinition {

    public final Actor user = Actor.named("user");

    @Managed(driver = "chrome", uniqueSession = true)
    public WebDriver Browser;
    @Before
    public void setUp() {
        user.can(BrowseTheWeb.with(Browser));
    }

    @Given("the user is on the flight booking page")
    public void theUserIsOnTheFlightBookingPage() {
        OnStage.setTheStage(new OnlineCast());
        user.attemptsTo(Open.url("http://localhost:3000"));
    }

    @When("the user fills out the form with valid data")
    public void theUserFillsOutTheFormWithValidData() {
        user.attemptsTo(new FillForm("Adulto", "Juan", "Perez", "Pasaporte", "12345678"));
    }

    @When("the user clicks on {string} button")
    public void theUserClicksOnButton(String button) {
        user.attemptsTo(Click.on(AGREGAR_PASAJERO));
    }

    @Then("the information is shown above the authorize checkbox")
    public void theInformationIsShownAboveTheAuthorizeCheckbox() {
        user.should(seeThat("Pasajero is visible", isBookingVisible()));
    }
}
