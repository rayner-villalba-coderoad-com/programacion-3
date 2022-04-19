package com.unifranz;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Ventanita extends JFrame implements ActionListener {
    //Atributos
    private JLabel label1;
    private JLabel label2;
    private JTextField campoTextoUsuario;
    private JPasswordField campoTextoPassword;
    private JButton botonLogin;
    private JButton cancelar;


    //Constructor
    public Ventanita() {
        super("Ventanita Unifranz");
        setLayout(null);

        this.label1 = new JLabel("Usuario:");
        //Definimos donde se va a dibujar en el plano cartesiano y definimos el ancho y el alto
        this.label1.setBounds(10, 10, 100, 30);
        //Agregamos el elemento a la ventanita
        add(this.label1);


        //Creamos la entrada tipo texto
        this.campoTextoUsuario = new JTextField();
        //Definimos donde se va a dibujar en el plano cartesiano y definimos el ancho y el alto
        this.campoTextoUsuario.setBounds(120, 17, 150, 20);
        //Agregamos el elemento a la ventanita
        add(this.campoTextoUsuario);


        this.label2 = new JLabel("Contranseña:");
        //Definimos donde se va a dibujar en el plano cartesiano y definimos el ancho y el alto
        this.label2.setBounds(10, 80, 100, 30);
        //Agregamos el elemento a la ventanita
        add(this.label2);

        //Creamos el campo de texto para el password
        this.campoTextoPassword = new JPasswordField();
        //Definimos donde se va a dibujar en el plano cartesiano y definimos el ancho y el alto
        this.campoTextoPassword.setBounds(120, 80, 150, 20);
        add(this.campoTextoPassword);


        //Agregamos el boton a la ventana
        this.botonLogin = new JButton("I N G R E S A R");
        this.botonLogin.setBounds(120, 110, 300, 30);
        add(this.botonLogin);


        this.cancelar = new JButton("CANCELAR");
        this.cancelar.setBounds(500, 110, 300, 30);
        add(this.cancelar);

        //Paso 1 agregamos funcionalidad al boton
        this.botonLogin.addActionListener(this);
        this.cancelar.addActionListener(this);
    }

    //Paso 2 agregando funcionalidad boton
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == botonLogin) {
            ejecutarLogin();
        }

        if(e.getSource() == cancelar) {
            JOptionPane.showMessageDialog(null, "Se ha cancelado", "CANCELAR", JOptionPane.WARNING_MESSAGE);
        }
    }

    public void ejecutarLogin() {
        JOptionPane.showMessageDialog(null, "Hola como estas a partir del evento boton", "INGRESAR", JOptionPane.INFORMATION_MESSAGE);
    }
}
