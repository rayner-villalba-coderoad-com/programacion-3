package com.unifranz.herencia;

public class Profesor extends Persona {
    private int nit;
    private String materia;

    public Profesor(String nombre, String apellido, int edad, int nit, String materia) {
        super(nombre, apellido, edad);
        this.nit = nit;
        this.materia = materia;
    }

    public void imprimirDatosProfesor() {
        System.out.println("El nombre del profesor es: " + this.nombre + " \nsu apellido es: " + this.apellido +
                "\nsu materia es: " + this.materia + "\nsu nit es: " + this.nit);
    }
}
