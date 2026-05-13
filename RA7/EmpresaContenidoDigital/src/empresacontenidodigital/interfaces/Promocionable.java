/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package empresacontenidodigital.interfaces;

/**
 *
 * @author turita
 */
public interface Promocionable {
    abstract void aplicarPromocion(double porcentaje);
    
    default void mostrarEstadoPromcion(){
        System.out.println("Su promoción está en proceso");
    }
    
    static boolean validarPorcentaje(double porcentaje){
        if (porcentaje > 0 && porcentaje<=100){
            return true;
        }
        return false;
    }
    
}
