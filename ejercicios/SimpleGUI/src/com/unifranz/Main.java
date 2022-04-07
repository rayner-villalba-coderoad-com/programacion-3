

package com.unifranz;
import javax.swing.JOptionPane;

public class Main {
    public static void main(String[] args) {
        String primerNumero = JOptionPane.showInputDialog("Ingresa el primer numero");
        String segundoNumero = JOptionPane.showInputDialog("Ingresa el segundo numero");

        int numero1 = Integer.parseInt(primerNumero);
        int numero2 = Integer.parseInt(segundoNumero);

        int resultado = sumar(numero1, numero2);
        JOptionPane.showMessageDialog(null, "El resultado es: " + resultado, "Resultado suma", JOptionPane.INFORMATION_MESSAGE);
    }

    public static int sumar(int num1, int num2) {
        return num1 + num2;
    }
}
