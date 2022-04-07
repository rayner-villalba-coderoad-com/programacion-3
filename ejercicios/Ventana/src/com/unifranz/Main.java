package com.unifranz;

public class Main {
    public static void main(String[] args) {
	   // write your code here
       Ventana ventanita = new Ventana();
       ventanita.setBounds(0, 300, 400, 400);
       ventanita.setVisible(true);
       ventanita.setLocationRelativeTo(null);
       ventanita.setResizable(false);
    }
}
