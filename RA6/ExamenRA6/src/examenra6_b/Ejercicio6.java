/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package examenra6_b;

import java.util.Arrays;
import java.util.List;

/**
 *
 * @author turita
 */
public class Ejercicio6 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        List<Integer> numeros = Arrays.asList(12, 15, 18, 20, 7);

        int sumaTotal = numeros.stream()
            .filter(n -> {
                int suma = 0;

                for (int i = 1; i <= n / 2; i++) {
                    if (n % i == 0) {
                        suma += i;
                    }
                }

                return suma > n;
            })
            .mapToInt(Integer::intValue)
            .sum();

        System.out.println("Suma de abundantes: " + sumaTotal);
    }
    
}
