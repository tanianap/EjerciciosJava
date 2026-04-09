/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ejercicioVideojuego;

import java.io.EOFException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;
import java.util.InputMismatchException;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

/**
 *
 * @author turita
 */
public class PrincipalVideojuego {

    /**
     * @param args the command line arguments
     */
    public static Scanner sc = new Scanner(System.in);
    public static Map<String, Videojuego> videojuegos = new LinkedHashMap<>();

    public static void registrarVideojuego() {
        System.out.println("Introduce el ID: ");
        String id = sc.next().toUpperCase();
        sc.nextLine();
        if (videojuegos.containsKey(id)) {
            System.out.println("El videojuego ya existe.");
        } else {
            System.out.println("Introduce el título:");
            String titulo = sc.nextLine();
            System.out.println("Introduce la plataforma:");
            String plataforma = sc.nextLine();
            System.out.println("Introduce el stock:");
            int stock = sc.nextInt();
            videojuegos.put(id, new Videojuego(id, titulo, plataforma, stock));
            System.out.println("Se ha añadido con éxito al inventario");
        }
    }

    public static Map<String, Videojuego> descargarInventario(Path ruta) {
        Map<String, Videojuego> inventario = new LinkedHashMap<>();
        if (!Files.exists(ruta)) {
            System.out.println("El fichero no existe");
        } else {
            try (ObjectInputStream ois = new ObjectInputStream(Files.newInputStream(ruta))) {
                while (true) {
                    try {
                        String llave = (String) ois.readObject();
                        Videojuego videojuego = (Videojuego) ois.readObject();
                        inventario.put(llave, videojuego);
                    } catch (EOFException e) {
                        //Fin del fichero
                        break;
                    }
                }
            } catch (NoSuchFileException e) {
                System.out.println("No se ha encontrado el fichero");
            } catch (IOException e) {
                System.out.println("Error de lectura del fichero");
            } catch (ClassNotFoundException e) {
                System.out.println("Clase no encontrada");
            }
        }
        return inventario;
    }

    public static void listarInventario() {
        if (videojuegos.isEmpty()) {
            System.out.println("El inventario esta vacio");
        } else {
            for (Map.Entry<String, Videojuego> entrada : videojuegos.entrySet()) {
                entrada.getValue().mostrarVideojuego();
            }
            System.out.println("Fin del Inventario");
        }
    }

    public static void buscarInventario() {
        if (videojuegos.isEmpty()) {
            System.out.println("El inventario esta vacio");
        } else {
            System.out.println("Introduce el id del videojuego: ");
            String id = sc.next().toUpperCase();
            if (videojuegos.containsKey(id)) {
                videojuegos.get(id).mostrarVideojuego();
            } else {
                System.out.println("No se ha encontrado el videojuego");
            }
        }
    }

    public static void actualizarInventario() {
        if (videojuegos.isEmpty()) {
            System.out.println("El inventario esta vacio");
        } else {
            System.out.println("Introduce el id del videojuego:");
            String id = sc.next().toUpperCase();
            if (videojuegos.containsKey(id)) {
                System.out.println("Si es para añadir introduce 'a' y si es para disminuir 'd'");
                char caracter = sc.next().toLowerCase().charAt(0);
                System.out.println("Introduce la cantidad de productos: ");
                int cantidad = sc.nextInt();
                if (caracter == 'a') {
                    videojuegos.get(id).setStock(videojuegos.get(id).getStock() + cantidad);
                } else if (caracter == 'd') {
                    if ((videojuegos.get(id).getStock() - cantidad) > 0) {
                        videojuegos.get(id).setStock(videojuegos.get(id).getStock() - cantidad);
                    } else {
                        System.out.println("No hay suficiente stock. Se llevara a 0 la cantidad");
                        videojuegos.get(id).setStock(0);
                    }
                } else {
                    System.out.println("Ha introducido una opción incorrecta");
                }
            }
        }
    }

    public static void cargarFichero(Path ruta) {
        try (ObjectOutputStream oos = new ObjectOutputStream(Files.newOutputStream(ruta))) {
            for (Map.Entry<String, Videojuego> entrada : videojuegos.entrySet()){
                oos.writeObject(entrada.getKey());
                oos.writeObject(entrada.getValue());
            }
        } catch (IOException e)  {
            System.out.println("Error de esritura del fichero");
        }
    }

    public static void main(String[] args) {
        // TODO code application logic here
        int opcion;
        try
        {
        Path ruta = Path.of("Inventario.dat");
        videojuegos = descargarInventario(ruta);
        do {
            System.out.println("--- GESTIÓN DE VIDEOJUEGOS ---");
            System.out.println("1.- Registrar videojuego");
            System.out.println("2.- Listar inventario");
            System.out.println("3.- Buscar videojuego por ID");
            System.out.println("4.- Actualizar stock.");
            System.out.println("5.- Salir");
            System.out.println("Introduce una opción");
            opcion = sc.nextInt();
            sc.nextLine();
            switch (opcion) {
                case 1:
                    System.out.println("--- REGISTRAR VIDEOJUEGO ---");
                    registrarVideojuego();
                    break;
                case 2:
                    System.out.println("--- INVENTARIO ---");
                    listarInventario();
                    break;
                case 3:
                    System.out.println("--- BUSCAR VIDEOJUEGO ---");
                    buscarInventario();
                    break;
                case 4:
                    System.out.println("--- ACTUALIZAR STOCK ---");
                    actualizarInventario();
                    break;
                case 5:
                    System.out.println("ADIOS!!!");
                    cargarFichero(ruta);
                    break;
                default:
                    System.out.println("Ha introducido una opción incorrecta");
            }
        } while (opcion != 5);
        } 
        catch (InputMismatchException e)
        {
            System.out.println("Tipo de dato incorrecto");
        }
    }

}
