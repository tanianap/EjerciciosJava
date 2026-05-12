/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package hiringcorev5.main;

import hiringcorev5.excepciones.PresupuestoExcedidoException;
import hiringcorev5.model.Externo;
import hiringcorev5.model.Interno;
import hiringcorev5.model.Recurso;
import hiringcorev5.model.Socio;
import hiringcorev5.model.TipoEquipo;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 *
 * @author turita
 */
public class PrincipalHiringCoreV5 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Externo externo = new Externo(10, 45, "SE1", "Francisco Bartolome");
        Interno interno = new Interno(5000, 300, "SI1", "Coral Bartolome");
        externo.agregarRecurso(new Recurso(TipoEquipo.LAPTOP, "LAPDELL01"));
        externo.agregarRecurso(new Recurso(TipoEquipo.LICENCIA_SOFTWARE, "LS1"));
        interno.agregarRecurso(new Recurso(TipoEquipo.MONITOR, "MHP1"));
        interno.agregarRecurso(new Recurso(TipoEquipo.TECLADO_MECANICO, "TECLADO1"));
        
        
        List<Socio> socios =  new ArrayList<>();
        
        socios.add(interno);
        socios.add(externo);
        Random random = new Random();
        for (Socio socio : socios){
            socio.mostrarInfo();
            socio.evaluarDesempenio(random.nextInt(0, 101));
            socio.calcularCompensacion();
            try {
                socio.ejecutarPago(socio.calcularCompensacion());
                if (socio.verificarPromocion()){
                    System.out.println("El socio: " + socio.getNombre() + " es APTO para promoción");
                } else {
                    System.out.println("El socio: " + socio.getNombre() + " NO es APTO para promoción");
                }
            }
            catch (PresupuestoExcedidoException e){
                System.out.println("ERROR: " + e.getMessage());
            }
            finally {
                System.out.println("---- Registro procesado correctamente ---");
            }
            
        }
    }
    
}
