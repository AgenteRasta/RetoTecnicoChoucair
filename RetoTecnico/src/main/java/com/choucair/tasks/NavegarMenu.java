package com.choucair.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.*;
import org.openqa.selenium.By;


import static com.choucair.ui.Menu.*;



public class NavegarMenu implements Task {
    public static String cate;
    public static String subcate;
    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Click.on(By.id(String.format(CATEGORIA,cate))),
                Click.on(By.xpath(String.format(SUBCATEGORIA,subcate)))
        );
    }


    public static NavegarMenu navegarMenu(){
        return new NavegarMenu();
    }
}
