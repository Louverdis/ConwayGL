package conway;

/**
 * Creado por luismario
 * Fecha: 9/10/15.
 */

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

public class GridPanel extends JPanel {

    private Universo universo;

    private final int filas = 60;
    private final int columnas = 80;

    public GridPanel(Universo universo){
        this.universo = universo;
    }

    @Override
    public void paint(Graphics g) {
        int pos;
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                pos = (i << universo.SHIFT) | j;
                if(universo.Grid.getOrDefault(pos, false)){
                    g.setColor(Color.BLACK);
                } else {
                    g.setColor(Color.WHITE);
                }
                g.fillRect(i * 10, j * 10, 10, 10);
            }
        }
    }
}
