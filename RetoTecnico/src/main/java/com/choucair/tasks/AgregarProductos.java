package com.choucair.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Scroll;
import net.serenitybdd.screenplay.questions.Visibility;
import net.serenitybdd.screenplay.waits.WaitUntil;
import org.openqa.selenium.By;

import static com.choucair.util.ObtenerNumero.obtenerEnteros;

import java.util.ArrayList;
import java.util.List;

import static com.choucair.ui.PaginaProductos.*;
import static com.choucair.util.NumeroAleatorio.generateRandomNumbers;
import static com.choucair.util.NumeroAleatorio.generateRandomNumbersR;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isNotVisible;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class AgregarProductos implements Task {
    public static List<Integer> productos = new ArrayList<>();
    public static List<Integer> cantidades = new ArrayList<>();
    public static List<String> nombres = new ArrayList<>();
    public static List<Integer> precios = new ArrayList<>();
    int unidadesA;
    int precioProducto;
    public static int totalCompra=0;

    @Override
    public <T extends Actor> void performAs(T actor) {

        productos=generateRandomNumbers(16);
        cantidades=generateRandomNumbersR(9);
        System.out.println(productos);
        System.out.println(cantidades);
        for(int i=0;i<5;i++){
            unidadesA=0;
            actor.attemptsTo(
                    Scroll.to(INICIO),
                    WaitUntil.the(INICIO, isVisible()).forNoMoreThan(10).seconds(),
                    WaitUntil.the(ESPERA_SCROLL, isVisible()).forNoMoreThan(10).seconds(),
                    Scroll.to(By.xpath("//body[1]/div[2]/div[1]/div[1]/div[1]/div[3]/div[1]/div[9]/section[1]/div[2]/div[1]/div[3]/div[1]/div[2]/div[1]/div[1]/div[5]/div[1]/div[1]/div[1]/" +
                            "div["+productos.get(i)+"]/section[1]/a[1]/article[1]/div[2]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]")),
                    Click.on(By.xpath("//body[1]/div[2]/div[1]/div[1]/div[1]/div[3]/div[1]/div[9]/section[1]/div[2]/div[1]/div[3]/div[1]/div[2]/div[1]/div[1]/div[5]/div[1]/div[1]/div[1]/" +
                            "div["+productos.get(i)+"]/section[1]/a[1]/article[1]/div[2]/div[2]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/span[1]")),
                    Click.on(AGREGAR_PRODUCTO)

            );
            nombres.add(NOMBRE_PRODUCTO.resolveFor(actor).getText());
            precios.add(obtenerEnteros(PRECIO_PRODUCTO.resolveFor(actor).getText())*cantidades.get(i));
            precioProducto=obtenerEnteros(PRECIO_PRODUCTO.resolveFor(actor).getText());
            if(cantidades.get(i)>=2){
                for (int j=0;j<cantidades.get(i)-1;j++){
                    actor.attemptsTo(
                            Click.on(ADD_PRODUCTO)
                            );
                    int pUni=obtenerEnteros(UNIDADES_COMPRA.resolveFor(actor).getText());
                    unidadesA=unidadesA+1;
                    pUni=(pUni/100);
                    System.out.println("UA:"+unidadesA);
                    System.out.println("UP:"+pUni);
                    if(pUni==unidadesA){
                        cantidades.set(i,pUni-1);
                        break;
                    }
                    actor.attemptsTo(
                            Click.on(CONTINUAR_COMPRA),
                            WaitUntil.the(CONTINUAR_COMPRA, isNotVisible()).forNoMoreThan(10).seconds(),
                            Click.on(By.xpath("//body[1]/div[2]/div[1]/div[1]/div[1]/div[3]/div[1]/div[9]/section[1]/div[2]/div[1]/div[3]/div[1]/div[2]/div[1]/div[1]/div[5]/div[1]/div[1]/div[1]/" +
                                    "div["+productos.get(i)+"]/section[1]/a[1]/article[1]/div[2]/div[2]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/span[1]"))
                    );
                }
            }
            totalCompra=totalCompra+(precioProducto*cantidades.get(i));
            actor.attemptsTo(

                    Click.on(CONTINUAR_COMPRA),
                    WaitUntil.the(ADD_PRODUCTO, isNotVisible()).forNoMoreThan(10).seconds()
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
