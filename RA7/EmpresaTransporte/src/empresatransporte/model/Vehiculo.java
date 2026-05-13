/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package empresatransporte.model;

import empresatransporte.excepciones.ConsumoInvalidoException;

/**
 *
 * @author turita
 */
public abstract class Vehiculo {
    protected String marca;
    protected String modelo;
    protected double kilometros;
    
    //Constructor

    public Vehiculo(String marca, String modelo, double kilometros) {
        this.marca = marca;
        this.modelo = modelo;
        this.kilometros = kilometros;
    }
    
    //Métodos
    public void mostrarInfo(){
        System.out.println("----------------------------");
        System.out.println("Marca: " + marca);
        System.out.println("Modelo: " + modelo);
        System.out.println("Kilometros: " + kilometros);
    }
    
    public abstract double calcularCostoViaje(double km) throws ConsumoInvalidoException;
}
