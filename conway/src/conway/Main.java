package conway;

/**
 * Creado por luismario
 * Fecha: 9/10/15.
 */

import java.util.Scanner;

public class Main {

    public static void main(String []Args){
        Scanner scanner = new Scanner(System.in);

        Universo game = new Universo();
        game.imprimir(16, 16);
        System.out.println();

        while(true){
            scanner.next();
            game.generacion();
            game.imprimir(16, 16);
        }

    }
}
