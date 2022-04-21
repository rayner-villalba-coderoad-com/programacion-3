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
    JPanel panel1;
    JPanel panel2;


    //Contructor
    public BorderLayoutVentanita() {
        super("BorderLayout");
        //Definiendo borderlayout
        setLayout(new BorderLayout());
        //contenedor
        panel1 = new JPanel();
        panel2 = new JPanel();

        panel1.setLayout(new BorderLayout(3, 4));
        panel2.setLayout(new GridLayout(2, 2));

        //Definiendo mis botones
        button1 = new JButton("Sur");
        button2 = new JButton("Oeste");
        button3 = new JButton("Norte");
        button4 = new JButton("Este");
        button5 = new JButton("Centro");

        panel1.add(button1, "South");
        //add(button1, "South");
        panel1.add(button2, "West");
        panel1.add(button3, "North");
        panel1.add(button4, "East");
        panel1.add(button5, "Center");

        this.getContentPane().add(panel1, "South");


        panel2.add(new JButton("1"));
        //panel2.add(new JButton("2"));
        panel2.add(new JButton("3"));
        panel2.add(new JButton("4"));

        this.getContentPane().add(panel2, "North");
        //Dimensionar la ventana de acuerdo al ancho y alto
        setSize(400, 400);

        //Mostrar al centro de la pantalla
        setLocationRelativeTo(null);

        //Mostrar la ventana
        setVisible(true);
    }
}
