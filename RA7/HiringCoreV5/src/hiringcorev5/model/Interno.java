/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hiringcorev5.model;

import java.util.List;

/**
 *
 * @author turita
 */
public class Interno extends Socio{
    private double sueldoBase;
    private double complemento;
    
    //Constructor

    public Interno(double sueldoBase, double complemento, String id, String nombre) {
        super(id, nombre);
        this.sueldoBase = sueldoBase;
        this.complemento = complemento;
    }
    
    //Getters y Setters

    public double getSueldoBase() {
        return sueldoBase;
    }

    public void setSueldoBase(double sueldoBase) {
        this.sueldoBase = sueldoBase;
    }

    public double getComplemento() {
        return complemento;
    }

    public void setComplemento(double complemento) {
        this.complemento = complemento;
    }
    
    //Métodos

    @Override
    public double calcularCompensacion() {
        return sueldoBase + complemento;
    }

    @Override
    public boolean verificarPromocion() {
        if (ultimaNota > 85){
            return true;
        }
        return false;
    }
    
}
