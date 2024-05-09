package trabajopractico.back;

import java.util.Arrays;

public class Prim {

    public static void calcularMST(Grafo grafo) {
        int numVertices = grafo.getCantidadVertices();
        int[] parent = new int[numVertices];
        int[] key = new int[numVertices];
        boolean[] mstSet = new boolean[numVertices];

        Arrays.fill(key, Integer.MAX_VALUE);
        Arrays.fill(parent, -1);
        key[0] = 0;

        for (int count = 0; count < numVertices - 1; count++) {
            int u = minKey(key, mstSet, grafo);
            if (u == -1) {
                // Manejar el error o romper el bucle si todos los vértices están incluidos
                System.out.println("No se encontró un vértice válido para continuar el MST.");
                break;
            }
            mstSet[u] = true;

            for (int v = 0; v < numVertices; v++) {
                if (grafo.getAdjMatriz()[u][v] != 0 && !mstSet[v] && grafo.getAdjMatriz()[u][v] < key[v]) {
                    parent[v] = u;
                    key[v] = grafo.getAdjMatriz()[u][v];
                }
            }
        }

        // Reiniciar la matriz de adyacencia para el MST (opcional, depende si quieres limpiar las conexiones no MST)
        for (int i = 0; i < numVertices; i++) {
            for (int j = 0; j < numVertices; j++) {
                grafo.getAdjMatriz()[i][j] = 0;  // Borrar la matriz existente si es necesario
            }
        }

        // Utilizar agregarArista para reconstruir el MST
        for (int i = 1; i < numVertices; i++) {
            int u = parent[i];
            int v = i;
            if (u != -1) {  // Solo intentar agregar arista si existe un padre válido
                int peso = grafo.getAdjMatriz()[u][v];
                grafo.agregarArista(u, v, peso);  // Usar agregarArista garantiza la creación de MapPolygon
            } else {
                System.out.println("No hay padre para el vértice " + i + ", por lo que no se agrega arista.");
            }
        }
    }

    private static int minKey(int[] key, boolean[] mstSet, Grafo grafo) {
        int min = Integer.MAX_VALUE;
        int minIndex = -1;
        for (int v = 0; v < grafo.getCantidadVertices(); v++) {
            if (!mstSet[v] && key[v] < min) {
                min = key[v];
                minIndex = v;
            }
        }
        return minIndex;
    }
}