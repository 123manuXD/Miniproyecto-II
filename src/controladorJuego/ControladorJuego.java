/**
 * Archivo: controlador.java
 * @author Manuel Felipe Cardoso Forero (2027288)
 * @author Juan David Rodriguez Rubio (2025435)
 * Fecha de creación: 07/05/2023
 */

package controladorJuego;

import javax.swing.*;
import javax.swing.event.*;
import java.awt.event.*;
import java.security.Key;

import modeloJuego.ModeloJuego;
import vistaVentanas.VentanaJuego;
import vistaVentanas.VentanaModoJuego;

public class ControladorJuego implements KeyListener {
    private VentanaJuego view;
    private ModeloJuego model;
    private JLabel[][] casillas;
    private int currentRow;
    private int currentCol;
    private boolean mensajeMostrado = false;
    
    public ControladorJuego(VentanaJuego view, ModeloJuego model){
        this.view = view;
        this.model =model;
        casillas =  view.getCasillas();
        addListeners();
        crearJugadores();
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
            model.marcarCasilla(currentRow, currentCol, casillas);
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
                model.marcarCasilla(i,j, casillas);
                terminarJuego();
            }
        });
    }

    private void crearJugadores() {
        JLabel j1 = view.getVictoriasJ1();
        JLabel j2 = view.getVictoriasJ2();
        JLabel j3 = view.getRondaspartida();
        model.setEstadisticasPartida(j1,j2, j3);
    }

    private void terminarJuego(){
       if (model.getrondascounter() == view.getnumeroRondas()){
        verificarvictoria();
       } else if (model.getrondascounter() > view.getnumeroRondas()){
        verificarvictoria();
       }
    }

    private void verificarvictoria(){
        if (model.getvictoriasJ1() > model.getvictoriasJ2()){
            terminarjuegowp1();
        } else if (model.getvictoriasJ2() > model.getvictoriasJ1()){
            terminarjuegowp2();
        } else if (model.getvictoriasJ1() == model.getvictoriasJ2()){
            terminarJuegoempate();
        }
    }

    public void terminarjuegowp1(){
        String mensaje = "<html><body><center><font size='5'> FELICIDADES USTED ES EL GANDOR </font></center></body></html>";
        String ganador = "<html><body><center><font size='5'>" +view.getnomp1()+ "</font></center></body></html>";
        String mensajeP1 = "<html><body><font size='5'>Puntos del jugador 1: " + model.getvictoriasJ1()+ "</font></body></html>";
        String mensajeP2 = "<html><body><font size='5'>Puntos del jugador 2: " + model.getvictoriasJ2()+ "</font></body></html>";
        JOptionPane.showMessageDialog(null,mensaje + "\n" + ganador +"\n" + mensajeP1 + "\n" + mensajeP2);
        System.exit(0);
    }

    public void terminarjuegowp2(){
        String mensaje = "<html><body><center><font size='5'> FELICIDADES USTED ES EL GANDOR </font></center></body></html>";
        String ganador = "<html><body><center><font size='5'>" +view.getnomp2()+"</font></center></body></html>";
        String mensajeP1 = "<html><body><font size='5'>Puntos del jugador 1: " + model.getvictoriasJ1()+ "</font></body></html>";
        String mensajeP2 = "<html><body><font size='5'>Puntos del jugador 2: " + model.getvictoriasJ2()+"</font></body></html>";
        JOptionPane.showMessageDialog(null,mensaje + "\n" + ganador +"\n" + mensajeP1 + "\n" + mensajeP2);
        System.exit(0);
    }


    public void terminarJuegoempate(){
        if(!mensajeMostrado){
            String mensaje = "<html><body><center><font size='5'> EMPATE TIENEN UNA RONDA MÁS </font></center></body></html>";
            JOptionPane.showMessageDialog(null, mensaje);
            mensajeMostrado = true;
        }
    }

    public void keyReleased(KeyEvent e) {
    }
    
    public void keyTyped(KeyEvent e) {
    }

}
