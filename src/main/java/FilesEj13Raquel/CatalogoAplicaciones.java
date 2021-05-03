/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FilesEj13Raquel;

import java.util.ArrayList;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author raquel
 */

/* Esta clase contiene una lista de objetos de tipo App */
// Etiquetas para el xml
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class CatalogoAplicaciones {

    //XMLElementWrapper define un contenedor para la lista
    //de aplicaciones
    @XmlElementWrapper(name = "catalogo")

    //XMLElement establece el nombre de los elementos
    //Cada elemento de la lista llevará esta etiqueta en el fichero xml
    @XmlElement(name = "aplicacion")

    private ArrayList<App> listaAplicaciones;
    private String descripcion;

    public ArrayList<App> getListaAplicaciones() {
        return listaAplicaciones;
    }

    public void setListaAplicaciones(ArrayList<App> listaAplicaciones) {
        this.listaAplicaciones = listaAplicaciones;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

}
