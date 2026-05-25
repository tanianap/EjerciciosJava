/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejercicioBiblioteca2;

import java.io.Serializable;

/**
 *
 * @author turita
 */
public class Libro implements Serializable{
    //Atributos
    private String titulo;
    private String autor;
    private int anio;
    private String isbn;
    
    //Constructor

    public Libro(String titulo, String autor, int anio, String isbn) {
        this.titulo = titulo;
        this.autor = autor;
        this.anio = anio;
        this.isbn = isbn;
    }
    
    //Getters y Setters

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public int getAnio() {
        return anio;
    }

    public void setAnio(int anio) {
        this.anio = anio;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }
    
    //Métodos
    public void mostrarLibro(){
        System.out.println("--------- LIBRO ---------");
        System.out.println("Titulo: " + titulo);
        System.out.println("Autor: " + autor);
        System.out.println("Año: " + anio);
        System.out.println("ISBN: " + isbn);
    }
}

