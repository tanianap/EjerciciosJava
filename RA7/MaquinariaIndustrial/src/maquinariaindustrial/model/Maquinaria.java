/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package maquinariaindustrial.model;

import maquinariaindustrial.excepciones.ValorInvalidoException;

/**
 *
 * @author turita
 */
public abstract class Maquinaria {
    //Atributos
    protected String numeroSerie;
    protected String modelo;
    protected int horasDeUso;
    
    //Constructor

    public Maquinaria(String numeroSerie, String modelo, int horasDeUso) {
        this.numeroSerie = numeroSerie;
        this.modelo = modelo;
        this.horasDeUso = horasDeUso;
    }
    
    //Métodos
    public void mostrarFicha(){
        System.out.println("----- MAQUINARIA -----");
        System.out.println("Numero Serie: " + numeroSerie);
        System.out.println("Modelo: " + modelo);
        System.out.println("Horas de uso: " + horasDeUso);
    }
    
    public abstract double calcularPrecioAlquiler(int horasSolicitadas) throws ValorInvalidoException;
}
