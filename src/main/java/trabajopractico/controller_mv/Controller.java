package trabajopractico.controller_mv;

import org.openstreetmap.gui.jmapviewer.Coordinate;
import org.openstreetmap.gui.jmapviewer.interfaces.MapPolygon;

import trabajopractico.back.Grafo;
import trabajopractico.back.Vertice;
import trabajopractico.view.MapViewer;

public class Controller {
    private Grafo grafo;
    private MapViewer mapa;

    public Controller() {
    }

    public void addVertice(String nombre, Coordinate coord) {
        mapa.drawVertice(nombre, coord);
    }

    public MapPolygon conectarProvincias(Coordinate coord1, Coordinate coord2) {
        return mapa.drawLineBetweenVertices(coord1, coord2);   //dibujamos la linea 
    }

    public void eliminarArista(MapPolygon polygon){
        mapa.removeLine(polygon);
    }

    public void eliminarTotalidadAristas(){
        mapa.removeAllPolygons();
    }

    //------------------Funciones set para obtener los objetos controlados---------------------------
    
    public void setGrafo(Grafo grafo) {
        this.grafo= grafo;
    }

    public void setMapa(MapViewer mapa) {
        this.mapa= mapa;
    }
    
    //------------------------------------------------------------------------------------------------
}
