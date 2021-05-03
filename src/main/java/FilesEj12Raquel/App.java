/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FilesEj12Raquel;

import java.time.LocalDate;
import java.time.Year;
import java.util.Objects;
import java.util.Random;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

/**
 *
 * @author raquel
 */
// Nombre de la etiqueta raiz
// Anotacion @XmlRootElement
@XmlRootElement(name = "app")
// Definicion del elemento que usara JAXB durante el
// procesamiento de datos --> @XmlAccessorType (por atributo)
@XmlAccessorType(XmlAccessType.FIELD)
public class App {

    private int codigoUnico;
    private String nombre;
    private String descripcion;
    private double tamanioKb;
    // Anotacion xml para el formateo del tiempo
    @XmlJavaTypeAdapter(value = LocalDateAdapter.class)
    private LocalDate fechaCreacion;
    private static int contadorInstancias = 0;
    private static Random random = new Random();

    /* Constructor por defecto */
    public App() {
        contadorInstancias++;

    }

    /* Constructor parametrizado */
    public App(String nombre, String descripcion, double tamanioKb, LocalDate fechaCreacion) {
        this.codigoUnico = getContadorInstancias();
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.tamanioKb = tamanioKb;
        this.fechaCreacion = fechaCreacion;
        contadorInstancias++;
    }

    /* Getters y setters */
    public int getCodigoUnico() {
        return codigoUnico;
    }

    public void setCodigoUnico(int codigoUnico) {
        this.codigoUnico = codigoUnico;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public double getTamanioKb() {
        return tamanioKb;
    }

    public void setTamanioKb(double tamanioKb) {
        this.tamanioKb = tamanioKb;
    }

    public LocalDate getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(LocalDate fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public static int getContadorInstancias() {
        return contadorInstancias;
    }

    /* Equals y hashcode */
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 37 * hash + this.codigoUnico;
        hash = 37 * hash + Objects.hashCode(this.nombre);
        hash = 37 * hash + Objects.hashCode(this.descripcion);
        hash = 37 * hash + (int) (Double.doubleToLongBits(this.tamanioKb) ^ (Double.doubleToLongBits(this.tamanioKb) >>> 32));
        hash = 37 * hash + Objects.hashCode(this.fechaCreacion);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final App other = (App) obj;
        if (this.codigoUnico != other.codigoUnico) {
            return false;
        }
        if (Double.doubleToLongBits(this.tamanioKb) != Double.doubleToLongBits(other.tamanioKb)) {
            return false;
        }
        if (!Objects.equals(this.nombre, other.nombre)) {
            return false;
        }
        if (!Objects.equals(this.descripcion, other.descripcion)) {
            return false;
        }
        if (!Objects.equals(this.fechaCreacion, other.fechaCreacion)) {
            return false;
        }
        return true;
    }

    /* To string */
    @Override
    public String toString() {
        return codigoUnico + "\t" + nombre + "\t" + descripcion + "\t" + tamanioKb + "\t" + fechaCreacion;
    }

    /* Metodo que genera y devuelve un nombre de app de manera aleatoria */
    private static String generaNombreAleatorio() {
        //el formato es app+código único+letra aleatoria (a-z)
        return "App" + getContadorInstancias() + generaLetraMinuscula();

    }

    /* Metodo que genera y devuelve una letra minuscula aleatoria */
    private static char generaLetraMinuscula() {
        return (char) (97 + random.nextInt(26));
    }

    /* Metodo que devuelve un valor aleatorio entre dos numeros */
    private static int generaNumeroAleatorio(int n, int m) {
        return random.nextInt(m - n + 1) + n;
    }

    /* Metodo que genera una descripcion de app aleatoria */
    private static String generaDescripcionAleatoria() {
        String[] descripciones = {"Descripcion numero 1", "Descripcion numero 2", "Descripcion numero 3",
            "Descripcion numero 4", "Descripcion numero 5", "Descripcion numero 6",
            "Descripcion numero 7", "Descripcion numero 8", "Descripcion numero 9", "Descripcion numero 10"};

        return descripciones[generaNumeroAleatorio(0, descripciones.length - 1)];
    }

    /* Metodo que genera aleatoriamente el tamaño de las aplicaciones
    entre dos valores */
    private static double generaTamanioAleatorio() {
        final double TAMANIO_MIN_APP = 100.0;
        final double TAMANIO_MAX_APP = 1024.0;
        final int TAMANIO_STREAM = 1;

        return ((random.doubles(TAMANIO_STREAM, TAMANIO_MIN_APP, TAMANIO_MAX_APP)).sum());
    }

    /* Metodo que genera una fecha aleatoria */
    private static LocalDate generaFechaAleatoria() {
        int anio = generaNumeroAleatorio(1970, 2022);
        int mes = generaNumeroAleatorio(1, 12);
        int dia;

        switch (mes) {
            case 2:
                if (Year.isLeap(anio)) { //si el año es bisiesto
                    dia = generaNumeroAleatorio(1, 29);
                } else {
                    dia = generaNumeroAleatorio(1, 28);
                }
                break;
            //para todos los meses con 31 dias:
            case 1:
            case 3:
            case 5:
            case 7:
            case 8:
            case 10:
            case 12:
                dia = generaNumeroAleatorio(1, 31);
                break;

            //para el resto de meses tendran 30 dias
            default:
                dia = generaNumeroAleatorio(1, 30);
                break;

        }

        return LocalDate.of(anio, mes, dia);
    }

    /* Metodo de clase que genera objetos tipo App de forma aleatoria */
    public static App generaObjetoAppAleatorio() {

        //creo un nuevo objeto app con valores aleatorios
        return new App(generaNombreAleatorio(), generaDescripcionAleatoria(),
                generaTamanioAleatorio(), generaFechaAleatoria());
    }
}
