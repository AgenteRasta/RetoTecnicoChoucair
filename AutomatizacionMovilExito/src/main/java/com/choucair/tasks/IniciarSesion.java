package com.choucair.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;

import static com.choucair.ui.IniciarSesion.*;

public class IniciarSesion implements Task {

    private String correo;
    private String contrasenia;

    public IniciarSesion conElCorreo(String correo) {
        this.correo = correo;
        return this;
    }
    public IniciarSesion conElContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
        return this;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Click.on(BOTON_INGRESAR),
                Enter.theValue(correo).into(CAMPO_CORREO_LOGIN),
                Enter.theValue(contrasenia).into(CAMPO_CONTRASENIA_LOGIN),
                Click.on(BOTON_LOGIN)
        );
    }
    public static IniciarSesion iniciarSesion(){
        return new IniciarSesion();
    }
}
