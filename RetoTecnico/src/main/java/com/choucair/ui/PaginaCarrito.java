package com.choucair.ui;

import net.serenitybdd.screenplay.targets.Target;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.By;

public class PaginaCarrito extends PageObject {

    public static final Target CARRITO=Target.
            the("Ir al carrito")
            .located(By.xpath("//a[contains(@class,'exito-header-3-x-minicartLink')]//*[name()='svg']"));

    public static final Target CAMPO_CORREO=Target.
            the("Campo del correo electronico")
            .located(By.xpath("//input[@placeholder='correo@email.com']"));

    public static final Target CONFIRMAR_CORREO=Target.
            the("")
            .located(By.xpath("//button[normalize-space()='Confirmar']"));

    public static final Target NOMBRE_PRODUCTO_CARRITO=Target.
            the("")
            .located(By.xpath("(//*[@class='exito-checkout-io-0-x-itemCartContent'])[1]/descendant::div[5]"));
/*
    public static final Target CONFIRMAR_CORREO1=Target.
            the("")
            .located(By.xpath("//button[normalize-space()='Confirmar1']"));*/


}
