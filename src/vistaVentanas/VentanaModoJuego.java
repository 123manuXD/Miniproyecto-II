/**
 * Archivo: VentanaModoJuego.java
 * @author Manuel Felipe Cardoso Forero (2027288)
 * @author Juan David Rodriguez Rubio (2025435)
 * Fecha de creación: 06/05/2023
 */

package vistaVentanas;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import controladorJuego.ControladorJuego;
import modeloJuego.ModeloJuego;

public class VentanaModoJuego extends JFrame implements ActionListener {
    private Decolib im1, im2, im3, im4, im5, im6, im7, im8, im9, im10;
    private JButton btnr1, btnr2, btnr3, btnr4;
    private JToggleButton btn1vs1, btn1vscop;
    private int rondaselecc = -1;

    public VentanaModoJuego(){
        iniciarComponentes();
        getContentPane().setBackground((new Color(42, 47, 79)));
        
    }

    private void iniciarComponentes() {
        //Configuracion del Jframe
        setTitle("TIK TAK TOE (Seleccion de modo)");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(950, 660);
        setLocationRelativeTo(null);
        setVisible(true);
        setResizable(false);
        setLayout(null);

        //configuracion de los componentes dentro del panel
        im1 = new Decolib("/Imgs/marcod.png");
        im1.setBounds(-10, -15, 940, 650 );
        add(im1);

        im2 = new Decolib("/Imgs/Stm/ic.png");
        im2.setBounds((int)68.56 ,(int)171.53, 348, 317);
        add(im2);

        btn1vs1 = new JToggleButton();
        btn1vs1.setBounds(460, 144, 189, 174);
        btn1vs1.setOpaque(true);
        btn1vs1.setContentAreaFilled(false);
        //btn1vs1.setBorderPainted(false);
        add(btn1vs1);

        btn1vscop = new JToggleButton();
        btn1vscop.setBounds(649, 144, 189, 174);
        btn1vscop.setOpaque(true);
        btn1vscop.setContentAreaFilled(false);
        //btnvscop.setBorderPainted(false);
        add(btn1vscop);

        btnr1 = new JButton();
        btnr1.setBounds(429,  340, 105, 105);
        btnr1.setOpaque(true);
        btnr1.setContentAreaFilled(false);
        //btnr1.setBorderPainted(false);
        add(btnr1);

        btnr2 = new JButton();
        btnr2.setBounds(538, 340,105, 105);
        btnr2.setOpaque(true);
        btnr2.setContentAreaFilled(false);
        //btnr2.setBorderPainted(false);
        add(btnr2);

        btnr3 = new JButton();
        btnr3.setBounds(653, 340,105, 105);
        btnr3.setOpaque(true);
        btnr3.setContentAreaFilled(false);
        //btnr3.setBorderPainted(false);
        add(btnr3);

        btnr4 = new JButton();
        btnr4.setBounds(763, 340,105, 105);
        btnr4.setOpaque(true);
        btnr4.setContentAreaFilled(false);
        //btnr4.setBorderPainted(false);
        add(btnr4);

        im3 =  new Decolib("/Imgs/Stm/im4.png");
        im3.setBounds(460, 144, 189, 174);
        add(im3);

        im4 =  new Decolib("/Imgs/Stm/im3.png");
        im4.setBounds(649, 144, 189, 174);
        add(im4);

        im5 =  new Decolib("/Imgs/Stm/im5.png");
        im5.setBounds(429,  340, 105, 105);
        add(im5);

        im6 =  new Decolib("/Imgs/Stm/im6.png");
        im6.setBounds(538, 340,105, 105);
        add(im6);

        im7 =  new Decolib("/Imgs/Stm/im7.png");
        im7.setBounds(653, 340,105, 105);
        add(im7);

        im8 =  new Decolib("/Imgs/Stm/im8.png");
        im8.setBounds(763, 340,105, 105);
        add(im8);

        im9 = new Decolib("/Imgs/Stm/im9.png");
        im9.setBounds(548,454, 205, 66);
        add(im9);
        

        btnr1.addActionListener(this);
        btnr2.addActionListener(this);
        btnr3.addActionListener(this);
        btnr4.addActionListener(this);
        btn1vs1.addActionListener(this);
        btn1vscop.addActionListener(this);
        

    }

    @Override
    public void actionPerformed(ActionEvent evento) {
        // Tomar como condicion precionar el boton de 1vs1 o 1vscop para seleccionar el número de rondas
        if(evento.getSource() == btn1vs1) {
            btn1vscop.setSelected(false);
        }
        else if (evento.getSource() == btn1vscop){
            btn1vs1.setSelected(false);
        }
        //Condicones para los botones de ronda 1
        if(evento.getSource()== btnr1){
            rondaselecc = 1;
            if(btn1vs1.isSelected()){
                Juego1vs1();
            }else if(btn1vscop.isSelected()){
                juego1vscop();
            } else {
                mensajesincategoria();
            }
        } 

        //Condicones para los botones de ronda 2
        if(evento.getSource()== btnr2){
            rondaselecc = 2;
            if(btn1vs1.isSelected()){
                Juego1vs1();
            }else if(btn1vscop.isSelected()){
                juego1vscop();
            } else {
                mensajesincategoria();
            }
        } 

        //Condicones para los botones de ronda 3
        if(evento.getSource()== btnr3){
            rondaselecc = 3;
            if(btn1vs1.isSelected()){
                Juego1vs1();
            }else if(btn1vscop.isSelected()){
                juego1vscop();
            } else {
                mensajesincategoria();
            }
        } 
        
        //Condicones para los botones de ronda 4
        if(evento.getSource()== btnr4){
            rondaselecc = 4;
            if(btn1vs1.isSelected()){
                Juego1vs1();
            }else if(btn1vscop.isSelected()){
                juego1vscop();
            } else {
                mensajesincategoria();
            }
        } 
    }
    

    public void Juego1vs1(){
        //Para traer la ventana juego
        dispose();
        ModeloJuego model = new ModeloJuego();
        VentanaJuego view = new VentanaJuego();
        ControladorJuego controlador = new ControladorJuego(view, model);
    }

    public void juego1vscop(){
        dispose();
        VentanaJuegoBot ventana = new VentanaJuegoBot();
    }

    public void mensajesincategoria(){
        JOptionPane.showMessageDialog(null,"Selecciona las rondas que quieres jugar.", "Parámetro Necesario",JOptionPane.ERROR_MESSAGE);
    }

    public int getnronda (){
        return rondaselecc;
    }
    
} 


