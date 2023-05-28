/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

/**
 *
 * @author andresrivas
 */
public class NodoRelation {
    
    private NodoRelation siguiente;
    private int user1;
    private int user2;
    private int tiempo;

    public NodoRelation(int user1, int user2, int tiempo) {
        this.siguiente = null;
        this.user1 = user1;
        this.user2 = user2;
        this.tiempo = tiempo;
    }

    public NodoRelation getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(NodoRelation siguiente) {
        this.siguiente = siguiente;
    }

    public int getUser1() {
        return user1;
    }

    public void setUser1(int user1) {
        this.user1 = user1;
    }

    public int getUser2() {
        return user2;
    }

    public void setUser2(int user2) {
        this.user2 = user2;
    }

    public int getTiempo() {
        return tiempo;
    }

    public void setTiempo(int tiempo) {
        this.tiempo = tiempo;
    }
    
    public void enlazarSiguiente(NodoRelation siguiente) {
        this.siguiente = siguiente;
    }
}
