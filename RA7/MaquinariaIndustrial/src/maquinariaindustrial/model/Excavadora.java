/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package maquinariaindustrial.model;


/**
 *
 * @author USER
 */
public class Excavadora extends Maquinaria{
    private double consumoGasoil;
    
    //Constructor
    
    public Excavadora(double consumoGasoil, String numeroSerie, String modelo, int horasDeUso) {
        super(numeroSerie, modelo, horasDeUso);
        this.consumoGasoil = consumoGasoil;
    }

    @Override
    public double calcularPrecioAlquiler(int horasSolicitadas) {
        return (horasSolicitadas * consumoGasoil * 10) + 50;
    }
    
}
