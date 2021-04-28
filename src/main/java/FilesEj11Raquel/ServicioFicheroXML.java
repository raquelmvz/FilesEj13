/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FilesEj11Raquel;

import java.util.ArrayList;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;

/**
 *
 * @author raquel
 */
public class ServicioFicheroXML {

    public static void creaArchivoXML(String rutaArchivo, ArrayList<App> lista) throws JAXBException {

        CatalogoAplicaciones catalogo = new CatalogoAplicaciones();
        catalogo.setListaAplicaciones(lista);
        catalogo.setDescripcion("Mi catalogo");

        // Crea el contexto JAXB. Se encarga de definir los objetos 
        // que vamos a guardar. En nuestro caso sólo el tipo CatalogoAplicaciones
        JAXBContext contexto = JAXBContext.newInstance(CatalogoAplicaciones.class);

    }

}
