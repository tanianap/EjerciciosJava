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
import java.util.List;

/**
 *
 * @author turita
 */
public class ejercicioDiferencias {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Path ruta1 = Path.of("recursos/archivo1.txt");
        Path ruta2 = Path.of("recursos/archivo2.txt");
        Path ruta3 = Path.of("recursos/diferencias.txt");
        List<String> palabras1 = new ArrayList<>();
        List<String> palabras2 = new ArrayList<>();
        try (BufferedReader br1 = Files.newBufferedReader(ruta1); BufferedReader br2 = Files.newBufferedReader(ruta2); BufferedWriter bw = Files.newBufferedWriter(ruta3)){
            String linea1, linea2;
            while ((linea1 = br1.readLine()) != null){
                palabras1.add(linea1);
            }
            while ((linea2 = br2.readLine()) != null){
                palabras2.add(linea2);
            }
            System.out.println("Archivo1");
            palabras1.stream().forEach(n-> System.out.println(n));
            
            System.out.println("Archivo2");
            palabras2.stream().forEach(n -> System.out.println(n));
            
            System.out.println("Palabras repetidas");
            bw.write("Palabras repetidas");
            bw.newLine();
            for (String palabra1 : palabras1){
                for (String palabra2 : palabras2){
                    if (palabra1.equals(palabra2)){
                        System.out.println(palabra1);
                        bw.write(palabra1);
                        bw.newLine();
                    }
                }
            }
            
            
            System.out.println("Palabras distintas");
            bw.write("Palabras distintas");
            bw.newLine();
            for (String palabra1 : palabras1){
                for (String palabra2 : palabras2){
                    if (!palabra1.equals(palabra2)){
                        System.out.println(palabra1);
                        bw.write(palabra2);
                        bw.newLine();
                    }
                }
            }
            
        }
        catch (NoSuchFileException e)
        {
            System.out.println("Fichero no encontrado");
        }
        catch (IOException e)
        {
            System.out.println("Error de lectura del fichero");
        }
    }
    
}