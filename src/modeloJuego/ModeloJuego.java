/**
 * Archivo: ModeloJuego.java
 * @author Manuel Felipe Cardoso Forero (2027288)
 * @author Juan David Rodriguez Rubio (2025435)
 * Fecha de creación: 07/05/2023
 */

package modeloJuego;

import javax.swing.*;

public class ModeloJuego {
    public void marcarCasilla(int i, int j, JLabel[][] casillas){
        casillas[i][j].setText("X");
    }
}
