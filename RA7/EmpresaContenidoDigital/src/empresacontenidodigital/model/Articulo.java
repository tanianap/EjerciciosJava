/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package empresacontenidodigital.model;

import empresacontenidodigital.interfaces.Promocionable;

/**
 *
 * @author turita
 */
public class Articulo extends Contenido implements Promocionable{
    private double pagoPorVista;
    
    //Constructor

    public Articulo(double pagoPorVista, String titulo, String autor, int visualizaciones) {
        super(titulo, autor, visualizaciones);
        this.pagoPorVista = pagoPorVista;
    }
    
  
    @Override
    public double calcularIngresos() {
        return visualizaciones * pagoPorVista;
    }

    @Override
    public void aplicarPromocion(double porcentaje) {
        pagoPorVista += (pagoPorVista*porcentaje)/100;
    }

    @Override
    public void tipoContenido() {
        System.out.println("Tipo ARTICULO");
    }
    
    

  
    
}
