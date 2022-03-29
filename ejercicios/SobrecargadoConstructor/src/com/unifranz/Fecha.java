package com.unifranz;

public class Fecha {
    //Atributos
    private int dia;
    private int mes;
    private int año;

    public Fecha() {
        //Constructor
        System.out.println("Construyendo objeto sin parametros");
    }

    public Fecha(int dia) {
        //Constructor
        System.out.println("Construyendo objeto con 1 parametro: " + dia);
    }

    public Fecha(int dia, int mes) {
        //Constructor
        System.out.println("2 parametros" + dia +" " + mes);
    }

    public Fecha(int dia, int mes, int gestion) {
        //Constructor
        this.dia = dia;
        this.mes = mes;
        this.año = gestion;
        System.out.println("3 parametros: " + dia +" " + mes + " " + gestion);
    }

    public Fecha(String dia, String mes, String año) {
        //Constructor
        System.out.println("3 parametros" + dia +" " + mes + " " + año);

    }

    public void imprimirFecha() {
        System.out.println("La fecha es: " + this.dia + "/" + this.mes + "/" + this.año);
    }
}
