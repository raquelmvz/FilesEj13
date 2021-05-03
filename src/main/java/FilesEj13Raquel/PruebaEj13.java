/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FilesEj13Raquel;

import static FilesEj13Raquel.ServicioFicheroJSON.leeFicheroJSONApp;
import java.io.File;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 *
 * @author raque
 */
public class PruebaEj13 {

    static Scanner entradaTeclado = new Scanner(System.in);

    public static void main(String[] args) {

        //listado de ficheros
        ArrayList<String> listaFicheros = listarDirectorio("./aplicaciones");
        //eleccion de uno de los ficheros
        int indiceFicheroElegido = eligeEnLaLista(listaFicheros);
        //lectura del fichero y creacion de un objeto app
        //con la informacion leida
        //usamos el metodo creado en ServicioFicheroJSON

        //App aplicacionLeida = leeFicheroJSONApp(listaFicheros.get(indiceFicheroElegido));
        //se muestra la app por pantalla
        //System.out.println("\n--------------------------------------\n"
        //        + "INFORMACION SOBRE LA APP LEIDA:");
        //aplicacionLeida.toString();
    }

    /* Metodo al que se le pasa una ruta y permite listar los ficheros que contiene
    junto con un indice numerico para facilitar la seleccion por parte del usuario 
    Devuelve una listaFicheros con las rutas de las aplicaciones */
    public static ArrayList<String> listarDirectorio(String ruta) {

        File f = new File(ruta);
        ArrayList<String> listaFicheros = new ArrayList<>();

        if (f.exists()) {
            File[] ficheros = f.listFiles();
            for (File file2 : ficheros) {

                System.out.println(listaFicheros.size() + ". - " + file2.getName());
                listaFicheros.add(file2.getPath());
            }
        } else {
            System.out.println("El directorio a listar no existe");
        }

        return listaFicheros;
    }

    /* Metodo que pide y devuelve la opcion elegida por el usuario de la listaFicheros*/
    private static int eligeEnLaLista(ArrayList<String> lista) {

        int elige;

        do {

            System.out.println("SELECCIONA UN NUMERO DE LA LISTA:");
            elige = entradaTeclado.nextInt();

        } while (elige < 0 || elige > lista.size() - 1);

        return elige;
    }

    /* Metodo que guarda en una estructura Map el nombre de la app (como clave) 
    y la fecha de creación (como valor) de aquellas apps cuyo tamaño esté entre 200 y 500 kb */
    public static Map<String, LocalDate> guardaEstructuraMap(ArrayList<App> lista) {

        final double TAM_MIN = 200.0;
        final double TAM_MAX = 500.0;

        Map<String, LocalDate> mapaApps = lista.stream()
                .filter(p -> p.getTamanioKb() > TAM_MIN //filtro por tam
                && p.getTamanioKb() < TAM_MAX)
                //el nombre como clave y localdate como valor
                .collect(Collectors.toMap(p -> p.getNombre(), p -> p.getFechaCreacion()));

        return mapaApps;
    }

}
