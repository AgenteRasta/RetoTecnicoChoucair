package com.choucair.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Scroll;
import net.serenitybdd.screenplay.waits.WaitUntil;
import org.openqa.selenium.By;

import static com.choucair.util.ObtenerNumero.obtenerEnteros;
import static net.serenitybdd.screenplay.Tasks.instrumented;

import java.util.ArrayList;
import java.util.List;

import static com.choucair.ui.PaginaProductos.*;
import static com.choucair.util.NumeroAleatorio.generateRandomNumbers;
import static com.choucair.util.NumeroAleatorio.generateRandomNumbersR;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isNotVisible;

public class AgregarProductos implements Task {
    public static List<Integer> productos = generateRandomNumbers(15);
    public static List<Integer> cantidades = generateRandomNumbersR(4 );
    public static List<String> nombres = new ArrayList<>();
    public static List<Integer> precios = new ArrayList<>();

    public static int totalCompra=0;

    @Override
    public <T extends Actor> void performAs(T actor) {

        for(int i=0;i<2;i++){
            actor.attemptsTo(
                    Scroll.to(INICIO),
                    Scroll.to(By.xpath("//body[1]/div[2]/div[1]/div[1]/div[1]/div[3]/div[1]/div[9]/section[1]/div[2]/div[1]/div[3]/div[1]/div[2]/div[1]/div[1]/div[5]/div[1]/div[1]/div[1]/" +
                            "div["+productos.get(i)+"]/section[1]/a[1]/article[1]/div[2]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]")),
                    Click.on(By.xpath("//body[1]/div[2]/div[1]/div[1]/div[1]/div[3]/div[1]/div[9]/section[1]/div[2]/div[1]/div[3]/div[1]/div[2]/div[1]/div[1]/div[5]/div[1]/div[1]/div[1]/" +
                            "div["+productos.get(i)+"]/section[1]/a[1]/article[1]/div[2]/div[2]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/span[1]")),
                    Click.on(AGREGAR_PRODUCTO)
            );
            nombres.add(NOMBRE_PRODUCTO.resolveFor(actor).getText());
            precios.add(obtenerEnteros(PRECIO_PRODUCTO.resolveFor(actor).getText())*cantidades.get(i));
            totalCompra=totalCompra+obtenerEnteros(PRECIO_PRODUCTO.resolveFor(actor).getText())*cantidades.get(i);
            for (int j=0;j<cantidades.get(i)-1;j++){
                actor.attemptsTo(
                        Click.on(ADD_PRODUCTO),
                        Click.on(CONTINUAR_COMPRA),
                        WaitUntil.the(CONTINUAR_COMPRA, isNotVisible()).forNoMoreThan(10).seconds(),
                        Click.on(By.xpath("//body[1]/div[2]/div[1]/div[1]/div[1]/div[3]/div[1]/div[9]/section[1]/div[2]/div[1]/div[3]/div[1]/div[2]/div[1]/div[1]/div[5]/div[1]/div[1]/div[1]/" +
                                "div["+productos.get(i)+"]/section[1]/a[1]/article[1]/div[2]/div[2]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/span[1]"))
                );
            }
            actor.attemptsTo(
                    Click.on(CONTINUAR_COMPRA)
            );
        }
        System.out.println(cantidades);
        System.out.println(nombres);
        System.out.println(precios);
        System.out.println(totalCompra);

    }

    public static AgregarProductos agregarProductos(){
        return new AgregarProductos();
    }
}
