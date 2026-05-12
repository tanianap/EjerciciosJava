/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hiringcorev5.model;

import hiringcorev5.excepciones.PresupuestoExcedidoException;
import hiringcorev5.interfaces.Gestionable;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author turita
 */
public abstract class Socio implements Gestionable{
    protected String id;
    protected String nombre;
    protected List<Recurso> listaRecursos;
    protected int ultimaNota;
    
    //Constructor

    public Socio(String id, String nombre) {
        this.id = id;
        this.nombre = nombre;
        this.listaRecursos = new ArrayList<>();
    }
    
    //Getters y Setters

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    //Métodos
    public void mostrarInfo(){
        System.out.println("ID: " + id);
        System.out.println("Nombre: " + nombre);
        StringBuilder sb = new StringBuilder();
        sb.append("Lista de Recursos: ");
        if (listaRecursos.isEmpty()){
            sb.append("ninguno");
        } else {
            for (Recurso recurso :listaRecursos){
                sb.append(" \n").append(recurso.getCategoria());
            }
        }
        System.out.println(sb); 
    }   
    
    public abstract double calcularCompensacion();
    
    public void agregarRecurso(Recurso recurso){
        listaRecursos.add(recurso);
    }

    @Override
    public void evaluarDesempenio(int nota){
        ultimaNota = nota;
    }
    
    @Override
    public void ejecutarPago(double monto) throws PresupuestoExcedidoException {
        if (monto > 5000){
            throw new PresupuestoExcedidoException("Se ha superado el presupuesto");
        } else {
            System.out.println("Pago realizado correctamente");
        }
    }
}
