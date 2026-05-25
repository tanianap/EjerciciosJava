/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejercicioClinica;

import java.time.LocalDate;

/**
 *
 * @author turita
 */
public class Paciente extends Persona{
    // Atributos
    
    protected double peso;
    protected double altura;
    protected String numeroHistorial;
    
    // Constructor
    
    public Paciente(double peso, double altura, String numeroHistorial, String nombre, String apellidos, String dni, LocalDate fechaNacimiento) {
        super(nombre, apellidos, dni, fechaNacimiento);
        this.peso = peso;
        this.altura = altura;
        this.numeroHistorial = numeroHistorial;
    }

    @Override
    public void mostrarInformacion() {
        System.out.println("Nombre: " + nombre);
        System.out.println("Apellidos: " + apellidos);
        System.out.println("DNI: " + dni);
        System.out.println("Fecha de Nacimiento: " + fechaNacimiento);
    }
    
}
