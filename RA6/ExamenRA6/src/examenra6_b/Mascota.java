/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package examenra6_b;

/**
 *
 * @author turita
 */
public class Mascota {
    //Atributos
    private int id;
    private String nombre;
    private String especie;
    private int edad;
    private boolean estado;
    
    //Constructor

    public Mascota(int id, String nombre, String especie, int edad) {
        this.id = id;
        this.nombre = nombre;
        this.especie = especie;
        this.edad = edad;
        this.estado = true;
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

    public String getEspecie() {
        return especie;
    }

    public void setEspecie(String especie) {
        this.especie = especie;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }
    
    //Métodos
    public void mostrarInfo(){
        System.out.println("--- MASCOTA ---");
        System.out.println("ID: " + id);
        System.out.println("Nombre: " + nombre);
        System.out.println("Especie: " + especie);
        System.out.println("Edad: " + edad);
        System.out.print("Estado: " );
        if (estado){
            System.out.println(" Consulta");
        } else {
            System.out.println(" Dada de Alta");
        }
    }
}
