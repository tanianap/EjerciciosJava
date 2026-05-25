/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package examenra6_b;

import java.util.List;

/**
 *
 * @author turita
 */
public class Ejercicio8 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        List<Double> transacciones = List.of(12.5, 5.0, 18.2, 7.5, 20.0, 10.0);
        
        double sumaTotal = transacciones.stream().mapToDouble(Double::doubleValue).sum();
        double promedio = transacciones.stream().mapToDouble(Double::doubleValue).average().orElse(0);
        
        System.out.println("La suma total es: " + sumaTotal);
        System.out.printf("El promedio es: %.2f%n ", promedio);
    }
    
}
