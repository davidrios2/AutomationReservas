package co.com.udea.calidad.reservas.moduloreservas.runners;

import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        features = "src/test/resources/features/find_udea.feature",
        glue = "co.com.udea.calidad.reservas.moduloreservas.stepdefinitions",
        snippets = CucumberOptions.SnippetType.CAMELCASE
)
public class SearchRunner {}