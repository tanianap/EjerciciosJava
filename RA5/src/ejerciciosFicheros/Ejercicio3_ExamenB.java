
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ejerciciosFicheros;

import java.io.EOFException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.ListIterator;
import java.util.Scanner;

/**
 *
 * @author turita
 */
public class Ejercicio3_ExamenB {

    /**
     * @param args the command line arguments
     */
    static Scanner sc = new Scanner(System.in);
    static List<Cliente> clientes = new ArrayList<>();

    public static void agregarCliente() {

        System.out.println("Introduzca el id:");
        int id = sc.nextInt();
        sc.nextLine();
        System.out.println("Introduzca el nombre:");
        String nombre = sc.nextLine();
        System.out.println("Introduzca el telefono:");
        String telefono = sc.nextLine();

        Cliente cliente = new Cliente(id, nombre, telefono);
        System.out.println("Cliente agregado");
        clientes.add(cliente);

    }

    public static void modificarCliente() {
        if (clientes.isEmpty()) {
            System.out.println("No hay clientes");
        } else {
            int opcion;
            System.out.println("Introduzca el id del cliente a modificar:");
            int id = sc.nextInt();
            sc.nextLine();
            Cliente nuevoCliente = null;
            for (Cliente cliente : clientes) {
                if (cliente.getId() == id) {
                    nuevoCliente = cliente;
                    break;
                }
            }
            if (nuevoCliente == null) {
                System.out.println("No se ha encontrado ningún cliente con ese ID");
                return;
            }
            do {
                System.out.println("--- DATOS A MODIFICAR ---");
                System.out.println("1.- Id");
                System.out.println("2.- Nombre");
                System.out.println("3.- Telefono");
                System.out.println("4.- Salir");
                System.out.println("Introduzca una opcion");
                opcion = sc.nextInt();

                sc.nextLine();
                switch (opcion) {
                    case 1:
                        System.out.println("Introduzca el nuevo id");
                        int idNuevo = sc.nextInt();
                        nuevoCliente.setId(idNuevo);
                        System.out.println("ID actualizado");
                        break;
                    case 2:
                        System.out.println("Introduzca el nombre:");
                        String nombreNuevo = sc.nextLine();
                        nuevoCliente.setNombre(nombreNuevo);
                        break;
                    case 3:
                        System.out.println("Introduzca el telefono:");
                        String telefono = sc.nextLine();
                        nuevoCliente.setTelefono(telefono);
                        break;
                    case 4:
                        System.out.println("Volviendo al menú principal. . . ");
                        break;
                    default:
                        System.out.println("Ha seleccionado una opción incorrecta");
                }
            } while (opcion != 4);
        }
    }

    public static void bajaCliente() {
        if (clientes.isEmpty()) {
            System.out.println("No hay clientes");
            return;
        }
        System.out.println("Introduzca el id:");
        int id = sc.nextInt();
        boolean encontrado = false;
        ListIterator<Cliente> it = clientes.listIterator();
        while (it.hasNext()) {
            Cliente cliente = it.next();
            if (cliente.getId() == id) {
                it.remove();
                encontrado = true;
            }
        }
        if (encontrado) {
            System.out.println("Se ha eliminado correctamente");
        } else {
            System.out.println("No se ha encontrado el cliente");
        }
    }

    public static void listarClientes() {
        if (clientes.isEmpty()) {
            System.out.println("No hay clientes");
            return;
        }
        for (Cliente cliente : clientes) {
            cliente.mostrarInfo();
        }
    }

    public static void cargarFichero() {
        Path ruta = Path.of("recursos/clientes.dat");
        try (ObjectOutputStream oos = new ObjectOutputStream(Files.newOutputStream(ruta))) {
            for (Cliente cliente : clientes) {
                oos.writeObject(cliente);
            }
            System.out.println("Datos guardados correctamente");
        } catch (IOException e) {
            System.out.println("Error al escribir en el fichero" + e.getMessage());
        }
    }

    public static List<Cliente> descargarFichero() {
        Path ruta = Path.of("recursos/clientes.dat");
        List<Cliente> clientesGuardados = new ArrayList<>();
        if (Files.notExists(ruta)) {
            return clientesGuardados;
        }
        try (ObjectInputStream ois = new ObjectInputStream(Files.newInputStream(ruta))) {
            while (true) {
                Cliente cliente = (Cliente) ois.readObject();
                clientesGuardados.add(cliente);
            }
        } catch (EOFException e) {
            System.out.println("Datos cargados correctamente en memoria.");
        } catch (NoSuchFileException e) {
            System.out.println("No se ha encontrado el fichero");
        } catch (IOException e) {
            System.out.println("Error de lectura");
        } catch (ClassNotFoundException e) {
            System.out.println("Clase no encontrada");
        }
        return clientesGuardados;
    }

    public static void main(String[] args) {
        // TODO code application logic here
        int opcion;
        try {
            clientes.addAll(descargarFichero());
            do {
                System.out.println("--- GESTIÓN COMERCIO ---");
                System.out.println("1.- Agregar nuevo cliente");
                System.out.println("2.- Modificar datos cliente");
                System.out.println("3.- Dar de baja cliente");
                System.out.println("4.- Listar clientes");
                System.out.println("5.- Salir");
                System.out.println("Seleccione una opción");
                opcion = sc.nextInt();

                sc.nextLine();
                switch (opcion) {
                    case 1:
                        System.out.println("--- AGREGAR CLIENTE ---");
                        agregarCliente();
                        break;
                    case 2:
                        System.out.println("--- MODIFICAR CLIENTE ---");
                        modificarCliente();
                        break;
                    case 3:
                        System.out.println("--- DAR DE BAJA CLIENTE ---");
                        bajaCliente();
                        break;
                    case 4:
                        System.out.println("--- CLIENTES ---");
                        listarClientes();
                        break;
                    case 5:
                        System.out.println("Saliendo . . .");
                        cargarFichero();
                        break;
                    default:
                        System.out.println("Ha seleccionado una opción incorrecta");
                }
            } while (opcion != 5);
        } catch (InputMismatchException e) {
            System.out.println("Tipo de dato incorrecto");
        }
    }

}
