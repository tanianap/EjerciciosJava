/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package techflowv4.model;

import java.util.ArrayList;
import java.util.List;
import techflowv4.excepciones.PresupuestoExcedidoException;
import techflowv4.interfaces.Evaluable;
import techflowv4.interfaces.Pago;

/**
 *
 * @author turita
 */
public abstract class Colaborador implements Pago, Evaluable {
    protected String id;
    protected String nombre;
    protected List<ActivoTecnologico> listaActivos;
    protected int ultimoPuntuaje;
    
    //Constructor

    public Colaborador(String id, String nombre) {
        this.id = id;
        this.nombre = nombre;
        this.listaActivos = new ArrayList<>();
    }
    
    public String getNombre() {
        return nombre;
    }

    //Getters y Setters
    public void setNombre(String nombre) {    
        this.nombre = nombre;
    }

    public abstract double calcularPago();
    
    public void agregarActivo(ActivoTecnologico activo){
        listaActivos.add(activo);
    }

    public void mostrarInfo(){
        System.out.println("------------------------------------");
        System.out.println("ID: " + id);
        System.out.println("Nombre: " + nombre);
        System.out.println("Tipo: " + this.getClass().getSimpleName());
        StringBuilder sb = new StringBuilder();
        sb.append("Lista de Activos: ");
        if (listaActivos.isEmpty()){
            sb.append("ninguno");
        } else {
            for (ActivoTecnologico activo : listaActivos){
                sb.append("\n").append(activo.getEquipo());
            }
        }
        System.out.println(sb);
    }
    @Override
    public void procesarPago(double monto) throws PresupuestoExcedidoException {
        if (monto > 5000){
            throw new PresupuestoExcedidoException("Presupuesto excedido");
        }
        System.out.println("Pago procesado correctamente " + String.format("%.2f", monto));
    }
    
    
}
