package com.choucair.ui;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class Registro {

    public static final Target BOTON_REGISTRARSE=Target.the("Boton para iniciar el registro")
            .located(By.id("com.exito.appcompania:id/AppCompatButton_registrarse"));

    public static final Target CAMPO_NOMBRE_REGISTRO=Target.the("Campo para escribir el nombre en el registro")
            .located(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.ScrollView/android.view.ViewGroup/android.widget.LinearLayout[1]/android.widget.FrameLayout/android.widget.EditText"));
}
