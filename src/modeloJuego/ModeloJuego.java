/**
 * Archivo: ModeloJuego.java
 * @author Manuel Felipe Cardoso Forero (2027288)
 * @author Juan David Rodriguez Rubio (2025435)
 * Fecha de creación: 07/05/2023
 */

package modeloJuego;

import javax.swing.*;
import vistaVentanas.VentanaJuego;
import vistaVentanas.VentanaModoJuego;


public class ModeloJuego {

    private String turno;
    private boolean end;
    private boolean draw;
    private JLabel cuadroj1;
    private JLabel cuadroj2, cuadroj3;
    private String[][] tablero;
    private int cantidadTurnos;
    private int victoriasJ1;
    private int victoriasJ2;
    private int rondascounter;

    public ModeloJuego(){
        turno = "X";
        end = false;
        draw = false;
        tablero = new String[3][3];
        cantidadTurnos = 0;
        victoriasJ1 = 0;
        victoriasJ2 = 0;
        rondascounter = 0;
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
                rondascounter++;
                if(rondascounter == 2){
                    terminarjuegowp1();
                }
                cuadroj1.setText(String.valueOf(victoriasJ1));
                cuadroj3.setText(String.valueOf(rondascounter));
                JOptionPane.showMessageDialog(null, "¡Ha ganado el Jugador 1");
            } else {
                victoriasJ2++;
                rondascounter++;
                if(rondascounter == 2){
                    terminarjuegowp2();
                }
                cuadroj2.setText(String.valueOf(victoriasJ2));
                cuadroj3.setText(String.valueOf(rondascounter));
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

    public void setEstadisticasPartida(JLabel j1, JLabel j2, JLabel j3){
        cuadroj1 = j1;
        cuadroj2 = j2;
        cuadroj3 = j3;
    }

    public void terminarjuegowp1(){
        String mensaje = "<html><body><center><font size='5'> FELICIDADES USTED ES EL GANDOR </font></center></body></html>";
        String ganador = "<html><body><center><font size='5'> " + "jugador 1"+ "</font></center></body></html>";
        String mensajeP1 = "<html><body><font size='5'>Puntos del jugador 1: " + victoriasJ1+ "</font></body></html>";
        String mensajeP2 = "<html><body><font size='5'>Puntos del jugador 2: " + victoriasJ2+"</font></body></html>";
        JOptionPane.showMessageDialog(null,mensaje + "\n" + ganador +"\n" + mensajeP1 + "\n" + mensajeP2);
    }

    public void terminarjuegowp2(){
        String mensaje = "<html><body><center><font size='5'> FELICIDADES USTED ES EL GANDOR </font></center></body></html>";
        String ganador = "<html><body><center><font size='5'> " + "jugador 2"+ "</font></center></body></html>";
        String mensajeP1 = "<html><body><font size='5'>Puntos del jugador 1: " + victoriasJ1+ "</font></body></html>";
        String mensajeP2 = "<html><body><font size='5'>Puntos del jugador 2: " + victoriasJ2+"</font></body></html>";
        JOptionPane.showMessageDialog(null,mensaje + "\n" + ganador +"\n" + mensajeP1 + "\n" + mensajeP2);
    }

}
