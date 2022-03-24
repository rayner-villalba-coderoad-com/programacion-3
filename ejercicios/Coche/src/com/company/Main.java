package com.company;

public class Main {

    public static void main(String[] args) {
	   System.out.println("Coche");

        Coche coche1 = new Coche();
        coche1.precio = 20000;
        coche1.marca = "Mazda";
        //coche1.acelerar();

       // coche1.irEnReversa();
        coche1.mostrarPrecio();
        coche1.mostrarMarca();
        System.out.println("--------------------------------------");

        Coche coche2 = new Coche();
        coche2.marca = "Susuki";

        coche2.mostrarMarca();
        System.out.println("--------------------------------------");
        Coche coche3 = new Coche();
        coche3.marca = "Chevrolet";
        coche3.precio = 15000;
        coche3.modelo = "Tracker";

        coche3.mostrarMarca();
        coche3.mostrarPrecio();
        coche3.mostrarModelo();
    }
}
