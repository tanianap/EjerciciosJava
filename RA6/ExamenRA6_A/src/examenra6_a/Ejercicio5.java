/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package examenra6_a;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author turita
 */
public class Ejercicio5 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        List<String> codigos = List.of("RT8822P","ABC1234D","PR1234X","AA0000B","pr1234x","ZZ9999Z");
        List<String> codigosValidos = new ArrayList<>();
        List<String> codigosInvalidos = new ArrayList<>();
        String regex ="([A-Z]{2}[0-9]{4}[A-Z])";
        Pattern pattern = Pattern.compile(regex);
        
        for (String codigo : codigos){
            Matcher matcher = pattern.matcher(codigo);
            if (matcher.matches()){
                 codigosValidos.add(codigo);
            }
            else {
                codigosInvalidos.add(codigo);
            }
        }
        
        System.out.println("Códigos Válidos:");
        for (String codigo : codigosValidos){
            System.out.println(codigo);
        }
        
        System.out.println("\nCódigos Inválidos:");
        for (String codigo : codigosInvalidos){
            System.out.println(codigo);
        }
        
    }
    
}
