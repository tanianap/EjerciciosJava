/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejerciciosFicheros;

import java.io.Serializable;

/**
 *
 * @author turita
 */
public class Cliente implements Serializable{
    //Atributos
    private int id;
    private String nombre;
    private String telefono;
    
    //Constructor

    public Cliente(int id, String nombre, String telefono) {
        this.id = id;
        this.nombre = nombre;
        this.telefono = telefono;
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

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
    
    //Métodos
    public void mostrarInfo(){
        System.out.println("---- CLIENTE ----");
        System.out.println("ID: " + id);
        System.out.println("Nombre: " + nombre);
        System.out.println("Teléfono: " + telefono);
    }
}
