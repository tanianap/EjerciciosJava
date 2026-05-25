/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ejercicioInventario;

import java.io.EOFException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

/**
 *
 * @author turita
 */
public class PrincipalProducto {

    /**
     * @param args the command line arguments
     */
    public static Scanner sc = new Scanner(System.in);
    public static Map<String, Set<Producto>> productos = new HashMap<>();
    public static Producto crearProducto(){
        System.out.println("Introduzca el id: ");
        int id = sc.nextInt();
        sc.nextLine();
        System.out.println("Introduzca el nombre: ");
        String nombre = sc.nextLine();
        System.out.println("Introduzca la categoria: ");
        String categoria = sc.nextLine();
        System.out.println("Introduzca el precio: ");
        double precio = sc.nextDouble();
        System.out.println("Introduzca el stock del producto: ");
        int stock = sc.nextInt();
        return (new Producto(id, nombre, categoria, precio, stock));
    }
    public static void agregarProductoSet(Producto producto){
        productos.computeIfAbsent(producto.getCategoria(), n -> new LinkedHashSet<>()).add(producto);
    }
    public static void mostrarProductos(){
        if (productos.isEmpty()){
            System.out.println("No hay productos que mostrar");
        } else {
            for (Map.Entry<String, Set<Producto>> entrada : productos.entrySet()){
                for (Producto producto : entrada.getValue()){
                    producto.mostrarProducto();
                }
            }
        }
    }
    public static void actualizarStock(){
        System.out.println("Introduzca el codigo del producto: ");
        int id = sc.nextInt();
        for (Map.Entry<String, Set<Producto>> entrada : productos.entrySet()){
            for (Producto producto : entrada.getValue()){
                if (producto.getId() == id){
                    System.out.println("El stock actual del producto: " + producto.getNombre() + " es de:" + producto.getStock());
                    System.out.println("Introduzca el nuevo stock: ");
                    int stock = sc.nextInt();
                    producto.setStock(stock);
                }
            }
        }
    }
    public static double calcularInventario(){
        double totalInventario = 0;
        for(Map.Entry<String, Set<Producto>> entrada : productos.entrySet()){
            for (Producto producto : entrada.getValue()){
                totalInventario += producto.getPrecio() * producto.getStock();
            }
        }
        return totalInventario;
    }
    public static void modificarProducto(){
        int opcion;
        System.out.println("Introduzca el id del producto:");
        int id = sc.nextInt();
        sc.nextLine();
        Producto productoEncontrado = null;
        String categoriaActual = null;
        for (Map.Entry<String, Set<Producto>> entrada : productos.entrySet()){
            for (Producto producto : entrada.getValue()){
                if (producto.getId()==id){
                    categoriaActual = entrada.getKey();
                    productoEncontrado = producto;
                    break;
                }
            }
        }
        if (productoEncontrado == null){
            System.out.println("No se ha encontrado el producto");
            return;
        }
        productos.get(categoriaActual).remove(productoEncontrado);
        do 
        {
            System.out.println("¿Qué desea modificar? ");
            System.out.println("1.- Modificar id");
            System.out.println("2.- Modificar nombre");
            System.out.println("3.- Modificar categoria");
            System.out.println("4.- Modificar precio");
            System.out.println("Introduzca una opción: ");
            opcion = sc.nextInt();
            sc.nextLine();
            switch (opcion)
            {
                case 1:
                    System.out.println("Nuevo ID:");
                    productoEncontrado.setId(sc.nextInt());
                    sc.nextLine();
                    break;
                case 2:
                    System.out.println("Nuevo nombre:");
                    productoEncontrado.setNombre(sc.nextLine());
                    break;
                case 3:
                    System.out.println("Nueva categoria:");
                    categoriaActual = sc.nextLine();
                    productoEncontrado.setCategoria(categoriaActual);
                    break;
                case 4:
                    System.out.println("Nuevo precio:");
                    productoEncontrado.setPrecio(sc.nextDouble());
                    break;
                case 5:
                    System.out.println("Volviendo al menú principal");
                    break;
                default:
                    System.out.println("La opción seleccionada es incorrecta");
                    
            }
        } while (opcion!=5);
        productos.computeIfAbsent(categoriaActual, k -> new LinkedHashSet<>())
             .add(productoEncontrado);

    System.out.println("Producto modificado correctamente.");
    }
    public static void cargarFichero(Path ruta){
        try (ObjectOutputStream oos = new ObjectOutputStream(Files.newOutputStream(ruta)))
        {
            oos.writeObject(productos);
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
                
            productos = (Map<String, Set<Producto>>) ois.readObject();                      
            
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
        Path ruta = Path.of("recursos/inventario.dat");
        leerFichero(ruta);
        do 
        {
            System.out.println("---- GESTIÓN DE INVENTARIO ----");
            System.out.println("1.- Agregar producto");
            System.out.println("2.- Listado de productos.");
            System.out.println("3.- Actualizar stock.");
            System.out.println("4.- Calcular valor total del inventario.");
            System.out.println("5.- Modificar producto.");
            System.out.println("6.- Guardar inventario.");
            System.out.println("7.- Salir");
            System.out.println("Introduzca una opción:");
            opcion = sc.nextInt();
            
            switch (opcion)
            {
                case 1:
                    System.out.println("---- AGREGAR PRODUCTO ----");
                    agregarProductoSet(crearProducto());
                    break;
                case 2:
                    System.out.println("---- LISTADO DE PRODUCTOS ----");
                    mostrarProductos();
                    break;
                case 3:
                    System.out.println("---- ACTUALIZAR STOCK ----");
                    actualizarStock();
                    break;
                case 4:
                    System.out.println("--- VALOR TOTAL INVENTARIO ---");
                    System.out.printf("El valor total del inventario es: %.2f€%n", calcularInventario());
                    break;
                case 5:
                    System.out.println("--- MODIFICACIÓN DEL PRODUCTO ---");
                    modificarProducto();
                    break;
                case 6:
                    System.out.println("Guardando inventario en fichero");
                    cargarFichero(ruta);
                    break;
                case 7:
                    System.out.println("Saliendo del sistema....");
                    break;
                default:
                    System.out.println("Ha introducido una opción incorrecta");   
                    
            }
        } while (opcion!=7);
    }
    
}
