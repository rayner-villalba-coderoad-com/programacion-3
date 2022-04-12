package com.unifranz;

public class Perrito implements Animal, AnimalesDomesticos {
    String raza;

    public Perrito(String raza) {
      this.raza = raza;
    }


    @Override
    public void haceSonido() {
        System.out.println("Guaw guaw");
    }

    @Override
    public void come() {
        //Implementacion
        System.out.println("El perrito come!!");
    }

    @Override
    public void serAmigable() {
        System.out.println("El perrito es amigable");
    }

    @Override
    public void jugar() {
        System.out.println("El perrito juega!!!");
    }
}
