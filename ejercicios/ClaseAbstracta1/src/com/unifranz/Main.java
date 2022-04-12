package com.unifranz;

import javax.swing.*;

public class Main {

    public static void main(String[] args) {
	// write your code here
        System.out.println("Ejemplo Clase Abstracta");
        String precioEnCadena = JOptionPane.showInputDialog("El precio de la banana es Bs:");
        double precioBanana = Double.parseDouble(precioEnCadena);
        Banana banana = new Banana(precioBanana);
        String nombreProducto = banana.obtenerNombre();

        //System.out.println("El nombre del producto es: " + nombreProducto);
        JOptionPane.showMessageDialog(null, "El producto es: " + nombreProducto, "KETAL",
                JOptionPane.INFORMATION_MESSAGE);
    }
}
