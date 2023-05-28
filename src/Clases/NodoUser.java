/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

/**
 *
 * @author andresrivas
 */
public class NodoUser {
    private NodoUser siguiente;
    private int posicion;
    private String nombre;
    private int id;

    public NodoUser( int posicion, String nombre, int id) {
        this.siguiente = null;
        this.posicion = posicion;
        this.nombre = nombre;
        this.id = id;
    }

    public NodoUser getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(NodoUser siguiente) {
        this.siguiente = siguiente;
    }

    public int getPosicion() {
        return posicion;
    }

    public void setPosicion(int posicion) {
        this.posicion = posicion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    public void enlazarSiguiente(NodoUser siguiente) {
        this.siguiente = siguiente;
    }
    
    
}