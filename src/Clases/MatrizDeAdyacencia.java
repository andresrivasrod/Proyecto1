/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

import javax.swing.JOptionPane;

/**
 *
 * @author andresrivas
 */
public class MatrizDeAdyacencia {
    
    private NodoMatriz first;
    private NodoMatriz last;
    private int tamaño;

    public NodoMatriz getFirst() {
        return first;
    }

    public void setFirst(NodoMatriz first) {
        this.first = first;
    }

    public NodoMatriz getLast() {
        return last;
    }

    public void setLast(NodoMatriz last) {
        this.last = last;
    }

    public int getTamaño() {
        return tamaño;
    }

    public void setTamaño(int tamaño) {
        this.tamaño = tamaño;
    }
    
    public MatrizDeAdyacencia(ListaRelation relation){ //Constructor de la matriz, se le pasa como parámetro la Lista de relaciones
        try{
            int dimensiones = 0;
            NodoRelation temp = relation.getFirst();
            for (int i = 0; i < relation.getTamaño(); i++) { //Bucle para obtener las dimensiones de la matriz
                if (temp.getUser1()>dimensiones) {
                    dimensiones = temp.getUser1();
                }
                temp = temp.getSiguiente();
            }
            
            for (int i = 0; i < dimensiones; i++) { //Bucle para crear la matriz de adyacencia
                if (first == null) {
                    first = last = new NodoMatriz(" ");
                    NodoMatriz aux = first;
                    for (int j = 0; j < dimensiones; j++) {
                        NodoMatriz nuevo = new NodoMatriz(j+1);
                        aux.enlazarLateral(nuevo);
                        aux = aux.getLateral();
                    }
                    tamaño++;
                }else{
                    NodoMatriz aux2 = new NodoMatriz(getTamaño());
                    last.enlazarSiguiente(aux2);
                    last = null;
                    last = aux2;
                    for (int j = 0; j < dimensiones; j++) {
                        NodoMatriz nuevo2 = new NodoMatriz("X");
                        aux2.enlazarLateral(nuevo2);
                        aux2 = aux2.getLateral();
                    }
                    tamaño++;
                }
            }
            for (int i = 1; i < tamaño; i++) {
                NodoMatriz auxiliar = first;
                for (int j = 0; j < i; j++) {
                    auxiliar = auxiliar.getSiguiente();
                }
                for (int j = 0; j < i; j++) {
                    auxiliar = auxiliar.getLateral();
                }
                auxiliar.setObj(0);
            }
            
            NodoRelation temporal = relation.getFirst();
            for (int i = 0; i < relation.getTamaño(); i++) {  //Bucle para asignar cada valor a los nodos de la matriz en base a las lista de relaciones y usuarios  
                NodoMatriz auxiliar = first;
                for (int j = 0; j < temporal.getUser1(); j++) {
                    auxiliar = auxiliar.getSiguiente();
                }
                for (int j = 0; j < temporal.getUser2(); j++) {
                    auxiliar = auxiliar.getLateral();
                }
                auxiliar.setObj(temporal.getTiempo());
                temporal = temporal.getSiguiente();
            }
        }
        catch (Exception e){
            JOptionPane.showMessageDialog(null, "Hubo un error al crear la matriz");
        }
    }
    
    public void imprimirMatriz(){  //Método para imprimir la matriz de adyacencia
        NodoMatriz aux = getFirst();
        NodoMatriz temp;
        for (int i = 0; i < getTamaño(); i++) {
            String fila = "";
            temp = aux;
            for (int j = 0; j < getTamaño(); j++) {
                fila = fila + "   " + temp.getObj();
                temp = temp.getLateral();
            }
            System.out.println(fila);
            aux = aux.getSiguiente();
        }
    }
            
}
