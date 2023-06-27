package com.choucair.ui;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class Productos {
    public static final Target ACEPTAR_PERMISOS=Target.the("Acepta acceder a la ubicacion")
            .located(By.id("com.android.permissioncontroller:id/permission_allow_one_time_button"));
    public static final Target CERRAR_VENTANA=Target.the("Cierra ventana que sale al iniciar sesion")
            .located(By.id("com.exito.appcompania:id/imageview_close"));

    public static final Target CELU_MANIA=Target.the("Ingresa a comprar un celular")
            .located(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[3]/android.widget.HorizontalScrollView/androidx.recyclerview.widget.RecyclerView/android.widget.LinearLayout[1]/android.view.ViewGroup[1]/android.widget.ImageView"));

    public static final Target ENVIO_DOMICILIO=Target.the("Opcion de enviar a domicilio")
            .located(By.id("com.exito.appcompania:id/appCompatTextView_item_title"));

    public static final Target BOTON_CONTINUAR=Target.the("Continuar con la compra")
            .located(By.id("com.exito.appcompania:id/appCompatButton_continue"));

    public static final Target NOMBRE_PRODUCTO=Target.the("Nombre del celular")
            .located(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.widget.FrameLayout[1]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[1]/android.widget.TextView[4]"));

    public static final Target AGREGAR_PRODUCTO=Target.the("Agrega el primer celular")
            .located(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.widget.FrameLayout[1]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]"));
    public static final Target IR_CARRITO=Target.the("Ir al carrito")
            .located(By.id("com.exito.appcompania:id/appCompatImageView_shopping_cart"));
}
