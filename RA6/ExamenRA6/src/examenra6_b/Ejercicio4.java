/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package examenra6_b;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.ListIterator;
import java.util.Scanner;

/**
 *
 * @author turita
 */
public class Ejercicio4 {

    /**
     * @param args the command line arguments
     */
    static Scanner sc = new Scanner(System.in);
    static List<Mascota> mascotas = new ArrayList<>();

    public static void ingresarMascota() {
        System.out.println("Introduce el id: ");
        int id = sc.nextInt();
        boolean existe = mascotas.stream().anyMatch(n -> n.getId() == id);
        if (existe) {
            System.out.println("Ya existe una mascota con ese ID");
        } else {
            System.out.println("Introduce el nombre: ");
            String nombre = sc.nextLine();
            System.out.println("Introduce la especie: ");
            String especie = sc.nextLine();
            System.out.println("Introduce la edad: ");
            int edad = sc.nextInt();

            Mascota mascota = new Mascota(id, nombre, especie, edad);
            System.out.println("Mascota añadida correctamente");
            mascotas.add(mascota);
        }
    }

    public static void buscarMascota() {
        if (mascotas.isEmpty()) {
            System.out.println("No hay mascotas agregadas");
        } else {
            System.out.println("Introduce el id:");
            int id = sc.nextInt();
            boolean encontrado = false;
            for (Mascota mascota : mascotas) {
                if (mascota.getId() == id) {
                    mascota.mostrarInfo();
                    encontrado = true;
                }
            }
            if (!encontrado) {
                System.out.println("Mascota no encontrada");
            }
        }
    }

    public static void actualizarEstado() {
        if (mascotas.isEmpty()) {
            System.out.println("No hay mascotas agregadas");
        } else {
            System.out.println("Introduce el id: ");
            int id = sc.nextInt();
            boolean encontrado = false;
            for (Mascota mascota : mascotas) {
                if (mascota.getId() == id) {
                    encontrado = true;
                    if (mascota.isEstado()) {
                        mascota.setEstado(false);
                    } else {
                        System.out.println("La mascota ha sido de alta");
                    }
                }
            }
            if (!encontrado) {
                System.out.println("Mascota no encontrada");
            }
        }
    }

    public static void listarPacientesCriticos() {
        if (mascotas.isEmpty()) {
            System.out.println("No hay mascotas agregadas");
        } else {
            for (Mascota mascota : mascotas) {
                if (mascota.getEdad() > 10 && mascota.isEstado()) {
                    mascota.mostrarInfo();
                }
            }
        }
    }

    public static void eliminarRegistro() {
        if (mascotas.isEmpty()) {
            System.out.println("No hay mascotas agregadas");
        } else {
            System.out.println("Introduce el id:");
            int id = sc.nextInt();
            boolean encontrado = false;
            ListIterator<Mascota> it = mascotas.listIterator();
            while (it.hasNext()) {
                Mascota m = it.next();
                if (m.getId() == id) {
                    encontrado = true;
                    it.remove();
                }
            }
            if (!encontrado) {
                System.out.println("Mascota no encontrada");
            }
        }
    }

    public static void main(String[] args) {
        // TODO code application logic here
        int opcion = 0;
        do {
            try {
                System.out.println("--- SISTEMA DE GESTIÓN VETERINARIA ---");
                System.out.println("1.- Ingresar Mascota");
                System.out.println("2.- Buscar Mascota");
                System.out.println("3.- Actualizar estado");
                System.out.println("4.- Listar pacientes críticos");
                System.out.println("5.- Eliminar registro");
                System.out.println("6.- Salir");
                System.out.println("Selecciona una opción:");
                opcion = sc.nextInt();

                sc.nextLine();
                switch (opcion) {
                    case 1:
                        System.out.println("--- INGRESAR MASCOTA ---");
                        ingresarMascota();
                        break;
                    case 2:
                        System.out.println("--- BUSCAR MASCOTA ---");
                        buscarMascota();
                        break;
                    case 3:
                        System.out.println("--- ACTUALIZAR ESTADO ---");
                        actualizarEstado();
                        break;
                    case 4:
                        System.out.println("--- LISTADO PACIENTES CRÍTICOS ---");
                        listarPacientesCriticos();
                        break;
                    case 5:
                        System.out.println("--- ELIMINAR REGISTRO ---");
                        eliminarRegistro();
                        break;
                    case 6:
                        System.out.println("Saliendo . . .");
                        break;
                    default:
                        System.out.println("Ha seleccionado una opción incorrecta");
                }
            } catch (InputMismatchException e) {
                System.out.println("Ha introducido un tipo de dato incorrecto");
            }
        } while (opcion != 6);

    }

}
