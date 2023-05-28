/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

/**
 *
 * @author andresrivas
 */
public class Arista {
    private int origen;
    private int destino;
    private int tiempo;
    private int[] nodoOrigen = new int[2];
    private int[] nodoDestino = new int[2];
    private Arista siguiente;

    public Arista(int origen, int destino, NodoUser origenN, NodoUser destinoN, int tiempo) {//Constructor de la clase arista
        this.origen = origen;
        nodoOrigen[0] = origenN.getX();
        nodoOrigen[1] = origenN.getY();
        this.destino = destino;
        nodoDestino[0] = destinoN.getX();
        nodoDestino[1] = destinoN.getY();
        this.tiempo = tiempo;
        siguiente = null;
    }

    public int getOrigen() {
        return origen;
    }

    public void setOrigen(int origen) {
        this.origen = origen;
    }

    public int getDestino() {
        return destino;
    }

    public void setDestino(int destino) {
        this.destino = destino;
    }

    public int getTiempo() {
        return tiempo;
    }

    public void setTiempo(int tiempo) {
        this.tiempo = tiempo;
    }

    public int[] getNodoOrigen() {
        return nodoOrigen;
    }

    public void setNodoOrigen(int[] nodoOrigen) {
        this.nodoOrigen = nodoOrigen;
    }

    public int[] getNodoDestino() {
        return nodoDestino;
    }

    public void setNodoDestino(int[] nodoDestino) {
        this.nodoDestino = nodoDestino;
    }

    public Arista getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(Arista siguiente) {
        this.siguiente = siguiente;
    }
    
    
    
}
