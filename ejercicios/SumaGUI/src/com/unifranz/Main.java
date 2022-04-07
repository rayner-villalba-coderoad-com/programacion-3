package com.unifranz;

//
import javax.swing.JOptionPane;
public class Main {

    public static void main(String[] args) {
	    System.out.println("Hola");
        String primerNumero = JOptionPane.showInputDialog("Introduzca el primer numero");
        String segundoNumero = JOptionPane.showInputDialog("Introduzca el segundo numero:");

        int numero1 = Integer.parseInt(primerNumero);
        int numero2 = Integer.parseInt(segundoNumero);

        int suma = numero1 + numero2;
        JOptionPane.showMessageDialog(null, "La suma es: " + suma, "Aprendiendo a SUMAR", JOptionPane.INFORMATION_MESSAGE);
    }
}
