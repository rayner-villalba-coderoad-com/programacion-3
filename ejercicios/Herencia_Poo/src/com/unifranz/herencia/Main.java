package com.unifranz.herencia;

public class Main {

    public static void main(String[] args) {
	    Estudiante estudiante = new Estudiante("Juan", "Perez", 18, 123,15.3f);

        estudiante.mostrarDatos();
        System.out.println("------------------------");

        Profesor profesor = new Profesor("Rayner", "Villalba", 30, 6995322,"Programacion 3");
        profesor.imprimirDatosProfesor();
        System.out.println("------------------------");

        profesor.imprimirTelefono();

        System.out.println("\n------------------------\n");



       String saludito = profesor.obtenerSaludo();
       System.out.println("Saludo que viene de la clase padre: " + saludito);
    }
}
