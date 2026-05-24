/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package examenra6_a;

/**
 *
 * @author turita
 */
public class Jugador implements Comparable<Jugador>{
    //Atributos
    private String nombre;
    private int puntos;
    private int nivel;
    
    //Constructor

    public Jugador(String nombre, int puntos, int nivel) {
        this.nombre = nombre;
        this.puntos = puntos;
        this.nivel = nivel;
    }
    
    //Getters y Setters

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getPuntos() {
        return puntos;
    }

    public void setPuntos(int puntos) {
        this.puntos = puntos;
    }

    public int getNivel() {
        return nivel;
    }

    public void setNivel(int nivel) {
        this.nivel = nivel;
    }
    
    //Métodos
    public void mostrarInformacion(){
        System.out.println(nombre + " - " + puntos + " puntos - nivel " + nivel );
    }

    @Override
    public int compareTo(Jugador o) {
        return Integer.compare(nivel, o.nivel);
    }
}
