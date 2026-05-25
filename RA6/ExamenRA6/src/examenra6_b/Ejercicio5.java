/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package examenra6_b;

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
        List<String> correos = List.of( "ana@empresa.com","luis@gmail.com", "marta@empresa.com", "pedro@yahoo.com","carlos@empresa.com","correo_invalido", "test@empresa");
        List<String> correosValidos = new ArrayList<>();
        String regex = "^[\\w.-]+@[\\w.]+\\.[a-z]{2,}$";
        Pattern pattern = Pattern.compile(regex);
        for (String correo : correos){
            Matcher matcher = pattern.matcher(correo);
            if (matcher.matches()){
                correosValidos.add(correo);
            }
        }
        
        System.out.println("Correos Corporativos: ");
        for (String correo : correosValidos){
            System.out.println(correo);
        }
        
        System.out.println("\n Hay un total de: " + correosValidos.size() + " correos corporativos");
    }
    
}
