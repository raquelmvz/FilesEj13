/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FilesEj13Raquel;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

/**
 *
 * @author raquel
 */
public class ServicioFicheroXML { //corregir lo de las fechas

    /* Metodo al que se le pasa una ruta de archivo y una lista de apps 
    y genera un fichero xml */
    public static void creaArchivoXML(String rutaArchivo, ArrayList<App> lista) {

        try {
            //se crea el objeto catalogoapp
            CatalogoAplicaciones catalogo = new CatalogoAplicaciones();
            //se incluye la lista de apps que se pasa por parametro
            catalogo.setListaAplicaciones(lista);

            catalogo.setDescripcion("Mi catalogo");

            // Crea el contexto JAXB. Se encarga de definir los objetos 
            // que vamos a guardar. En nuestro caso sólo el tipo CatalogoAplicaciones
            JAXBContext contexto = JAXBContext.newInstance(CatalogoAplicaciones.class);

            // El contexto JAXB permite crear un objeto Marshaller, que sirve para
            // generar la estructura del fichero XML 
            // El proceso de pasar objetos Java (CatalogoAplicaciones) a ficheros XML 
            // se conoce como "marshalling" o "serialización"
            Marshaller serializador = contexto.createMarshaller();

            // Especificamos que la propiedad del formato de salida
            // del serializador sea true, lo que implica que el formato se 
            // realiza con indentación y saltos de línea
            serializador.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

            // Llamando al método de serialización marshal (sobrecargado) se pueden
            // serializar objetos java en formato XML y volcarlos donde necesitemos:
            // consola, ficheros. El proceso consiste en que el contexto es el 
            // encargo de leer los objetos java, pasarlos al serializador y éste 
            // crear la salida de serialización
            // Serialización y salida por consola
            serializador.marshal(catalogo, System.out);

            // Volcado al fichero xml
            serializador.marshal(catalogo, new File(rutaArchivo));
            System.out.println("Archivo XML creado correctamente");

        } catch (JAXBException ex) {
            Logger.getLogger(ServicioFicheroXML.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Error");
        }

    }

    /* Metodo que permite leer el fichero XML */
    public static void leeArchivoXML(String rutaArchivo) {//que devuelva la lista

        try {

            // Crea el contexto JAXB 
            JAXBContext contexto = JAXBContext.newInstance(CatalogoAplicaciones.class);
            // Crea el objeto Unmarshaller
            Unmarshaller um = contexto.createUnmarshaller();

            // Llama al método de unmarshalling
            CatalogoAplicaciones catalogo = (CatalogoAplicaciones) um.unmarshal(new File(rutaArchivo));

            ArrayList<App> listaApps = catalogo.getListaAplicaciones();

            listaApps.forEach(System.out::println);

        } catch (JAXBException ex) {

            Logger.getLogger(ServicioFicheroXML.class.getName()).log(Level.SEVERE, null, ex);

        }
    }
}
