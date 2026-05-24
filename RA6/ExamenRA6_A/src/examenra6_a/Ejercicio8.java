/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package examenra6_a;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
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
        List<Jugador> jugadores = new ArrayList<>();
        jugadores.add(new Jugador("Ana", 1500, 10));
        jugadores.add(new Jugador("Luis", 1500, 8));
        jugadores.add(new Jugador("Carlos", 1200, 7));
        
        Collections.sort(jugadores, new Comparator<Jugador>() {
            @Override
            public int compare(Jugador jugador1, Jugador jugador2){
                return Integer.compare(jugador2.getNivel(), jugador1.getNivel());
            }
        });
        
        for (Jugador jugador : jugadores){
            jugador.mostrarInformacion();
        }
    }
    
}
