package com.unifranz;

import javax.swing.*;
import java.awt.*;

public class BorderLayoutVentanita extends JFrame {
    //Atributos
    JButton button1;
    JButton button2;
    JButton button3;
    JButton button4;
    JButton button5;

    //Contructor
    public BorderLayoutVentanita() {
        super("BorderLayout");
        //Definiendo borderlayout
        setLayout(new BorderLayout());

        //Definiendo mis botones
        button1 = new JButton("Sur");
        button2 = new JButton("Oeste");
        button3 = new JButton("Norte");
        button4 = new JButton("Este");
        button5 = new JButton("Centro");

        add(button1, "South");
        add(button2, "West");
        add(button3, "North");
        add(button4, "East");
        add(button5, "Center");

        //Dimensionar la ventana de acuerdo al ancho y alto
        setSize(400, 400);

        //Mostrar al centro de la pantalla
        setLocationRelativeTo(null);

        //Mostrar la ventana
        setVisible(true);
    }
}
