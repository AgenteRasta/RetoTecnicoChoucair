package com.choucair.ui;

import net.serenitybdd.screenplay.targets.Target;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.By;
import static com.choucair.ui.PaginaInicial.MENU;
public class Menu extends PageObject {
    public static String cat;
    public static String subcat;

    static String cate = String.format("undefined-nivel2-%s", cat);

    public static final Target CATEGORIA = Target.
            the("Seleccionar categoria")
            .located(By.id("undefined-nivel2-Dormitorio"));

    public static final Target PUBLICIDAD=Target.
            the("Cerrar publicidad").
            located(By.id("wps-overlay-close-button"));

    public static final Target SUBCATEGORIA = Target.
            the("Seleccionar subcategoria")
            .located(By.xpath("//*[text()='Colchones sencillos']"));
}
