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
public class Consultor extends Colaborador{
    private int horasTrabajadas;
    private double tarifaHora;
    
    //Constructor

    public Consultor(int horasTrabajadas, double tarifaHora, String id, String nombre) {
        super(id, nombre);
        this.horasTrabajadas = horasTrabajadas;
        this.tarifaHora = tarifaHora;
    }
    
    // Getters y Setters

    public int getHorasTrabajadas() {
        return horasTrabajadas;
    }

    public void setHorasTrabajadas(int horasTrabajadas) {
        this.horasTrabajadas = horasTrabajadas;
    }

    public double getTarifaHora() {
        return tarifaHora;
    }

    public void setTarifaHora(double tarifaHora) {
        this.tarifaHora = tarifaHora;
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
       return horasTrabajadas * tarifaHora;
    }
    
    public void actualizarTarifa(double nuevaTarifa){
        tarifaHora = nuevaTarifa;
    }
    
    public void actulizarTarifaHorasExtras(double nuevaTarifa, int horasExtras){
        tarifaHora = nuevaTarifa;
        horasTrabajadas += horasExtras;
    }

    @Override
    public void realizarEvaluacion(int puntuaje) {
        ultimoPuntuaje = puntuaje;
    }

    @Override
    public boolean esAptoParaAscenso() {
        if (ultimoPuntuaje > 90 && horasTrabajadas > 150){
            return true;
        } 
        return false;
    }
    
}
