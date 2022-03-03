//Paso 1 importamos scanner
import java.util.Scanner;

public class PruebaCajeroAutomatico{
    public static void main(String[ ] args )
    {
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

    }
}
