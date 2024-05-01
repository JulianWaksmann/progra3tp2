package trabajopractico.back;

public class App {
    private Grafo grafo;
    int cantProvincias= 2;

    public App(){
        this.grafo= new Grafo(cantProvincias);
        inicializarProvincias();
        conectarProvincias();
    }

    private void inicializarProvincias() {
        //--------------Genero los vertices de las provincias--------------
        Vertice verticeBuenosAires= new Vertice("Buenos Aires", -34.6037, -58.3816);
        Vertice verticeCordoba= new Vertice("Cordoba", -31.4201, -64.1888);

        //----------------Incluyo los vertices al grafo--------------------
        this.grafo.addVertice(verticeBuenosAires, 0);    //indice 0 --> Buenos Aires
        this.grafo.addVertice(verticeCordoba, 1);        //indice 1 --> Cordoba
    }

    private void conectarProvincias() {
        // Conexiones ficticias para ejemplo
        grafo.agregarArista(0, 1, 200);  // Buenos Aires a Córdoba
    }

    public Grafo getGrafo() {
        return grafo;
    }
}