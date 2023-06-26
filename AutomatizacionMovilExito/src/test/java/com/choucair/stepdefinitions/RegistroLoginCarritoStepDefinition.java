package com.choucair.stepdefinitions;

import com.choucair.driver.AndroidDriverr;
import com.choucair.tasks.AgregarProducto;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import org.assertj.core.api.Assertions;

import java.util.logging.Logger;

import static com.choucair.questions.ProductoCarrito.productoCarrito;
import static com.choucair.tasks.AgregarProducto.agregarProducto;
import static com.choucair.tasks.IniciarSesion.iniciarSesion;
import static com.choucair.tasks.LlenarRegistro.llenarRegistro;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.hamcrest.CoreMatchers.equalTo;

public class RegistroLoginCarritoStepDefinition {
    String email;
    public static java.util.logging.Logger LOGGER = Logger.getLogger(String.valueOf(RegistroLoginCarritoStepDefinition.class));
    protected Actor actor = Actor.named("Estiven");

    @Given("que estoy en la app del exito")
    public void queEstoyEnLaAppDelExito() {
        try {
            LOGGER.info("Se inicia la automatizacion");
            actor.can(BrowseTheWeb.with(AndroidDriverr.configureDriver().start()));
        }catch (Exception e){
            LOGGER.warning(e.getMessage());
        }
    }
    @When("registro una cuenta con {string} {string} {string} {string} {string} {string} {string} {string}")
    public void registroUnaCuentaCon(String nombre, String apellido, String cedula, String dia, String mes, String anio, String celular, String correo) {
        email=correo;
        try {
            LOGGER.info("Se inicia el registro");
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
            LOGGER.info("Registro exitoso");
        }catch (Exception e){
            LOGGER.warning(e.getMessage());
        }
    }
    @When("inicio sesion con la cuenta recien registrada")
    public void inicioSesionConLaCuentaRecienRegistrada() {
        try {
            LOGGER.info("Inicio de sesion");
            actor.attemptsTo(
                    iniciarSesion()
                            .conElCorreo(email)
                            .conElContrasenia("Queserauff1")
            );
            LOGGER.info("Fin inicio de sesion");
        }catch (Exception e){
            LOGGER.warning(e.getMessage());
        }
    }
    @When("agrego un producto al carrito")
    public void agregoUnProductoAlCarrito() {
        try {
            actor.attemptsTo(
                    agregarProducto()
            );
            LOGGER.info("Se agrega el producto");
        }catch (Exception e){
            LOGGER.warning(e.getMessage());
        }
    }
    @Then("puedo observar el producto en el carrito")
    public void puedoObservarElProductoEnElCarrito() {
        try {
            LOGGER.info("Inicio de los asserts");
            actor.should(
                    seeThat(productoCarrito(), equalTo(AgregarProducto.nombreProducto))
            );
        }catch (Exception e){
            LOGGER.warning(e.getMessage());
        }
        LOGGER.info("Fin de la automatizacion");
    }
}
