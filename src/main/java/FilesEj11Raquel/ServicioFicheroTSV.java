/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FilesEj11Raquel;

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

    public static void creaArchivoTSV(String rutaArchivo, ArrayList<App> lista) {

        //File fichero = new File("./" + ruta);
        //creaDirectorio(nomDirectorio);
        creaFicheroVacio(rutaArchivo);
        escribeEnFichero(rutaArchivo, lista);

    }

//    public static void creaDirectorio(String nombreDirectorio) {
//        Path directory = Paths.get("./" + nombreDirectorio);
//
//        try {
//            Files.createDirectory(directory);
//        } catch (IOException e) {
//            System.out.println("Problema creando el directorio.");
//            System.out.println(e.toString());
//
//        }
//    }
    public static void creaFicheroVacio(String ruta) {

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

    public static void escribeEnFichero(String ruta, ArrayList<App> lista) {

        String idFichero = ruta;//ruta del fichero

        try (BufferedWriter flujo = new BufferedWriter(new FileWriter(idFichero))) {

            flujo.write("CODIGO UNICO\tNOMBRE\tDESCRIPCION\tTAMAÑO KB\tFECHA CREACION");
            flujo.newLine();
            for (App aplic : lista) {

                flujo.write(aplic.toString());
                flujo.newLine();

            }

            System.out.println(idFichero + " se ha creado");
        } catch (IOException e) {

            System.out.println(e.getMessage());
        }

    }

    public static void listarDirectorio(String ruta) {

        File f = new File(ruta);

        if (f.exists()) {
            File[] ficheros = f.listFiles();
            for (File file2 : ficheros) {
                System.out.println(file2.getName());
            }
        } else {
            System.out.println("El directorio a listar no existe");
        }
    }

//    public static void main(String[] args) {
//
//        creaArchivoTSV("ficheros", "./ficheros", "ficheroprueba111", "./ficheros/ficheroprueba111.tsv", listaApps);
//    }
}
