package com.unifranz;

import java.util.Date;

public class Empleado extends Trabajador {
    private double sueldo;
    //AFP
    private double impuestos;
    public Empleado(String nombre, String puesto, String direccion, String telefono, Date fechaNacimiento, Date fechaContratacion, double sueldo) {
        //super
        super(nombre, puesto, direccion, telefono, fechaNacimiento, fechaContratacion);

        this.sueldo = sueldo;
        //Recuerda el descuento es del 12.71%
        this.impuestos = 0.1271 * sueldo;
    }

    public void imprimirInformacion() {
        System.out.println("Nombre del empleado: "  + this.getNombre());
        System.out.println("Puesto del empleado: "  + this.getPuesto());
    }
    public double calcularPaga() {
        return (sueldo - impuestos);
    }
}
