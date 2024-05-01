package trabajopractico.back;

public class Vertice {
    String nombre;
    double latitud;
    double longitud;

    public Vertice(){};

    public Vertice(String nombre, double latitud, double longitud){
        this.nombre= nombre;
        this.latitud= latitud;
        this.longitud= longitud;
    }

    public void setNombre(String nombrePasado){
        this.nombre= nombrePasado;
    }

    public void setLatitud(double latitudPasada){
        this.latitud= latitudPasada;
    }

    public void setLongitud(double longitudPasada){
        this.longitud= longitudPasada;
    }

    public String getNombre(){
        return this.nombre;
    }

    public double getLatitud(){
        return this.latitud;
    }

    public double getLongitud(){
        return this.longitud;
    }
}
