package com.unifranz;
//Clase abstracta
public abstract class Producto {
    private double precio;

    public Producto(double precio) {
        this.precio = precio;
    }

    public double getPrecio() {
        return precio;
    }

    //Definir al menos un metodo abstracto. Donde un metodo abstracto no tiene implementacion
    public abstract String obtenerNombre();
}
