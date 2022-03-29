package com.unifranz;
//Miembros estaticos de una clase, no le pertenece a un objeto
public class Estatico {
    private static String frase = "Primera Frase";

    public static void main(String[] args) {
	// write your code here
//        Estatico ob1 = new Estatico();
//        Estatico ob2 = new Estatico();
//
//        ob2.frase = "Segunda Frase";


        Estatico.frase = "Nueva frase";
        //System.out.println(ob1.frase);
        //System.out.println(ob2.frase);
        System.out.println(Estatico.frase);
        System.out.println(multiplar(2,2));
        System.out.println("Otra manera de multiplicar: " + Estatico.multiplar(3,3));
    }

    public static  int multiplar(int num1, int num2) {
        return num1 * num2;
    }

}
