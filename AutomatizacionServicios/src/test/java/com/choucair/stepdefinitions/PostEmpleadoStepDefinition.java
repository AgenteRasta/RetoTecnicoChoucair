package com.choucair.stepdefinitions;

import com.choucair.setup.ApiSetUp;
import com.choucair.utils.LeerTxt;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.junit.jupiter.api.Assertions;
import java.util.List;
import java.util.logging.Logger;
import static com.choucair.questions.ReturnResponse.returnResponse;
import static com.choucair.tasks.DoPost.doPost;
import static com.choucair.utils.ReqresResources.*;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.rest.questions.ResponseConsequence.seeThatResponse;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.notNullValue;

public class PostEmpleadoStepDefinition extends ApiSetUp {
    public static Logger LOGGER = Logger.getLogger(String.valueOf(PostEmpleadoStepDefinition.class));

    int codigoRespuesta;
    JSONObject empleadoJson = null;
    JSONObject resBody = null;
    JSONObject data = null;
    JSONObject empleadoRespuesta = null;
    Response actualResponse;
    JSONParser parser = new JSONParser();
    List<String> lines;
    @Given("que estoy apuntando con un endpoint a la api post de empleado de restApiExample")
    public void queEstoyApuntandoConUnEndpointALaApiPostDeEmpleadoDeRestApiExample() {
        try{
            waitForMilliseconds(60000);
            setUp(API_BASE_URL.getValue());
            LOGGER.info("Inicio de la automatizacion");
        }catch (Exception e){
            LOGGER.warning(e.getMessage());
        }
    }

    @When("envio la peticion post con la informacion del empleado segun su {int}")
    public void envioLaPeticionPostConLaInformacionDelEmpleadoSegunSu(Integer index) {
        try{
            LOGGER.info("Se selecciona el json que sera enviado para probar y se envia el recurso de la url");
            lines= LeerTxt.readTextFile("DatosPruebaPost.txt");
            String jsonString=lines.get(index);
            empleadoJson=(JSONObject) parser.parse(jsonString);
            actor.attemptsTo(
                    doPost()
                            .withTheResource(POST_EMPLEADO_RESOURCE.getValue())
                            .andTheRequestBody(empleadoJson)
            );
        }catch (Exception e){
            LOGGER.info("FALLO EN AGREGANDO EL RECURSO");
            LOGGER.warning(e.getMessage());
        }
    }

    @Then("recibo el {int} de respuesta")
    public void reciboElDeRespuesta(Integer codigo) {
        try {
            LOGGER.info("Inician los asserts");
            codigoRespuesta=codigo;
            actualResponse=returnResponse().answeredBy(actor);
            actor.should(
                    seeThatResponse("El codigo de respuesta es: "+ actualResponse.getStatusCode(),
                            code -> code.statusCode(codigo))
            );
        }catch (Exception e){
            LOGGER.info("Fallo comparando los codigos de respuesta");
            Assertions.fail();
        }
    }

    @Then("un {string} de confirmacion junto con la informacion del usuario creado")
    public void unDeConfirmacionJuntoConLaInformacionDelUsuarioCreado(String mensaje) {
        if(codigoRespuesta==200){
            try{
                LOGGER.info("Se revisa la respuesta de los codigos 200");
                resBody= (JSONObject) parser.parse(actualResponse.getBody().asString());
                data=(JSONObject) parser.parse(resBody.get("data").toString());
                empleadoRespuesta=(JSONObject) parser.parse(resBody.get("data").toString());
                empleadoRespuesta.remove("id");
                actor.should(
                        seeThat("Se recibe el mensaje",
                                msj->resBody.get("message").toString(),equalTo(mensaje)),
                        seeThat("Retorna informacion",
                                info-> actualResponse,notNullValue()),
                        seeThat("El id es",
                                id->data.get("id").toString(),notNullValue()),
                        seeThat("Se crea el empleado",
                                emple->empleadoJson.toString(),equalTo(empleadoRespuesta.toString()))
                );
            }catch (Exception e){
                LOGGER.warning(e.getMessage());
                Assertions.fail();
            }
        }
        LOGGER.info("FIN DE LA AUTOMATIZACION");
    }
}
