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

public class VentanaInicio extends JFrame {

    //Imagenes del juego (5)
    private Decolib im1;
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
        im1 = new Decolib("/Imgs/marco.png");
        im1.setBounds(10, 10, 915, 603 );
        add(im1);
    }



}
