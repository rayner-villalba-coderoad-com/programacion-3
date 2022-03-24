package src.com.unifranz;

import java.util.Scanner;

public class PruebaFactura {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
       // System.out.println("Hola");

        System.out.println("*******************************");
        System.out.println("           FACTURA             ");
        System.out.println("*******************************");

        System.out.print("Ingrese la pieza a facturar: ");
        String pieza = scanner.nextLine();
        System.out.println("");

        // Recuerdas el System.out.printf es un print con formato donde cuando usamos datos de tipo string sustituirá %s
        // con el valor que esta despues de la coma (,)
        // Supongamos pieza = "madera" la siguiente linea imprimira "Ingrese la descripcion de la pieza madera"
        // NOTA el %s es para string, si usas datos tipo int usa %d cuando uses float usa %f
        System.out.printf("Ingrese la descripcion de la pieza %s a facturar: ", pieza);
        String descripcion = scanner.nextLine();

        System.out.println("");

        System.out.printf("Ingresa la cantidad de %s a facturar: ", pieza);

        // Recuerda cuando leemos numeros enteros desde el scanner usa scanner.nextInt();
        int cantidad = scanner.nextInt();

        System.out.printf("Ingresa el precio de cada %s a facturar Bs: ", pieza);
        double precio = scanner.nextDouble();

        //👷 Creamos el nuevo objeto factura para ello
        // Nombre de la clase  + nombre de la variable = new NombreDelaClase(argumentos)
        // Donde agregamos los argumentos si los necesitan para crear el objeto y asignar valores a nuestros atributos
        Factura factura = new Factura(pieza,descripcion, cantidad, precio);

        // Obtenemos el monto de la factura para ello accedemos al metodo del objeto a traves del punto
        // En nuestro caso el objeto se llama factura.obtenerMontoFactura(cantidad, precio)
        // Donde cantidad y precio son los argumentos que solicita el método
        // Asi como notamos el metodo obtenerMontoFactura retorna el precio total
        double totalFactura = factura.obtenerMontoFactura(cantidad, precio);

        System.out.println("\nPrecio total de la factura es: " + totalFactura + " Bs.-");
    }
}
