/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package examenra6_a;

import java.util.List;

/**
 *
 * @author turita
 */
public class Ejercicio7 {

    /**
     * @param args the command line arguments
     */
    public static boolean esPerfecto(int numero){
        if (numero <= 1){
            return false;
        }
        
        int sumaDivisores = 0;
        for (int i = 1; i<= numero/2; i++){
            if (numero % i == 0){
                sumaDivisores += i;
            }
        }
        return sumaDivisores == numero;
    }
    public static void main(String[] args) {
        // TODO code application logic here
        List<Integer> numeros = List.of(6, 10, 28, 12, 496);
        
        int sumaTotal = numeros.stream()
                .filter(n -> esPerfecto(n))
                .mapToInt(Integer::intValue)
                .sum();
        
        System.out.println("Suma de números perfectos: " + sumaTotal);
    }
    
}
