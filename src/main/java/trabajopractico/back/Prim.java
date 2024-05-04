package trabajopractico.back;

import java.util.Arrays;

public class Prim {
    private Grafo grafo;

    public Prim(Grafo grafo) {
        this.grafo = grafo;
    }

    public int[] calcularMST() {
        int numVertices = grafo.getCantidadVertices();
        int[] parent = new int[numVertices];  // Almacena el árbol generador mínimo
        int[] key = new int[numVertices];     // Almacena los pesos mínimos de corte de todos los vértices
        boolean[] mstSet = new boolean[numVertices]; // Rastrea los vértices no incluidos en el MST

        Arrays.fill(key, Integer.MAX_VALUE);
        Arrays.fill(parent, -1);

        key[0] = 0; // Hace la clave 0 para que este vértice sea elegido primero

        for (int count = 0; count < numVertices - 1; count++) {
            imprimirEstados(key, parent, mstSet);

            int u = minKey(key, mstSet);
            mstSet[u] = true;
            System.out.println("Vértice seleccionado: " + u + " con costo mínimo: " + key[u]);

            imprimirEstados(key, parent, mstSet);

            for (int v = 0; v < numVertices; v++) {
                // grafo.getAdjMatriz() accede a la matriz de adyacencia de la clase Grafo
                if (grafo.getAdjMatriz()[u][v] != 0 && grafo.getAdjMatriz()[u][v] != Integer.MAX_VALUE && !mstSet[v] && grafo.getAdjMatriz()[u][v] < key[v]) {
                    parent[v] = u;
                    key[v] = grafo.getAdjMatriz()[u][v];
                    
                    System.out.println("  Actualizando vértice: " + v + " con nuevo costo: " + key[v] + " conectado a través de: " + u);
                    imprimirEstados(key, parent, mstSet);
                }
            }
        }

        imprimirEstados(key, parent, mstSet);
        return parent;
    }

    private int minKey(int[] key, boolean[] mstSet) {
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

    private void imprimirEstados(int[] key, int[] parent, boolean[] mstSet) {
        System.out.println("Estado actual de key[]: " + Arrays.toString(key));
        System.out.println("Estado actual de parent[]: " + Arrays.toString(parent));
        System.out.println("Estado actual de mstSet[]: " + Arrays.toString(mstSet));
    }
}