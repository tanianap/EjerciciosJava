/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package examenra6_b;

/**
 *
 * @author turita
 */
public class Estudiante {
    //Atributos
    private String nombre;
    private double nota;
    
    //Constructor

    public Estudiante(String nombre, double nota) {
        this.nombre = nombre;
        this.nota = nota;
    }
    
    //Getters y Setters

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getNota() {
        return nota;
    }

    public void setNota(double nota) {
        this.nota = nota;
    }
    
    //Métodos
    public void mostrarInfo(){
        System.out.println("Nombre: " + nombre + ", nota: " + nota);
    }
}
