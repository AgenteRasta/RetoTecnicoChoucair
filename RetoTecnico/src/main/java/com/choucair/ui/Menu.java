package com.choucair.ui;

import net.serenitybdd.screenplay.targets.Target;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.By;

public class Menu extends PageObject {
    public static String CATEGORIA="undefined-nivel2-%s";
    public static String SUBCATEGORIA="//*[text()='%s']";


    public static final Target PUBLICIDAD=Target.
            the("Cerrar publicidad").
            located(By.id("wps-overlay-close-button"));


}
