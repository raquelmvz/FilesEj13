/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FilesEj11Raquel;

import static FilesEj11Raquel.ServicioFicheroJSON.creaArchivoJSON;
import static FilesEj11Raquel.ServicioFicheroTSV.creaArchivoTSV;
import static FilesEj11Raquel.ServicioFicheroTSV.creaDirectorio;
import static FilesEj11Raquel.ServicioFicheroXML.creaArchivoXML;
import java.io.IOException;
import java.util.ArrayList;
import javax.xml.bind.JAXBException;

/**
 *
 * @author raque
 */
public class Programa {
    
    public static void main(String[] args) throws IOException, JAXBException {
        
        ArrayList<App> listaApps = new ArrayList<>();
        
        for (int i = 0; i < 50; i++) {
            listaApps.add(App.generaObjetoAppAleatorio());
        }

        //creacion de los directorios
        creaDirectorio("appstsv");
        creaDirectorio("appsxml");
        creaDirectorio("appsjson");
        creaDirectorio("copias");
        creaDirectorio("aplicaciones");

        //archivo tsv en su directorio
        creaArchivoTSV("./appstsv/aplicaciones.tsv", listaApps);

        //archivo json en su directorio
        creaArchivoJSON("./appsjson/aplicaciones.json", listaApps);

        //archivos json por cada app
        for (int i = 0; i < listaApps.size(); i++) {
            creaArchivoJSON("./aplicaciones/" + listaApps.get(i).getNombre() + ".json", listaApps.get(i));
        }

        //archivo xml
        creaArchivoXML("./appsxml/aplicaciones.xml", listaApps);
    }
    
}
