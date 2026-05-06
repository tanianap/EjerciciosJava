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
public class Grua  extends Maquinaria{
    private int tonelajeMaximo;
    private double tarifaFija;
    
    //Constructor
    
    public Grua(int tonelajeMaximo, double tarifaFija, String numeroSerie, String modelo, int horasDeUso) {
        super(numeroSerie, modelo, horasDeUso);
        this.tonelajeMaximo = tonelajeMaximo;
        this.tarifaFija = tarifaFija;
    }

    @Override
    public double calcularPrecioAlquiler(int horasSolicitadas) throws ValorInvalidoException{
        return (horasSolicitadas * tarifaFija) + (tonelajeMaximo * 2);
    }
    
}
