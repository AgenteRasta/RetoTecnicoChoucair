package com.choucair.ui;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class IniciarSesion {

    public static final Target BOTON_INGRESAR=Target.the("Boton para empezar el inicio de sesion")
            .located(By.id("com.exito.appcompania:id/AppCompatButton_ingresar"));

    public static final Target CAMPO_CORREO_LOGIN=Target.the("Campo para escribir el correo en el login")
            .located(By.id("com.exito.appcompania:id/TextInputEditText_email"));

    public static final Target CAMPO_CONTRASENIA_LOGIN=Target.the("Campo para escribir la contrasenia en el login")
            .located(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.widget.LinearLayout[3]/android.widget.FrameLayout/android.widget.EditText"));

    public static final Target BOTON_LOGIN=Target.the("Boton para iniciar sesion")
            .located(By.id("com.exito.appcompania:id/AppCompatButton_ingresar"));


}
