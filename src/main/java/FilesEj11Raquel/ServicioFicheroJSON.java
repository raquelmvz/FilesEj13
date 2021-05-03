/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FilesEj11Raquel;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author raquel
 */
public class ServicioFicheroJSON {

    /* Metodo que recibe un arraylist de Apps y una ruta de archivo
    y crea un archivo json */
    public static void creaArchivoJSON(String rutaArchivo, ArrayList<App> lista) {

        //objeto mapeador para configurar el archivo json
        ObjectMapper mapeador = new ObjectMapper();

        //el metodo configure --> para que la estructura este bien tabulada
        mapeador.configure(SerializationFeature.INDENT_OUTPUT, true);

        try {
            // Escribe en un fichero JSON la lista
            mapeador.writeValue(new File(rutaArchivo), lista);
        } catch (IOException ex) {
            Logger.getLogger(ServicioFicheroJSON.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Error");
        }

    }

    /* Metodo que recibe un App y una ruta de archivo
    y crea un archivo json */
    public static void creaArchivoJSON(String rutaArchivo, App app) {

        ObjectMapper mapeador = new ObjectMapper();

        mapeador.configure(SerializationFeature.INDENT_OUTPUT, true);

        try {
            // Escribe en un fichero JSON la lista
            mapeador.writeValue(new File(rutaArchivo), app);
        } catch (IOException ex) {
            Logger.getLogger(ServicioFicheroJSON.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Error");
        }

    }

}
