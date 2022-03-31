package com.unifranz.polimorfismo;

public class Animal {

    private String especie;

    public Animal(String especie) {
        this.especie = especie;
    }

    public void imprimirMensaje() {
        System.out.println("Soy un animal de la especie: " + this.especie);
    }

    public String getEspecie() {
        return especie;
    }

    public void setEspecie(String especie) {
        this.especie = especie;
    }


}
