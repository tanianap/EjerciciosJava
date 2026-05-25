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
import java.util.Scanner;

/**
 *
 * @author turita
 */
public class Ejercicio2_ExamenA {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner sc = new Scanner(System.in);
        Path ruta = Path.of("recursos/ejercicio2_examenA.txt");
        try (BufferedReader br = Files.newBufferedReader(ruta))
        {
            String linea;
            int contador = 0;
            while ((linea = br.readLine()) != null)
            {
                System.out.println(linea);
                contador++;
                if (contador == 24){
                    System.out.println("Presione Intro para continuar");
                    sc.nextLine();
                    contador = 0;
                }
            }
            System.out.println("Fin del fichero");
        }
        catch (NoSuchFileException e)
        {
            System.out.println("No se ha encontrado el archivo");
        }
        catch (IOException e)
        {
            System.out.println("Error de lectura del fichero");
        }
    }
    
}
