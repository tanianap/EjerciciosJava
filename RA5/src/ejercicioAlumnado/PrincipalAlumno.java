/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ejercicioAlumnado;

import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;
import com.opencsv.exceptions.CsvValidationException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.InputMismatchException;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author turita
 */
public class PrincipalAlumno {

    /**
     * @param args the command line arguments
     */
    public static List<Alumno> alumnado = new LinkedList<>();
    public static Scanner sc = new Scanner(System.in);
    public static boolean validarDNI(String dni) {
        String letras = "TRWAGMYFPDXBNJZSQVHLCKE";

        if (dni == null || !dni.matches("^\\d{8}[A-Za-z]$")) {
            return false;
        }

        int numero = Integer.parseInt(dni.substring(0, 8));
        char letra = Character.toUpperCase(dni.charAt(8));

        return letra == letras.charAt(numero % 23);
    }
    public static boolean validarNIE(String nie) {
        String letras = "TRWAGMYFPDXBNJZSQVHLCKE";
        if (nie == null || !nie.matches("^[XYZxyz]\\d{7}[A-Za-z]$")) {
            return false;
        }
        char inicial = Character.toUpperCase(nie.charAt(0));
        String numeroNIE = nie.substring(1, 8);

        String numeroCompleto = "";

        switch (inicial) {
            case 'X':
                numeroCompleto = "0" + numeroNIE;
                break;
            case 'Y':
                numeroCompleto = "1" + numeroNIE;
                break;
            case 'Z':
                numeroCompleto = "2" + numeroNIE;
                break;
        }

        int numero = Integer.parseInt(numeroCompleto);
        char letra = Character.toUpperCase(nie.charAt(8));

        return letra == letras.charAt(numero % 23);
    }

    public static void agregarAlumno(){
        System.out.println("Introduzca si el num de identificacion es (nie,dni u otro): ");
        String identificacion = sc.next().toLowerCase();
        String dni;
        if (identificacion.equals("dni")){
            System.out.println("Introduzca el DNI: ");
            dni = sc.next();
            if (!validarDNI(dni)){
                System.out.println("DNI No váilido");
                return;
            }
        } else if (identificacion.equals("nie")){
            System.out.println("Introduzca el NIE: ");
            dni = sc.next();
            if (!validarNIE(dni)){
                System.out.println("NIE No válido");
                return;
            }
        } else {
            System.out.println("Introduzca el num de identidad: ");
            dni = sc.next();
        }
        boolean existe = alumnado.stream().anyMatch(n -> n.getDni().equals(dni));
        
        if (existe){
            System.out.println("Existe un alumno con ese numero de identificación");
        } else {
            sc.nextLine();
            System.out.println("Introduzca el nombre: ");
            String nombre = sc.nextLine().toUpperCase();
            System.out.println("Introduzca los apellidos: ");
            String apellidos = sc.nextLine().toUpperCase();
            System.out.println("Introduzca la edad: ");
            int edad = sc.nextInt();
            while (edad < 0 || edad > 120){
                System.out.println("Edad incorrecta");
                System.out.println("Introduzca la edad: ");
                edad = sc.nextInt();
            }
            System.out.println("Introduzca la nota media: ");
            double notaMedia =sc.nextDouble();
            alumnado.add(new Alumno(dni, nombre, apellidos, edad, notaMedia));
            System.out.println("Alumno añadido exitosamente");
        }
    }
    public static void mostrarAlumnos()
    {
        if (alumnado.isEmpty()){
            System.out.println("No hay alumnos guardados");
        } else {
            for (Alumno alumno : alumnado)
            {
                alumno.mostrarAlumno();
            }
        }
    }
    public static void buscarAlumno(){
        if (alumnado.isEmpty()){
            System.out.println("No hay alumnos inscritos");
        } else {
            sc.nextLine();
            System.out.println("Introduzca el nombre del alumno a buscar: ");
            String nombre = sc.nextLine().toUpperCase();
            for (Alumno alumno: alumnado){
                if (alumno.getNombre().equals(nombre)){
                    alumno.mostrarAlumno();
                }
            }
        }
    }
    public static void guardarFichero(Path ruta)
    {
        try (var writer = new CSVWriter(Files.newBufferedWriter(ruta)))
        {
            String[] encabezado = {"DNI", "Nombre", "Apellidos", "Edad", "Nota Media"};
            writer.writeNext(encabezado);
            for (Alumno alumno: alumnado){
                String [] fila = {alumno.getDni(), alumno.getNombre(), alumno.getApellido(),
                    String.valueOf(alumno.getEdad()), String.valueOf(alumno.getNotaMedia())};
                writer.writeNext(fila);
            }
            System.out.println("Fichero guardado con éxito");
        }
        catch (IOException e)
        {
            System.out.println("Error al escribir en el fichero " + e.getMessage());
        }
    }
    public static List<Alumno> cargarFichero(Path ruta)
    {
        List<Alumno> alumnos = new LinkedList<>();
        try (CSVReader reader = new CSVReader(Files.newBufferedReader(ruta))){
            reader.readNext();
            String [] nextLine;
            while ((nextLine = reader.readNext()) != null){
                if (nextLine.length >= 5) {
                    String dni = nextLine[0];
                    String nombre = nextLine[1];
                    String apellidos = nextLine[2];
                    String edad = nextLine[3];
                    String notaMedia = nextLine[4];
                    alumnos.add(new Alumno(dni, nombre, apellidos, Integer.parseInt(edad), Double.parseDouble(notaMedia)));
                } else {
                    System.out.println("Linea incompleta o malformada");
                }
            }
        }
        catch (IOException | CsvValidationException e)
        {
            System.out.println("Error de lectura del fichero Csv: " + e.getMessage());
        }
        return alumnos;
    }
    public static void main(String[] args) {
        // TODO code application logic here
        Path ruta = Path.of("recursos/alumnado.csv");
        int opcion;
        try
        {
        do 
        {
            System.out.println("--- SISTEMA DE GESTIÓN DE ALUMNADO ---");
            System.out.println("1.- Agregar alumno");
            System.out.println("2.- Mostrar todo el alumnado");
            System.out.println("3.- Buscar alumno por nombre");
            System.out.println("4.- Guardar información en fichero");
            System.out.println("5.- Cargar información del fichero");
            System.out.println("6.- Salir");
            System.out.println("Introduzca una opción:");
            opcion = sc.nextInt();
            
            switch(opcion)
            {
                case 1:
                    System.out.println("--- AGREGAR ALUMNO ---");
                    agregarAlumno();
                    break;
                case 2:
                    System.out.println("--- ALUMNADO ---");
                    mostrarAlumnos();
                    break;
                case 3:
                    System.out.println("--- BUSCAR ALUMNO ---");
                    buscarAlumno();
                    break;
                case 4:
                    System.out.println("Guardando fichero...");
                    guardarFichero(ruta);
                    break;
                case 5:
                    System.out.println("Descargando fichero....");
                    alumnado = cargarFichero(ruta);
                    break;
                case 6:
                    System.out.println("ADIOS!!!!");
                    break;
                default:
                    System.out.println("Ha seleccionado una opción incorrecta");
            }
                    
        } while (opcion!=6);
        } 
        catch (InputMismatchException e)
        {
            System.out.println("Tipo de dato incorrecto");
        }
    }
    
}
