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

public class CrearProducto {

    private AppiumDriver driver;

    public CrearProducto(){
        this.driver = DriverContext.getDriver();
        PageFactory.initElements( new AppiumFieldDecorator( driver ), this );
    }

    @AndroidFindBy(xpath = "//*[contains(@text,\"Crear Producto\")]")
    private MobileElement tituloCrearProducto;
    @AndroidFindBy(id = "com.rodrigo.registro:id/nombre_producto")
    private MobileElement inputNombreProducto;
    @AndroidFindBy(id = "com.rodrigo.registro:id/precio")
    private MobileElement inputPrecio;
    @AndroidFindBy(id = "com.rodrigo.registro:id/confirmar")
    private MobileElement btnConfirmar;

    public void validarVistaDesplegada(){
        if(esperarObjeto(tituloCrearProducto, 5)){
            addStep("[Validar titulo de la vista Crear Producto]", true, Status.PASSED, false);
        }else {
            addStep("[Error, al validar titulo de la vista Crear Producto]", true, Status.FAILED, true);
        }
    }

    public void completarFormularioCrearProducto(String nombreProducto, int precio){
        System.out.println("[ Completar formulario Crear Producto ]");
        inputNombreProducto.setValue( nombreProducto );
        this.driver.hideKeyboard();
        inputPrecio.setValue( String.valueOf( precio ) );
        this.driver.hideKeyboard();
        addStep("[Completar formulario Crear Producto]", true, Status.PASSED, false);
    }

    public void tapConfirmar(){
        btnConfirmar.click();
    }
}
