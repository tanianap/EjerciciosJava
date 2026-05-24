/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package examenra6_a;

import java.util.List;

/**
 *
 * @author turita
 */
public class Camion {
    // Atributos
    private int id;
    private List<Double> lista;
    
    //Constructor

    public Camion(int id, List<Double> lista) {
        this.id = id;
        this.lista = lista;
    }
    
    //Getters y Setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<Double> getLista() {
        return lista;
    }

    public void setLista(List<Double> lista) {
        this.lista = lista;
    }
    
    //Métodos
    public void mostrarInfo(){
        System.out.println("ID: " + id);
        System.out.println("Lista de paquetes: ");
    }
}
