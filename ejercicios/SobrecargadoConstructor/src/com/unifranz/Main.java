package com.unifranz;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Fecha fecha1 = new Fecha();
        Fecha fecha2 = new Fecha(01);
        Fecha fecha3 = new Fecha(01);
        Fecha fecha4 = new Fecha(01,03, 2022);

        Fecha fecha5 = new Fecha("02", "Febrero", "2022");

        fecha1.imprimirFecha();
        fecha4.imprimirFecha();
    }
}
