package com.unifranz;

import java.util.Date;
import javax.swing.JOptionPane;

public class Main {

    public static void main(String[] args) {
	   System.out.println("******************************************");
       System.out.println("*    SISTEMA DE RECURSOS HUMANOS         *");
	   System.out.println("******************************************");
       String nombre = JOptionPane.showInputDialog("Ingresa el nombre del Empleado: ");
       Empleado empleado1 = new Empleado(nombre, "Seguridad", "Avenida Mejillones", "2223232",new Date("05/10/1990"), new Date("04/05/2021"), 5000);
       empleado1.imprimirInformacion();
       double pagaEmpleado = empleado1.calcularPaga();
       System.out.println("Pago del empleado es: " + pagaEmpleado);

    }


}
