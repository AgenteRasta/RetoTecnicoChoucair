package com.choucair.tasks;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.offset.PointOption;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import org.openqa.selenium.interactions.Actions;

import static com.choucair.driver.AndroidDriverr.driver;
import static com.choucair.ui.Registro.*;
import static net.serenitybdd.core.Serenity.getDriver;

public class LlenarRegistro implements Task {
    TouchAction touchAction = new TouchAction(driver);
    private String nombre;
    private String apellido;
    private String anio;
    private String mes;
    private String dia;
    private String documento;
    private String celular;
    private String correo;

    public LlenarRegistro conElNombre(String nombre){
        this.nombre=nombre;
        return this;
    }
    public LlenarRegistro conElApellido(String apellido) {
        this.apellido = apellido;
        return this;
    }

    public LlenarRegistro conElAnio(String anio) {
        this.anio = anio;
        return this;
    }

    public LlenarRegistro conElMes(String mes) {
        this.mes = mes;
        return this;
    }

    public LlenarRegistro conElDia(String dia) {
        this.dia = dia;
        return this;
    }

    public LlenarRegistro conElDocumento(String documento) {
        this.documento = documento;
        return this;
    }

    public LlenarRegistro conElCelular(String celular) {
        this.celular = celular;
        return this;
    }

    public LlenarRegistro conElCorreo(String correo) {
        this.correo = correo;
        return this;
    }
    @Override
    public <T extends Actor> void performAs(T actor) {

        actor.attemptsTo(
                Click.on(BOTON_REGISTRARSE),
                Enter.theValue(nombre).into(CAMPO_NOMBRE_REGISTRO),
                Enter.theValue(apellido).into(CAMPO_APELLIDO_REGISTRO),
                Enter.theValue(documento).into(CAMPO_DOCUMENTO),
                Enter.theValue(anio).into(CAMPO_ANIO),
                Enter.theValue(mes).into(CAMPO_MES),
                Enter.theValue(dia).into(CAMPO_DIA),
                Enter.theValue(documento).into(CAMPO_DOCUMENTO),
                Enter.theValue(celular).into(CAMPO_CELULAR),
                Enter.theValue(correo).into(CAMPO_CORREO)

        );
        touchAction.tap(PointOption.point(115, 1662)).perform();
        touchAction.tap(PointOption.point(111, 1746)).perform();
        actor.attemptsTo(
                Click.on(VOLVER_AL_INICIO),
                Click.on(ACEPTAR_RETROCEDER)
        );

    }

    public static LlenarRegistro llenarRegistro(){
        return new LlenarRegistro();
    }
}
