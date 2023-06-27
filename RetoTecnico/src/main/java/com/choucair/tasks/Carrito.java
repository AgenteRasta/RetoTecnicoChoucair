package com.choucair.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.Scroll;
import net.serenitybdd.screenplay.targets.Target;
import net.serenitybdd.screenplay.waits.WaitUntil;
import org.openqa.selenium.By;

import java.util.ArrayList;
import java.util.List;

import static com.choucair.ui.PaginaCarrito.*;
import static com.choucair.util.ObtenerNumero.obtenerEnteros;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isClickable;


public class Carrito implements Task {
    public static List<String> nombresCarrito = new ArrayList<>();
    public static List<Integer> preciosCarrito = new ArrayList<>();
    public static List<Integer> cantidadesCarrito = new ArrayList<>();
    public static String correo;
    public static int totalCompraCarrito;
    String cantidadAux;
    @Override
    public <T extends Actor> void performAs(T actor) {
        totalCompraCarrito=0;
        actor.attemptsTo(
                WaitUntil.the(CARRITO, isClickable()).forNoMoreThan(15).seconds(),
                Click.on(CARRITO),
                Enter.theValue(correo).into(CAMPO_CORREO),
                Click.on(CONFIRMAR_CORREO)

        );
        for(int i=1;i<=5;i++){
            if(i==3){
                actor.attemptsTo(
                        Scroll.to(BAJAR_CARRITO)
                );
            }
            nombresCarrito.add(Target.the("Obtiene el nombre de los productos del carrito").
                    located(By.xpath(String.format(NOMBRE_CARRITO,String.valueOf(i)))).resolveFor(actor).getText());
            cantidadAux=(Target.the("Obtiene las cantidades de los productos en el carrito").
                    located(By.xpath(String.format(CANTIDADES_CARRITO,i))).resolveFor(actor).getText());
            cantidadesCarrito.add(obtenerEnteros(cantidadAux));
            preciosCarrito.add(obtenerEnteros(Target.the("").
                    located(By.xpath(String.format(PRECIOS_CARRITO,i))).resolveFor(actor).getText()));
        }
        totalCompraCarrito=obtenerEnteros(TOTAL_COMPRA.resolveFor(actor).getText());
    }

    public static Carrito carrito(){
        return new Carrito();
    }
}
