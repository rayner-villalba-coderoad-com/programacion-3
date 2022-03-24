package com.company;

public class Coche {
    //Atributos
    String marca;
    String color;
    String modelo;
    String tamano;
    double precio;

    //Metodos
    public void acelerar() {
        System.out.println("Acelarando......");
    }

    public void irEnReversa() {
        System.out.println("Ir en reversa......");
    }

    public void frenar() {
        System.out.println("Frenar");
    }

    public void mostrarPrecio() {
        System.out.println("El precio del auto es: " + precio + " $us");
    }

    public void mostrarMarca() {
        System.out.println("La marca es: " + marca);
    }

    public void mostrarModelo() {
        System.out.println("El modelo es: " + modelo);
    }
}
