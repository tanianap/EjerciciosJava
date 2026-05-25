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
import java.util.List;

/**
 *
 * @author turita
 */
public class Ejercicio4_ExamenB {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Path ruta1 = Path.of("recursos/perso1.txt");
        Path ruta2 = Path.of("recursos/perso2.txt");
        Path ruta3 = Path.of("recursos/todosPerso.txt");
        List<String> nombres1 = new ArrayList<>();
        List<String> nombres2 = new ArrayList<>();
        try (BufferedReader br1 = Files.newBufferedReader(ruta1); BufferedReader br2 = Files.newBufferedReader(ruta2); BufferedWriter wr1 = Files.newBufferedWriter(ruta3)) {
            String linea1;
            String linea2;
            while ((linea1 = br1.readLine()) != null) {
                nombres1.add(linea1);
            }
            while ((linea2 = br2.readLine()) != null){
                nombres2.add(linea2);
            }
            List<String> nombres = new ArrayList<>(nombres1);
            for (String nombre : nombres2) {
                nombres.add(nombre);
            }
            Collections.sort(nombres);
            for (String nombre : nombres){
                wr1.write(nombre);
                wr1.newLine();
            }
            System.out.println("Fichero escrito con exito");

        } catch (NoSuchFileException e) {
            System.out.println("Fichero no encontrado");
        } catch (IOException e) {
            System.out.println("Error de lectura/escritura: " + e.getMessage());
        }

    }

}
