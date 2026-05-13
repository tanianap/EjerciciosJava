/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package empresatransporte.interfaces;

/**
 *
 * @author turita
 */
public interface Electrico {
    void cargarBateria();
    
    default void estadoBateria(){
        System.out.println("Estado Saludable de la batería");
    }
    
    static boolean consumoValido(double consumo){
        if (consumo > 0){
            return true;
        } else {
            return false;
        }
    }
}
