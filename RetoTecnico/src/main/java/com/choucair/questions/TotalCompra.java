package com.choucair.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

import static com.choucair.ui.PaginaCarrito.TOTAL_COMPRA;
import static com.choucair.util.ObtenerNumero.obtenerEnteros;

public class TotalCompra implements Question<Integer> {


    @Override
    public Integer answeredBy(Actor actor) {
            return obtenerEnteros(TOTAL_COMPRA.resolveFor(actor).getText());
    }

    public static TotalCompra totalCompra(){
        return new TotalCompra();
    }
}
