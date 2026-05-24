/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package examenra6_a;

/**
 *
 * @author turita
 */
public class Vehiculo implements Comparable<Vehiculo> {
    //Atributos
    private String patente;
    private String marca;
    private double kilometraje;
    private boolean disponible;
    
    //Constructor

    public Vehiculo(String patente, String marca, double kilometraje, boolean disponible) {
        this.patente = patente;
        this.marca = marca;
        this.kilometraje = kilometraje;
        this.disponible = disponible;
    }
    
    //Getters y Setters

    public String getPatente() {
        return patente;
    }

    public void setPatente(String patente) {
        this.patente = patente;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public double getKilometraje() {
        return kilometraje;
    }

    public void setKilometraje(double kilometraje) {
        this.kilometraje = kilometraje;
    }

    public boolean isDisponible() {
        return disponible;
    }

    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }
    
    //Métodos
    public void mostrarInformacion(){
        System.out.println("------ VEHICULO ------");
        System.out.println("Patente: " + patente);
        System.out.println("Marca: " + marca);
        System.out.println("Kilometraje: " + kilometraje);
        System.out.println("Disponible: " + disponible);
    }

    @Override
    public int compareTo(Vehiculo otro) {
        return Double.compare(otro.kilometraje, kilometraje);
    }
}
