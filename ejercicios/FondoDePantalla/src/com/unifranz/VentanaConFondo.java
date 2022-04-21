package com.unifranz;

import javax.swing.*;
import java.awt.*;

public class VentanaConFondo extends JFrame {

    //Constructor
    public VentanaConFondo() {
        super("Ventana con fondo");
        //Llamamos a la clase panel que creara nuestro fondo
        CrearFondo panel = new CrearFondo();

        //Definimos el border layout que se mostrara al centro de la pantalla
        setLayout(new BorderLayout());

        //Agregamos la imagen como fondo de pantalla
        panel.setImagen("/assets/imagenes/came_house.jpg");

        //agregando el panel a la ventana
        add(panel, BorderLayout.CENTER);

        //Habilitamos la opcion cerrar del JFrame
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //Renderizamos la ventana 700 de ancho y 350 de alto
        setSize(700, 350);

        //Mostramos al centro de la pantalla la ventana
        setLocationRelativeTo(null);

        //Mostramos la ventana
        setVisible(true);
    }
}
