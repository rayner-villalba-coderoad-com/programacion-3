package com.unifranz;

import javax.swing.JFrame;

public class Main {

    public static void main(String[] args) {
        System.out.println("Mi segunda interfaz de usuario");
        //Paso 1 Creamos el objeto ventanita
        Ventanita ventanita = new Ventanita();

        //paso 2 definimos donde se va a dibujar en el plano cartesiano ancho y alto
        ventanita.setBounds(50, 50, 1000, 500);

        //paso 3 Mostrar ventanita
        ventanita.setVisible(true);

        //Paso 4 Habilitar la opcion de cerrar ventana
        ventanita.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
