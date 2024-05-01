package trabajopractico.back;

public class Grafo {
    
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
    }

    public void agregarArista(int primerVertice, int segundoVertice, int peso){
        adjMatriz[primerVertice][segundoVertice] = peso; 
        adjMatriz[segundoVertice][primerVertice] = peso; //esto si solo si el grafo no es dirigido.
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

    public Vertice[] getVertices() {
        return vertices;
    }

    public int[][] getAdjMatriz() {
        return adjMatriz;
    }
    //public static void main(String[] args) {
    //    int cantProvincias= 2;
    //    Grafo argentina= new Grafo(cantProvincias);

    //    //--------------Genero los vertices de las provincias--------------
    //    Vertice verticeBuenosAires= new Vertice("Buenos Aires", -34.6037, -58.3816);
    //    Vertice verticeCordoba= new Vertice("Cordoba", -31.4201, -64.1888);

    //    //----------------Incluyo los vertices al grafo--------------------
    //    argentina.addVertice(verticeBuenosAires, 0);    //indice 0 --> Buenos Aires
    //    argentina.addVertice(verticeCordoba, 1);        //indice 1 --> Cordoba
    //    
    //    argentina.agregarArista(0, 1, 200);
    //    
    //    argentina.printGrafo();
    //}
}