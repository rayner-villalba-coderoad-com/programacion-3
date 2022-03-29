package com.unifranz;

public class Main {

    public static void main(String[] args) {
	// write your code here
        //cuenta es un objeto
        Cuenta cuenta = new Cuenta();
        //cuenta.numeroCuenta = 123456;

        int numeroDeCuenta = cuenta.getNumeroCuenta();
        System.out.println("Numero de cuenta antes: " + numeroDeCuenta);
        cuenta.setNumeroCuenta(654321);
        numeroDeCuenta = cuenta.getNumeroCuenta();
        System.out.println("Numero de cuenta despues: " + numeroDeCuenta);
    }
}
