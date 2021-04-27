/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FilesEj11Raquel;

import static FilesEj11Raquel.ServicioFicheroTSV.creaArchivoTSV;
import java.util.ArrayList;

/**
 *
 * @author raque
 */
public class PruebaMain {

    public static void main(String[] args) {

        ArrayList<App> listaApps = new ArrayList<>();

        for (int i = 0; i < 20; i++) {
            listaApps.add(App.generaObjetoAppAleatorio());
        }

        creaArchivoTSV("./ficheros/listaAplicaciones.tsv", listaApps);
    }

}
