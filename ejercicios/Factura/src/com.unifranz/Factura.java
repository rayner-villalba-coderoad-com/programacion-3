package src.com.unifranz;

public class Factura {
    private String numeroPiezas;
    private String descripcion;
    private int cantidadArticulos;
    private double precioArticulo;

    public Factura(String piezas, String nuevaDescripcion, int cantidad, double precio) {
        this.numeroPiezas = piezas;
        this.descripcion = nuevaDescripcion;
        this.cantidadArticulos = cantidad;
        this.precioArticulo = precio;
    }

    public double obtenerMontoFactura(int cantidad, double precio) {
        // Verificamos si la cantidad  es positiva asignamos la cantidad a cero
        if (cantidad < 0) {
           cantidad = 0;
        }

        if (precio < 0) {
            precio = 0.0;
        }                //   10.0
         //double c = (double)cantidad * 20.99
        return cantidad * precio;
    }
}
