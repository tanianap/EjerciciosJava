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

/**
 *
 * @author turita
 */
public class ejercicioNotas {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Path ruta = Path.of("recursos/notas.txt");
        Path ruta1 = Path.of("recursos/aprobados.txt");
        try (BufferedReader br = Files.newBufferedReader(ruta); BufferedWriter wr = Files.newBufferedWriter(ruta1))
        {
            String linea, alumnoTop = "";
            String [] milinea;
            double notaMedia = 0, mayorNota = -1;
            int contador = 0;
            System.out.println("--- DATOS DEL FICHERO ---");
            while ((linea = br.readLine()) != null){
                System.out.println(linea);
                milinea = linea.split(",");
                String nombre = milinea[0];
                double nota = Double.parseDouble(milinea[1]);
                if (nota > mayorNota){
                    mayorNota = nota;
                    alumnoTop = nombre;
                }
                notaMedia += nota;
                contador++;
                if (nota > 5){
                    wr.write(nombre + "," + String.valueOf(nota));
                    wr.newLine();
                }
            }
            
            if (contador > 0)
            {
                System.out.println("La nota media es: " + notaMedia/contador);
            
                System.out.println("El alumno con mayor nota es: " + alumnoTop + " con un " + mayorNota);
            }
            System.out.println("Se ha generado un nuevo fichero con los estudiantes aprobados");
        }
        catch (NoSuchFileException e)
        {
            System.out.println("Fichero no encontrado " + e.getMessage());
        }
        catch (IOException e)
        {
            System.out.println("Error al leer el fichero " + e.getMessage());
        }
    }
    
}
