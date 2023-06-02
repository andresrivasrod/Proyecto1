/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

/**
 *
 * @author andresrivas
 */
public class Grafo {
    public int cantidadUser = 0;
    public NodoUser[] vectorUser;
    public int[][] matrizRecorridos;
    public int[][] matrizDistancias;
    public ListaRelation listaRelation = new ListaRelation();
    public ListaUser userGrafo = new ListaUser();
    public ListaArista relationGrafo = new ListaArista();

    public Grafo(ListaUser userGrafo, ListaRelation listaRelation) {
        this.userGrafo = userGrafo;
        this.listaRelation = listaRelation;
    }

    public void RellenarMatriz() {//Procedimiento para rellenar la matriz
        matrizRecorridos = new int[cantidadUser][cantidadUser];
        for (int i = 0; i < matrizRecorridos.length; i++) {
            for (int j = 0; j < matrizRecorridos[0].length; j++) {
                if (i == j) {
                    matrizRecorridos[i][j] = -1;
                } else {
                    matrizRecorridos[i][j] = 999999999;
                }
            }
        }
    }

    public void ActualizarMatriz() {//Obtener los datos de los usuarios para el grafo
        NodoRelation aux = listaRelation.getFirst();
        matrizDistancias = new int[cantidadUser][cantidadUser];
        matrizRecorridos = new int[cantidadUser][cantidadUser];
        RellenarMatriz();
        while (aux != null) {
            int user1 = aux.getUser1();
            int user2 = aux.getUser2();
            matrizDistancias[user1 - 1][user2 - 1] = aux.getTiempo();
            aux = aux.getSiguiente();
        }
        for (int i = 0; i < matrizDistancias.length; i++) {
            for (int j = 0; j < matrizDistancias.length; j++) {
                if ((matrizDistancias[i][j] == 0) && i != j) {
                    matrizDistancias[i][j] = 999999999;
                }
            }
        }
    }

    int[] obtenerAdyacentes(int vertice) { //Obtener los adyacentes del grafo
        int[] adyacentes = new int[cantidadUser];
        int cantidadAdyacentes = 0;
        for (int i = 0; i < cantidadUser; i++) {
            if (matrizDistancias[vertice][i] != 0 && matrizDistancias[vertice][i] != 999999999) {
                adyacentes[cantidadAdyacentes] = i;
                cantidadAdyacentes++;
            }
        }
        int[] resultado = new int[cantidadAdyacentes];
        for (int i = 0; i < cantidadAdyacentes; i++) {
            resultado[i] = adyacentes[i];
        }
        return resultado;
    }

    int obtenerNumeroDeVertices() { //Obtener los numeros de vertices del grafo
        return cantidadUser;
    }
}
