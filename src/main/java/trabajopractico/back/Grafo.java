package trabajopractico.back;
import org.openstreetmap.gui.jmapviewer.Coordinate;
import org.openstreetmap.gui.jmapviewer.interfaces.MapPolygon;

import trabajopractico.controller_mv.*;

public class Grafo {
    private Controller miController;
    private int[][] adjMatriz;
    private int cantVertices;
    private Vertice[] vertices;

    public Grafo(int cantVertices){
        vertices= new Vertice[cantVertices];
        adjMatriz= new int[cantVertices][cantVertices];

        // Inicializar la matriz con valores infinitos, excepto la diagonal, los infinitos luego los iremos modificando
        for (int i = 0; i < cantVertices; i++) {
            for (int j = 0; j < cantVertices; j++) {
                if (i == j) {
                    adjMatriz[i][j] = 0;    //la diagonal es 0 porque el peso que hay entre la misma provincia es 0
                } else {
                    adjMatriz[i][j] = Integer.MAX_VALUE;
                }
            }
        }
    }

    public void addVertice(Vertice verticeAgregado, int indice){
        //Se debe pasar un indice dentro del rango de [0, cantVertices)
        vertices[indice]= verticeAgregado;

        //informamos al controller
        miController.addVertice(verticeAgregado.getNombre(), verticeAgregado.getCoordinate());
    }

    public MapPolygon agregarArista(int primerVertice, int segundoVertice, int peso){
        adjMatriz[primerVertice][segundoVertice] = peso; 
        adjMatriz[segundoVertice][primerVertice] = peso; //esto si solo si el grafo no es dirigido.

        //informamos al controller
        Coordinate coord1= vertices[primerVertice].getCoordinate();
        Coordinate coord2= vertices[segundoVertice].getCoordinate();
        
        return miController.conectarProvincias(coord1, coord2);
    }

    public void eliminarArista(MapPolygon polygon, int primerVertice, int segundoVertice){
        adjMatriz[primerVertice][segundoVertice] = Integer.MAX_VALUE; 
        adjMatriz[segundoVertice][primerVertice] = Integer.MAX_VALUE; //esto si solo si el grafo no es dirigido.

        miController.eliminarArista(polygon);
    }

    //aplicamos prim al grafo
    public void aplicarPrim(){
        miController.eliminarTotalidadAristas();
        Prim.calcularMST(this);
    }

    // Método para imprimir la matriz de adyacencia
    public void printGrafo() {
        System.out.println("Matriz de Adyacencia:");

        for (int t = 0; t < adjMatriz.length; t++) {
            for (int m = 0; m < adjMatriz.length; m++) {
                if (adjMatriz[t][m] == Integer.MAX_VALUE) {
                    System.out.print("& ");
                } else {
                    System.out.print(adjMatriz[t][m] + " ");
                }
            }
            System.out.println();  // Nueva línea al final de cada fila de la matriz
        }
    }

    public int getCantidadVertices(){
        return adjMatriz.length;
    }

    public Vertice[] getVertices() {
        return vertices;
    }

    public int[][] getAdjMatriz() {
        return adjMatriz;
    }

    public void setController(Controller miControlador) {
        this.miController= miControlador;
    }
    
    //public static void main(String[] args) {
    //    int cantProvincias = 3;
    //    Grafo argentina = new Grafo(cantProvincias);
    //
    //    Vertice verticeBuenosAires = new Vertice("Buenos Aires", -34.6037, -58.3816);
    //    Vertice verticeCordoba = new Vertice("Cordoba", -31.4201, -64.1888);
    //    Vertice verticeSantaFe = new Vertice("Santa Fe", -30.7069, -60.9498);
    //
    //    argentina.addVertice(verticeBuenosAires, 0);
    //    argentina.addVertice(verticeCordoba, 1);
    //    argentina.addVertice(verticeSantaFe, 2);
    //
    //    argentina.agregarArista(0, 1, 200);
    //    argentina.agregarArista(1, 2, 150);
    //    argentina.agregarArista(0, 2, 250);
    //
    //    argentina.printGrafo();
    //    
    //    //System.out.println(argentina.getCantidadVertices());
//
    //    //for(Vertice vert : argentina.getVertices()){
    //    //    System.out.println(vert.getNombre());
    //    //}
    //    
    //    Prim prim = new Prim(argentina);
    //    int[] mst = prim.calcularMST();
    //
    //    System.out.println("Arista \tPeso");
    //    for (int i = 1; i < argentina.getCantidadVertices(); i++) {
    //        if (argentina.getAdjMatriz()[i][mst[i]] != Integer.MAX_VALUE) {
    //            System.out.println(mst[i] + " - " + i + "\t" + argentina.getAdjMatriz()[i][mst[i]]);
    //        }
    //    }
    //}
}