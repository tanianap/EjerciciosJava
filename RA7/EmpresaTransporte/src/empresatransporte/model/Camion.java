/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package empresatransporte.model;

import empresatransporte.excepciones.ConsumoInvalidoException;
import empresatransporte.interfaces.Electrico;

/**
 *
 * @author turita
 */
public class Camion extends Vehiculo{
    private double cargaMaxima;
    private double precioPorKm;
    
    //Constructor
    public Camion(double cargaMaxima, double precioPorKm, String marca, String modelo, double kilometros) {
        super(marca, modelo, kilometros);
        this.cargaMaxima = cargaMaxima;
        this.precioPorKm = precioPorKm;
    }

    @Override
    public double calcularCostoViaje(double km) throws ConsumoInvalidoException {
        if (!Electrico.consumoValido(precioPorKm)){
            throw new ConsumoInvalidoException("El precio por Km debe ser mayor que 0");
        }
        return km * precioPorKm + (cargaMaxima*0.1);
    }
    
}
