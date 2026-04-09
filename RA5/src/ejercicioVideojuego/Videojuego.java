/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejercicioVideojuego;

import java.io.Serializable;

/**
 *
 * @author turita
 */
public class Videojuego implements Serializable{
    // Atributos
    private String id;
    private String titulo;
    private String plataforma;
    private int stock;
    
    // Constructor

    public Videojuego(String id, String titulo, String plataforma, int stock) {
        this.id = id;
        this.titulo = titulo;
        this.plataforma = plataforma;
        this.stock = stock;
    }
    
    // Getters y Setters

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getPlataforma() {
        return plataforma;
    }

    public void setPlataforma(String plataforma) {
        this.plataforma = plataforma;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }
    
    // Métodos
    public void mostrarVideojuego(){
        System.out.println("--- VIDEOJUEGO ---");
        System.out.println("ID: " + id);
        System.out.println("Titulo: " + titulo);
        System.out.println("Plataforma: " + plataforma);
        System.out.println("Stock: " + stock);
    }
    
}
