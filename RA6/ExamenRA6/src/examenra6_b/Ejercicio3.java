/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package examenra6_b;

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
        List<String> nombres = List.of("Ana", "Luis", "Pedro", "Ana", "Marta", "Luis", "Carlos");
        Set<String> nombresConfirmados = new HashSet<>();
        
        for(String nombre : nombres){
            nombresConfirmados.add(nombre);
        }
        
        System.out.println("Invitados confirmados: " + nombresConfirmados.size());
        for (String nombre : nombresConfirmados){
            System.out.println(nombre);
        }
        
        if (nombresConfirmados.contains("Marta")){
            System.out.println("El invitado Marta está confirmado");
        } else {
            System.out.println("El invitado Marta no está confirmado");
        }
    }
    
}
