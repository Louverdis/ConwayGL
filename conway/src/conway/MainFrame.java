package conway;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

import java.util.concurrent.TimeUnit;

/**
 * Creado por luismario
 * Fecha: 9/10/15.
 */
public class MainFrame implements Runnable {
    private Universo universo;
    private GridFrame frame;

    public MainFrame() {
        universo = new Universo();
        frame = new GridFrame(universo);
    }

    @Override
    public void run() {
        //Ciclo de reloj objetivo: ~60 hz
        frame.repaint();
        universo.generacion();

    }

    public static void main(String[] args) {
        MainFrame main = new MainFrame();

        ScheduledExecutorService ses = Executors.newSingleThreadScheduledExecutor();
        ses.scheduleAtFixedRate(main, 0, 500, TimeUnit.MILLISECONDS);
    }
}
