package com.unifranz;

public class Gatito extends Felino implements Animal, AnimalesDomesticos{
    private String nombre;

    public Gatito(String nombreDelFelino, String nombre) {
        super(nombreDelFelino);
        this.nombre = nombre;
    }

    @Override
    public void haceSonido() {
        System.out.println( " El gato " + this.nombre + " hace Miaw");
    }

    @Override
    public void come() {
       //
    }

    @Override
    public void serAmigable() {
//
    }

    @Override
    public void jugar() {
        System.out.println("Jugando con el Gatito");
    }
}

