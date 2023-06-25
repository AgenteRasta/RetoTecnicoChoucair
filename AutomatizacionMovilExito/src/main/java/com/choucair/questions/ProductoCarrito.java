package com.choucair.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

import static com.choucair.ui.Carrito.PRODUCTO_CARRITO;

public class ProductoCarrito implements Question<String> {
    @Override
    public String answeredBy(Actor actor) {
        return PRODUCTO_CARRITO.resolveFor(actor).getText();
    }

    public static ProductoCarrito productoCarrito(){
        return new ProductoCarrito();
    }
}
