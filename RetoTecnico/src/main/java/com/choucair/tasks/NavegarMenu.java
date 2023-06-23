package com.choucair.tasks;
import io.cucumber.datatable.TableCellByTypeTransformer;
import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import net.serenitybdd.screenplay.questions.WebElementQuestion;
import org.openqa.selenium.remote.server.handler.FindElement;

import java.util.List;

import static com.choucair.ui.Menu.*;



public class NavegarMenu implements Task {

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Click.on(CATEGORIA),
                //Click.on(PUBLICIDAD),
                Click.on(SUBCATEGORIA)
                //Scroll.to(By.xpath("//*[@id='gallery-layout-container']/descendant::div["+productoNum+"]")),
                //Click.on("//*[@id='gallery-layout-container']/descendant::div["+productoNum+"]")

        );
       try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
       /*
        actor.attemptsTo(

                Click.on(By.xpath("(//*[@class='pointer outline-0'])[1]"))
        );
        System.out.println("Hay productos"+COMPRA_PRODUCTO.resolveAllFor(actor).size());
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }*/
    }


    public static NavegarMenu navegarMenu(){
        return new NavegarMenu();
    }
}
