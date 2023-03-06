package com.example.lk_grafikrechner;

import java.awt.Graphics;

import javax.swing.*;

import static javafx.application.Application.launch;


class DrawController extends JPanel {



    @Override protected void paintComponent( Graphics g ) {

        super.paintComponent( g );

        g.drawLine( 10, 10, 100, 50 );

    }
    public static void main(String[] args) {
        launch(args);
    }
}

public class GUI {

}
