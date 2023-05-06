/*
 * Archivo: VentanaJuego.java
 * Autores: 
 * Manuel Felipe Cardoso Forero (2027288)
 * ----------------------------- (2027288)
 * Fecha de creación: 06/05/2023
 */

 package vistaVentanas;
 import java.awt.*;
 import java.awt.event.*;
 import javax.swing.*;


public class VentanaJuego extends JFrame {
    private Decolib im1, im2, im3, im4, im5;
    private JPanel jptriki, jppuntos;
    private JLabel lblpointp1, lblpointp2;

    public VentanaJuego(){
        iniciarComponentes();
        getContentPane().setBackground((new Color(42, 47, 79)));
    }

    private void iniciarComponentes() {
        //Configuracion del Jframe
        setTitle("TIK TAK TOE (juego)");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(950, 660);
        setLocationRelativeTo(null);
        setVisible(true);
        setResizable(false);
        setLayout(null);

        im1 = new Decolib("/Imgs/marcod.png");
        im1.setBounds(-10, -15, 940, 650 );
        add(im1);

        im2 = new Decolib("/Imgs/Stg/triki.png");
        im2.setBounds((int)276.41, 98,390, 343 );
        add(im2);

        im3 = new Decolib("/Imgs/Stg/xo.png");
        im3.setBounds(710, 88, 168,167);
        add(im3);

        //Crear un contenedos para guardar los datos de partida (PUNTOS)
        jppuntos = new JPanel();
        jppuntos.setSize(490, 111);
        jppuntos.setBounds(233, 447, 490,111);
        jppuntos.setLayout(null);
        jppuntos.setBackground(new Color(42, 47, 79));
        add(jppuntos);

        im4 = new Decolib("/Imgs/Stg/score.png");
        im4.setBounds(0, 0, 490,111);
        jppuntos.add(im4);

        lblpointp1 = new JLabel("test",SwingConstants.CENTER);
        lblpointp1.setBounds(131,37, 84, 42);
        lblpointp1.setOpaque(false);
        lblpointp1.setForeground(new Color(229, 190, 236));
        lblpointp1.setFont(new Font("arial", Font.ROMAN_BASELINE, 30));
        jppuntos.add(lblpointp1);

        lblpointp2 = new JLabel("test",SwingConstants.CENTER);
        lblpointp2.setBounds(360,37, 84, 42);
        lblpointp2.setOpaque(false);
        lblpointp2.setForeground(new Color(229, 190, 236));
        lblpointp2.setFont(new Font("arial", Font.ROMAN_BASELINE, 30));
        jppuntos.add(lblpointp2);

    }

}
