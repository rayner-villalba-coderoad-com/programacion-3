package com.unifranz;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GridLayoutVentanita extends JFrame implements ActionListener {
    //Atributos
    private static final int COLUMNAS = 5;
    private static final int FILAS = 3;
    JButton[][] boton = new JButton [FILAS][COLUMNAS];

    //Constructor
    public GridLayoutVentanita() {
        //Agregando titulo a la ventana
        super("GridLayout");

        //Defino el layout como matriz o tabla de acuerdo al numero de filas y columnas
        setLayout(new GridLayout(FILAS, COLUMNAS));

        int botonIncremental = 0;
        for (int i=0; i<FILAS; i++) {
            for(int j=0; j<COLUMNAS; j++) {
               boton[i][j] = new JButton(Integer.toString(botonIncremental + 1));

                //Agregando a la ventanita
               add(boton[i][j]);
               //Agregamos funcionalidad al boton
               boton[i][j].addActionListener(this);
               botonIncremental++;
            }
        }

        //Renderiza la ventana de acuerdo al contenido
        pack();

        //Mostrar ventana
        setVisible(true);

        //Cerrar el proceso
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //Mostrar la ventana al centro de la pantalla
        setLocationRelativeTo(null);

    }
   @Override
    public void actionPerformed(ActionEvent e) {
        for (int i=0; i<FILAS; i++) {
            for(int j=0; j<COLUMNAS; j++) {
                if (e.getSource()== boton[i][j]) {
                    JOptionPane.showMessageDialog(null, "Usted a presionado el boton: " + boton[i][j].getText(), "Boton Presionado", JOptionPane.INFORMATION_MESSAGE);
                }
            }
        }
    }
}
