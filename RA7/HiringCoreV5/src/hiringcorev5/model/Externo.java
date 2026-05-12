/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hiringcorev5.model;

import hiringcorev5.excepciones.PresupuestoExcedidoException;
import java.util.List;

/**
 *
 * @author turita
 */
public class Externo extends Socio{
    private double precioHora;
    private int horasMes;
    
    //Constructor

    public Externo(double precioHora, int horasMes, String id, String nombre) {
        super(id, nombre);
        this.precioHora = precioHora;
        this.horasMes = horasMes;
    }
    
    //Getters y Setters

    public double getPrecioHora() {
        return precioHora;
    }

    public void setPrecioHora(double precioHora) {
        this.precioHora = precioHora;
    }

    public int getHorasMes() {
        return horasMes;
    }

    public void setHorasMes(int horasMes) {
        this.horasMes = horasMes;
    }
    
    //Métodos
    
    @Override
    public double calcularCompensacion() {
        return precioHora * horasMes;
    }
    
    public void actualizarTerminos(double nuevoPrecio){
        precioHora = nuevoPrecio;
    }
    
    public void actualizarTerminos(double nuevoPrecio, int horasExtras){
        precioHora = nuevoPrecio;
        horasMes += horasExtras;
    }

    @Override
    public boolean verificarPromocion() {
        if (ultimaNota > 90 && horasMes > 160){
            return true;
        }
        return false;
    }

    
    
}
