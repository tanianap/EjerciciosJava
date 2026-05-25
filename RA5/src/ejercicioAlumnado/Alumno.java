/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejercicioAlumnado;

/**
 *
 * @author turita
 */
public class Alumno {
    //Atributos
    private String dni;
    private String nombre;
    private String apellido;
    private int edad;
    private double notaMedia;
    
    //Constructor

    public Alumno(String dni, String nombre, String apellido, int edad, double notaMedia) {
        this.dni = dni;
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.notaMedia = notaMedia;
    }
    
    //Getters y Setters

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public double getNotaMedia() {
        return notaMedia;
    }

    public void setNotaMedia(double notaMedia) {
        this.notaMedia = notaMedia;
    }
    
    //Métodos
    public void mostrarAlumno()
    {
        System.out.println("------- ALUMNO -------");
        System.out.println("DNI: " + dni);
        System.out.println("Nombre: " + nombre);
        System.out.println("Apellidos: " + apellido);
        System.out.println("Edad: " + edad);
        System.out.println("Nota media: " + notaMedia);
    }
}
