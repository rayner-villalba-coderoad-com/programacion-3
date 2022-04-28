package com.unifranz;

import javax.swing.*;

public class Pacman extends JFrame {
    //Atributos
    Juego juego;

    //Constructor
    public Pacman() {
        //Agregamos el titulo a la ventanita
        super("Pacman Unifranz!");
        //Declaramos el panel
        juego = new Juego();

        //Asignarmos el tamano
        setSize(380, 420);

        //Desahabilitar el re dimensionado de la ventana
        setResizable(false);


        //Agregamos el contenedor
        add(juego);

        //Colocamos la ventana al centro de la pantalla
        setLocationRelativeTo(null);

        //Cerrar el proceso
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        //Mostrar ventanita
        setVisible(true);


    }

}
