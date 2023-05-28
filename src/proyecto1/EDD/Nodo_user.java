/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto1.EDD;

/**
 *
 * @author andresrivas
 */
public class Nodo_user {
    private Nodo_user siguiente;
    private int posicion, x, y;
    private String nombre;
    private int id;

    public Nodo_user( int posicion, String nombre, int id) {
        this.siguiente = null;
        this.posicion = posicion;
        this.nombre = nombre;
        this.id = id;
    }

    public Nodo_user(int posicion, String nombre, int id, int x, int y) {
        this.siguiente = null;
        this.posicion = posicion;
        this.nombre = nombre;
        this.id = id;
    }

    public Nodo_user getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(Nodo_user siguiente) {
        this.siguiente = siguiente;
    }

    public int getPosicion() {
        return posicion;
    }

    public void setPosicion(int posicion) {
        this.posicion = posicion;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
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
    
    public void enlazar_siguiente(Nodo_user siguiente) {
        this.siguiente = siguiente;
    }
    
    
}
