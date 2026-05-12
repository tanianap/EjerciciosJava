/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package techflowv4.model;

import java.util.List;

/**
 *
 * @author turita
 */
public class Empleado extends Colaborador{
    private double sueldoBase;
    private double bono;
    
    //Constructor

    public Empleado(double sueldoBase, double bono, String id, String nombre) {
        super(id, nombre);
        this.sueldoBase = sueldoBase;
        this.bono = bono;
    }
    
    //Getters y Setters

    public double getSueldoBase() {
        return sueldoBase;
    }

    public void setSueldoBase(double sueldoBase) {
        this.sueldoBase = sueldoBase;
    }

    public double getBono() {
        return bono;
    }

    public void setBono(double bono) {
        this.bono = bono;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<ActivoTecnologico> getListaActivos() {
        return listaActivos;
    }

    public void setListaActivos(List<ActivoTecnologico> listaActivos) {
        this.listaActivos = listaActivos;
    }
    
    //Métodos

    @Override
    public double calcularPago() {
        return sueldoBase + bono;
    }

    @Override
    public void realizarEvaluacion(int puntuaje) {
        ultimoPuntuaje = puntuaje;
    }

    @Override
    public boolean esAptoParaAscenso() {
        if (ultimoPuntuaje > 80){
            return true;
        }
        return false;
    }
    
}
