package com.unifranz.herencia;

public class Persona {
    protected String nombre;  //private, protected, public
    protected String apellido;
    private int edad;

    //Constructor
    public Persona(String nombre, String apellido, int edad) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public void imprimirTelefono() {
        System.out.println(" El numero de telefono es: " + 754523234);
    }

    public String obtenerSaludo() {
        String saludo = "Hola como estas: " + this.nombre;
        return saludo;
    }
}

