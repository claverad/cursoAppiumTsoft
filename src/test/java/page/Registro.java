package page;

import driver.DriverContext;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.qameta.allure.model.Status;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

import static report.AllureReport.addStep;
import static utils.MetodosGenericos.esperarObjeto;

public class Registro {
    private AppiumDriver driver;

    public Registro(){
        this.driver = DriverContext.getDriver();
        PageFactory.initElements( new AppiumFieldDecorator( driver ), this );
    }

    @AndroidFindBy(xpath = "//*[contains(@text,\"Registro\")]")
    private MobileElement tituloVistaRegistro;
    @AndroidFindBy(id = "com.rodrigo.registro:id/fab_expand_menu_button")
    private MobileElement btnMas;
    @AndroidFindBy(id = "com.rodrigo.registro:id/action_cliente")
    private MobileElement btnCrearCliente;
    @AndroidFindBy(id = "com.rodrigo.registro:id/action_producto")
    private MobileElement btnCrearProducto;
    @AndroidFindBy(id = "com.rodrigo.registro:id/nombre_cliente")
    private MobileElement nombreCliente;
    @AndroidFindBy(id = "com.rodrigo.registro:id/nombre_producto")
    private MobileElement nombreProducto;
    @AndroidFindBy(xpath = "//*[contains(@text,\"PRODUCTOS\")]")
    private MobileElement  btnProductos;
    @AndroidFindBy(xpath = "//*[contains(@text,\"CLIENTES\")]")
    private MobileElement  btnClientes;
    @AndroidFindBy(id = "com.rodrigo.registro:id/nombre_cliente")
    private List<MobileElement> listaClientes;
    @AndroidFindBy(id = "com.rodrigo.registro:id/title")
    private MobileElement tituloCliente;
    @AndroidFindBy(id = "com.rodrigo.registro:id/textView6")
    private MobileElement lblSinClientes;
    @AndroidFindBy(id = "com.rodrigo.registro:id/textView6")
    private MobileElement lblSinProductos;


    public void buscarNombreCliente( String nombre){
        boolean cliente = esperarObjeto( nombreCliente, 4 );
        if(cliente){
            System.out.println("[Validar creacion de cliente: "+nombre+" en vista Registro]");
            addStep("[Cliente creado en vista Registro]", true, Status.PASSED, false);
        }else {
            addStep("[Error, el cliente: "+nombre+" no se encuentra en la vista Registro]", true, Status.FAILED, true);
        }
    }

    public void tapBtnProductos(){
        if(esperarObjeto( btnProductos,3 )){
            addStep( "[Tap al boton "+btnProductos+" ]", true, Status.PASSED, false );
            btnProductos.click();
        }else {
            addStep( "[Error, el boton: "+btnProductos+" no se encuentra. ]", true, Status.FAILED, true );
        }
    }

    public void validarClientes(){

        if(nombreCliente.getText().isEmpty()){
            addStep( "[Error, no existen Clientes ]", true, Status.FAILED, true );
        }else{
            System.out.println("[Existen Clientes registrados]");
            addStep( "[Existen Clientes registrados ]", true, Status.PASSED, false );
        }
    }

    public void validarProductos(){
        tapBtnProductos();
        if(nombreProducto.getText().isEmpty()){
            addStep( "[Error, no existen Productos ]", true, Status.FAILED, true );
        }else{
            System.out.println("[Existen Productos registrados]");
            addStep( "[Existen Productos registrados ]", true, Status.PASSED, false );
        }
    }

    public void buscarNombreProducto( String nombre){
        boolean producto = esperarObjeto( nombreProducto, 4 );
        if(producto){
            System.out.println("[Validar creacion de producto: "+nombre+" en vista Registro]");
            addStep("[Producto creado en vista Registro]", true, Status.PASSED, false);
        }else {
            addStep("[Error, el producto: "+nombre+" no se encuentra en la vista Registro]", true, Status.FAILED, true);
        }
    }

    public void validarVistaDesplegada(){
        if(esperarObjeto(tituloVistaRegistro, 5)){
            addStep("[Validar titulo de la vista Registro]", true, Status.PASSED, false);
        }else {
            addStep("[Error, al validar titulo de la vista Registro]", true, Status.FAILED, true);
        }
    }

    public void tapBtnMas(){
        if(esperarObjeto( btnMas,3 )){
            addStep( "[Tap al boton "+btnMas+" ]", true, Status.PASSED, false );
            btnMas.click();
        }else {
            addStep( "[Error, el boton: "+btnMas+" no se encuentra. ]", true, Status.FAILED, true );
        }
    }

    public void seleccionarCliente()  {

        System.out.println("[Vista Registro]");
        esperarObjeto( tituloVistaRegistro, 2 );
        int numero = (int) (Math.random() * listaClientes.size()) + 0;
        System.out.println("\t[Seleccionar cliente al azar, existen "+listaClientes.size()+" clientes]");
        listaClientes.get( numero ).click();
        System.out.println("\t[cliente seleccionado: "+tituloCliente.getText()+"]");
    }

    public void tapBtnCrearProducto(){
        if(esperarObjeto( btnCrearProducto, 3 )){
            addStep( "[Tap al boton "+btnCrearProducto+" ]", true, Status.PASSED, false );
            btnCrearProducto.click();
        }else{
            addStep( "[Error, el boton: "+btnCrearProducto+" no se encuentra. ]", true, Status.FAILED, true );
        }
    }

    public void tapBtnCliente(){
        if(esperarObjeto( btnClientes, 3 )){
            addStep( "[Tap al boton "+btnClientes+" ]", true, Status.PASSED, false );
            btnClientes.click();
        }else{
            addStep( "[Error, el boton: "+btnClientes+" no se encuentra. ]", true, Status.FAILED, true );
        }
    }

    public void tapBtnCrearCliente(){
        if(esperarObjeto( btnCrearCliente, 3 )){
            addStep( "[Tap al boton "+btnCrearCliente+" ]", true, Status.PASSED, false );
            btnCrearCliente.click();
        }else{
            addStep( "[Error, el boton: "+btnCrearCliente+" no se encuentra. ]", true, Status.FAILED, true );
        }
    }

}
