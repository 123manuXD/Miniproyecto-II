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

public class VentanaInicio extends JFrame implements ActionListener {

    //Imagenes del juego (5)
    private Decolib im1, im2, im3, im4, im5, im6;
    //boton de jugar
    private JButton btninicarJuego;
    //panel
    JPanel jpcontenidogoblal;

    public VentanaInicio(){
        iniciarComponentes();
        getContentPane().setBackground((new Color(42, 47, 79)));
        
    }

    private void iniciarComponentes() {
        //Configuracion del Jframe
        setTitle("TIK TAK TOE (INCIO)");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(950, 660);
        setLocationRelativeTo(null);
        setVisible(true);
        setResizable(false);
        setLayout(null);

        //configuracion de los componentes dentro del panel
        im1 = new Decolib("/Imgs/marcod.png");
        im1.setBounds(-10, -15, 950, 660 );
        add(im1);

        im2 = new Decolib("/Imgs/St/tik.png");
        im2.setBounds((int)118.78, (int)144.28, 222, 120);
        add(im2);

        im3 = new Decolib("/Imgs/St/tac.png");
        im3.setBounds((int) 207.5, (int) 261.5, 223, 117);
        add(im3);
        
        im4 = new Decolib("/Imgs/St/toe.png");
        im4.setBounds((int) 297.5, (int) 390.5, 234, 117);
        add(im4);

        im5 = new Decolib("/Imgs/St/xo.png");
        im5.setBounds((int) 672.75, (int) 97.88, 172, 170);
        add(im5);

        btninicarJuego = new JButton();
        btninicarJuego.setBounds(563, 283, 283, 153);
        btninicarJuego.setOpaque(true);
        btninicarJuego.setContentAreaFilled(false);
        btninicarJuego.setBorderPainted(false);
        add(btninicarJuego);

        //añadirle imagen al boton
        im6 = new Decolib("/Imgs/St/btplay.png");
        im6.setBounds(564,283, 283, 153);
        add(im6);
        
        btninicarJuego.addActionListener(this);

    }

    @Override
    public void actionPerformed(ActionEvent evento) {
        // TODO Auto-generated method stub
       if (evento.getSource() == btninicarJuego); {
        dispose();
        VentanaModoJuego ventana = new VentanaModoJuego();
       }
    }



}
