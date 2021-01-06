package testClases;

import page.Carrusel;
import page.CrearCliente;
import page.CrearProducto;
import page.Registro;

public class CrearNuevoProducto {

    Carrusel carrusel = new Carrusel();
    Registro registro = new Registro();
    CrearProducto crearProducto = new CrearProducto();
    int numero = (int) (Math.random() * 100) + 1;
    String nombreProducto = "producto".concat( String.valueOf( numero ) );
    int precio = (int) (Math.random() * 25000) + 10000;
    public void flujo(){
        carrusel.validarVista();
        carrusel.recorrerCarrusel();
        carrusel.tapBtnHecho();
        registro.validarVistaDesplegada();
        registro.tapBtnMas();
        registro.tapBtnCrearProducto();
        crearProducto.validarVistaDesplegada();
        crearProducto.completarFormularioCrearProducto( nombreProducto, precio );
        crearProducto.tapConfirmar();
        registro.tapBtnProductos();
        registro.buscarNombreProducto( nombreProducto );
    }
}
