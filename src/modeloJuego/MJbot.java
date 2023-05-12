/**
 * Archivo: MJbot.java
 * @author Manuel Felipe Cardoso Forero (2027288)
 * @author Juan David Rodriguez Rubio (2025435)
 * Fecha de creación: 10/05/2023
 */

 package modeloJuego;

 import java.util.Random;

import javax.swing.*;
 import vistaVentanas.VentanaJuegoBot;
 import vistaVentanas.VentanaModoJuego;

 public class MJbot {
    private String turno;
    private boolean end;
    private boolean draw;
    private JLabel cuadrojbot1, cuadrojbot2, cuadrojbot3;
    private String[][] tablero;
    private int cantidadTurnos;
    private int victoriasJ1;
    private int victoriasbot;
    private int rondascounter;
    private Random random;


    public MJbot(){
        turno = "X";
        end = false;
        draw = false;
        tablero = new String[3][3];
        cantidadTurnos = 0;
        victoriasJ1 = 0;
        victoriasbot = 0;
        random = new Random();
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
                        int[] casillaMaquina = seleccionarCasillaMaquina();
                        marcarCasilla(casillaMaquina[0], casillaMaquina[1], casillas);
                    } else{
                        turno = "X";
                    }
                } else{
                    terminarJuego(casillas);
                    
                }
            }
        }
    };

    private int[] seleccionarCasillaMaquina(){
        // Método para que la máquina seleccione una casilla aleatoria en el tablero
        int i = random.nextInt(3);
        int j = random.nextInt(3);
        while(tablero[i][j] != null){
            i = random.nextInt(3);
            j = random.nextInt(3);
        }
        return new int[]{i, j};
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
                cuadrojbot1.setText(String.valueOf(victoriasJ1));
                cuadrojbot3.setText(String.valueOf(rondascounter));
                JOptionPane.showMessageDialog(null, "¡Ha ganado el Jugador 1");
            } else {
                victoriasbot++;
                rondascounter++;
                cuadrojbot2.setText(String.valueOf(victoriasbot));
                cuadrojbot3.setText(String.valueOf(rondascounter));
                JOptionPane.showMessageDialog(null, "¡Ha ganado la maquina");
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

    public void setEstadisticasPartida(JLabel jb1, JLabel jb2, JLabel jb3){
        cuadrojbot1 = jb1;
        cuadrojbot2 = jb2;
        cuadrojbot3 = jb3;
    }

    public int getvictoriasJ1(){
        return victoriasJ1;
    }

    public int getvictoriasbot(){
        return victoriasbot;
    }

    public int getrondascounter(){
        return rondascounter;
    }
 }

