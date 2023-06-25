package com.choucair.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.Scroll;
import net.serenitybdd.screenplay.targets.Target;
import net.serenitybdd.screenplay.waits.Wait;
import net.serenitybdd.screenplay.waits.WaitUntil;
import org.openqa.selenium.By;

import java.util.ArrayList;
import java.util.List;

import static com.choucair.ui.PaginaCarrito.*;
import static com.choucair.util.ObtenerNumero.obtenerEnteros;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isClickable;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;


public class Carrito implements Task {
    public static List<String> nombresCarrito = new ArrayList<>();
    public static List<Integer> preciosCarrito = new ArrayList<>();
    public static List<Integer> cantidadesCarrito = new ArrayList<>();
    public static String correo;
    public static int totalCompraCarrito;

    @Override
    public <T extends Actor> void performAs(T actor) {
        totalCompraCarrito=0;
        actor.attemptsTo(
                WaitUntil.the(CARRITO, isClickable()).forNoMoreThan(10).seconds(),
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
            nombresCarrito.add(Target.the("").
                    located(By.xpath("(//*[@class='exito-checkout-io-0-x-itemCartContent'])["+i+"]/descendant::div[5]")).resolveFor(actor).getText());
            String cantidadAux=(Target.the("").
                    located(By.xpath("(//*[@class='exito-checkout-io-0-x-itemCartContent'])["+i+"]/descendant::div[13]")).resolveFor(actor).getText());
            cantidadesCarrito.add(obtenerEnteros(cantidadAux));
            preciosCarrito.add(obtenerEnteros(Target.the("").
                    located(By.xpath("(//*[@class='exito-checkout-io-0-x-itemCartContent'])["+i+"]/descendant::div[8]")).resolveFor(actor).getText()));
        }
        totalCompraCarrito=obtenerEnteros(TOTAL_COMPRA.resolveFor(actor).getText());
        System.out.println(nombresCarrito);
        System.out.println(cantidadesCarrito);
        System.out.println(preciosCarrito);
        System.out.println(totalCompraCarrito);
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public static Carrito carrito(){
        return new Carrito();
    }
}
