package com.choucair.ui;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class Registro {

    public static final Target BOTON_REGISTRARSE=Target.the("Boton para iniciar el registro")
            .located(By.id("com.exito.appcompania:id/AppCompatButton_registrarse"));

    public static final Target CAMPO_NOMBRE_REGISTRO=Target.the("Campo para escribir el nombre en el registro")
            .located(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.ScrollView/android.view.ViewGroup/android.widget.LinearLayout[1]/android.widget.FrameLayout/android.widget.EditText"));

    public static final Target CAMPO_APELLIDO_REGISTRO=Target.the("Campo para escribir el apellido en el registro")
            .located(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.ScrollView/android.view.ViewGroup/android.widget.LinearLayout[2]/android.widget.FrameLayout/android.widget.EditText"));

    public static final Target JOPTION_TIPO_DOCUMENTO=Target.the("Desplegar opciones de documento")
            .located(By.xpath("(//android.widget.ImageButton[@content-desc=\"Show dropdown menu\"])[1]"));

    public static final Target CAMPO_DOCUMENTO=Target.the("Campo para escribir el documento en el registro")
            .located(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.ScrollView/android.view.ViewGroup/android.widget.LinearLayout[4]/android.widget.FrameLayout/android.widget.EditText"));

    public static final Target CAMPO_ANIO=Target.the("Campo para escribir el anio")
            .located(By.id("com.exito.appcompania:id/filled_exposed_dropdown_anio_registro"));

    public static final Target CAMPO_MES=Target.the("Campo para escribir el mes")
            .located(By.id("com.exito.appcompania:id/filled_exposed_dropdown_anio_registro"));

    public static final Target CAMPO_DIA=Target.the("Campo para escribir el dia")
            .located(By.id("com.exito.appcompania:id/filled_exposed_dropdown_dia_registro"));

    public static final Target CAMPO_CELULAR=Target.the("Campo para escribir el celular")
            .located(By.id("com.exito.appcompania:id/TextInputEditText_tel"));

    public static final Target CAMPO_CORREO=Target.the("Campo para escribir el correo")
            .located(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.ScrollView/android.view.ViewGroup/android.widget.LinearLayout[7]/android.widget.FrameLayout/android.widget.EditText"));

    public static final Target BOTON_CONFIRMAR_REGISTRO=Target.the("Boton para confirmar el registro")
            .located(By.id("com.exito.appcompania:id/AppCompatButton_registrar"));
    public static final Target VOLVER_AL_INICIO=Target.the("Volver a tras")
            .located(By.id("com.exito.appcompania:id/MaterialButton_goBack"));

    public static final Target ACEPTAR_RETROCEDER=Target.the("Aceptar volver al inicio y perder los datos llenados")
            .located(By.id("com.exito.appcompania:id/AppCompatButton_confirm"));

}
