package page;

import driver.DriverContext;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.qameta.allure.model.Status;
import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.support.PageFactory;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static report.AllureReport.addStep;

public class AgregarVenta {

    private AppiumDriver driver;

    public AgregarVenta(){
        this.driver = DriverContext.getDriver();
        PageFactory.initElements( new AppiumFieldDecorator( driver ), this );
    }

    @AndroidFindBy(xpath = "//*[contains(@text,\"Registro\")]")
    private MobileElement tituloVistaRegistro;
    @AndroidFindBy(id = "com.rodrigo.registro:id/vc_anadirVenta")
    private MobileElement btnAgregarNuevaVenta;
    @AndroidFindBy(id = "android:id/text1")
    private List<MobileElement> listaProductos;
    @AndroidFindBy(id = "com.rodrigo.registro:id/cp_producto")
    private MobileElement tituloProducto;
    @AndroidFindBy(id = "com.rodrigo.registro:id/cp_cantidad")
    private MobileElement inputCantidad;
    @AndroidFindBy(id = "com.rodrigo.registro:id/ci_add")
    private MobileElement btnAgregar;
    @AndroidFindBy(id = "com.rodrigo.registro:id/precio_producto")
    private List<MobileElement> precioProducto;
    @AndroidFindBy(id = "com.rodrigo.registro:id/nombre_producto")
    private List<MobileElement> nombreProducto;
    @AndroidFindBy(id = "com.rodrigo.registro:id/confirmarydinero")
    private MobileElement btnPagarEfectivo;
    @AndroidFindBy(id = "com.rodrigo.registro:id/buttonDefaultPositive")
    private MobileElement btnConfirmarVenta;
    @AndroidFindBy(id = "com.rodrigo.registro:id/vercli_ultVenta")
    private MobileElement lblDetalleVenta;

    public Map<String, String> obtenerListaProductoYPrecios(){
        System.out.println("[Guardando lista y precio de Productos]");
        Map<String, String> lista = new HashMap<>();
        for(int i = 0; i < precioProducto.size(); i++){
            lista.put( nombreProducto.get( i ).getText(), precioProducto.get( i ).getText());
            System.out.println("\t[Producto "+nombreProducto.get( i ).getText()+" - precio: "+precioProducto.get( i ).getText());
        }
        return lista;
    }

    public Map<String, Integer> seleccionarProducto()  {

        System.out.println("[Vista Seleccionar Producto]");
        int numero = (int) (Math.random() * listaProductos.size()) ;
        int cantidad = (int) (Math.random() *10) + 1;
        btnAgregarNuevaVenta.click();
        System.out.println("\t[Seleccionar producto al azar, existen "+listaProductos.size()+" producto(s)]");
        listaProductos.get( numero ).click();
        System.out.println("\t[producto seleccionado: "+tituloProducto.getText()+"]");
        System.out.println("\t[cantidad: "+cantidad+"]");
        inputCantidad.setValue( String.valueOf( cantidad ) );
        Map<String, Integer> productoCantidad = new HashMap<>();
        productoCantidad.put( tituloProducto.getText(), cantidad );
        return productoCantidad;
    }

    public void tapAgregar(){
        btnAgregar.click();
    }

    public void tapPagarEfectivo(){
        btnPagarEfectivo.click();
    }

    public void tapPopUpConfirmacionVenta(){
        btnConfirmarVenta.click();
    }

    public void validacionVenta(Map<String, String> listaPrecios){
        Map<String, Integer> venta = new HashMap<>();
        //System.out.println("Venta: "+lblDetalleVenta.getText());
        String detalleVenta = lblDetalleVenta.getText();
        String cantidad = StringUtils.substringBefore(detalleVenta, "x");
        String producto = StringUtils.substringBetween(detalleVenta, "x", "=");
        double total = Double.parseDouble( StringUtils.substringAfter(detalleVenta, "=").replaceAll("\\s","") );
        double precioProducto = Double.parseDouble( listaPrecios.get( producto.replaceAll("\\s","") ) );
        double totalCalculado = Double.parseDouble(cantidad.replaceAll("\\s","")) * precioProducto;
        //System.out.println("totalCalculado:"+totalCalculado);
        if(totalCalculado == total){
            addStep("[Validación de la venta, \n\tTotal venta: $"+total+"\n\tTotal calculado ("+cantidad+" * "+precioProducto+") = "+totalCalculado+"]", true, Status.PASSED, false);
        }else{
            addStep("[Error, el total de la venta no corresponde al calculado (producto * cantidad) ]", true, Status.FAILED, true);
        }

    }


}
