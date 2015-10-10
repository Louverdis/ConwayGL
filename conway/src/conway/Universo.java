package conway;

import java.util.HashMap;

/**
 * Creado por luismario
 * Fecha: 9/10/15.
 */
public class Universo {

    private final int[][] Offsets = {
            {-1, -1}, {-1, 0}, {-1, 1},
            {0,  -1},          {0,  1},
            {1,  -1}, {1,  0}, {1,  1}
    };

    public final int SHIFT = 16;
    public final int MASK = 0xFFFF;

    public HashMap<Integer, Boolean> Grid;
    private HashMap<Integer, Boolean> Buffer;

    public Universo() {
        Grid = new HashMap<>();
        Buffer = new HashMap<>();

        // Llenar grid con patron inicial
        int _pos_1 = (20 << SHIFT) | 1;
        int _pos_2 = (20 << SHIFT) | 2;
        int _pos_3 = (20 << SHIFT) | 3;
        int _pos_4 = (20 << SHIFT) | 4;
        int _pos_5 = (20 << SHIFT) | 5;
        int _pos_6 = (20 << SHIFT) | 6;
        int _pos_7 = (20 << SHIFT) | 7;
        int _pos_8 = (20 << SHIFT) | 8;

        int _pos_9 = (20 << SHIFT) | 10;
        int _pos_10 = (20 << SHIFT) | 11;
        int _pos_11 = (20 << SHIFT) | 12;
        int _pos_12 = (20 << SHIFT) | 13;
        int _pos_13 = (20 << SHIFT) | 15;

        int _pos_14 = (20 << SHIFT) | 27;
        int _pos_15 = (20 << SHIFT) | 28;
        int _pos_16 = (20 << SHIFT) | 29;
        int _pos_17 = (20 << SHIFT) | 30;
        int _pos_18 = (20 << SHIFT) | 31;

        int _pos_19 = (20 << SHIFT) | 33;
        int _pos_20 = (20 << SHIFT) | 34;
        int _pos_21 = (20 << SHIFT) | 35;
        int _pos_22 = (20 << SHIFT) | 36;
        int _pos_23 = (20 << SHIFT) | 37;
        int _pos_24 = (20 << SHIFT) | 38;
        int _pos_25 = (20 << SHIFT) | 39;
        int _pos_26 = (20 << SHIFT) | 40;

        int _pos_27 = (20 << SHIFT) | 19;
        int _pos_28 = (20 << SHIFT) | 20;
        int _pos_29 = (20 << SHIFT) | 21;

        Grid.put(_pos_1, true);
        Grid.put(_pos_2, true);
        Grid.put(_pos_3, true);
        Grid.put(_pos_4, true);
        Grid.put(_pos_5, true);
        Grid.put(_pos_6, true);
        Grid.put(_pos_7, true);
        Grid.put(_pos_8, true);
        Grid.put(_pos_9, true);
        Grid.put(_pos_10, true);
        Grid.put(_pos_11, true);
        Grid.put(_pos_12, true);
        Grid.put(_pos_13, true);
        Grid.put(_pos_14, true);
        Grid.put(_pos_15, true);
        Grid.put(_pos_16, true);
        Grid.put(_pos_17, true);
        Grid.put(_pos_18, true);
        Grid.put(_pos_19, true);
        Grid.put(_pos_20, true);
        Grid.put(_pos_21, true);
        Grid.put(_pos_22, true);
        Grid.put(_pos_23, true);
        Grid.put(_pos_24, true);
        Grid.put(_pos_25, true);
        Grid.put(_pos_26, true);

        Grid.put(_pos_27, true);
        Grid.put(_pos_28, true);
        Grid.put(_pos_29, true);

        Buffer.putAll(Grid);
    }

    public void generacion(){
        Grid.forEach((k, v) -> {
            int vecinos = obtenerVecinos(k);
            if (v) {
                if (!(vecinos == 2 || vecinos == 3)) {
                    // Celula muere
                    Buffer.replace(k, false);
                }
                procesarReproduccion(k);
            } else {
                if (vecinos == 3) {
                    // Nueva celula
                    Buffer.replace(k, true);
                }
            }
        });
        Grid.clear();
        Grid.putAll(Buffer);
    }

    public void procesarReproduccion(int posicion){
        int fila = posicion >> SHIFT;
        int columna = posicion & MASK;

        for (int[] offset: Offsets){
            int pos = ((fila + offset[0]) << SHIFT) | (columna + offset[1]);
            if(!Grid.getOrDefault(pos, false)){
                int vecinos = obtenerVecinos(pos);
                if(vecinos == 3){
                    // Nueva celula
                    Buffer.put(pos, true);
                }
            }
        }
    }

    public int obtenerVecinos(int posicion){
        int fila = posicion >> SHIFT;
        int columna = posicion & MASK;

        int vecinos = 0;
        for (int[] offset: Offsets){
            int pos = ((fila + offset[0]) << SHIFT) | (columna + offset[1]);
            if(Grid.getOrDefault(pos, false)){
                vecinos++;
            }
        }
        return vecinos;
    }

    public void imprimir(int filas, int columnas){
        int pos;
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                pos = (i << SHIFT) | j;
                if(Grid.getOrDefault(pos, false)){
                    System.out.print("# ");
                } else {
                    System.out.print("- ");
                }
            }
            System.out.println();
        }
    }
}
