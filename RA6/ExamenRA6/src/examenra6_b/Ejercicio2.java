/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package examenra6_b;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author turita
 */
public class Ejercicio2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        List<Estudiante> estudiantes = new ArrayList<>();
        Map<String,List<Estudiante>> calificaciones = new HashMap<>();
        
        estudiantes.add(new Estudiante("Ana", 9.5));
        estudiantes.add(new Estudiante("Luis", 4.2));
        estudiantes.add(new Estudiante("Pedro", 7.8));
        estudiantes.add(new Estudiante("Marta", 5.5));
        estudiantes.add(new Estudiante("Juan", 8.1));
    
        for (Estudiante estudiante : estudiantes){
            if (estudiante.getNota()>= 0 && estudiante.getNota()<5){
                calificaciones.computeIfAbsent("Suspenso", n -> new ArrayList<>()).add(estudiante);
            } else if (estudiante.getNota()>=5 && estudiante.getNota()<7){
                calificaciones.computeIfAbsent("Aprobado", n -> new ArrayList<>()).add(estudiante);
            } else if (estudiante.getNota()>=7 && estudiante.getNota()<9){
                calificaciones.computeIfAbsent("Notable", n -> new ArrayList<>()).add(estudiante);
            } else if (estudiante.getNota()>=9 && estudiante.getNota()<=10){
                calificaciones.computeIfAbsent("Sobresaliente", n -> new ArrayList<>()).add(estudiante);
            } else {
                System.out.println("Nota inválida");
            }
        }
        
        for (Map.Entry<String,List<Estudiante>> entrada : calificaciones.entrySet()){
            System.out.println("\n" + entrada.getKey());
            entrada.getValue().forEach(n -> n.mostrarInfo());
        }
    }
    
}
