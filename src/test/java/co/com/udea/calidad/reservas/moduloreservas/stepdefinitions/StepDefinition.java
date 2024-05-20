package co.com.udea.calidad.reservas.moduloreservas.stepdefinitions;

import co.com.udea.calidad.reservas.moduloreservas.questions.Validation;
import co.com.udea.calidad.reservas.moduloreservas.tasks.Find;
import co.com.udea.calidad.reservas.moduloreservas.tasks.Open;
import co.com.udea.calidad.reservas.moduloreservas.userinterfaces.GoogleSearchPage;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.annotations.Managed;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.GivenWhenThen;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static co.com.udea.calidad.reservas.moduloreservas.userinterfaces.GoogleSearchPage.UDEA_LINK;
import static net.serenitybdd.core.Serenity.getDriver;
import static net.serenitybdd.screenplay.GivenWhenThen.givenThat;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.setTheStage;
import static org.hamcrest.Matchers.is;

public class StepDefinition {
    //Actor is the main class that represents the user that is going to interact with the application
    public final Actor user = Actor.named("user");

    @Managed(driver = "chrome", uniqueSession = true)
    public WebDriver Browser;

    @Before
    public void setUp() {
        user.can(BrowseTheWeb.with(Browser));
    }

    @Given("I am on the google search page")
    public void iAmOnTheGoogleSearchPage() {
        user.attemptsTo(Open.browserOn(new GoogleSearchPage()));
    }
    @When("I search for {string}")
    public void iSearchFor(String string) {
        user.attemptsTo(
                Enter.theValue(string).into(GoogleSearchPage.SEARCH_BAR),
                Enter.theValue(string).into(GoogleSearchPage.SEARCH_BAR).thenHit(Keys.ENTER)
        );
    }

    @Then("I should see the official UdeA website in the search results")
    public void iShouldSeeTheOfficialUdeAWebsiteInTheSearchResults() {
        user.attemptsTo(Find.word());
    }

    @When("I click on the official UdeA website link")
    public void iClickOnTheOfficialUdeAWebsiteLink() {
        user.attemptsTo(Click.on(UDEA_LINK));
    }

    @Then("I should be redirected to the official UdeA website")
    public void iShouldBeRedirectedToTheOfficialUdeAWebsite() {
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10)); // wait up to 10 seconds
        wait.until(ExpectedConditions.jsReturnsValue("return document.readyState=='complete';"));
        GivenWhenThen.then(user).should(seeThat(Validation.isOnPage(), is("ESTUDIANTES")));
    }
}
