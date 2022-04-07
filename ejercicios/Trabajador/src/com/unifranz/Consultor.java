package com.unifranz;

import java.util.Date;

public class Consultor extends Trabajador {
    private int horas;
    private double tarifa;

    public Consultor(String nombre, String puesto, String direccion, String telefono, Date fechaNacimiento, Date fechaContratacion, int horas, double tarifa) {
        super(nombre, puesto, direccion, telefono,fechaNacimiento, fechaContratacion);
        this.horas = horas;
        this.tarifa = tarifa;
    }

    public double calcularPaga() {
        return (this.horas * this.tarifa);
    }
}
