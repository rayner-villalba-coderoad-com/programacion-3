package com.unifranz.herencia;

public class Estudiante extends Persona {
    private int codigoEstudiante;
    private float notaFinal;

    //Constructor
    public Estudiante(String nombre, String apellido, int edad, int codigoEstudiante,float notaFinal) {
        //super indica que una variable o metodo es de la clase padre,
        super(nombre, apellido, edad);
        this.codigoEstudiante = codigoEstudiante;
        this.notaFinal = notaFinal;
    }

    public void mostrarDatos() {
        System.out.println("Nombre: " + nombre +
                "\nApellido: " + this.getApellido() +
                "\nEdad: " + this.getEdad() +
                "\nCodigo Estudiante: " + this.codigoEstudiante +
                "\nNota Final: " + this.notaFinal);
    }
}
