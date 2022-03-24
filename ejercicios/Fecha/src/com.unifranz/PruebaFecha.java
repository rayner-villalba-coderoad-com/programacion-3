package src.com.unifranz;
import java.util.Scanner;
public class PruebaFecha {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("********************************");
        System.out.println("     Sistema de Fecha           ");
        System.out.println("********************************");

        Fecha fecha = new Fecha(1, 10,1990);
        fecha.mostrarFecha();

        System.out.print("Ingrese el dia (1-31): ");
        int dia = scanner.nextInt();
        fecha.establecerDia(dia);

        System.out.print("Ingrese el mes (1-12): ");
        int mes = scanner.nextInt();
        fecha.establecerMes(mes);

        System.out.print("Ingrese la gestion 2000: ");
        int gestion = scanner.nextInt();
        fecha.establecerGestion(gestion);

        System.out.println("Mostramos la nueva fecha");
        fecha.mostrarFecha();
    }
}
