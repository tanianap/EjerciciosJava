/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ejercicioEmpleado;

import java.io.EOFException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/**
 *
 * @author turita
 */
public class PrincipalEmpleado {

    /**
     * @param args the command line arguments
     */
    public static Scanner sc = new Scanner(System.in);
    public static Map<String, List<Empleado>> empleados = new HashMap<>();
    public static Empleado agregarEmpleados(){
        System.out.println("Introduzca el id: ");
        int id = sc.nextInt();
        sc.nextLine();
        System.out.println("Introduzca el nombre: ");
        String nombre = sc.nextLine();
        System.out.println("Introduzca el salario: ");
        float salario = sc.nextFloat();
        sc.nextLine();
        System.out.println("Introduzca el departamento: ");
        String departamento = sc.nextLine().toUpperCase();
        return (new Empleado(id, nombre, salario,departamento));
    }
    public static void agregar(Empleado empleado){
        empleados.computeIfAbsent(empleado.getDepartamento(), n -> new ArrayList<>()).add(empleado);
    }
    public static void mostrarEmpleados(){
        sc.nextLine();
        System.out.println("Introduce el departamento: ");
        String departamento = sc.nextLine().toUpperCase();
        if (empleados.containsKey(departamento)){
            System.out.println("Empleados en el departamento: " + departamento);
            empleados.get(departamento).forEach(n -> n.mostrarEmpleado());
        } else {
            System.out.println("No existe empleados en ese departamento");
        }
    }
    public static void aumentarSalario(){
        System.out.println("Introduzca el porcentaje en entero: ");
        int porcentaje = sc.nextInt();
        for (Map.Entry<String, List<Empleado>> entrada : empleados.entrySet()){
            entrada.getValue().forEach(n -> n.aumentarSalario(porcentaje));
        }
        System.out.println("Se ha aumentado el salario de todos los empleados.");
    }
    public static void encontrarSalarioMax(){
        Empleado emp = empleados.values().stream().flatMap(List::stream).max(Comparator.comparing(Empleado::getSalario)).orElse(null);
        if (emp != null) {
            System.out.println("El empleado que más gana es: ");
            emp.mostrarEmpleado();
        } else {
            System.out.println("No hay empleados registrados.");
        }
    }
    public static void cargarFichero(Path ruta){
        System.out.println("Introduce el valor del salario:");
        double salario = sc.nextDouble();
        try (ObjectOutputStream oos = new ObjectOutputStream(Files.newOutputStream(ruta)))
        {
            for (Map.Entry<String, List<Empleado>> entrada : empleados.entrySet()){
                for (Empleado empleado : entrada.getValue()){
                    if (empleado.getSalario() >= salario){
                        oos.writeObject(empleado);
                    }
                }
            }
            System.out.println("Fichero escrito correctamente");
        }
        catch (IOException e)
        {
            System.out.println("Error de escritura del fichero");
        }
    }
    public static void leerFichero(Path ruta){
        try (ObjectInputStream ois = new ObjectInputStream(Files.newInputStream(ruta)))
        {
            while (true) {
                try {
                    Empleado empleado = (Empleado) ois.readObject();
                    empleado.mostrarEmpleado();
                }
                catch (EOFException e)
                {
                    break;
                }
            }
        }
        catch (NoSuchFileException e)
        {
            System.out.println("No se ha encontrado el fichero");
        }
        catch (IOException e)
        {
            System.out.println("Error de lectura del fichero");
        }
        catch (ClassNotFoundException e)
        {
            System.out.println("No se ha encontrado la clase");
        }
    }
    public static void main(String[] args) {
        // TODO code application logic here
        int opcion;
        Path ruta = Path.of("recursos/salarios_altos.dat");
        do
        {
            System.out.println("--- GESTIÓN DE EMPLEADOS ---");
            System.out.println("1.- Agregar empleados.");
            System.out.println("2.- Mostrar todos los empleados por departamento");
            System.out.println("3.- Aumentar salario de todos.");
            System.out.println("4.- Encontrar empleado con mayor salario.");
            System.out.println("5.- Crear fichero con mayores sueldos");
            System.out.println("6.- Leer Fichero.");
            System.out.println("7.- Salir.");
            System.out.println("Introduzca una opción: ");
            opcion = sc.nextInt();
            
            switch (opcion)
            {
                case 1:
                    System.out.println("--- AGREGAR EMPLEADOS ---");
                    agregar(agregarEmpleados());
                    break;
                case 2:
                    System.out.println("--- LISTADO DE EMPLEADOS ---");
                    mostrarEmpleados();
                    break;
                case 3:
                    System.out.println("--- AUMENTAR SALARIO ---");
                    aumentarSalario();
                    break;
                case 4:
                    System.out.println("--- SALARIO MAS ALTO ---");
                    encontrarSalarioMax();
                    break;
                case 5:
                    System.out.println("Creando fichero....");
                    cargarFichero(ruta);
                    break;
                case 6:
                    System.out.println("Leer Fichero");
                    leerFichero(ruta);
                    break;
                case 7:
                    System.out.println("ADIOS!!!");
                    break;
                default:
                    System.out.println("Ha seleccionado una opción incorrecta");
                   
            }
        } while(opcion!=7);
    }
    
}
