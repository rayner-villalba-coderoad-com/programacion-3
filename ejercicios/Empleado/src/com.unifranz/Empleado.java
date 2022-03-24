package src.com.unifranz;

public class Empleado {
    //Atributos de la clase
    private String primerNombre;
    private String apellidoPaterno;
    private double salarioMensual;

    //Constructor del objeto
    public Empleado(String nombre, String apellido, double salario) {
        this.primerNombre = nombre;
        this.apellidoPaterno = apellido;

        if (salario > 0.0) {
            this.salarioMensual = salario;
        }
    }

    public void establecerNombre(String nuevoNombre) {
        this.primerNombre = nuevoNombre;
    }

    public String obtenerNombre() {
        return this.primerNombre;
    }

    public void establecerApellido(String nuevoApellido) {
        this.apellidoPaterno = nuevoApellido;
    }

    public String obtenerApellido() {
        return this.apellidoPaterno;
    }

    public void establecerSalarioMensual(double nuevoSalarioMensual) {
        if (nuevoSalarioMensual > 0.0) {
            this.salarioMensual = nuevoSalarioMensual;
        } else {
            System.out.println("\nEl salario no es válido.");
        }
    }

    public double obtenerSalarioMensual() {
        return this.salarioMensual;
    }

    //Obtenemos el salario anual multiplicando el actual salario mensual * 12
    public double obtenerSalarioAnual() {
        return obtenerSalarioMensual() * 12;
    }

    // Método para incrementar el 10% sobre el sueldo anual del empleado
    public double obtenerAumento()
    {
        double salarioAnual = obtenerSalarioAnual();
        double salarioConIncremento = salarioAnual + (0.10 * salarioAnual);
        return salarioConIncremento;
    }

    // Método que muestra resumen de la información relativa al empleado
    public void mostrarResumen() {
        System.out.printf( "\nSu nombre es: %s" , obtenerNombre() );
        System.out.printf( "\nSu apellido es: %s" , obtenerApellido() );
        System.out.printf( "\nSu salario mensual es: %.2f Bolivianos" , obtenerSalarioMensual());
        System.out.printf( "\nSu salario anual sin incremento es: %.2f Bolivianos" , obtenerSalarioAnual());
        System.out.printf( "\nSu salario anual con incremento es: %.2f Bolivianos" , obtenerAumento());
    }
}
