package com.unifranz;

//Paso 1 es importar la libreria Javax.swing.JOPtionPane
import javax.swing.JOptionPane;
public class Main {

    public static void main(String[] args) {
        String primerNumero = JOptionPane.showInputDialog("Introduzca el primer numero");
        //validar los datos de entrada de datos
        boolean isValidaLaPrimeraEntrada = validarEntradaDeDato(primerNumero);
        String segundoNumero = JOptionPane.showInputDialog("Introduzca el segundo numero:");
        //validar los datos de entrada de datos
        boolean isValidaLaSegundaEntrada = validarEntradaDeDato(segundoNumero);

        if (isValidaLaPrimeraEntrada && isValidaLaSegundaEntrada) {
            int numero1 = Integer.parseInt(primerNumero);
            int numero2 = Integer.parseInt(segundoNumero);

            int suma = numero1 + numero2;
            JOptionPane.showMessageDialog(null, "La suma es: " + suma, "Aprendiendo a SUMAR", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, "Usted no ha ingresado un valor valido en el programa", "ERROR", JOptionPane.WARNING_MESSAGE);
        }

    }

    public static boolean validarEntradaDeDato(String entrada) {
        boolean isValida = false;
        try {
            Integer.parseInt(entrada);
            System.out.println(entrada + " es un entero!!");
            isValida = true;
        } catch (Exception e) {
            isValida = false;
            System.out.println(entrada + " no es un entero por esta exception: " + e.getMessage());
        }

       return isValida;
    }
}
