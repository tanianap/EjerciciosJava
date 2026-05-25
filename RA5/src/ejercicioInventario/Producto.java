/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejercicioInventario;

import java.io.Serializable;

/**
 *
 * @author turita
 */
public class Producto implements Serializable{
    //Atributos
    private int id;
    private String nombre;
    private String categoria;
    private double precio;
    private int stock;
    
    //Constructor
    public Producto(int id, String nombre, String categoria, double precio, int stock) {
        this.id = id;
        this.nombre = nombre;
        this.categoria = categoria;
        this.precio = precio;
        this.stock = stock;
    }
    
    //Getters y Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }
    
    //Métodos
    public void mostrarProducto(){
        System.out.println("--- PRODUCTO ---");
        System.out.println("ID: " + id);
        System.out.println("Nombre: " + nombre);
        System.out.println("Categoria: " + categoria);
        System.out.println("Precio: " + precio);
        System.out.println("Stock: " + stock);
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 97 * hash + this.id;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Producto other = (Producto) obj;
        return this.id == other.id;
    }
    
    
}
