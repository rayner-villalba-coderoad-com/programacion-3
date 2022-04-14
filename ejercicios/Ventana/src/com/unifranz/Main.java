package com.unifranz;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
	   // write your code here
       Ventana ventanita = new Ventana();
       ventanita.setBounds(0, 300, 400, 400);
       ventanita.setVisible(true);
       ventanita.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       ventanita.setLocationRelativeTo(null);
       ventanita.setResizable(false);
    }
}
