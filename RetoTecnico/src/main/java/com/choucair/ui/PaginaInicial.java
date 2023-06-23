package com.choucair.ui;

import net.serenitybdd.screenplay.targets.Target;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.By;

public class PaginaInicial extends PageObject {
    public static final Target MENU = Target.
            the("Desplegar menu")
            .located(By.id("Trazado_7822"));

}
