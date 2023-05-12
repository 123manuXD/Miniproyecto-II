/**
 * Archivo: controladorJuegobot.java
 * @author Manuel Felipe Cardoso Forero (2027288)
 * @author Juan David Rodriguez Rubio (2025435)
 * Fecha de creación: 10/05/2023
 */

 package controladorJuego;

import javax.swing.*;
import javax.swing.event.*;
import java.awt.event.*;

import modeloJuego.MJbot;
import vistaVentanas.VentanaJuegoBot;

public class controlerJuegobot implements KeyListener{
    private VentanaJuegoBot viewbot;
    private MJbot modelbot;
    private JLabel[][]casillas;
    private int currentRow;
    private int currentCol;

    public controlerJuegobot(VentanaJuegoBot viewBot, MJbot modelbot){
        this.viewbot = viewBot;
        this.modelbot = modelbot;
        casillas = viewBot.getCasillas();
        addListeners();
        crearEstacs();
        currentRow = 0;
        currentCol = 0;
        casillas[0][0].requestFocus();

    }

    private void addListeners() {
        for(int i=0; i<3; i++){
            for(int j=0; j<3; j++){
                addMouseEvent(i,j);
                casillas[i][j].addKeyListener(this);
            }
        }
    }

    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();
        JLabel currentCasilla = casillas[currentRow][currentCol];

        if (key == KeyEvent.VK_ENTER) {
            modelbot.marcarCasilla(currentRow, currentCol, casillas);
        } else if (key == KeyEvent.VK_LEFT && currentCol > 0) {
            currentCol--;
        } else if (key == KeyEvent.VK_RIGHT && currentCol < 2) {
            currentCol++;
        } else if (key == KeyEvent.VK_UP && currentRow > 0) {
            currentRow--;
        } else if (key == KeyEvent.VK_DOWN && currentRow < 2) {
            currentRow++;
        }
        currentCasilla = casillas[currentRow][currentCol];
        currentCasilla.requestFocus();

    }

    private void addMouseEvent(int i, int j) {
        JLabel casillaActual = casillas[i][j];

        casillaActual.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e){
                modelbot.marcarCasilla(i,j, casillas);
                terminarJuego();
            }
        });
    }

    private void crearEstacs() {
        JLabel jb1 = viewbot.getVictoriasJ1();
        JLabel jb2 = viewbot.getvictoriasbot();
        JLabel jb3 = viewbot.getRondaspartida();
        modelbot.setEstadisticasPartida(jb1,jb2, jb3);
    }

    private void terminarJuego(){
        if (modelbot.getrondascounter() == viewbot.getnumeroRondas()){
         verificarvictoria();
        } 
     }
 
    private void verificarvictoria(){
        if (modelbot.getvictoriasJ1() > modelbot.getvictoriasbot()){
            terminarjuegowp1();
        } else if (modelbot.getvictoriasbot() > modelbot.getvictoriasJ1()){
            terminarjuegowmaquina();
        }
    }

    public void terminarjuegowp1(){
        String mensaje = "<html><body><center><font size='5'> !VENCISTE A LA MAQUINA FELICIDADES! :D </font></center></body></html>";
        String mensajeP1 = "<html><body><font size='5'>Tus puntos: " + modelbot.getvictoriasJ1()+ "</font></body></html>";
        String mensajeP2 = "<html><body><font size='5'>Puntos del la maquina: " + modelbot.getvictoriasbot()+"</font></body></html>";
        JOptionPane.showMessageDialog(null,mensaje + "\n" + mensajeP1 + "\n" + mensajeP2);
    }

    public void terminarjuegowmaquina(){
        String mensaje = "<html><body><center><font size='5'> UFFF! LA MAQUINA VENCIO, VUELVE CUANDO SEAS MÁS FUERTE </font></center></body></html>";
        String mensajeP1 = "<html><body><font size='5'>Tus puntos: " + modelbot.getvictoriasJ1()+ "</font></body></html>";
        String mensajeP2 = "<html><body><font size='5'>Puntos del la maquina: " + modelbot.getvictoriasbot()+"</font></body></html>";
        JOptionPane.showMessageDialog(null,mensaje + "\n" + mensajeP1 + "\n" + mensajeP2);
    }


    public void keyReleased(KeyEvent e) {
    }
    
    public void keyTyped(KeyEvent e) {
    }

}
