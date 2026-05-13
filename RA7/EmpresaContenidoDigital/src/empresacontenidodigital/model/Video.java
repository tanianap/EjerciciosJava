/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package empresacontenidodigital.model;

import empresacontenidodigital.interfaces.Descargable;
import empresacontenidodigital.interfaces.Promocionable;

/**
 *
 * @author turita
 */
public class Video extends Contenido implements Promocionable, Descargable{
    private int duracionMinutos;
    private double ingresoPorAnuncio;
    
    //Constructor

    public Video(int duracionMinutos, double ingresoPorAnuncio, String titulo, String autor, int visualizaciones) {
        super(titulo, autor, visualizaciones);
        this.duracionMinutos = duracionMinutos;
        this.ingresoPorAnuncio = ingresoPorAnuncio;
    }

    @Override
    public double calcularIngresos() {
        return (visualizaciones/100)*ingresoPorAnuncio;
    }

    @Override
    public void tipoContenido() {
        System.out.println("Tipo VIDEO");
    }

    @Override
    public void aplicarPromocion(double porcentaje) {
        ingresoPorAnuncio += (ingresoPorAnuncio*porcentaje)/100;
    }

    @Override
    public void descargar() {
        System.out.println("El video es DESCARGABLE");
    }

    @Override
    public void mostrarEstadoPromcion(){
        System.out.println("El video ha sido promocionado");
    }
    
    
}
