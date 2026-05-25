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
public class Ejercicio2_ExamenB {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Path ruta = Path.of("recursos/calificaciones.csv");
        Path ruta2 = Path.of("recursos/calificaciones_clasificados.csv");

        List<String> suspensos = new ArrayList<>();
        List<String> aprobados = new ArrayList<>();
        List<String> notables = new ArrayList<>();
        List<String> sobresalientes = new ArrayList<>();

        try (CSVReader reader = new CSVReader(Files.newBufferedReader(ruta)); CSVWriter writer = new CSVWriter(Files.newBufferedWriter(ruta2))) {
            String[] encabezado = {"Nombre", "Nota", "Categoria"};
            writer.writeNext(encabezado);

            String[] nextLine;
            while ((nextLine = reader.readNext()) != null) {
                if (nextLine.length >= 3) {
                    try {
                        int id = Integer.parseInt(nextLine[0].trim());
                        String nombre = nextLine[1].trim();
                        double nota = Double.parseDouble(nextLine[2].trim());

                        String categoria = "";

                        if (nota >= 0 && nota <= 4.9) {
                            categoria = "Suspenso";
                            suspensos.add(nombre + "\n" + nota);
                        } else if (nota >= 5 && nota <= 6.9) {
                            categoria = "Aprobado";
                            aprobados.add(nombre + "\n" + nota);
                        } else if (nota >= 7 && nota <= 8.9) {
                            categoria = "Notable";
                            notables.add(nombre + "\n" + nota);
                        } else {
                            categoria = "Sobresaliente";
                            sobresalientes.add(nombre + "\n" + nota);
                        }

                        String[] persona = {nombre, String.valueOf(nota), categoria};
                        writer.writeNext(persona);

                    } catch (NumberFormatException e) {
                        System.out.println("Línea mal formada (error de números), saltando registro...");
                    }
                } else {
                    System.out.println("Línea incompleta");
                }
            }
        } catch (IOException | CsvValidationException e) {
            System.out.println("Error leyendo el archivo CSV: " + e.getMessage());
        }
        System.out.println("SUSPENSOS");
        for (String suspenso : suspensos) {
            System.out.println(suspenso);
        }

        System.out.println("\nAPROBADOS");
        for (String aprobado : aprobados) {
            System.out.println(aprobado);
        }

        System.out.println("\nNOTABLES");
        for (String notable : notables) {
            System.out.println(notable);
        }

        System.out.println("\nSOBRESALIENTES");
        for (String sobresaliente : sobresalientes) {
            System.out.println(sobresaliente);
        }

        System.out.println("\nResumen:");
        System.out.println("Suspensos: " + suspensos.size());
        System.out.println("Aprobados: " + aprobados.size());
        System.out.println("Notables: " + notables.size());
        System.out.println("Sobresalientes: " + sobresalientes.size());
    }

}
