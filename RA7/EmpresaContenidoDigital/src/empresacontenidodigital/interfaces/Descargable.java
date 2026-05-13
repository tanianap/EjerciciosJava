/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package empresacontenidodigital.interfaces;

/**
 *
 * @author turita
 */
public interface Descargable {
    abstract void descargar();
    
    default void verificarEspacio(){
        System.out.println("Se está verificando el espacio disponible ");
    }
    
    static int tamanioMaximoPermitido(){
        return 500;
    }
}
