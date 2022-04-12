package com.unifranz;

import java.util.Date;

public abstract class Trabajador {
    //Atributos
    private String nombre;
    private String puesto;
    private String direccion;
    private String telefono;
    private Date fecha_nacimiento;
    private Date fecha_contratacion;

    public Date getFecha_nacimiento() {
        return fecha_nacimiento;
    }

    public void setFecha_nacimiento(Date fecha_nacimiento) {
        this.fecha_nacimiento = fecha_nacimiento;
    }

    public Date getFecha_contratacion() {
        return fecha_contratacion;
    }

    public void setFecha_contratacion(Date fecha_contratacion) {
        this.fecha_contratacion = fecha_contratacion;
    }

    public abstract double calcularPaga();

    //Constructor
    public Trabajador(String nombreP,
                      String puesto,
                      String direccion,
                      String telefono,
                      Date fecha_nacimiento,
                      Date fecha_contratacion) {
       this.nombre = nombreP;
       this.puesto = puesto;
       this.direccion = direccion;
       this.telefono = telefono;
       this.fecha_nacimiento = fecha_nacimiento;
       this.fecha_contratacion = fecha_contratacion;
    }

    @Override
    public String toString() {
        return "Trabajador{" +
                "nombre='" + nombre + '\'' +
                ", puesto='" + puesto + '\'' +
                ", direccion='" + direccion + '\'' +
                ", telefono='" + telefono + '\'' +
                '}';
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPuesto() {
        return puesto;
    }

    public void setPuesto(String puesto) {
        this.puesto = puesto;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
}
