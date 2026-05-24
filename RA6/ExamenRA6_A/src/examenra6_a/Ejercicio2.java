/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package examenra6_a;

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
    public static void camionPesado(Map<Integer, Camion> flota) {
        double sumaCamion = 0;
        double maxSuma = 0;
        int idActual = 0;
        for (Map.Entry<Integer, Camion> entrada : flota.entrySet()) {
            sumaCamion = 0;
            for (var pesos : entrada.getValue().getLista()) {
                sumaCamion += pesos;
            }
            if (maxSuma < sumaCamion) {
                maxSuma = sumaCamion;
                idActual = entrada.getKey();
            }
        }
        System.out.println("El camión más pesado es: " + idActual);
    }

    public static void paqueteMasPesado(Map<Integer, Camion> flota) {
        double maxPaquete = 0;
        int idActual = 0;
        for (Map.Entry<Integer, Camion> entrada : flota.entrySet()) {
            for (var pesos : entrada.getValue().getLista()) {
                if (maxPaquete < pesos) {
                    maxPaquete = pesos;
                    idActual = entrada.getKey();
                }
            }
        }
        System.out.println("El paquete más pesado es de : " + maxPaquete + " del camión " + idActual);
    }

    public static void main(String[] args) {
        // TODO code application logic here
        Map<Integer, Camion> flota = new HashMap<>();
        Camion camion1 = new Camion(1, List.of(20.5, 10.0, 50.0));
        flota.put(camion1.getId(), camion1);
        Camion camion2 = new Camion(2, List.of(100.0, 5.5));
        flota.put(camion2.getId(), camion2);
        Camion camion3 = new Camion(3, List.of(15.0, 15.0, 15.0, 15.0));
        flota.put(camion3.getId(), camion3);

        camionPesado(flota);
        paqueteMasPesado(flota);

    }

}
