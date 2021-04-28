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

/**
 *
 * @author raquel
 */
public class ServicioFicheroJSON {

    public static void creaArchivoJSON(String rutaArchivo, ArrayList<App> lista) throws IOException {

        ObjectMapper mapeador = new ObjectMapper();

        mapeador.configure(SerializationFeature.INDENT_OUTPUT, true);

        // Escribe en un fichero JSON la lista
        mapeador.writeValue(new File(rutaArchivo), lista);

    }

    public static void creaArchivoJSON(String rutaArchivo, App app) throws IOException {

        ObjectMapper mapeador = new ObjectMapper();

        mapeador.configure(SerializationFeature.INDENT_OUTPUT, true);

        // Escribe en un fichero JSON el catálogo de muebles
        mapeador.writeValue(new File(rutaArchivo), app);

    }

}
