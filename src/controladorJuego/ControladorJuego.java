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

public class ControladorJuego implements KeyListener {
    private VentanaJuego view;
    private ModeloJuego model;
    private JLabel[][] casillas;
    private int currentRow;
    private int currentCol;
    
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
            }
        });
    }

    private void crearJugadores() {
        JLabel j1 = view.getVictoriasJ1();
        JLabel j2 = view.getVictoriasJ2();
        JLabel j3 = view.getRondaspartida();
        model.setEstadisticasPartida(j1,j2, j3);
    }

    public void keyReleased(KeyEvent e) {
    }
    
    public void keyTyped(KeyEvent e) {
    }

}
