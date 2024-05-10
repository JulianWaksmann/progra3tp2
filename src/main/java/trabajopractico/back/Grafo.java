package trabajopractico.back;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openstreetmap.gui.jmapviewer.Coordinate;
import org.openstreetmap.gui.jmapviewer.interfaces.MapPolygon;

import trabajopractico.controller_mv.*;

public class Grafo {
    private Controller miController;
    private int[][] adjMatriz;
    private int cantVertices;
    private Vertice[] vertices;
    private List<Arista> aristas;

    public Grafo(int cantVertices){
        this.vertices= new Vertice[cantVertices];
        this.adjMatriz= new int[cantVertices][cantVertices];
        this.cantVertices=cantVertices;
        this.aristas = new ArrayList<>();

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

    public Arista agregarArista(int primerVertice, int segundoVertice, int peso){
        adjMatriz[primerVertice][segundoVertice] = peso; 
        adjMatriz[segundoVertice][primerVertice] = peso; //esto si solo si el grafo no es dirigido.
        
        System.out.println("se agrega arista: "+ primerVertice +"-"+ segundoVertice + "con peso: " + peso);
        
        //informamos al controller
        Coordinate coord1= vertices[primerVertice].getCoordinate();
        Coordinate coord2= vertices[segundoVertice].getCoordinate();
        
        //el controlador nos retorna el poligono, que si bien es algo visual lo necesitamos
        MapPolygon polygon= miController.conectarProvincias(coord1, coord2);
        
        //generamos nueva arista y la agregamos a la lista
        Arista nuevaArista= new Arista(primerVertice, segundoVertice, polygon);
        aristas.add(nuevaArista); // Agregar la arista a la lista

        return nuevaArista;
    }

    public void eliminarArista(Arista arista){
        //eliminamos la arista de nuestra lista de aristas
        aristas.remove(arista);

        //eliminamos los pesos contenidos en la matriz
        adjMatriz[arista.getOrigen()][arista.getDestino()] = Integer.MAX_VALUE; 
        adjMatriz[arista.getDestino()][arista.getOrigen()] = Integer.MAX_VALUE; //esto si solo si el grafo no es dirigido.

        miController.eliminarArista(arista.getPolygon());
    }

    //aplicamos prim al grafo
    public void aplicarPrim(){
        miController.eliminarTotalidadAristas();
        aristas.clear();
        Prim.calcularMST(this);
    }

    // Metodo para imprimir la matriz de adyacencia
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
            System.out.println();  // Nueva linea al final de cada fila de la matriz
        }
    }

    //metodo para eliminar las k-1 aristas mas pesadas
    public void eliminarAristasPesadas(int k) {
        if (k <= 1) {
            System.out.println("No se pueden eliminar menos de una arista.");
            return;
        }
    
        // Aseguramos que las aristas esten actualizadas con los pesos actuales de la matriz de adyacencia
        aristas.sort((a1, a2) -> {
            int pesoA1 = adjMatriz[a1.getOrigen()][a1.getDestino()];
            int pesoA2 = adjMatriz[a2.getOrigen()][a2.getDestino()];
            return Integer.compare(pesoA2, pesoA1);  // Orden descendente
        });
    
        // Eliminar las k-1 aristas mas pesadas
        int limite = Math.min(k - 1, aristas.size());
        for (int i = 0; i < limite; i++) {
            Arista aristaAEliminar = aristas.get(i);
            eliminarArista(aristaAEliminar);
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
    
    public int getNumeroDeAristas() {
        return aristas.size();  // Retorna el numero de aristas en la lista
    }

    public void imprimirPesosAristas() {
        System.out.println("Pesos de las aristas en el grafo:");
        for (Arista arista : aristas) {
            int origen = arista.getOrigen();
            int destino = arista.getDestino();
            int peso = adjMatriz[origen][destino];  // Obtener el peso desde la matriz de adyacencia
    
            // Imprimir informacion de la arista
            System.out.println("Arista de " + origen + " a " + destino + " tiene un peso de: " + peso);
        }
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