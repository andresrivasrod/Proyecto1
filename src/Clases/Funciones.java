/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

/**
 *
 * @author Edgar Torres
 */
public class Funciones {
    private Grafo grafo;
    private boolean[] visitado;
    private int[] predecesor;
    private int[] orden;
    private int[] low;
    private int tiempo;
    private int[] puentes;
    private int cantidadDePuentes;

    public Funciones(Grafo grafo) {
        this.grafo = grafo;
        this.visitado = new boolean[grafo.obtenerNumeroDeVertices()];
        this.predecesor = new int[grafo.obtenerNumeroDeVertices()];
        this.orden = new int[grafo.obtenerNumeroDeVertices()];
        this.low = new int[grafo.obtenerNumeroDeVertices()];
        this.tiempo = 0;
        this.puentes = new int[grafo.obtenerNumeroDeVertices()];
        this.cantidadDePuentes = 0;
    }

    public String mostrarCantidadDeIslasDFS() { //Funcion que muestra la cantidad de de islas usando el metodo dfs
        int cantidadDeIslas = 0;
        for (int i = 0; i < grafo.obtenerNumeroDeVertices(); i++) {
            if (!visitado[i]) {
                cantidadDeIslas++;
                dfs(i);
            }
        }
        return "La cantidad de islas es: " + cantidadDeIslas;
    }

    public String mostrarCantidadDeIslasBFS() { //Funcion que muestra la cantidad de de islas usando el metodo bfs
        int cantidadDeIslas = 0;
        for (int i = 0; i < grafo.obtenerNumeroDeVertices(); i++) {
            if (!visitado[i]) {
                cantidadDeIslas++;
                bfs(i);
            }
        }
        return "La cantidad de islas es: " + cantidadDeIslas;
    }

    public String identificarPuentes() { //Funcion que identifica los puentes usando el metodo dfs
        for (int i = 0; i < grafo.obtenerNumeroDeVertices(); i++) {
            if (!visitado[i]) {
                dfsPuentes(i, -1);
            }
        }
        return "Los puentes son: "+ nombrarPuentes();    
    }    
    
    public String nombrarPuentes(){
        String puen = "";
        for (int j = 0; j < cantidadDePuentes; j++) {
            puen += puentes[j] + " ";
        }
        return puen;
    } 
       
    

    private void dfs(int actual) { //Funcion dfs
        visitado[actual] = true;
        for (int adyacente : grafo.obtenerAdyacentes(actual)) {
            if (!visitado[adyacente]) {
                predecesor[adyacente] = actual;
                dfs(adyacente);
            }
        }
    }

    private void bfs(int actual) { //Funcion bfs
    visitado[actual] = true;
    int[] cola = new int[grafo.obtenerNumeroDeVertices()];
    int inicio = 0;
    int fin = 0;
    cola[fin] = actual;
    fin++;
    while (inicio < fin) {
        int vertice = cola[inicio];
        inicio++;
        for (int adyacente : grafo.obtenerAdyacentes(vertice)) {
            if (!visitado[adyacente]) {
                visitado[adyacente] = true;
                predecesor[adyacente] = vertice;
                cola[fin] = adyacente;
                fin++;
            }
        }
    }
}


    private void dfsPuentes(int actual, int padre) { 
        visitado[actual] = true;
        predecesor[actual] = padre;
        orden[actual] = tiempo;
        low[actual] = tiempo;
        tiempo++;
        for (int adyacente : grafo.obtenerAdyacentes(actual)) {
            if (!visitado[adyacente]) {
                dfsPuentes(adyacente, actual);
                low[actual] = low[actual] < low[adyacente] ? low[actual] : low[adyacente];
                if (low[adyacente] > orden[actual]) {
                    puentes[cantidadDePuentes] = actual;
                    cantidadDePuentes++;
                }
            } else if (adyacente != padre) {
                low[actual] = low[actual] < orden[adyacente] ? low[actual] : orden[adyacente];
            }
        }
    }
}

