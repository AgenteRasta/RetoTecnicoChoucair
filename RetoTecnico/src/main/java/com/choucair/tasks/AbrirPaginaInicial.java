package com.choucair.tasks;

import com.choucair.ui.PaginaInicial;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Open;

import static com.choucair.ui.PaginaInicial.MENU;

public class AbrirPaginaInicial implements Task {

    private PaginaInicial paginaInicial;

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Open.browserOn(paginaInicial),
                Click.on(MENU)
        );
    }
}
