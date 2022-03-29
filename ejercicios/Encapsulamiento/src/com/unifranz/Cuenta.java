package com.unifranz;
// Dentro de un cuenta hay datos sensibles

//Encapsulamiento puede ocultar atributos y metodos
//Pero cuando defino el nivel de acceso es private crear Getter and Setter
public class Cuenta {
   //Atributos
   private int numeroCuenta;
   private int saldoDeCuenta;

   public Cuenta() {
       //Constructor
   }

   public Cuenta(int numeroCuentaP, int saldoDeCuentaP) {
       //Constructor
      this.numeroCuenta = numeroCuentaP;
      this.saldoDeCuenta = saldoDeCuentaP;
   }

   public void setNumeroCuenta(int nuevaCuenta) {
      this.numeroCuenta = nuevaCuenta;
   }

   //Getter tipo de dato + (obtener)Atributo
   public int getNumeroCuenta() {
      //returna el atributo
      return numeroCuenta;
   }


   protected int sumar(int num1, int num2) {
      return num1 + num2;
   }

   public int getSaldoDeCuenta() {
      return saldoDeCuenta;
   }

   public void setSaldoDeCuenta(int saldoDeCuenta) {
      this.saldoDeCuenta = saldoDeCuenta;
   }
}
