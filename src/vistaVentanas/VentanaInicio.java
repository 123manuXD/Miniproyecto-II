/**
 * Archivo: VentanaInicio.java
 * @author Manuel Felipe Cardoso Forero (2027288)
 * @author Juan David Rodriguez Rubio (2025435)
 * Fecha de creación: 06/05/2023
 */

package vistaVentanas;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class VentanaInicio extends JFrame implements ActionListener {

    private JTextField txtplayer1, txtplayer2;
    //Imagenes del juego (5)
    private Decolib im1, im2, im3, im4, im5, im6, im7;
    //boton de jugar
    private JButton btninicarJuego;
    //panel
    JPanel jpcontenidogoblal;

    private String nombrep1, nombrep2;

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
        im2.setBounds((int)108.78, (int)95.28, 222, 120);
        add(im2);

        im3 = new Decolib("/Imgs/St/tac.png");
        im3.setBounds((int) 77.5, (int) 271.5, 223, 117);
        add(im3);
        
        im4 = new Decolib("/Imgs/St/toe.png");
        im4.setBounds((int) 165.5, (int) 435.5, 234, 117);
        add(im4);

        im5 = new Decolib("/Imgs/St/xo.png");
        im5.setBounds((int) 702.75, (int) 72.88, 172, 170);
        add(im5);

        btninicarJuego = new JButton();
        btninicarJuego.setBounds((int)490.91, (int) 406.78, 214, 116);
        btninicarJuego.setOpaque(true);
        btninicarJuego.setContentAreaFilled(false);
        btninicarJuego.setBorderPainted(false);
        add(btninicarJuego);

        //añadirle imagen al boton
        im6 = new Decolib("/Imgs/St/btplay.png");
        im6.setBounds((int)490.91, (int)406.78, 214, 116);
        add(im6);

        im7 = new Decolib("/Imgs/St/players.png");
        im7.setBounds((int)344.13, 270, 517, 117 );
        add(im7);

        txtplayer1 = new JTextField("Player 1");
        txtplayer1.setHorizontalAlignment(SwingConstants.CENTER);
        txtplayer1.setBounds(376,301,204,59);
        txtplayer1.setForeground(Color.white);
        txtplayer1.setFont(new Font("arial", Font.ROMAN_BASELINE, 30));
        txtplayer1.setOpaque(false);
        txtplayer1.setBorder(BorderFactory.createEmptyBorder());
        add(txtplayer1);

        txtplayer2 = new JTextField("Player 2");
        txtplayer2.setHorizontalAlignment(SwingConstants.CENTER);
        txtplayer2.setBounds(620,301,204,59);
        txtplayer2.setForeground(Color.white);
        txtplayer2.setFont(new Font("arial", Font.ROMAN_BASELINE, 30));
        txtplayer2.setOpaque(false);
        txtplayer2.setBorder(BorderFactory.createEmptyBorder());
        add(txtplayer2);
        
        
        btninicarJuego.addActionListener(this);


        txtplayer1.addFocusListener(new FocusListener() {
            public void focusGained(FocusEvent e) {
                txtplayer1.setText("");
            }
        
            @Override
            public void focusLost(FocusEvent e) {
                //no hacer nada aqui
            }
        });

        txtplayer2.addFocusListener(new FocusListener() {
            public void focusGained(FocusEvent e) {
                txtplayer2.setText("");
            }
        
            @Override
            public void focusLost(FocusEvent e) {
                //no hacer nada aqui
            }
        });

    }


    @Override
    public void actionPerformed(ActionEvent evento) {
        // TODO Auto-generated method stub
       if (evento.getSource() == btninicarJuego) {
        textselec();
       }
    }

    private void textselec(){
        nombrep1 = txtplayer1.getText();
        nombrep2 = txtplayer2.getText();
        if(nombrep1.trim().isEmpty() || nombrep1.trim().equals("Player 1") || nombrep2.trim().isEmpty() || nombrep2.trim().equals("Player 2")) {
            JOptionPane.showMessageDialog(null, "PORFAVOR INGRESE SUS NOMBRES PARA INICAR EN CASO DE JUGAR SOLO INGRESE BOT EN SEGUNDO JUGADOR", "Advertencia", JOptionPane.ERROR_MESSAGE);
            if(nombrep1.trim().isEmpty() || nombrep1.trim().equals("Player 1")) {
                txtplayer1.requestFocus();
            } else {
                txtplayer2.requestFocus();
            }
        } else {
            dispose();
            VentanaModoJuego ventana = new VentanaModoJuego(nombrep1, nombrep2);
        }
        

    }
        
}
