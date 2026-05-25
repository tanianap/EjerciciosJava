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
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author turita
 */
public class ejercicioCiudad {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Path ruta = Path.of("recursos/ciudad.txt");
        Path ruta2 = Path.of("recursos/estadisticas.txt");
        Map<String,Integer> palabras = new HashMap <>();
        try (BufferedReader br = Files.newBufferedReader(ruta); BufferedWriter wr = Files.newBufferedWriter(ruta2)){
            String linea;
            while ((linea = br.readLine()) != null){
                String [] milinea = linea.toLowerCase().split("[\\s.,]+");
                for (String palabra: milinea){
                    palabras.put(palabra, palabras.getOrDefault(palabra, 0)+1);
                }
            }
            System.out.println("Número total de palabras: " + palabras.size());
            System.out.println("--- CANTIDAD DE PALABRAS REPETIDAS ---");
            palabras.entrySet().stream().forEach(n -> {System.out.println(n.getKey() + " -> " + n.getValue());});
            wr.write("--- CANTIDAD DE PALABRAS REPETIDAS ---");
            wr.newLine();
            for (Map.Entry<String, Integer> entrada : palabras.entrySet()){
                wr.write(entrada.getKey() + " = " + entrada.getValue());
                wr.newLine();
            }
            System.out.println("--- PALABRAS MÁS REPETIDAS ---");
            palabras.entrySet().stream().sorted((n1,n2) -> n2.getValue().compareTo(n1.getValue()))
                    .limit(5).forEach(n -> System.out.println(n.getKey() + " -> " + n.getValue()));
            wr.write("--- PALABRAS MÁS REPETIDAS ---");
            wr.newLine();
            List<Map.Entry<String, Integer>> top5 = palabras.entrySet().stream()
                            .sorted((n1, n2) -> n2.getValue().compareTo(n1.getValue())).limit(5).toList();
            for (Map.Entry<String, Integer> entry : top5) {
                wr.write(entry.getKey() + " -> " + entry.getValue());
                wr.newLine();
            }
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
