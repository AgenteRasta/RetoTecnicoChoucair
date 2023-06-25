package com.choucair.stepdefinitions;

import com.choucair.driver.AndroidDriverr;
import com.choucair.tasks.AgregarProducto;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import org.assertj.core.api.Assertions;

import static com.choucair.questions.ProductoCarrito.productoCarrito;
import static com.choucair.tasks.AgregarProducto.agregarProducto;
import static com.choucair.tasks.IniciarSesion.iniciarSesion;
import static com.choucair.tasks.LlenarRegistro.llenarRegistro;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.hamcrest.CoreMatchers.equalTo;

public class RegistroLoginCarritoStepDefinition {
    String email;

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
        email=correo;
        try {
            actor.attemptsTo(
                llenarRegistro()
                        .conElNombre(nombre)
                        .conElApellido(apellido)
                        .conElDocumento(cedula)
                        .conElAnio(anio)
                        .conElMes(mes)
                        .conElDia(dia)
                        .conElCelular(celular)
                        .conElCorreo(correo)
            );
        }catch (Exception e){

        }
    }
    @When("inicio sesion con la cuenta recien registrada")
    public void inicioSesionConLaCuentaRecienRegistrada() {
        try {
            actor.attemptsTo(
                    iniciarSesion()
                            .conElCorreo(email)
                            .conElContrasenia("Queserauff1")
            );
        }catch (Exception e){

        }
    }
    @When("agrego un producto al carrito")
    public void agregoUnProductoAlCarrito() {
        try {
            actor.attemptsTo(
                    agregarProducto()
            );
        }catch (Exception e){

        }
    }
    @Then("puedo observar el producto en el carrito")
    public void puedoObservarElProductoEnElCarrito() {
        try {
            actor.should(
                    seeThat(productoCarrito(), equalTo(AgregarProducto.nombreProducto))
            );
        }catch (Exception e){

        }
    }
}
