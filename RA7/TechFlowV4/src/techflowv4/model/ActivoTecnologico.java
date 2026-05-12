/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package techflowv4.model;

/**
 *
 * @author turita
 */
public class ActivoTecnologico {
    private TipoEquipo equipo;
    private String inventario;
    
    //Constructor

    public ActivoTecnologico(TipoEquipo equipo, String inventario) {
        this.equipo = equipo;
        this.inventario = inventario;
    }
    
    //Getters y Setters

    public TipoEquipo getEquipo() {
        return equipo;
    }

    public void setEquipo(TipoEquipo equipo) {
        this.equipo = equipo;
    }

    public String getInventario() {
        return inventario;
    }

    public void setInventario(String inventario) {
        this.inventario = inventario;
    }
    
    //Métodos
    public void mostrarEquipo(){
        System.out.println("Equipo: " + equipo);
        System.out.println("Codigo de Inventario: " + inventario);
    }
}
