//Paso 1 importamos scanner
import java.util.Scanner;

public class PruebaCajeroAutomatico{
    public static void main(String[ ] args )
    {
        int defaultPin = 1234;
        //Paso 2 instanciar para realizar la lectura de datos
        Scanner scanner = new Scanner(System.in);

        System.out.println("*******************************************");
        System.out.println("Cajero Automático");
        System.out.println("*******************************************");
        System.out.println("Bienvenido!");
        System.out.println();
        System.out.print("Escriba su PIN!");

        //Leer el pin desde teclado
        int pin = scanner.nextInt();

        if (defaultPin == pin) {
            System.out.println("Menu PRINCIPAL");
            System.out.println("=================================");
            System.out.println("1 - Ver mi Saldo");
            System.out.println("2 - Retirar mi efectivo");
            System.out.println("3 - Depositar fondos");
            System.out.println("4 - Salir");
            System.out.print("Ingrese su opcion: ");
            int opcion = scanner.nextInt();
        } else {
            System.out.print(" PIN incorrecto");
        }

    }
}
