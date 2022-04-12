package com.unifranz;

public class Banana extends Producto {
    public Banana(double precio) {
        super(precio);
    }

    //Definimos la implementacion del metodo abstracto
    public String obtenerNombre() {
        String nombreProducto = "Banana";
        return nombreProducto;
    }
}
