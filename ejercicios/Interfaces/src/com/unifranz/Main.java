package com.unifranz;

import javax.swing.JOptionPane;
public class Main {

    public static void main(String[] args) {
	// write your code here
        System.out.println("Aprendiendo interface en Java");

        String razaPerrito = JOptionPane.showInputDialog("La raza del perrito es: ");
        Perrito perrito = new Perrito(razaPerrito);

        perrito.haceSonido();
        perrito.come();
        perrito.jugar();

        Gatito gatito = new Gatito("Gatito","Mishifush");
        gatito.caminar();
        gatito.haceSonido();
        gatito.jugar();
    }
}
