/**
 * Archivo: ModeloJuego.java
 * @author Manuel Felipe Cardoso Forero (2027288)
 * @author Juan David Rodriguez Rubio (2025435)
 * Fecha de creación: 07/05/2023
 */

package modeloJuego;

import javax.swing.*;
import vistaVentanas.VentanaJuego;

public class ModeloJuego {

    private String turno;
    private boolean end;
    private boolean draw;
    private JLabel cuadroj1;
    private JLabel cuadroj2;
    private String[][] tablero;
    private int cantidadTurnos;
    private int victoriasJ1;
    private int victoriasJ2;

    public ModeloJuego(){
        turno = "X";
        end = false;
        draw = false;
        tablero = new String[3][3];
        cantidadTurnos = 0;
        victoriasJ1 = 0;
        victoriasJ2 = 0;
    }

    public void marcarCasilla(int i, int j, JLabel[][] casillas){
        if(!end){
            if(tablero[i][j] == null){
                tablero[i][j] = turno;
                casillas[i][j].setText(turno);
                cantidadTurnos++;
                verificarEstado();
                if(!end){
                    if(turno.equals("X")){
                        turno = "O";
                    } else{
                        turno = "X";
                    }
                } else{
                    terminarJuego(casillas);
                    
                }
            }
        }
    };

    

    private void verificarEstado() {
        verificarFilas();
        if(!end){
            verificarColumnas();
            if(!end){
                verificarDiagonalP();
                if(!end){
                    verificarDiagonalS();
                    if(!end){
                        if(cantidadTurnos == 9){
                            draw = true;
                            end = true;
                        }
                    }
                    
                }
            }
        }
    };

    private void verificarFilas() {
        for(int i=0; i<3 && !end; i++){
            boolean win = true;
            for(int j=0; j<3 && win; j++){
                if(tablero[i][j] == null || !tablero[i][j].equals(turno)){
                    win = false;
                }
            }
            if(win){
                end = true;
            }
        }
    }

    private void verificarColumnas() {
        for(int j=0; j<3 && !end; j++){
            boolean win = true;
            for(int i=0; i<3 && win; i++){
                if(tablero[i][j] == null || !tablero[i][j].equals(turno)){
                    win = false;
                }
            }
            if(win){
                end = true;
            }
        }
    }

    private void verificarDiagonalP() {
        boolean win = true;
            for(int i=0; i<3 && win; i++){
                if(tablero[i][i] == null || !tablero[i][i].equals(turno)){
                    win = false;
                }
            }
            if(win){
                end = true;
            }
    }

    private void verificarDiagonalS() {

            boolean win = true;
            int j = 2;
            for(int i=0; i<3 && win; i++, j--){
                if(tablero[i][j] == null || !tablero[i][j].equals(turno)){
                    win = false;
                }
            }
            if(win){
                end = true;
            }

    }

    private void terminarJuego(JLabel[][] casillas) {
        if(draw){
            JOptionPane.showMessageDialog(null, "Es un empate");
        } else{
            if(turno.equals("X")){
                victoriasJ1++;
                cuadroj1.setText(String.valueOf(victoriasJ1));
                JOptionPane.showMessageDialog(null, "¡Ha ganado el Jugador 1");
            } else {
                victoriasJ2++;
                cuadroj2.setText(String.valueOf(victoriasJ2));
                JOptionPane.showMessageDialog(null, "¡Ha ganado el Jugador 2");
            }
        }
        turno = "X";
        end = false;
        draw = false;
        cantidadTurnos = 0;
        for (int i = 0; i < 3; i++) {        
            for (int j = 0; j < 3; j++) {
                tablero[i][j] = null;
                casillas[i][j].setText("");
            }
        }
    }

    public void setJugadores(JLabel j1, JLabel j2){
        cuadroj1 = j1;
        cuadroj2 = j2;
    }
}
