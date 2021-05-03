/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FilesEj12Raquel;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 *
 * @author raque
 */
public class Directorio {

    /* Metodo que crea un directorio dado un nombre */
    public static void creaDirectorio(String nombreDirectorio) {
        Path directory = Paths.get("./" + nombreDirectorio);

        try {
            Files.createDirectory(directory);
            System.out.println("Se ha creado el directorio " + nombreDirectorio);
        } catch (IOException e) {
            System.out.println("Problema creando el directorio.");
            System.out.println(e.toString());

        }
    }

}
