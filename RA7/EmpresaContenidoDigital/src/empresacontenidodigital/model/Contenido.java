/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package empresacontenidodigital.model;

/**
 *
 * @author turita
 */
public abstract class Contenido {
    protected String titulo;
    protected String autor;
    protected int visualizaciones;
    
    //Constructor

    public Contenido(String titulo, String autor, int visualizaciones) {
        this.titulo = titulo;
        this.autor = autor;
        this.visualizaciones = visualizaciones;
    }
    
    //Getters

    public String getTitulo() {
        return titulo;
    }

    public String getAutor() {
        return autor;
    }

    public int getVisualizaciones() {
        return visualizaciones;
    }
    
    //Métodos
    public void mostrarResumen(){
        System.out.println("Título: " + titulo);
        System.out.println("Autor: " + autor);
        System.out.println("Visualizaciones: " + visualizaciones);
    }
    
    public abstract double calcularIngresos();
    
    public abstract void tipoContenido();
}
