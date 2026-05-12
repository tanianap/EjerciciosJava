/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package techflowv4.main;

import java.util.ArrayList;
import java.util.List;
import techflowv4.excepciones.PresupuestoExcedidoException;
import techflowv4.model.ActivoTecnologico;
import techflowv4.model.Colaborador;
import techflowv4.model.Consultor;
import techflowv4.model.Empleado;
import techflowv4.model.TipoEquipo;

/**
 *
 * @author turita
 */
public class PrincipalTechFlowV4 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        List<Colaborador> colaboradores = new ArrayList<>();
        Consultor consultor = new Consultor(32, 12, "C101", "Miguel Bartolome");
        colaboradores.add(consultor);
        consultor.agregarActivo(new ActivoTecnologico(TipoEquipo.LAPTOP,"LAP-001"));
        consultor.agregarActivo(new ActivoTecnologico(TipoEquipo.MONITOR,"MON-001"));
        Empleado empleado = new Empleado(3000, 1500, "I101", "Carlos Valdes");
        colaboradores.add(empleado);
        
        for (Colaborador colaborador : colaboradores){
            colaborador.mostrarInfo();
            System.out.println(colaborador.calcularPago());
            try 
            {
                colaborador.procesarPago(colaborador.calcularPago());
            }
            catch (PresupuestoExcedidoException e){
                System.out.println("Error: " + e.getMessage());
            } finally {
                System.out.println("--- Proceso Completado ---");
            }
        }
        
        empleado.realizarEvaluacion(90);
        consultor.realizarEvaluacion(40);
        
        for (Colaborador colaborador : colaboradores){
            if (colaborador.esAptoParaAscenso()){
                System.out.println("El colaborador " + colaborador.getNombre() + " es apto para un ascenso");
            } else {
                System.out.println("El colaborador " + colaborador.getNombre() + " NO es apto para un ascenso" );
            }
        }
   
    }
    
}
