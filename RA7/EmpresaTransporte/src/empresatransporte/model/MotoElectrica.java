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
public class MotoElectrica extends Vehiculo implements Electrico{
    private double consumoElectrico;
    
    //Constructor

    public MotoElectrica(double consumoElectrico, String marca, String modelo, double kilometros) {
        super(marca, modelo, kilometros);
        this.consumoElectrico = consumoElectrico;
    }
    

    @Override
    public double calcularCostoViaje(double km) throws ConsumoInvalidoException {
         if (!Electrico.consumoValido(consumoElectrico)){
            throw new ConsumoInvalidoException("El consumo debe ser mayor que 0");
        }
        return km *consumoElectrico * 0.2; 
    }

    @Override
    public void cargarBateria() {
        System.out.println("Cargando bateria. . .");
    }
}
