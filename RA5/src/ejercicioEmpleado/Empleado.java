/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejercicioEmpleado;

import java.io.Serializable;

/**
 *
 * @author turita
 */
public class Empleado implements Serializable{
    // Atributos
    private int id;
    private String nombre;
    private float salario;
    private String departamento;
    
    // Constructor

    public Empleado(int id, String nombre, float salario, String departamento) {
        this.id = id;
        this.nombre = nombre;
        this.salario = salario;
        this.departamento = departamento;
    }
    
    // Getters y Setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public float getSalario() {
        return salario;
    }

    public void setSalario(float salario) {
        this.salario = salario;
    }

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }
    
    // Métodos
    public void mostrarEmpleado(){
        System.out.println("---- EMPLEADO ----");
        System.out.println("ID: " + id);
        System.out.println("Nombre: " + nombre);
        System.out.println("Salario: " + salario);
        System.out.println("Departamento: " + departamento);
    }
    
    public void aumentarSalario(int porcentaje){
        salario = salario + (salario * (porcentaje/100.0f));
    }
}

