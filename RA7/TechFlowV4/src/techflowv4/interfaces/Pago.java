/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package techflowv4.interfaces;

import techflowv4.excepciones.PresupuestoExcedidoException;

/**
 *
 * @author turita
 */
public interface Pago {
    void procesarPago(double monto) throws PresupuestoExcedidoException;
     
}
