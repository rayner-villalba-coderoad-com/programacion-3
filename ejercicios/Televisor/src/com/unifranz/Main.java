package com.unifranz;

public class Main {

    public static void main(String[] args) {
	 System.out.println("Creando nuestro proyecto televisor!");

     Televisor televisor1 = new Televisor();
     televisor1.agregarPrecio(2000);

     double precioTelevisor = televisor1.obtenerPrecio();

     System.out.println("El precio del televisor es: " + precioTelevisor + " Bs.");
     System.out.println("---------------------------------------------------.");


     Televisor televisor2 = new Televisor();
     televisor2.cambiarMarca("Sony");
     televisor2.encender();


     televisor2.agregarPrecio(3000);





     double precioTelevisor2 = televisor2.obtenerPrecio();

     System.out.println("El precio del televisor 2 es: " + precioTelevisor2 + " Bs.");
    }
}
