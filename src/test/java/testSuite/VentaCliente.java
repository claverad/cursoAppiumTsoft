package testSuite;

import driver.BaseConfig;
import org.testng.annotations.Test;
import testClases.AsignarVentaCliente;
import testClases.CrearNuevoCliente;
import testClases.CrearNuevoProducto;
import testClases.PreCondiciones;

import static report.AllureReport.finalAssert;

public class VentaCliente extends BaseConfig {

    @Test(priority = 1, description = "Crea un Cliente aleatorio")
    public void crearCliente(){
        CrearNuevoCliente crearNuevoCliente = new CrearNuevoCliente();
        crearNuevoCliente.flujo();
        finalAssert();
    }

    @Test(priority = 2, description = "Crea un producto aleatorio")
    public void crearProducto(){
        CrearNuevoProducto crearNuevoProducto = new CrearNuevoProducto();
        crearNuevoProducto.flujo();
        finalAssert();
    }

    @Test(priority = 3, description = "validar las precondiciones")
    public void validarPreCondiciones(){
        PreCondiciones preCondiciones = new PreCondiciones();
        preCondiciones.flujoPreCondiciones();
        finalAssert();
    }

    @Test(priority = 4, dependsOnMethods = { "validarPreCondiciones" })
    public void asignarVentaCliente() {
        AsignarVentaCliente asignarVentaCliente = new AsignarVentaCliente();
        asignarVentaCliente.flujo();
        finalAssert();
    }
}
