/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package empresacontenidodigital.model;

import empresacontenidodigital.interfaces.Descargable;

/**
 *
 * @author turita
 */
public class Podcast extends Contenido implements Descargable{
    private int oyentesPremiun;
    private double pagoPremiun;
    
    //COnstructor

    public Podcast(int oyentesPremiun, double pagoPremiun, String titulo, String autor, int visualizaciones) {
        super(titulo, autor, visualizaciones);
        this.oyentesPremiun = oyentesPremiun;
        this.pagoPremiun = pagoPremiun;
    }
    
    //Métodos

    @Override
    public double calcularIngresos() {
       return oyentesPremiun * pagoPremiun;
    }

    @Override
    public void tipoContenido() {
        System.out.println("Tipo: PODCAST");
    }

    @Override
    public void descargar() {
        System.out.println("El podcast es descargable");
    }
    
}
