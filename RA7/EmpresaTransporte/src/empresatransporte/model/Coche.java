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
public class Coche extends Vehiculo{
    private double consumoCombustible;
    
    //Constructor

    public Coche(double consumoCombustible, String marca, String modelo, double kilometros) {
        super(marca, modelo, kilometros);
        this.consumoCombustible = consumoCombustible;
    }

    //Métodos
    @Override
    public double calcularCostoViaje(double km) throws ConsumoInvalidoException{
       if(!Electrico.consumoValido(consumoCombustible)){
           throw new ConsumoInvalidoException("Consumo inválido de combustible");
       }
        return km * consumoCombustible * 1.5;
    }
    
    
}
