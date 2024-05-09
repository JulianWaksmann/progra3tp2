package trabajopractico.view;

import org.openstreetmap.gui.jmapviewer.*;
import org.openstreetmap.gui.jmapviewer.interfaces.MapMarker;

import javax.swing.*;
import java.awt.*;

import trabajopractico.App;
import trabajopractico.back.Grafo;
import trabajopractico.back.Vertice;
import trabajopractico.controller_mv.Controller;

import org.openstreetmap.gui.jmapviewer.interfaces.MapPolygon;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MapViewer {
    private JFrame frame;
    private JMapViewer mapViewer;
    private Controller miController;

    public MapViewer() {
        frame = new JFrame("Mapa de Provincias de Argentina");
        mapViewer = new JMapViewer();

        frame.setLayout(new BorderLayout());
        frame.add(new JLabel("Visualización del Grafo de Provincias"), BorderLayout.NORTH);
        frame.add(mapViewer, BorderLayout.CENTER);
        frame.setSize(800, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public MapPolygon drawLineBetweenVertices(Coordinate coord1, Coordinate coord2) {
        List<Coordinate> route = new ArrayList<Coordinate>(Arrays.asList(coord1, coord2, coord2));
        MapPolygon polygon = new MapPolygonImpl(route);
        mapViewer.addMapPolygon(polygon);

        return polygon;
    }

    public void removeLine(MapPolygon polygon) {
        mapViewer.removeMapPolygon(polygon);
        mapViewer.repaint();  // Actualiza el mapa
    }

    public void drawVertice(String nombre, Coordinate coord) {
        mapViewer.addMapMarker(new MapMarkerDot(nombre, coord));
    }

    // Método para remover todos los polígonos
    public void removeAllPolygons() {
        mapViewer.removeAllMapPolygons();
        mapViewer.repaint();  // Refrescar el mapa después de remover los elementos
    }

    public void showMap() {
        // Este método hará que el frame sea visible, llamalo después de añadir todos los elementos necesarios al mapa
        frame.setVisible(true);
    }

    public void setController(Controller miControlador) {
        this.miController= miControlador;
    }
}

