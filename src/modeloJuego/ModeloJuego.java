/**
 * Archivo: ModeloJuego.java
 * @author Manuel Felipe Cardoso Forero (2027288)
 * @author Juan David Rodriguez Rubio (2025435)
 * Fecha de creación: 07/05/2023
 */

package modeloJuego;

import javax.swing.*;

public class ModeloJuego {

    private String turno;
    private boolean end;
    private boolean draw;
    private JLabel cuadroj1;
    private JLabel cuadroj2;
    private String[][] tablero;
    private int cantidadTurnos;

    public ModeloJuego(){
        turno = "X";
        end = false;
        draw = false;
        tablero = new String[3][3];
        cantidadTurnos = 0;
    }

    public void marcarCasilla(int i, int j, JLabel[][] casillas){
        if(!end){
            if(tablero[i][j] == null){
                tablero[i][j] = turno;
                casillas[i][j].setText(turno);
                verificarEstado();
                if(!end){
                    if(turno.equals("X")){
                        turno = "O";
                    } else{
                        turno = "X";
                    }
                }
            }
        }
    }

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
    }

    public void setJugadores(JLabel j1, JLabel j2){

    }
}
