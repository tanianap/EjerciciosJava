/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ejerciciosFicheros;

import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;
import com.opencsv.exceptions.CsvValidationException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author turita
 */
public class Ejercicio3_ExamenA {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Path ruta = Path.of("recursos/productos.csv");
        Path ruta2 = Path.of("recursos/productos_clasificados.csv");
        List<String> barato = new ArrayList<>();
        List<String> medio = new ArrayList<>();
        List<String> caro = new ArrayList<>();
        try (CSVReader reader = new CSVReader(Files.newBufferedReader(ruta)); CSVWriter writer = new CSVWriter(Files.newBufferedWriter(ruta2))) {
            reader.readNext();
            String[] linea;
            String [] encabezado = {"Nombre", "Precio", "Categoria"};
            writer.writeNext(encabezado);
            while ((linea = reader.readNext()) != null) {
                if (linea.length >= 3) {
                    try {
                        int id = Integer.parseInt(linea[0]);
                        String nombre = linea[1];
                        double precio = Double.parseDouble(linea[2]);
                        
                        String categoria = "";
                        
                        if (precio < 20)
                        {
                            categoria = "Barato";
                            barato.add(nombre + " - " + precio);
                        } else if (precio >= 20 && precio <=100){
                            categoria = "Medio";
                            medio.add(nombre + " - " + precio);
                        }else if (precio > 100){
                            categoria = "Caro";                        
                            caro.add(nombre + " - " + precio);
                        }else {
                            System.out.println("Precio invalido");
                        }
                        
                        String [] producto = {nombre, String.valueOf(precio), categoria};
                        writer.writeNext(producto);
                        
                    } catch (NumberFormatException e) {
                        System.out.println("Línea mal formada");
                    }
                }
                else {
                    System.out.println("Línea incompleta");
                }

            }
        } catch (IOException | CsvValidationException e) {
            System.out.println("Error de lectura del fichero");
        }
        
        System.out.println("Productos Baratos:");
        for (String producto : barato){
            System.out.println(producto);
        }
        
        System.out.println("\nProductos Medios:");
        for (String producto : medio){
            System.out.println(producto);
        }
        
        System.out.println("\nProductos Baratos:");
        for (String producto : caro){
            System.out.println(producto);
        }
        
        System.out.println("\nRESUMEN");
        System.out.println("Números de productos baratos: " + barato.size());
        System.out.println("Números de productos medios: " + medio.size());
        System.out.println("Números de productos caros: " + caro.size());
    }

}
