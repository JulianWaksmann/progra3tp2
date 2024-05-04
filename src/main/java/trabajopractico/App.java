package trabajopractico;

import org.openstreetmap.gui.jmapviewer.Coordinate;

import trabajopractico.back.Grafo;
import trabajopractico.back.Vertice;
import trabajopractico.view.MapViewer;
import trabajopractico.controller_mv.Controller;

public class App {
    //private Controller miControlador;
    //private MapViewer mapa;
    //private Grafo grafo;
    //int cantProvincias= 24;

    public static void inicializarProvincias(Grafo grafo) {
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
        grafo.addVertice(verticeBuenosAires, 0);       //indice 0 --> Buenos Aires
        grafo.addVertice(verticeCapitalFederal, 1);    //indice 1 --> Capital federal
        grafo.addVertice(verticeCordoba, 2);           //indice 2 --> Cordoba
        grafo.addVertice(verticeSantaFe,3);
        grafo.addVertice(verticeMendoza,4);
        grafo.addVertice(verticeTucuman,5);
        grafo.addVertice(verticeEntreRios,6);
        grafo.addVertice(verticeSalta,7);
        grafo.addVertice(verticeMisiones,8);
        grafo.addVertice(verticeChaco,9);
        grafo.addVertice(verticeCorrientes,10);
        grafo.addVertice(verticeSantaCruz,11);
        grafo.addVertice(verticeNeuquen,12);
        grafo.addVertice(verticeRioNegro,13);
        grafo.addVertice(verticeSanJuan,14);
        grafo.addVertice(verticeJujuy,15);
        grafo.addVertice(verticeSanLuis,16);
        grafo.addVertice(verticeLaRioja,17);
        grafo.addVertice(verticeCatamarca,18);
        grafo.addVertice(verticeLaPampa,19);
        grafo.addVertice(verticeSantiagoDelEstero,20);
        grafo.addVertice(verticeFormosa,21);
        grafo.addVertice(verticeChubut,22);
        grafo.addVertice(verticeTierraDelFuego,23);

        //----------------genero las aristas--------------------
        // Buenos Aires
        grafo.agregarArista(0, 3, 25);  // Buenos Aires a Santa Fe
        grafo.agregarArista(0, 2, 45);  // Buenos Aires a Córdoba
        grafo.agregarArista(0, 19, 30); // Buenos Aires a La Pampa
        grafo.agregarArista(0, 13, 60); // Buenos Aires a Río Negro
        grafo.agregarArista(0, 6, 20);  // Buenos Aires a Entre Ríos

        // Catamarca
        grafo.agregarArista(18, 7, 55);  // Catamarca a Salta
        grafo.agregarArista(18, 5, 25);  // Catamarca a Tucumán
        grafo.agregarArista(18, 20, 40); // Catamarca a Santiago del Estero
        grafo.agregarArista(18, 2, 50);  // Catamarca a Córdoba
        grafo.agregarArista(18, 17, 45); // Catamarca a La Rioja

        // Chaco
        grafo.agregarArista(9, 21, 15);  // Chaco a Formosa
        grafo.agregarArista(9, 20, 35);  // Chaco a Santiago del Estero
        grafo.agregarArista(9, 3, 30);   // Chaco a Santa Fe
        grafo.agregarArista(9, 10, 20);  // Chaco a Corrientes

        // Chubut
        grafo.agregarArista(22, 13, 70); // Chubut a Río Negro
        grafo.agregarArista(22, 11, 75); // Chubut a Santa Cruz
        
        grafo.agregarArista(13, 4, 80);  // Rio Negro a Mendoza

        // Córdoba
        grafo.agregarArista(2, 16, 40);  // Córdoba a San Luis
        grafo.agregarArista(2, 17, 45);  // Córdoba a La Rioja
        grafo.agregarArista(2, 20, 50);  // Córdoba a Santiago del Estero

        // Corrientes
        grafo.agregarArista(10, 6, 15);  // Corrientes a Entre Ríos
        grafo.agregarArista(10, 3, 25);  // Corrientes a Santa Fe
        grafo.agregarArista(10, 21, 30); // Corrientes a Formosa
        grafo.agregarArista(10, 8, 35);  // Corrientes a Misiones

        // Entre Ríos
        grafo.agregarArista(6, 10, 20);  // Entre Ríos a Corrientes
        grafo.agregarArista(6, 3, 25);   // Entre Ríos a Santa Fe

        // Formosa
        grafo.agregarArista(21, 7, 45);  // Formosa a Salta

        // Jujuy
        grafo.agregarArista(15, 7, 30);  // Jujuy a Salta

        // La Pampa
        grafo.agregarArista(19, 4, 50);  // La Pampa a Mendoza
        grafo.agregarArista(19, 16, 40); // La Pampa a San Luis
        grafo.agregarArista(19, 13, 55); // La Pampa a Río Negro

        //Neuquen
        grafo.agregarArista(12, 13, 30);
        grafo.agregarArista(12, 19, 30);
        grafo.agregarArista(12, 4, 30);

        //Santa Fe
        grafo.agregarArista(3, 2, 40);
        grafo.agregarArista(3, 20, 40);

        //San Juan
        grafo.agregarArista(14, 4,31);
        grafo.agregarArista(14, 16,33);
        grafo.agregarArista(14, 17,32);

        //otros
        grafo.agregarArista(23, 11, 70);

    }

    public static void main(String[] args){
        int cantProvincias= 24;
        
        Controller miControlador= new Controller();
        Grafo grafo= new Grafo(cantProvincias);
        MapViewer mapa= new MapViewer();

        miControlador.setGrafo(grafo);
        miControlador.setMapa(mapa);

        grafo.setController(miControlador);
        mapa.setController(miControlador);

        inicializarProvincias(grafo);
        
        Coordinate one = new Coordinate(-36.6769, -60.5588);
        Coordinate two = new Coordinate(-34.6037, -58.3816);
        mapa.drawLineBetweenVertices(one, two);

        mapa.showMap();
    }
}