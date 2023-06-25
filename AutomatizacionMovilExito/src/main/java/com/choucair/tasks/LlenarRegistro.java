package com.choucair.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;

import static com.choucair.ui.Registro.BOTON_REGISTRARSE;
import static com.choucair.ui.Registro.CAMPO_NOMBRE_REGISTRO;

public class LlenarRegistro implements Task {

    private String nombre;
    private String apellido;

    public LlenarRegistro conElNombre(String nombre){
        this.nombre=nombre;
        return this;
    }
    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Click.on(BOTON_REGISTRARSE),
                Enter.theValue(nombre).into(CAMPO_NOMBRE_REGISTRO)
        );
    }

    public static LlenarRegistro llenarRegistro(){
        return new LlenarRegistro();
    }
}
