package trabajopractico;

import org.openstreetmap.gui.jmapviewer.Coordinate;
import org.openstreetmap.gui.jmapviewer.interfaces.MapPolygon;

import java.util.Scanner;
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
        Vertice verticeCapitalFederal = new Vertice("Ciudad Autonoma de Buenos Aires", -34.6037, -58.3816);
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

        //---------------Incluyo los vertices al grafo--------------------
        grafo.addVertice(verticeBuenosAires, 0);       // indice 0 --> Buenos Aires
        grafo.addVertice(verticeCapitalFederal, 1);    // indice 1 --> Capital Federal
        grafo.addVertice(verticeCordoba, 2);           // indice 2 --> Cordoba
        grafo.addVertice(verticeSantaFe,3);            // indice 3 --> Santa Fe
        grafo.addVertice(verticeMendoza,4);            // indice 4 --> Mendoza
        grafo.addVertice(verticeTucuman,5);            // indice 5 --> Tucuman
        grafo.addVertice(verticeEntreRios,6);          // indice 6 --> Entre Rios
        grafo.addVertice(verticeSalta,7);              // indice 7 --> Salta
        grafo.addVertice(verticeMisiones,8);           // indice 8 --> Misiones
        grafo.addVertice(verticeChaco,9);              // indice 9 --> Chaco
        grafo.addVertice(verticeCorrientes,10);        // indice 10 --> Corrientes
        grafo.addVertice(verticeSantaCruz,11);         // indice 11 --> Santa Cruz
        grafo.addVertice(verticeNeuquen,12);           // indice 12 --> Neuquen
        grafo.addVertice(verticeRioNegro,13);          // indice 13 --> Rio Negro
        grafo.addVertice(verticeSanJuan,14);           // indice 14 --> San Juan
        grafo.addVertice(verticeJujuy,15);             // indice 15 --> Jujuy
        grafo.addVertice(verticeSanLuis,16);           // indice 16 --> San Luis
        grafo.addVertice(verticeLaRioja,17);           // indice 17 --> La Rioja
        grafo.addVertice(verticeCatamarca,18);         // indice 18 --> Catamarca
        grafo.addVertice(verticeLaPampa,19);           // indice 19 --> La Pampa
        grafo.addVertice(verticeSantiagoDelEstero,20); // indice 20 --> Santiago del Estero
        grafo.addVertice(verticeFormosa,21);           // indice 21 --> Formosa
        grafo.addVertice(verticeChubut,22);            // indice 22 --> Chubut
        grafo.addVertice(verticeTierraDelFuego,23);    // indice 23 --> Tierra del Fuego

        //----------------genero las aristas--------------------
        // Buenos Aires
        grafo.agregarArista(0, 1, 10);  // Buenos Aires a capital
        grafo.agregarArista(0, 3, 25);  // Buenos Aires a Santa Fe
        grafo.agregarArista(0, 2, 45);  // Buenos Aires a Cordoba
        grafo.agregarArista(0, 19, 30); // Buenos Aires a La Pampa
        grafo.agregarArista(0, 13, 60); // Buenos Aires a Rio Negro
        grafo.agregarArista(0, 6, 20);  // Buenos Aires a Entre Rios

        // Catamarca
        grafo.agregarArista(18, 7, 55);  // Catamarca a Salta
        grafo.agregarArista(18, 5, 25);  // Catamarca a Tucuman
        grafo.agregarArista(18, 20, 40); // Catamarca a Santiago del Estero
        grafo.agregarArista(18, 2, 50);  // Catamarca a Cordoba
        grafo.agregarArista(18, 17, 45); // Catamarca a La Rioja

        // Chaco
        grafo.agregarArista(9, 21, 15);  // Chaco a Formosa
        grafo.agregarArista(9, 20, 35);  // Chaco a Santiago del Estero
        grafo.agregarArista(9, 3, 30);   // Chaco a Santa Fe
        grafo.agregarArista(9, 10, 20);  // Chaco a Corrientes

        // Chubut
        grafo.agregarArista(22, 13, 33); // Chubut a Rio Negro
        grafo.agregarArista(22, 11, 35); // Chubut a Santa Cruz
        
        grafo.agregarArista(13, 4, 80);  // Rio Negro a Mendoza

        // Cordoba
        grafo.agregarArista(2, 16, 40);  // Cordoba a San Luis
        grafo.agregarArista(2, 17, 45);  // Cordoba a La Rioja
        grafo.agregarArista(2, 20, 50);  // Cordoba a Santiago del Estero

        // Corrientes
        grafo.agregarArista(10, 6, 15);  // Corrientes a Entre Rios
        grafo.agregarArista(10, 3, 25);  // Corrientes a Santa Fe
        grafo.agregarArista(10, 21, 30); // Corrientes a Formosa
        grafo.agregarArista(10, 8, 32);  // Corrientes a Misiones

        // Entre Rios
        grafo.agregarArista(6, 10, 20);  // Entre Rios a Corrientes
        grafo.agregarArista(6, 3, 25);   // Entre Rios a Santa Fe

        // Formosa
        grafo.agregarArista(21, 7, 45);  // Formosa a Salta

        // Jujuy
        grafo.agregarArista(15, 7, 30);  // Jujuy a Salta

        // La Pampa
        grafo.agregarArista(19, 4, 50);  // La Pampa a Mendoza
        grafo.agregarArista(19, 16, 40); // La Pampa a San Luis
        grafo.agregarArista(19, 13, 55); // La Pampa a Rio Negro

        // Neuquen
        grafo.agregarArista(12, 13, 30); // Neuquen a Rio Negro con un peso de 30
        grafo.agregarArista(12, 19, 45); // Neuquen a La Pampa con un peso de 30
        grafo.agregarArista(12, 4, 43);  // Neuquen a Mendoza con un peso de 30

        // Santa Fe
        grafo.agregarArista(3, 2, 30);  // Santa Fe a Cordoba con un peso de 40
        grafo.agregarArista(3, 20, 40); // Santa Fe a Santiago del Estero con un peso de 40

        // San Juan
        grafo.agregarArista(14, 4, 31);  // San Juan a Mendoza con un peso de 31
        grafo.agregarArista(14, 16, 33); // San Juan a San Luis con un peso de 33
        grafo.agregarArista(14, 17, 32); // San Juan a La Rioja con un peso de 32

        // Otros
        grafo.agregarArista(23, 11, 35); // Tierra del Fuego a Santa Cruz con un peso de 70
        grafo.agregarArista(5, 20, 35);  // Tucuman a Santiago del Estero con un peso de 35
        grafo.agregarArista(5, 7, 33);   // Tucuman a Salta con un peso de 33

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

        grafo.aplicarPrim();
        //mapa.removeAllPolygons();
        //grafo.imprimirPesosAristas();

        grafo.eliminarAristasPesadas(3);

        //System.out.println("luego de eliminar aristas pesadas");
        //grafo.imprimirPesosAristas();
        mapa.showMap();
    }
}