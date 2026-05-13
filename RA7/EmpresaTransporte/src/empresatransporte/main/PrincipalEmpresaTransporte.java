/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package empresatransporte.main;

import empresatransporte.excepciones.ConsumoInvalidoException;
import empresatransporte.model.Camion;
import empresatransporte.model.Coche;
import empresatransporte.model.MotoElectrica;
import empresatransporte.model.Vehiculo;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author turita
 */
public class PrincipalEmpresaTransporte {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Coche coche = new Coche(30, "Toyota", "Corolla", 80000);
        Camion camion = new Camion(1000, 8, "Ford", "FordExplorer", 200000);
        MotoElectrica moto = new MotoElectrica(60, "Hyunday", "modelo", 60000);
        
        List<Vehiculo> vehiculos = new ArrayList<>();
        vehiculos.add(coche);
        vehiculos.add(moto);
        vehiculos.add(camion);
        
        for (Vehiculo vehiculo : vehiculos){
            vehiculo.mostrarInfo();
            try {
                System.out.println("El costo  de recorrer 100 km es: " + vehiculo.calcularCostoViaje(100));
            } catch (ConsumoInvalidoException e) {
                System.out.println("ERROR: " + e.getMessage());
            }
            if (vehiculo instanceof MotoElectrica){
                MotoElectrica provisional = (MotoElectrica) vehiculo;
                provisional.estadoBateria();
                provisional.cargarBateria();
            }
        }
    }
    
}
