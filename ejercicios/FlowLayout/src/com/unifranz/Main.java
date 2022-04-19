package com.unifranz;

import javax.swing.*;

public class Main {

    public static void main(String[] args) {
	// write your code here
        VentanitaAlineadosDeIzquierdaADerecha ventanita = new VentanitaAlineadosDeIzquierdaADerecha();
        //Renderiza de acuerdo al contenido
        ventanita.pack();

        //Cerrar el proceso
        ventanita.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //Mostrar la ventanita
        ventanita.setVisible(true);

    }
}
