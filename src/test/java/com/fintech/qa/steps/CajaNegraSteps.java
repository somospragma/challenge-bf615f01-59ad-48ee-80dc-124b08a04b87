package com.fintech.qa.steps;

import com.fintech.qa.tasks.RealizarTransaccion;
import com.fintech.qa.questions.VerificarSaldo;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.ensure.Ensure;
import net.serenitybdd.screenplay.questions.page.TheWebPage;
import net.thucydides.core.annotations.Steps;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import static net.serenitybdd.screenplay.GivenWhenThen.givenThat;
import static net.serenitybdd.screenplay.GivenWhenThen.when;
import static net.serenitybdd.screenplay.GivenWhenThen.then;

public class CajaNegraSteps {

    @Steps
    RealizarTransaccion realizarTransaccion;
    @Steps
    VerificarSaldo verificarSaldo;

    private Actor actor;
    private WebDriver driver;

    public CajaNegraSteps() {
        this.driver = new ChromeDriver();
        this.actor = Actor.named("usuario").whoCan(BrowseTheWeb.with(driver));
    }

    @Given("que el usuario ha ingresado un valor dentro del rango de partición de equivalencia")
    public void ingresarValorParticionEquivalencia() {
        realizarTransaccion.conValor("100");
    }

    @When("el usuario realiza una transacción")
    public void realizarTransaccion() {
        actor.attemptsTo(realizarTransaccion);
    }

    @Then("se espera que la transacción sea procesada correctamente")
    public void verificarTransaccionCorrecta() {
        then(actor).should(Ensure.that(verificarSaldo).answeredBy(actor).isEqualTo("100"));
    }

    @Given("que el usuario ha ingresado un valor en el límite inferior del rango")
    public void ingresarValorLimiteInferior() {
        realizarTransaccion.conValor("0");
    }

    @Given("que el usuario ha ingresado valores que satisfacen una regla de la tabla de decisión")
    public void ingresarValoresTablaDecision() {
        realizarTransaccion.conValor("50");
    }
}