package trabajopractico.back;

import java.util.Arrays;

public class Prim {

    public static void calcularMST(Grafo grafo) {
        int numVertices = grafo.getCantidadVertices();
        // Arrays para el algoritmo de Prim:
        int[] parent = new int[numVertices];  // Almacena el arbol generador minimo
        int[] key = new int[numVertices];     // Almacena los pesos minimos de corte de todos los vertices
        boolean[] mstSet = new boolean[numVertices]; // Rastrea los vertices ya incluidos en el MST
    
        // Inicializacion de los arrays:
        Arrays.fill(key, Integer.MAX_VALUE); // Inicia todas las claves con infinito
        Arrays.fill(parent, -1); // Inicia todos los padres como no definidos
        key[0] = 0; // Comienza desde el vertice 0, asignandole la clave minima de 0
    
        // Bucle principal del algoritmo de Prim:
        for (int count = 0; count < numVertices - 1; count++) {
            int u = minKey(key, mstSet, grafo);
            if (u == -1) {
                System.out.println("No se encontro un vertice valido para continuar el MST.");
                break;
            }
            mstSet[u] = true; // Marca el vertice como incluido en MST
    
            // Actualiza las claves y los padres de los vertices adyacentes al vertice seleccionado:
            for (int v = 0; v < numVertices; v++) {
                // Actualiza la clave solo si v no esta en mstSet, hay una arista de u a v, y el peso
                // de la arista es menor que la clave actual de v.
                if (grafo.getAdjMatriz()[u][v] != 0 && !mstSet[v] && grafo.getAdjMatriz()[u][v] < key[v]) {
                    parent[v] = u;
                    key[v] = grafo.getAdjMatriz()[u][v];
                }
            }
        }
    
        // Limpieza de la matriz de adyacencia:
        for (int i = 0; i < numVertices; i++) {
            for (int j = 0; j < numVertices; j++) {
                grafo.getAdjMatriz()[i][j] = Integer.MAX_VALUE;  // Establecer todos los enlaces como infinito
            }
        }
    
        // Reconstruccion de las aristas del MST en la matriz de adyacencia y la lista de aristas:
        for (int i = 1; i < numVertices; i++) {
            if (parent[i] != -1) {  // Si existe un padre valido
                int u = parent[i];
                int v = i;
                // Establecer el peso en ambos sentidos ya que el grafo es no dirigido
                grafo.getAdjMatriz()[u][v] = key[v];
                grafo.getAdjMatriz()[v][u] = key[v];
                // Agregar la arista al grafo, lo que tambien maneja la visualizacion si es necesario
                grafo.agregarArista(u, v, key[v]);  
            }
        }
    }
    
    private static int minKey(int[] key, boolean[] mstSet, Grafo grafo) {
        int min = Integer.MAX_VALUE;
        int minIndex = -1;
        // Encuentra el vertice con la clave minima, que aun no esta incluido en MST
        for (int i = 0; i < grafo.getCantidadVertices(); i++) {
            if (!mstSet[i] && key[i] < min) {
                min = key[i];
                minIndex = i;
            }
        }
        return minIndex;
    }
}