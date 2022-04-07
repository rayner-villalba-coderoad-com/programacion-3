package com.unifranz;

import java.awt.FlowLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.Icon;
import javax.swing.ImageIcon;

public class LabelFrame extends JFrame {
    private final JLabel label1;
    //private final JLabel label2;
   // private final JLabel label3;

    public LabelFrame() {
        super("Revisando JLabel");
        setLayout(new FlowLayout());
        this.label1 = new JLabel("Label con texto");
        this.label1.setToolTipText("Label 1");

        // Agrega label1 al JFrame
        add(label1);


    }
}
