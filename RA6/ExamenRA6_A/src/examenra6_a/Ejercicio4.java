/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package examenra6_a;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/**
 *
 * @author turita
 */
public class Ejercicio4 {

    /**
     * @param args the command line arguments
     */
    public static Map<String, Vehiculo> vehiculos = new HashMap<>();
    public static void registrarVehiculo(){
        System.out.println("Introduzca la patente: ");
        String patente = sc.nextLine().toUpperCase();
        System.out.println("Introduzca la marca: ");
        String marca = sc.nextLine();
        double kilometraje;
        do {
            System.out.println("Introduzca el kilometraje: ");
            kilometraje = sc.nextDouble();
        } while (kilometraje<0); 
        System.out.println("Está disponible? (SI/NO)");
        String disponible = sc.next().toUpperCase();
        boolean disp = false;
        if (disponible.equals("SI")){
            disp = true;
        } else if (disponible.equals("NO")) {
            disp = false;
        } else {
            System.out.println("Ha introducido datos incorrectos");
        }
        Vehiculo vehiculo = new Vehiculo(patente, marca, kilometraje, disp);
        vehiculos.put(patente, vehiculo);
        System.out.println("Vehículo registrado correctamente");
    }
    public static void buscarPatente(){
        System.out.println("Introduzca la patente:");
        String patente = sc.nextLine().toUpperCase();
        if (vehiculos.containsKey(patente)){
            vehiculos.get(patente).mostrarInformacion();
        } else {
            System.out.println("Vehiculo no encontrado");
        }
    }
    public static void cambiarDisponibilidad(){
        System.out.println("Introduzca la patente:");
        String patente = sc.nextLine().toUpperCase();
        if (vehiculos.containsKey(patente)){
            if (vehiculos.get(patente).isDisponible()){
                vehiculos.get(patente).setDisponible(false);
            } else {
                vehiculos.get(patente).setDisponible(true);
            }
            System.out.println("Disponibilidad de vehiculo actualizada");
        } else {
            System.out.println("Vehiculo no encontrado");
        }
    }
    public static void listarFlotaPorKM(){
        if (vehiculos.isEmpty()){
            System.out.println("No hay vehículos registrados");
            return;
        }
        
        List<Vehiculo> listaOrdenada = new ArrayList<>(vehiculos.values());
        Collections.sort(listaOrdenada);
        
        for (Vehiculo v : listaOrdenada){
            v.mostrarInformacion();
        }
    }
    public static void eliminarVehiculo(){
        System.out.println("Introduzca la patente:");
        String patente = sc.nextLine().toUpperCase();
        Iterator<String> it = vehiculos.keySet().iterator();
        while(it.hasNext()){
            String clave = it.next();
            if (clave.equals(patente)){
                it.remove();
            }
        }
    }
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        // TODO code application logic here
        int opcion;
        do
        {
            System.out.println("--- SISTEMA DE GESTIÓN DE FLOTA ---");
            System.out.println("1.- Registrar vehículo");
            System.out.println("2.- Buscar por patente");
            System.out.println("3.- Cambiar disponibilidad");
            System.out.println("4.- Listar flota por KM");
            System.out.println("5.- Eliminar vehiculo");
            System.out.println("6.- Salir");
            System.out.println("Seleccione una opción: ");
            opcion = sc.nextInt();
            sc.nextLine();
            switch(opcion)
            {
                case 1:
                    registrarVehiculo();
                    break;
                case 2:
                    buscarPatente();
                    break;
                case 3:
                    cambiarDisponibilidad();
                    break;
                case 4:
                    listarFlotaPorKM();
                    break;
                case 5:
                    eliminarVehiculo();
                    break;
                case 6:
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("Ha seleccionado una opción incorrecta");
            }
        }
        while (opcion!=6);
    }
    
}
