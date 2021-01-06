package page;

import driver.DriverContext;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.qameta.allure.model.Status;
import org.openqa.selenium.support.PageFactory;

import static report.AllureReport.addStep;
import static utils.MetodosGenericos.esperarObjeto;

public class CrearCliente {
    private AppiumDriver driver;

    public CrearCliente(){
        this.driver = DriverContext.getDriver();
        PageFactory.initElements( new AppiumFieldDecorator( driver ), this );
    }

    @AndroidFindBy(xpath = "//*[contains(@text,\"Crear Cliente\")]")
    private MobileElement tituloCrearCliente;
    @AndroidFindBy(id = "com.rodrigo.registro:id/ac_nombre")
    private MobileElement inputNombre;
    @AndroidFindBy(id = "com.rodrigo.registro:id/ruc")
    private MobileElement inputIdentificador;
    @AndroidFindBy(id = "com.rodrigo.registro:id/tel")
    private MobileElement inputTelefono;
    @AndroidFindBy(id = "com.rodrigo.registro:id/dir")
    private MobileElement inputDireccion;
    @AndroidFindBy(id = "com.rodrigo.registro:id/notas")
    private MobileElement inputNotas;
    @AndroidFindBy(id = "com.rodrigo.registro:id/cambiar_ubicacion")
    private MobileElement BtnSeleccionarUbicacion;
    @AndroidFindBy(id = "com.rodrigo.registro:id/guardar")
    private MobileElement btnGuardar;

    public void validarVistaDesplegada(){
        if(esperarObjeto(tituloCrearCliente, 5)){
            addStep("[Validar titulo de la vista Crear Cliente]", true, Status.PASSED, false);
        }else {
            addStep("[Error, al validar titulo de la vista Crear Cliente]", true, Status.FAILED, true);
        }
    }

    public void completarFormularioCrearCliente(String nombre, String id, String fono, String direccion, String notas){
        System.out.println("[ Completar formulario Crear Cliente ]");
            inputNombre.setValue( nombre );
            this.driver.hideKeyboard();
            inputIdentificador.setValue( id );
            this.driver.hideKeyboard();
            inputTelefono.setValue( fono );
            this.driver.hideKeyboard();
            inputDireccion.setValue( direccion );
            this.driver.hideKeyboard();
            inputNotas.setValue( notas );
            this.driver.hideKeyboard();
            addStep("[Completar formulario Crear Cliente]", true, Status.PASSED, false);
    }

    public void tapguardar(){
        btnGuardar.click();
    }
}
