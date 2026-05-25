/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package examenra6_b;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 *
 * @author turita
 */
public class Ejercicio7 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        List<Vuelo> vuelos = new ArrayList<>();
        vuelos.add(new Vuelo("Iberia", 980.5, 420));
        vuelos.add(new Vuelo("Qatar", 2555.25, 640));
        vuelos.add(new Vuelo("Iberia", 25.55,75));
        vuelos.add(new Vuelo("Volotea",25.55,65));
        
        Collections.sort(vuelos, new Comparator<Vuelo>(){
           @Override
           public int compare(Vuelo vuelo1, Vuelo vuelo2){
               return Integer.compare(vuelo1.getDuracionMinutos(), vuelo2.getDuracionMinutos());
           } 
        });
        for (Vuelo vuelo : vuelos){
            vuelo.mostrarInfo();
        }
    }
    
}
