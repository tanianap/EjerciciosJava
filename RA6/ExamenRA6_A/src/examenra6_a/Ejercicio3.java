/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package examenra6_a;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 *
 * @author turita
 */
public class Ejercicio3 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
         List <String> nombres = List.of("Shadow", "Wolf", "Shadow", "Pikachu", "Wolf", "Dragon");
         Set<String> nombresAceptados = new HashSet<>();
         List<String> nombresRechazados = new ArrayList<>();
         
         for (String nombre : nombres){
             if (nombresAceptados.contains(nombre)){
                 nombresRechazados.add(nombre);
             }
             nombresAceptados.add(nombre);
         }
         
         System.out.println("Nombres Aceptados: ");
         for (String nombre : nombresAceptados){
             System.out.println(nombre);
         }
         
         System.out.println("\nNombres Rechazados:");
         for (String nombre : nombresRechazados){
             System.out.println(nombre);
         }
    }
    
}
