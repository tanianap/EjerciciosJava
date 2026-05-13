/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package empresacontenidodigital.main;

import empresacontenidodigital.interfaces.Descargable;
import empresacontenidodigital.interfaces.Promocionable;
import empresacontenidodigital.model.Articulo;
import empresacontenidodigital.model.Contenido;
import empresacontenidodigital.model.Podcast;
import empresacontenidodigital.model.Video;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author USER
 */
public class PrincipalEmpresaContenidoDigital {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        List<Contenido> contenidos = new ArrayList<>();
        Articulo articulo = new Articulo(0.02, "Las maravillas de Java", "James Gosling", 15000);
        Video video = new Video(25, 45.0, "Tutorial de Interfaces en Java", "TechFlow Academy", 1200000);
        Podcast podcast = new Podcast(850, 3.5, "Hablemos de Código", "DevTalks", 5000);
        
       contenidos.add(video);
       contenidos.add(articulo);
       contenidos.add(podcast);
       
       for (Contenido contenido : contenidos){
           contenido.tipoContenido();
           contenido.mostrarResumen();
           Descargable.tamanioMaximoPermitido();
           if (contenido instanceof Descargable){
               Descargable desc = (Descargable) contenido;
               desc.verificarEspacio();
           }
           if (contenido instanceof Promocionable){
               Promocionable prom = (Promocionable) contenido;
               prom.mostrarEstadoPromcion();
               if (Promocionable.validarPorcentaje(15)){
                   prom.aplicarPromocion(15);
               }
           }    
       }
    }
    
}
