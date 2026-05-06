/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package maquinariaindustrial.main;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import maquinariaindustrial.excepciones.ValorInvalidoException;
import maquinariaindustrial.model.Excavadora;
import maquinariaindustrial.model.Grua;
import maquinariaindustrial.model.Maquinaria;
import maquinariaindustrial.model.MontacargasElectrico;

/**
 *
 * @author USER
 */
public class MaquinariaIndustrial {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        List<Maquinaria> inventario = new ArrayList<>();
        inventario.add(new Excavadora(5.2, "EXC-001", "Caterpillar 320", 1500));
        inventario.add(new Grua(25, 120.5, "GRU-99", "Liebherr LTM", 800));
        inventario.add(new MontacargasElectrico(0.85, "MON-10", "Toyota Core", 200));
        
        Scanner sc = new Scanner(System.in);
        System.out.println("Introduce las horas para el alquiler: ");
        int horas = sc.nextInt();
        for (Maquinaria maquinaria : inventario)
        {
            try {
                maquinaria.mostrarFicha();
                System.out.println("Coste de alquiler: " + maquinaria.calcularPrecioAlquiler(horas) + "€");
                if (maquinaria instanceof MontacargasElectrico){
                    MontacargasElectrico provisional = (MontacargasElectrico) maquinaria;
                    provisional.avisoEco();
                    provisional.realizarCertificacionEnergetica();
                }
            } catch (ValorInvalidoException e) {
                System.out.println("Error en el cálculo: " + e.getMessage());
            }
        }
    }
    
}
