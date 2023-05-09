/**
 * Archivo: Main.java
 * @author Manuel Felipe Cardoso Forero (2027288)
 * @author Juan David Rodriguez Rubio (2025435)
 * Fecha de creación: 14/04/2023
 */

package vistaVentanas;
import javax.swing.JFrame;

import controladorJuego.ControladorJuego;
import modeloJuego.ModeloJuego;

public class Main {
    public static void main(String args[]){
        VentanaInicio ventana = new VentanaInicio();
        ModeloJuego model = new ModeloJuego();
        // VentanaJuego view = new VentanaJuego();
        // ControladorJuego controlador = new ControladorJuego(view, model);
    }
}
