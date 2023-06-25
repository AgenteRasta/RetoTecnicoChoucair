package com.choucair.stepdefinitions;

import com.choucair.driver.AndroidDriverr;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import org.assertj.core.api.Assertions;

import static com.choucair.tasks.LlenarRegistro.llenarRegistro;

public class RegistroLoginCarritoStepDefinition {

    protected Actor actor = Actor.named("Estiven");

    @Given("que estoy en la app del exito")
    public void queEstoyEnLaAppDelExito() {
        try {
            actor.can(BrowseTheWeb.with(AndroidDriverr.configureDriver().start()));
        }catch (Exception e){
            Assertions.fail(e.getMessage());
        }
    }
    @When("registro una cuenta con {string} {string} {string} {string} {string} {string} {string} {string}")
    public void registroUnaCuentaCon(String nombre, String apellido, String cedula, String dia, String mes, String anio, String celular, String correo) {
        try {
            actor.attemptsTo(
                llenarRegistro().conElNombre(nombre)
            );
        }catch (Exception e){

        }
    }
    @When("inicio sesion con la cuenta recien registrada")
    public void inicioSesionConLaCuentaRecienRegistrada() {

    }
    @When("agrego un producto al carrito")
    public void agregoUnProductoAlCarrito() {

    }
    @Then("puedo observar el producto en el carrito")
    public void puedoObservarElProductoEnElCarrito() {

    }
}
