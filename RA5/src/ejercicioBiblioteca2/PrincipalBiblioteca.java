/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ejercicioBiblioteca2;

import java.io.EOFException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;
import java.util.InputMismatchException;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author turita
 */
public class PrincipalBiblioteca {

    /**
     * @param args the command line arguments
     */
    public static List<Libro> biblioteca = new LinkedList<>();
    public static Scanner sc = new Scanner(System.in);

    public static void agregarLibro() {
        System.out.println("Inntroduce el ISBN:");
        String isbn = sc.next().toUpperCase();
        sc.nextLine();
        boolean encontrado = false;
        for (Libro libro : biblioteca) {
            if (libro.getIsbn().equals(isbn)) {
                encontrado = true;
                return;
            }
        }
        if (encontrado) {
            System.out.println("Ya existe un libro con ese isbn");
        } else {
            System.out.println("Introduce el título: ");
            String titulo = sc.nextLine().toUpperCase();
            System.out.println("Introduce el autor: ");
            String autor = sc.nextLine();
            System.out.println("Introduce el año: ");
            int anio = sc.nextInt();
            biblioteca.add(new Libro(titulo, autor, anio, isbn));
            System.out.println("Se ha añadido correctamente");
        }
    }

    public static void mostrarLibros() {
        if (biblioteca.isEmpty()) {
            System.out.println("No hay Libros añadidos");
        } else {
            for (Libro libro : biblioteca) {
                libro.mostrarLibro();
            }
        }
    }

    public static void buscarLibro() {
        System.out.println("Introduce el titulo: ");
        String titulo = sc.nextLine().toUpperCase();
        boolean encontrado = false;
        for (Libro libro : biblioteca) {
            if (libro.getTitulo().equals(titulo)) {
                libro.mostrarLibro();
                return;
            }
        }
        if (encontrado) {
            System.out.println("No se ha encontrado el libro");
        }
    }

    public static void cargarFichero(Path ruta) {
        try (ObjectOutputStream oos = new ObjectOutputStream(Files.newOutputStream(ruta))) {
            for (Libro libro : biblioteca) {
                oos.writeObject(libro);
            }
        } catch (IOException e) {
            System.out.println("Error de escritura");
        }
    }

    public static List<Libro> descargarFichero(Path ruta) {
        List<Libro> libros = new LinkedList<>();
        if (!Files.exists(ruta)) {
            System.out.println("El archivo no existe");
        } else {
            try (ObjectInputStream ois = new ObjectInputStream(Files.newInputStream(ruta))) {
                while (true) {
                    try {
                        Libro libro = (Libro) ois.readObject();
                        libros.add(libro);
                    } catch (EOFException e) {
                        break;
                    }
                }
            } catch (NoSuchFileException e) {
                System.out.println("No se ha encontrado el fichero");
            } catch (IOException e) {
                System.out.println("Error de lectura");
            } catch (ClassNotFoundException e) {
                System.out.println("Clase no encontrada");
            }
        }
        return libros;
    }
    public static void main(String[] args) {
        // TODO code application logic here
        Path ruta = Path.of("BibliotecaPAROD.dat");
        int opcion;
        try
        {
        do
        {
            System.out.println("--- GESTIION DE UNA BIBLIOTECA ---");
            System.out.println("1.- Agregar libro");
            System.out.println("2.- Listar todos los libros");
            System.out.println("3.- Buscar libro por titulo");
            System.out.println("4.- Cargar inventario");
            System.out.println("5.- Descargar inventario");
            System.out.println("6.- Salir");
            System.out.println("Introduzca una opción: ");
            opcion = sc.nextInt();
            sc.nextLine();
            switch (opcion)
            {
                case 1:
                    System.out.println("--- AGREGAR LIBROS ---");
                    agregarLibro();
                    break;
                case 2:
                    System.out.println("--- LISTADO DE LIBROS ---");
                    mostrarLibros();
                    break;
                case 3:
                    System.out.println("--- BUSCAR LIBRO ---");
                    buscarLibro();
                    break;
                case 4:
                    System.out.println("Cargando Inventario...");
                    cargarFichero(ruta);
                    break;
                case 5:
                    System.out.println("DescargandoInventario...");
                    biblioteca = descargarFichero(ruta);
                    break;
                case 6:
                    System.out.println("ADIOS!!!");
                    break;
                default:
                    System.out.println("Ha introducido una opción incorrecta");
            }
        } while (opcion!=6);
        } 
        catch (InputMismatchException e)
        {
            System.out.println("Ha introducido un tipo de dato incorrecto");
        }
    }

}
