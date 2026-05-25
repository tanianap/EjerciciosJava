/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ejerciciosFicheros;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Collections;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author turita
 */
public class Ejercicio4_ExamenA {

    /**
     * @param args the command line arguments
     */
    static List<String> contactos = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);
    public static void nuevoContacto(){
        if (contactos.size() >= 20) {
            System.out.println("Error: La agenda está llena (Máximo 20 contactos).");
            return;
        }
        
        System.out.println("Introduce el nombre: ");
        String nombre = sc.nextLine().toUpperCase();
        
  
        for (String contacto : contactos) {
            if (contacto.startsWith(nombre + " ,")) {
                System.out.println("Error: El nombre ya existe en la agenda.");
                return;
            }
        }
        System.out.println("Introduce el teléfono:");
        String telefono = sc.nextLine();
        
        StringBuilder sb = new StringBuilder();
        sb.append(nombre).append(" , ").append(telefono);
        
        contactos.add(sb.toString());
    }
    public static void buscarNombre(){
        if (contactos.isEmpty()){
            System.out.println("La lista está vacía");
            return;
        }
        System.out.println("Introduce el nombre: ");
        String nombre = sc.nextLine().toUpperCase();
        boolean encontrado = false;
        for (String contacto : contactos){
            String [] con = contacto.split(" ,");
            String nombreGuardado = con[0];
            String telefono = con[1];
            if (con[0].contains(nombre)){
                System.out.println(contacto);
                encontrado = true;
            }
        }
        if (!encontrado){
            System.out.println("El contacto No ha sido encontrado");
        }
    }
    public static void mostrarContactos(){
        if (contactos.isEmpty()){
            System.out.println("No hay contactos añadidos");
            return;
        }
        Collections.sort(contactos);
        for (String contacto : contactos){
            System.out.println(contacto);
        }
    }
    public static void cargarFichero(){
        Path ruta = Path.of("recursos/agenda.txt");
        try (BufferedWriter bw = Files.newBufferedWriter(ruta))
        {
            for (String contacto : contactos){
                bw.write(contacto);
                bw.newLine();
            }
            System.out.println("Fichero escrito correctamente");
        }
        catch (IOException e)
        {
            System.out.println("Error de escritura del fichero");
        }
    }
    public static List<String> descargarFichero(){
        Path ruta = Path.of("recursos/agenda.txt");
        List<String> contactosGuardados = new ArrayList<>();
        if (Files.notExists(ruta)){
            return contactosGuardados;
        }
        try (BufferedReader br = Files.newBufferedReader(ruta)){
            String linea;
            while ((linea = br.readLine()) != null)
            {
                contactosGuardados.add(linea);
            }
        }
        catch (NoSuchFileException e)
        {
            System.out.println("No se ha enocntrado el fichero");
        }
        catch (IOException e)
        {
            System.out.println("Error de lectura del fichero");
        }
        return contactosGuardados;
    }
    public static void main(String[] args) {
        // TODO code application logic here
        int opcion = 0;
        contactos.addAll(descargarFichero());
        do
        {
            try
            {
                System.out.println("--- AGENDA ----");
                System.out.println("1.- Nuevo Contacto");
                System.out.println("2.- Buscar contacto por nombre");
                System.out.println("3.- Mostrar contactos");
                System.out.println("4.- Salir");
                System.out.println("Selecciona una opción:");
                opcion = sc.nextInt();
                sc.nextLine();
                
                switch(opcion)
                {
                    case 1:
                        System.out.println("--- AGREGAR CONTACTO ---");
                        nuevoContacto();
                        break;
                    case 2:
                        System.out.println("--- BUSCAR CONTACTO ---");
                        buscarNombre();
                        break;
                    case 3:
                        System.out.println("--- CONTACTOS ---");    
                        mostrarContactos();
                        break;
                    case 4:
                        System.out.println("Saliendo . . .");
                        cargarFichero();
                        break;
                    default:
                        System.out.println("Ha introducido una opción incorrecta");
                }
            }
            catch (InputMismatchException e)
            {
                System.out.println("Tipo de dato incorrecto");
                sc.nextLine();
            }
        } while (opcion != 4);
        
    }
    
}
