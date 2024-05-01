package trabajopractico.view;

import org.openstreetmap.gui.jmapviewer.*;
import org.openstreetmap.gui.jmapviewer.interfaces.MapMarker;

import javax.swing.*;
import java.awt.*;

import trabajopractico.back.App;
import trabajopractico.back.Grafo;
import trabajopractico.back.Vertice;

public class MapViewer {
    private JFrame frame;
    private JMapViewer mapViewer;

    public MapViewer() {
        frame = new JFrame("Mapa de Provincias de Argentina");
        mapViewer = new JMapViewer();

        frame.setLayout(new BorderLayout());
        frame.add(new JLabel("Visualización del Grafo de Provincias"), BorderLayout.NORTH);
        frame.add(mapViewer, BorderLayout.CENTER);
        frame.setSize(800, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void displayGraph(Grafo grafo) {
        for (Vertice v : grafo.getVertices()) {
            mapViewer.addMapMarker(new MapMarkerDot(v.getNombre(), new Coordinate(v.getLatitud(), v.getLongitud())));
        }
    }

    public void show() {
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        App graphManager = new App();  // Suponiendo 23 provincias en Argentina
        MapViewer mapViewer = new MapViewer();
        mapViewer.displayGraph(graphManager.getGrafo());
        mapViewer.show();
    }
}
