package com.choucair.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.waits.Wait;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static com.choucair.ui.Carrito.PRODUCTO_CARRITO;
import static com.choucair.ui.Productos.*;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class AgregarProducto implements Task {

    public static String nombreProducto;
    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Click.on(ACEPTAR_PERMISOS),
                //Click.on(CERRAR_VENTANA),
                Click.on(CELU_MANIA),
                Click.on(ENVIO_DOMICILIO),
                Click.on(BOTON_CONTINUAR),
                WaitUntil.the(NOMBRE_PRODUCTO, isVisible()).forNoMoreThan(10).seconds()
        );
        nombreProducto=NOMBRE_PRODUCTO.resolveFor(actor).getText().toString();
        actor.attemptsTo(
                Click.on(AGREGAR_PRODUCTO),
                Click.on(IR_CARRITO),
                WaitUntil.the(PRODUCTO_CARRITO, isVisible()).forNoMoreThan(10).seconds()
        );
    }

    public static AgregarProducto agregarProducto(){
        return new AgregarProducto();
    }
}
