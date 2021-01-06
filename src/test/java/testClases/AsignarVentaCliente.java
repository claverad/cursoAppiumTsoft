package testClases;

import page.AgregarVenta;
import page.Carrusel;
import page.Registro;

import java.util.Map;

public class AsignarVentaCliente {

    Carrusel carrusel = new Carrusel();
    Registro registro = new Registro();
    AgregarVenta agregarVenta = new AgregarVenta();

    public void flujo() {
        carrusel.validarVista();
        carrusel.recorrerCarrusel();
        carrusel.tapBtnHecho();
        registro.validarVistaDesplegada();
        registro.tapBtnProductos();
        Map<String, String> listaPrecios = agregarVenta.obtenerListaProductoYPrecios();
        registro.tapBtnCliente();
        registro.seleccionarCliente();
        agregarVenta.seleccionarProducto();
        agregarVenta.tapAgregar();
        agregarVenta.tapPagarEfectivo();
        agregarVenta.tapPopUpConfirmacionVenta();
        agregarVenta.validacionVenta(listaPrecios);

    }
}
