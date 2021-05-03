/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FilesEj12Raquel;

import static FilesEj12Raquel.Directorio.creaDirectorio;
import static FilesEj12Raquel.ServicioFicheroJSON.creaArchivoJSON;
import static FilesEj12Raquel.ServicioFicheroTSV.creaArchivoTSV;
import static FilesEj12Raquel.ServicioFicheroXML.creaArchivoXML;
import java.io.IOException;
import java.util.ArrayList;
import javax.xml.bind.JAXBException;

/**
 *
 * @author raque
 */
public class Programa {

    public static void main(String[] args) throws IOException, JAXBException {

        // Generacion de la lista de 50 apps
        ArrayList<App> listaApps = generaListaApps(50);

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

        //se crea un archivo json por cada app
        for (int i = 0; i < listaApps.size(); i++) {
            creaArchivoJSON("./aplicaciones/" + listaApps.get(i).getNombre() + ".json", listaApps.get(i));
        }

        //archivo xml
        creaArchivoXML("./appsxml/aplicaciones.xml", listaApps);
    }

    /* Metodo que genera una lista de apps dado un tamaño */
    public static ArrayList generaListaApps(int tam) {

        ArrayList<App> listaApps = new ArrayList<>();

        for (int i = 0; i < tam; i++) {
            //se usa el metodo de generar app aleatoria
            listaApps.add(App.generaObjetoAppAleatorio());
        }
        return listaApps;

    }

}
