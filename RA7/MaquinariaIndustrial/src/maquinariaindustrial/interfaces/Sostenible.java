/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package maquinariaindustrial.interfaces;

/**
 *
 * @author USER
 */
public interface Sostenible {
    
    abstract void realizarCertificacionEnergetica();
    
    default void avisoEco(){
        System.out.println("Este equipo cumple con normativas de baja emisión");
    }
    
    static boolean emisionValida(double emision){
        if (emision > 0){
            return true;
        } 
        return false;
    }
}
