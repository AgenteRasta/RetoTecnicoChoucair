package com.choucair.setup;

import io.github.bonigarcia.wdm.WebDriverManager;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.thucydides.core.annotations.Managed;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;


import static com.google.common.base.StandardSystemProperty.USER_DIR;
import static com.choucair.util.Log4j.LOG4J_PROPERTIES_FILE_PATH;
import static net.serenitybdd.screenplay.actors.OnStage.theActorCalled;


public class Configuracion {
    private static final String SWITCHES = "--remote-allow-origins=*";
    private static final String ACTOR = "Estiven";
    private static final int DIEZ_SEGUNDOS = 10;

    @Managed()
    protected WebDriver webDriver;


    private void setupUser( WebDriver webDriver) {
        configurarDriver();
        OnStage.setTheStage(new OnlineCast());
        theActorCalled(ACTOR).can(BrowseTheWeb.with(webDriver));
        maximizar(webDriver);
    }

    private void configurarDriver() {
        ChromeOptions co = new ChromeOptions();
        co.addArguments(SWITCHES);
        co.addArguments("--incognito");
        WebDriverManager.chromedriver().setup();
        webDriver = new ChromeDriver(co);
    }

    private static void maximizar(WebDriver webDriver) {
        webDriver.manage().window().maximize();
    }

    protected void quitarDriver() {
        webDriver.quit();
    }

    protected void configurarNavegador() {
        setupUser(webDriver);
        setUplog4j();
    }

    private void setUplog4j() {
        PropertyConfigurator.configure(USER_DIR.value() + LOG4J_PROPERTIES_FILE_PATH.getValue());
    }


    /*public static void waitExplicit() {
        //WebDriverWait wait = new WebDriverWait(getDriver(), DIEZ_SEGUNDOS);
        //wait.until(ExpectedConditions.alertIsPresent());
    }*/


}
