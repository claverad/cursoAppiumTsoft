package testSuite;

import driver.BaseConfig;
import org.testng.annotations.Test;
import testClases.CrearNuevoCliente;

public class RegistroUsuarios extends BaseConfig {

    @Test(description = "Crea un cliente con nombre aleatorio")
    public void crearCliente(){
        CrearNuevoCliente crearCliente = new CrearNuevoCliente();
        crearCliente.flujo();
    }
}
