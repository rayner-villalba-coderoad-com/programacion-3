package com.unifranz;

import javax.swing.*;
import java.awt.*;

public class VentanitaAlineadosDeIzquierdaADerecha extends JFrame {
    //Atributos
    JButton boton;
    JButton boton2;
    JButton boton3;
    JCheckBox checkBox;

    //Constructor
    public VentanitaAlineadosDeIzquierdaADerecha() {
        //COloco titulo a la ventana
        super("FlowLayout");

        // Defino que los elementos iran de izquierda a derecha
        setLayout(new FlowLayout());

        //Definiendo los elementos
        boton = new JButton("Unifranz");
        boton2 = new JButton("Unifranz 2");
        boton3 = new JButton("Unifranz 3");
        checkBox = new JCheckBox("Utilizando Checkbox");

        //Agregamos cada elemento a la ventana
        add(checkBox);
        add(boton);
        add(boton2);
        add(boton3);

    }
}
