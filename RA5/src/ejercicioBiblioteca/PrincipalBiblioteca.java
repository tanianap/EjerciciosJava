/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ejercicioBiblioteca;

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
public class PrincipalBiblioteca {

    /**
     * @param args the command line arguments
     */
    public static Scanner sc = new Scanner(System.in);
    public static Map<String,Libro> biblioteca = new LinkedHashMap<>();
    public static void agregarLibro(){
        System.out.println("Introduce el isbn");
        String isbn = sc.next();
        sc.nextLine();
        if (biblioteca.containsKey(isbn)){
            System.out.println("Ya existe un libro con ese ISBN");
        } else {
            System.out.println("Introduce el titulo");
            String titulo = sc.nextLine();
            System.out.println("Introduce el nombre del autor");
            String autor = sc.nextLine();
            System.out.println("Introduce el precio");
            double precio = sc.nextDouble();
            biblioteca.put(isbn, new Libro(isbn, titulo, autor, precio));
            System.out.println("Libro añadido correctamente.");
        }  
    }
    public static Map<String, Libro> descargarFichero(Path ruta){
        Map<String, Libro> libros = new LinkedHashMap<>();
        if (!Files.exists(ruta)){
            System.out.println("El fichero no existe");
        } else {
            try (ObjectInputStream ois = new ObjectInputStream(Files.newInputStream(ruta)))
            {
               while (true) {
                   try {
                        String llave = (String) ois.readObject();
                        Libro libro = (Libro) ois.readObject();
                        libros.put(llave, libro);    
                   } catch (EOFException e){
                       // Fin del fichero
                       break;
                   }
               }
            } catch (NoSuchFileException e){
                System.out.println("Fichero no encontrado");
            } catch (IOException e){
                System.out.println("Error al leer el fichero");
            } catch (ClassNotFoundException e){
                System.out.println("Clase no encontrada");
            }
                
        }
        return libros;
    }
    public static void cargarFichero(Path ruta){
        try (ObjectOutputStream oos = new ObjectOutputStream(Files.newOutputStream(ruta))){
            for (Map.Entry<String, Libro> entrada : biblioteca.entrySet()){
                oos.writeObject(entrada.getKey());
                oos.writeObject(entrada.getValue());
            }
        } catch (IOException e){
             System.out.println("Error de escritura de fichero");
        }
    }
    public static void mostrarLibros(){
        if (biblioteca.isEmpty()){
            System.out.println("No hay libros almacenados");
        } else {
            for (Map.Entry<String, Libro> entrada : biblioteca.entrySet())
            {
                entrada.getValue().mostrarLibro();
            }
        }
    }
    public static void buscarLibro(){
        System.out.println("Introduce el isbn:");
        String isbn = sc.next();
        if (biblioteca.containsKey(isbn)){
            biblioteca.get(isbn).mostrarLibro();
        } else {
            System.out.println("No se ha encontrado el libro");
        }
    }
    public static void eliminarLibro(){
        System.out.println("Introduce el isbn: ");
        String isbn  =sc.next();
        
        Libro eliminado = biblioteca.remove(isbn);
        if (eliminado != null){
            System.out.println("Libro eliminado");
        } else {
            System.out.println("No se ha encontrado");
        }
    }
    public static void main(String[] args) {
        // TODO code application logic here
        int opcion;
        Path ruta = Path.of("biblioteca.dat");
        biblioteca = descargarFichero(ruta);
        try 
        {
        do 
        {
            System.out.println("--- GESTIÓN BIBLIOTECA ---");
            System.out.println("1.- Añadir libro");
            System.out.println("2.- Mostrar todos los libros");
            System.out.println("3.- Buscar libro por ISBN");
            System.out.println("4.- Eliminar libro por ISBN");
            System.out.println("5.- Guardar en fichero");
            System.out.println("6.- Salir");
            System.out.println("Introduzca una opción:");
            opcion = sc.nextInt();
            sc.nextLine();
            switch (opcion)
            {
                case 1:
                    System.out.println("--- AÑADIR LIBRO ---");
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
                    System.out.println("--- ELIMINAR LIBRO ---");
                    eliminarLibro();
                    break;
                case 5:
                    System.out.println("CARGANDO FICHERO...");
                    cargarFichero(ruta);
                    break;
                case 6:
                    System.out.println("ADIÓS!!!");
                    break;
                default:
                    System.out.println("Ha introducido una opción incorrecta");
            }
        } while (opcion!=6);
        }
        catch (InputMismatchException e)
        {
            System.out.println("Tipo de dato incorrecto");
        }
    }
    
}
