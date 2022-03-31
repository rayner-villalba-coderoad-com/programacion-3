package com.unifranz.polimorfismo;

public class Main {
    public static void main(String[] args) {
        Animal fido = new Perro("Perro", "Fido");
        Animal mishifuz = new Gato("Gato", "Mishifuz");

        fido.imprimirMensaje();
        mishifuz.imprimirMensaje();
    }
}
