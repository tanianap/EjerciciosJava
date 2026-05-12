/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hiringcorev5.model;

/**
 *
 * @author USER
 */
public class Recurso {
    private TipoEquipo categoria;
    private String idCategoria;
    
    //COnstructor

    public Recurso(TipoEquipo categoria, String idCategoria) {
        this.categoria = categoria;
        this.idCategoria = idCategoria;
    }
    
    //Getters y Setters

    public TipoEquipo getCategoria() {
        return categoria;
    }

    public void setCategoria(TipoEquipo categoria) {
        this.categoria = categoria;
    }

    public String getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(String idCartegoria) {
        this.idCategoria = idCartegoria;
    }
    
    //Métodos
    public void mostrarInfo(){
        System.out.println("Tipo: " + categoria);
        System.out.println("ID categoria: " + idCategoria);
    }
}
