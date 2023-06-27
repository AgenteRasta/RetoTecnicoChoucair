package com.choucair.stepdefinitions;

import com.choucair.setup.Configuracion;
import com.choucair.tasks.AbrirPaginaInicial;
import com.choucair.tasks.AgregarProductos;
import com.choucair.tasks.Carrito;
import com.choucair.tasks.NavegarMenu;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.util.Collections;
import java.util.logging.Logger;
import static com.choucair.questions.TotalCompra.totalCompra;
import static com.choucair.tasks.AgregarProductos.agregarProductos;
import static com.choucair.tasks.AgregarProductos.totalCompra;
import static com.choucair.tasks.Carrito.carrito;
import static com.choucair.tasks.NavegarMenu.navegarMenu;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.hamcrest.CoreMatchers.equalTo;
public class CompraProductosStepDefinition extends Configuracion {

    public static java.util.logging.Logger LOGGER = Logger.getLogger(String.valueOf(CompraProductosStepDefinition.class));
    @Given("que el usuario esta en la pagina del exito")
    public void queElUsuarioEstaEnLaPaginaDelExito() {
        AgregarProductos.nombres.clear();
        AgregarProductos.cantidades.clear();
        AgregarProductos.precios.clear();
        Carrito.nombresCarrito.clear();
        Carrito.cantidadesCarrito.clear();
        Carrito.preciosCarrito.clear();
        totalCompra=0;
        configurarNavegador();

        try {
            theActorInTheSpotlight().wasAbleTo(
                    new AbrirPaginaInicial()
            );
        }catch (Exception e){
            LOGGER.warning(e.getMessage());
            quitarDriver();
        }
    }

    @When("selecciona una {string} y una {string}")
    public void seleccionaUnaYUna(String categoria, String subcategoria) {
        NavegarMenu.cate=categoria;
        NavegarMenu.subcate=subcategoria;
        try {
            theActorInTheSpotlight().attemptsTo(
                    navegarMenu()
            );
        }catch (Exception e){
            LOGGER.warning(e.getMessage());
            quitarDriver();
        }

    }

    @When("aniade cinco productos al carrito con sus respectivas cantidades")
    public void aniadeCincoProductosAlCarritoConSusRespectivasCantidades() {
        try {
            theActorInTheSpotlight().attemptsTo(
                    agregarProductos()
            );
        }catch (Exception e){
            LOGGER.warning(e.getMessage());
            quitarDriver();
        }

    }

    @When("entra al carrito de compras y registra un {string}")
    public void entroAlCarritoDeComprasYRegistroUn(String correo) {
        Carrito.correo=correo;
        try {
            theActorInTheSpotlight().attemptsTo(
                    carrito()
            );
        }catch (Exception e){
            LOGGER.warning(e.getMessage());
            quitarDriver();
        }

    }

    @Then("visualiza toda la informacion de la compra")
    public void visualizoTodaLaInformacionDeLaCompra() {
        try {
            Collections.sort(AgregarProductos.nombres);
            Collections.sort(Carrito.nombresCarrito);
            Collections.sort(AgregarProductos.cantidades);
            Collections.sort(Carrito.cantidadesCarrito);
            Collections.sort(AgregarProductos.precios);
            Collections.sort(Carrito.preciosCarrito);

            theActorInTheSpotlight().should(
                    seeThat(totalCompra(), equalTo(totalCompra)),
                    seeThat("Se obtienen los productos",
                            prod-> AgregarProductos.nombres,equalTo(Carrito.nombresCarrito)),
                    seeThat("Las cantidades de los productos son",
                            cant-> AgregarProductos.cantidades,equalTo(Carrito.cantidadesCarrito)),
                    seeThat("El total de cada producto es",
                            totalU-> AgregarProductos.precios, equalTo(Carrito.preciosCarrito))
            );
            quitarDriver();
        }catch (Exception e){
            LOGGER.warning(e.getMessage());
            quitarDriver();

        }
    quitarDriver();
    }

}
