package com.choucair.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

import java.util.ArrayList;
import java.util.List;

import static com.choucair.ui.PaginaCarrito.*;
import static com.choucair.ui.PaginaProductos.NOMBRE_PRODUCTO;
import static com.choucair.ui.PaginaProductos.PRECIO_PRODUCTO;


public class Carrito implements Task {
    List<String> nombresCarrito = new ArrayList<>();
    List<String> preciosCarrito = new ArrayList<>();

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Click.on(CARRITO),
                Enter.theValue("estiven.tr96@gmail.com").into(CAMPO_CORREO),
                Click.on(CONFIRMAR_CORREO)
        );
        for(int i=1;i<=2;i++){
            System.out.println(Target.the("").
                    located(By.xpath("(//*[@class='exito-checkout-io-0-x-itemCartContent'])["+i+"]/descendant::div[5]")).resolveFor(actor).getText());
            //System.out.println(PRECIO_PRODUCTO.resolveFor(actor).getText());
            nombresCarrito.add(Target.the("").
                    located(By.xpath("(//*[@class='exito-checkout-io-0-x-itemCartContent'])["+i+"]/descendant::div[5]")).resolveFor(actor).getText());
            //precios.add(PRECIO_PRODUCTO.resolveFor(actor).getText());
        }
        System.out.println(nombresCarrito);

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
