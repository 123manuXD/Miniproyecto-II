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


import modeloJuego.ModeloJuego;
import vistaVentanas.VentanaJuego;

public class ControladorJuego {
    private VentanaJuego view;
    private ModeloJuego model;
    private JLabel[][] casillas;
    
    public ControladorJuego(VentanaJuego view, ModeloJuego model){
        this.view = view;
        this.model =model;
        casillas =  view.getCasillas();
        addListeners();
        crearJugadores();
    }
   
    private void addListeners() {
        for(int i=0; i<3; i++){
            for(int j=0; j<3; j++){
                addMouseEvent(i,j);
            }
        }
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

}
