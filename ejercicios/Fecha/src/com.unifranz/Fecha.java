package src.com.unifranz;

public class Fecha {
    private int dia;
    private int mes;
    private int gestion;

    public Fecha(int dia, int mes, int gestion) {
        if (dia > 0 && dia < 32) {
            this.dia = dia;
        }

        if (mes > 0 && mes < 13) {
            this.mes = mes;
        }

        if (gestion > 0) {
            this.gestion = gestion;
        }

    }

    public int obtenerDia() {
        return this.dia;
    }

    public void establecerDia(int dia) {
        if (dia > 0 && dia < 32) {
            this.dia = dia;
        } else {
            System.out.println("No es un dia");
        }
    }

    public int obtenerMes() {
        return this.mes;
    }

    public void establecerMes(int mes) {
        if (mes > 0 && mes < 13) {
            this.mes = mes;
        } else {
            System.out.println("No es un mes valido");
        }
    }

    public int obtenerGestion() {
        return this.gestion;
    }

    public void establecerGestion(int gestion) {
        if (gestion > 0) {
            this.gestion = gestion;
        } else {
            System.out.println("No es una gestion valida");
        }
    }

   public void mostrarFecha() {
        System.out.println("La fecha es: " + this.dia + "/" + this.mes + "/" + this.gestion);
   }
}
