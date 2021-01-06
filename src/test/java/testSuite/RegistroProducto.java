package testSuite;

import driver.BaseConfig;
import org.testng.annotations.Test;
import testClases.CrearNuevoProducto;

public class RegistroProducto extends BaseConfig {

    @Test(description = "Crea un producto con nombre aleatorio y valor aleatorio entre 10.000 y 25.000")
    public void crearProducto(){
        CrearNuevoProducto crearNuevoProducto = new CrearNuevoProducto();
        crearNuevoProducto.flujo();
    }
}
