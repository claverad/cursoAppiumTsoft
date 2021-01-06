package testClases;

import page.Carrusel;
import page.CrearCliente;
import page.Registro;

public class CrearNuevoCliente {
    Carrusel carrusel = new Carrusel();
    Registro registro = new Registro();
    CrearCliente crearCliente = new page.CrearCliente();
    int numero = (int) (Math.random() * 100) + 1;
    String nombre= "cliente".concat( String.valueOf( numero ) ), id="123", fono="323224455", direccion="siempre viva #321", notas="algo q poner";

    public void flujo(){
        carrusel.validarVista();
        carrusel.recorrerCarrusel();
        carrusel.tapBtnHecho();
        registro.validarVistaDesplegada();
        registro.tapBtnMas();
        registro.tapBtnCrearCliente();
        crearCliente.validarVistaDesplegada();
        crearCliente.completarFormularioCrearCliente( nombre, id, fono, direccion, notas );
        crearCliente.tapguardar();
        registro.validarVistaDesplegada();
        registro.buscarNombreCliente( nombre );
    }
}
