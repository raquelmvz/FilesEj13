/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FilesEj11Raquel;

import static FilesEj11Raquel.ServicioFicheroJSON.creaArchivoJSON;
import static FilesEj11Raquel.ServicioFicheroTSV.creaArchivoTSV;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author raque
 */
public class PruebaMain {

    public static void main(String[] args) throws IOException {

        ArrayList<App> listaApps = new ArrayList<>();

        for (int i = 0; i < 20; i++) {
            listaApps.add(App.generaObjetoAppAleatorio());
        }

        creaArchivoTSV("./ficheros/listaAplicaciones.tsv", listaApps);
        
        
        creaArchivoJSON("./ficheros/listaApps.json", listaApps);
        
        for (int i = 0; i < listaApps.size(); i++) {
            creaArchivoJSON("./ficheros/"+listaApps.get(i).getNombre()+".json", listaApps.get(i));
        }
    }

}
