package com.unifranz;

import javax.swing.*;

public class Pacman extends JFrame {
    //Atributos
    Juego juego;

    //Constructor
    public Pacman() {
        //Agregamos el titulo a la ventanita
        super("Pacman Unifranz!");
        juego = new Juego();

        //Asignarmos el tamano
        setSize(380, 420);


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
