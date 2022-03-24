package src.com.unifranz;
import java.util.Scanner;
public class PruebaEmpleado {
    public static void main(String[] args) {
        Scanner scanner = new Scanner( System.in );
        String nombre; 
        String apellido; 
        double salario;

        Empleado empleado1 = new Empleado( "Rayner" , "Villalba" , 1000);


        Empleado empleado2 = new Empleado( "Juana" , "Ruiz" , -2000);

        System.out.println( "************************************" );
        System.out.println( "     Sistema de Recursos Humanos    " );
        System.out.println( "************************************" );

        System.out.println("\nRecepción de los datos del primer empleado");
        // Nombre
        System.out.print( "\nEscriba su nombre: " );
        nombre = scanner.nextLine();
        empleado1.establecerNombre(nombre);

        // Apellido
        System.out.print( "\nEscriba su apellido: " );
        apellido = scanner.nextLine();
        empleado1.establecerApellido(apellido);

        // Salario
        System.out.print( "\nEscriba su salario mensual: " );
        salario = scanner.nextDouble();
        empleado1.establecerSalarioMensual(salario);

        // Muestra el resumen del empleado1
        System.out.print( "\nReporte del Empleado 1: " );
        empleado1.mostrarResumen();

        System.out.println( "\n\nRecepción de los datos del segundo empleado" );

        // Nombre
        System.out.print( "\nEscriba su nombre: " );
        nombre = scanner.nextLine();
        empleado2.establecerNombre(nombre);

        // Apellido
        System.out.print( "\nEscriba su apellido: " );
        apellido = scanner.nextLine();
        empleado2.establecerApellido(apellido);

        // Salario
        System.out.print( "\nEscriba su salario mensual: " );
        salario = scanner.nextDouble();
        empleado2.establecerSalarioMensual(salario);

        // Muestra el resumen del empleado2
        System.out.print( "\nReporte del  empleado 2: " );
        empleado2.mostrarResumen();

        System.out.println();
    }
}
