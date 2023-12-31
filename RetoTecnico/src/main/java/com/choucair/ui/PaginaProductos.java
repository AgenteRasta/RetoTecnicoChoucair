package com.choucair.ui;

import net.serenitybdd.screenplay.targets.Target;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.By;

public class PaginaProductos extends PageObject {

    public static final String BUSCAR_PRODUCTO="//body[1]/div[2]/div[1]/div[1]/div[1]/div[3]/div[1]/div[9]/section[1]/div[2]/div[1]/div[3]/div[1]/div[2]/div[1]/div[1]/div[5]/div[1]/div[1]/div[1]/" +
            "div[%s]/section[1]/a[1]/article[1]/div[2]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]";

    public static final String CLICK_PRODUCTO="//body[1]/div[2]/div[1]/div[1]/div[1]/div[3]/div[1]/div[9]/section[1]/div[2]/div[1]/div[3]/div[1]/div[2]/div[1]/div[1]/div[5]/div[1]/div[1]/div[1]/" +
            "div[%s]/section[1]/a[1]/article[1]/div[2]/div[2]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/span[1]";
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
    public static final Target CERRAR_REGISTRO=Target.
            the("")
            .located(By.xpath("//span[@class='exito-geolocation-3-x-cursorPointer']//*[name()='svg']"));

    public static final Target UNIDADES_COMPRA=Target.
            the("Saber cuentas unidades van al carrito")
            .located(By.xpath("//div[contains(@class,'exito-vtex-components-4-x-stepperContainerQty')]"));

    public static final Target ESPERA_SCROLL=Target.
            the("")
            .located(By.xpath("(//*[@class='flex items-center exito-vtex-components-4-x-soldByText fw1 ma0 ml1'])[1]"));
}
