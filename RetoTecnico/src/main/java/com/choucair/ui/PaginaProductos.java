package com.choucair.ui;

import net.serenitybdd.screenplay.targets.Target;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.By;

public class PaginaProductos extends PageObject {

    public static final Target AGREGAR_PRODUCTO = Target.
            the("Agrega un producto")
            .located(By.xpath("//*[@class='exito-vtex-components-4-x-mainBuyButton']"));
    public static final Target ADD_PRODUCTO=Target.
            the("Suma una cantidad de un producto")
            .located(By.xpath("//span[contains(@class,'product-details-exito-vtex-components-buy-button-manager-more')]//*[name()='svg']"));
    public static final Target CONTINUAR_COMPRA=Target.
            the("Seguir comprando")
            .located(By.xpath("//*[@class='exito-vtex-components-4-x-continue']"));

    public static final Target INICIO=Target.
            the("Subir al inicio")
            .located(By.id("header-tabExito"));

    public static final Target NOMBRE_PRODUCTO=Target.
            the("")
            .located(By.cssSelector("div[role='presentation'] div:nth-child(1) h3:nth-child(1) span:nth-child(1)"));
    public static final Target PRECIO_PRODUCTO=Target.
            the("")
            .located(By.cssSelector("div[class='w-100 center pt2 pb5'] div[class='exito-vtex-components-4-x-selling-price flex items-center '] span[class='exito-vtex-components-4-x-currencyContainer']"));

}
