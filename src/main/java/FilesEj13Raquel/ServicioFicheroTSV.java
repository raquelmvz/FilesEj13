/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FilesEj13Raquel;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

/**
 *
 * @author raque
 */
public class ServicioFicheroTSV {

    /* Metodo al que se le pasa una ruta de archivo y una lista de Apps
    y genera un fichero TSV */
    public static void creaArchivoTSV(String rutaArchivo, ArrayList<App> lista) {

        creaFicheroVacio(rutaArchivo);
        escribeEnFichero(rutaArchivo, lista);

    }

    /* Metodo que genera un fichero vacio */
    private static void creaFicheroVacio(String ruta) {

        //Path file = Paths.get(ruta, "/" + nombreFichero + ".tsv");
        Path file = Paths.get(ruta);

        try {
            // Este método no crea el archivo si ya existe
            Files.createFile(file);
        } catch (IOException e) {
            System.out.println("Problema creando el archivo.");
            System.out.println(e.toString());
        }

    }

    /* Metodo que recibe una ruta de archivo y una lista de Apps 
    y escribe en el archivo los elementos de la lista */
    private static void escribeEnFichero(String ruta, ArrayList<App> lista) {

        String idFichero = ruta;//ruta del fichero

        try (BufferedWriter flujo = new BufferedWriter(new FileWriter(idFichero))) {

            flujo.write("CODIGO UNICO\tNOMBRE\tDESCRIPCION\tTAMAÑO KB\tFECHA CREACION");
            flujo.newLine();
            for (App aplic : lista) {

                flujo.write(aplic.toString());
                flujo.newLine();

            }
            flujo.flush(); //para forzar el guardado

            System.out.println(idFichero + " se ha creado");
        } catch (IOException e) {

            System.out.println(e.getMessage());
        }

    }

}
