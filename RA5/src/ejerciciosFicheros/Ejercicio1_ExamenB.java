/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ejerciciosFicheros;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author turita
 */
public class Ejercicio1_ExamenB {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Path ruta = Path.of("recursos/palabras.txt");
        List<String> palabras = List.of("Amiga", "ormiga", "italia", "Casa", "Perro", "Universidad");
        List<String> palabrasVocales = new ArrayList<>();
        for (String palabra : palabras){
            if (palabra.toLowerCase().startsWith("a") ||  palabra.toLowerCase().startsWith("e") || palabra.toLowerCase().startsWith("i")
                    || palabra.toLowerCase().startsWith("o") || palabra.toLowerCase().startsWith("u")){
                System.out.println(palabra);
                palabrasVocales.add(palabra);
            }
        } 
        System.out.println("Hay " + palabrasVocales.size() + " palabras que empiezan con vocal");
        try (BufferedWriter bw = Files.newBufferedWriter(ruta)) {
            for (String palabra : palabras){
                bw.write(palabra);
                bw.newLine();
            }
        }
        catch (IOException e)
        {
            System.out.println("Error de escritura: " + e.getMessage());
        }
    }
    
}
