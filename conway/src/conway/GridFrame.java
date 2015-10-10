package conway;

/**
 * Creado por luismario
 * Fecha: 9/10/15.
 */

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JFrame;

public class GridFrame extends JFrame {

    public GridFrame(Universo u) {
        setPreferredSize(new Dimension(800, 600));
        pack();

        setPreferredSize(
                new Dimension(
                        400 + getInsets().left + getInsets().right,
                        600 + getInsets().top + getInsets().bottom
                )
        );

        GridPanel gridPanel = new GridPanel(u);
        setLayout(new BorderLayout());
        add(gridPanel, BorderLayout.CENTER);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("CONWAY");
        pack();

        setVisible(true);
    }

}
