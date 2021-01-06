package testClases;

import page.Carrusel;
import page.Registro;

public class PreCondiciones {

    Registro registro = new Registro();
    Carrusel carrusel = new Carrusel();


    public void flujoPreCondiciones() {
        carrusel.validarVista();
        carrusel.recorrerCarrusel();
        carrusel.tapBtnHecho();
        registro.validarVistaDesplegada();
        registro.validarClientes();
        registro.validarProductos();
    }
}
