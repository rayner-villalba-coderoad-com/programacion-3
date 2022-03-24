package com.unifranz;

public class Televisor {
    private String marca;
    String tamano;
    double precio;

    void conectarConElCelular() {

    }

   public void encender() {
      System.out.println("Encendiendo.....");
      this.apagar();

    }

    public void cambiarMarca(String nuevaMarca) {
        this.marca = nuevaMarca;
        System.out.println("Marca televisor: " + nuevaMarca);
    }

    private void apagar() {
        System.out.println("Apagar.....");

    }
    //....

     void agregarPrecio(double precio) {
        this.encender();
        this.apagar();
        this.marca = "Samsung";
        System.out.println("Marca: " + this.marca);

        System.out.println("Agregando Precio....");
        this.precio = precio;

    }

    double obtenerPrecio() {
        return this.precio;
    }
}

