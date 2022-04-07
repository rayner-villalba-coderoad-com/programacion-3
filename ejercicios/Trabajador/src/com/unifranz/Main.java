package com.unifranz;

import java.util.Date;
//Paso numero 1
import javax.swing.JOptionPane;

public class Main {

    public static void main(String[] args) {
	   System.out.println("******************************************");
       System.out.println("*    SISTEMA DE RECURSOS HUMANOS         *");
	   System.out.println("******************************************");
       //Paso 2
       String nombre = JOptionPane.showInputDialog("Ingresa el nombre del Empleado: ");
       Empleado empleado1 = new Empleado(nombre, "Seguridad", "Avenida Mejillones", "2223232",new Date("05/10/1990"), new Date("04/05/2021"), 5000);
       double pagaEmpleado = empleado1.calcularPaga();
       System.out.println("Pago del empleado es: " + pagaEmpleado);
       String nombreConsultor = JOptionPane.showInputDialog("El nombre del consultor es: ");
       Consultor consultor1 = new Consultor(nombreConsultor, "Seguridad", "Avenida Mejillones", "2223232",new Date("05/10/1990"), new Date("04/05/2021"), 40, 50);
       double pagaDelConsult = consultor1.calcularPaga();

       System.out.println("Pago del consultor es: " + pagaDelConsult);


    }


}
