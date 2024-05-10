package trabajopractico.back;
import org.openstreetmap.gui.jmapviewer.interfaces.MapPolygon;

public class Arista {
    private int origen;
    private int destino;
    private MapPolygon polygon; // Opcional, si estás manejando la visualización

    public Arista(int origen, int destino, MapPolygon polygon) {
        this.origen = origen;
        this.destino = destino;
        this.polygon = polygon;
    }

    public int getOrigen() {
        return origen;
    }

    public int getDestino() {
        return destino;
    }

    public MapPolygon getPolygon() {
        return polygon;
    }
}
