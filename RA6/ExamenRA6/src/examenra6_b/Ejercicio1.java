/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package examenra6_b;

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
        
        int [][] miArray = new int[5][10];
        Random random = new Random();
        
        int suma = 0;
        int maxSuma = 0;
        int indice = 0;
        for (int i = 0; i < miArray.length; i++) {
            suma = 0;
            for (int j = 0; j < miArray[0].length; j++) {
                miArray[i][j] = random.nextInt(1,10);
                System.out.print(miArray[i][j] +" ");
                suma += miArray[i][j];
            }
            if (maxSuma<suma){
                maxSuma = suma;
                indice = i;
            }
            System.out.println("");
        }
        
        System.out.println("--- RESULTADO ---");
        System.out.println("El pasillo más concurrido es el índice: " + indice);
        System.out.println("Total de accesos en ese pasillo es: " + maxSuma);
    }
    
}
