/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ejerciciosFicheros;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;

/**
 *
 * @author turita
 */
public class Ejercicio1_ExamenA {

    /**
     * @param args the command line arguments
     */
    public static boolean esPalindromo(String palabra){
        StringBuilder sb = new StringBuilder();
        sb.append(palabra);
        
        if (palabra.equals(sb.reverse().toString())){
            return true;
        }
        return false;
    }
    public static void main(String[] args) {
        // TODO code application logic here
        Path ruta =  Path.of("recursos/palindromos.txt");
        try (BufferedReader br = Files.newBufferedReader(ruta))
        {
            String linea;
            System.out.println("Palindromos encontrados: ");
            int contador = 0;
            while ((linea = br.readLine()) != null)
            {
                if (esPalindromo(linea)){
                    System.out.println(linea);
                    contador++;
                }
            }
            System.out.println("\nTotal de palíndromos: " + contador);
        }
        catch (NoSuchFileException e)
        {
            System.out.println("No se ha encontrado el fichero");
        }
        catch (IOException e)
        {
            System.out.println("Error de lectura");
        }
    }
    
}
