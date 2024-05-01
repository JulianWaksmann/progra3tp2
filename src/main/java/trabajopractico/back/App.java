package trabajopractico.back;

public class App {
    private Grafo grafo;
    int cantProvincias= 24;

    public App(){
        this.grafo= new Grafo(cantProvincias);
        inicializarProvincias();
        conectarProvincias();
    }

    private void inicializarProvincias() {
        //--------------Genero los vertices de las provincias--------------
        Vertice verticeBuenosAires = new Vertice("Buenos Aires", -36.6769, -60.5588);
Vertice verticeCapitalFederal = new Vertice("Ciudad Autónoma de Buenos Aires", -34.6037, -58.3816);
Vertice verticeCordoba = new Vertice("Cordoba", -32.1429, -63.8017);
Vertice verticeSantaFe = new Vertice("Santa Fe", -30.7069, -60.9498);
Vertice verticeMendoza = new Vertice("Mendoza", -34.6299, -68.334);
Vertice verticeTucuman = new Vertice("Tucuman", -26.9478, -65.3648);
Vertice verticeEntreRios = new Vertice("Entre Rios", -32.0583, -59.2014);
Vertice verticeSalta = new Vertice("Salta", -24.7859, -64.9912);
Vertice verticeMisiones = new Vertice("Misiones", -26.9370, -54.4232);
Vertice verticeChaco = new Vertice("Chaco", -26.3864, -60.7658);
Vertice verticeCorrientes = new Vertice("Corrientes", -28.4696, -58.8306);
Vertice verticeSantaCruz = new Vertice("Santa Cruz", -48.8767, -69.2389);
Vertice verticeNeuquen = new Vertice("Neuquen", -38.9517, -70.1333);
Vertice verticeRioNegro = new Vertice("Rio Negro", -40.8135, -66.8150);
Vertice verticeSanJuan = new Vertice("San Juan", -30.8654, -68.8895);
Vertice verticeJujuy = new Vertice("Jujuy", -23.3201, -65.7643);
Vertice verticeSanLuis = new Vertice("San Luis", -33.7577, -66.0281);
Vertice verticeLaRioja = new Vertice("La Rioja", -29.6857, -67.1817);
Vertice verticeCatamarca = new Vertice("Catamarca", -28.6788, -66.0750);
Vertice verticeLaPampa = new Vertice("La Pampa", -37.1316, -65.4460);
Vertice verticeSantiagoDelEstero = new Vertice("Santiago del Estero", -27.7951, -64.2615);
Vertice verticeFormosa = new Vertice("Formosa", -25.3632, -58.6435);
Vertice verticeChubut = new Vertice("Chubut", -43.7886, -68.5268);
Vertice verticeTierraDelFuego = new Vertice("Tierra del Fuego", -54.8019, -67.6987);

        //----------------Incluyo los vertices al grafo--------------------
        this.grafo.addVertice(verticeBuenosAires, 0);    //indice 0 --> Buenos Aires
        this.grafo.addVertice(verticeCapitalFederal, 1);    //indice 1 --> Capital federal
        this.grafo.addVertice(verticeCordoba, 2);        //indice 2 --> Cordoba
        this.grafo.addVertice(verticeSantaFe,3);
        this.grafo.addVertice(verticeMendoza,4);
        this.grafo.addVertice(verticeTucuman,5);
        this.grafo.addVertice(verticeEntreRios,6);
        this.grafo.addVertice(verticeSalta,7);
        this.grafo.addVertice(verticeMisiones,8);
        this.grafo.addVertice(verticeChaco,9);
        this.grafo.addVertice(verticeCorrientes,10);
        this.grafo.addVertice(verticeSantaCruz,11);
        this.grafo.addVertice(verticeNeuquen,12);
        this.grafo.addVertice(verticeRioNegro,13);
        this.grafo.addVertice(verticeSanJuan,14);
        this.grafo.addVertice(verticeJujuy,15);
        this.grafo.addVertice(verticeSanLuis,16);
        this.grafo.addVertice(verticeLaRioja,17);
        this.grafo.addVertice(verticeCatamarca,18);
        this.grafo.addVertice(verticeLaPampa,19);
        this.grafo.addVertice(verticeSantiagoDelEstero,20);
        this.grafo.addVertice(verticeFormosa,21);
        this.grafo.addVertice(verticeChubut,22);
        this.grafo.addVertice(verticeTierraDelFuego,23);
    }

    private void conectarProvincias() {
        // Conexiones ficticias para ejemplo
        grafo.agregarArista(0, 1, 200);  // Buenos Aires a Córdoba
    }

    public Grafo getGrafo() {
        return grafo;
    }
}