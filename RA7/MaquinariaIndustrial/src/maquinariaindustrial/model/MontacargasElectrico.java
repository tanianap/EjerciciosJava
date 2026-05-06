/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package maquinariaindustrial.model;

import maquinariaindustrial.excepciones.ValorInvalidoException;
import maquinariaindustrial.interfaces.Sostenible;

/**
 *
 * @author turita
 */
public class MontacargasElectrico extends Maquinaria implements Sostenible {
    private double coeficienteEficiencia;
    
    //Constructor
    public MontacargasElectrico(double coeficienteEficiencia, String numeroSerie, String modelo, int horasDeUso) {
        super(numeroSerie, modelo, horasDeUso);
        this.coeficienteEficiencia = coeficienteEficiencia;
    }

    @Override
    public double calcularPrecioAlquiler(int horasSolicitadas) throws ValorInvalidoException{
        if (!Sostenible.emisionValida(coeficienteEficiencia)) {
            throw new ValorInvalidoException("La emisión introducida no es válida");
        }
        return (horasSolicitadas * coeficienteEficiencia * 5.5);
    }

    @Override
    public void realizarCertificacionEnergetica() {
        System.out.println("Certificación completada: El montacargas cumple con la normativa de eficiencia energética.");
    }
    
    
    
}
