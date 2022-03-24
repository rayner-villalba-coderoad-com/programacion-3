package src.com.unifranz;

public class FrecuenciaCardiaca
{
    // Variables de instancia
    private int edad;
    private String nombreCompleto;

    // Constructores
    public FrecuenciaCardiaca(String nombre, int edad) {
        this.nombreCompleto = nombre;
        this.edad = edad;
    }

    // Métodos
    /**
     * Imprime el nombre completo,
     * frecuencia cardiaca máxima: 220 - edad
     * frecuencia cardiaca esperada: rango entre el 50% y 85% de la frecuencia máxima
     */
    public void mostrarDatos() {
        // Calcular frecuencias
        int fmax = 220 - this.edad;
        double fesp_inicio = fmax * 0.5;
        double fesp_fin = fmax * 0.85;

        // Imprimir
        System.out.println("Nombre: " + this.nombreCompleto);
        System.out.println("Frecuencia cardiaca máxima: " + fmax );
        String fesp = "Frecuencia cardiaca esperada (rango): [ ";
        fesp += fesp_inicio + "-" + fesp_fin + " ]";
        System.out.println( fesp );
    }

    // Getters & Setters
    public int getEdad() {
        return this.edad;
    }

    public String getNombreCompleto() {
        return this.nombreCompleto;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }
}