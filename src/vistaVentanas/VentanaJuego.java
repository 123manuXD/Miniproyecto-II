/**
 * Archivo: VentanaJuego.java
 * @author Manuel Felipe Cardoso Forero (2027288)
 * @author Juan David Rodriguez Rubio (2025435)
 * Fecha de creación: 06/05/2023
 */

 package vistaVentanas;
 import java.awt.*;
 import java.awt.event.*;
 import javax.swing.*;


public class VentanaJuego extends JFrame {

    private Decolib im1, im2, im3, im4, im5;
    private JPanel jppuntos;
    private JLabel lblpointp1, lblpointp2, csll1, csll2, csll3, csll4, csll5, csll6, csll7, csll8, csll9;
    private JLabel[][] casillas;

    public VentanaJuego(){
        casillas = new JLabel[3][3];
        iniciarComponentes();
        asignarCasillas();
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

        //Crear un contenedor para guardar los datos de partida (PUNTOS)
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

        //Añadir los Label que se conectaran a la matriz
        csll1 = new JLabel("1",SwingConstants.CENTER);
        csll1.setBounds(338,140, 62,63);
        csll1.setOpaque(false);
        add(csll1);

        csll2 = new JLabel("2",SwingConstants.CENTER);
        csll2.setBounds(443,140, 62,63);
        csll2.setOpaque(false);
        add(csll2);

        csll3 = new JLabel("3",SwingConstants.CENTER);
        csll3.setBounds(547,140, 62,63);
        csll3.setOpaque(false);
        add(csll3);

        csll4 = new JLabel("4",SwingConstants.CENTER);
        csll4.setBounds(338,241, 62,63);
        csll4.setOpaque(false);
        add(csll4);

        csll5 = new JLabel("5",SwingConstants.CENTER);
        csll5.setBounds(443,241, 62,63);
        csll5.setOpaque(false);
        add(csll5);

        csll6 = new JLabel("6",SwingConstants.CENTER);
        csll6.setBounds(547,241, 62,63);
        csll6.setOpaque(false);
        add(csll6);

        csll7 = new JLabel("7",SwingConstants.CENTER);
        csll7.setBounds(338,342, 62,63);
        csll7.setOpaque(false);
        add(csll7);

        csll8 = new JLabel("8",SwingConstants.CENTER);
        csll8.setBounds(443,342, 62,63);
        csll8.setOpaque(false);
        add(csll8);

        csll9 = new JLabel("9",SwingConstants.CENTER);
        csll9.setBounds(547,342, 62,63);
        csll9.setOpaque(false);
        add(csll9);

    }

    private void asignarCasillas(){
        casillas[0][0] = csll1;
        casillas[0][1] = csll2;
        casillas[0][2] = csll3;
        casillas[1][0] = csll4;
        casillas[1][1] = csll5;
        casillas[1][2] = csll6;
        casillas[2][0] = csll7;
        casillas[2][1] = csll8;
        casillas[2][2] = csll9;
    }

    public JLabel[][] getCasillas(){
        return casillas;
    }
    public JLabel getVictoriasJ1(){
        return lblpointp1;
    }
    public JLabel getVictoriasJ2(){
        return lblpointp2;
    }

}
