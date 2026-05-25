/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package examenra6_b;

/**
 *
 * @author turita
 */
public class Vuelo implements Comparable<Vuelo>{
    //Atributos
    private String aerolinea;
    private double precio;
    private int duracionMinutos;
    
    //Constructor

    public Vuelo(String aerolinea, double precio, int duracionMinutos) {
        this.aerolinea = aerolinea;
        this.precio = precio;
        this.duracionMinutos = duracionMinutos;
    }
    
    //Getters y Setters

    public String getAerolinea() {
        return aerolinea;
    }

    public void setAerolinea(String aerolinea) {
        this.aerolinea = aerolinea;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getDuracionMinutos() {
        return duracionMinutos;
    }

    public void setDuracionMinutos(int duracionMinutos) {
        this.duracionMinutos = duracionMinutos;
    }
    
    //Métodos
    public void mostrarInfo(){
        System.out.println("Aerolinea: " + aerolinea + ", precio: " + precio + ", duracion: " + duracionMinutos);
    }

    @Override
    public int compareTo(Vuelo v) {
        return Double.compare(precio, v.precio);
    }
}
