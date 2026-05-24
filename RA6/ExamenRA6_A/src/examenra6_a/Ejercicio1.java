/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package examenra6_a;

import java.util.Random;

/**
 *
 * @author turita
 */
public class Ejercicio1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        int [][] radar = new int[8][8];
        Random random = new Random();
        int objetosDetectados = 0;
        for (int i = 0; i < radar.length; i++) {
            for (int j = 0; j < radar[0].length; j++) {
                radar[i][j] = random.nextInt(2);
                System.out.print(radar[i][j] + " ");
                if (radar[i][j]==1){
                   objetosDetectados += 1;
                }
            }
            System.out.println("");
        }
        
        System.out.println("Objetos detectados: " + objetosDetectados);
    }
    
}
