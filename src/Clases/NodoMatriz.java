/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

/**
 *
 * @author andresrivas
 */
public class NodoMatriz {
    
    private NodoMatriz siguiente;
    private NodoMatriz lateral;
    private Object obj;

    public NodoMatriz(Object obj) {
        this.siguiente = null;
        this.obj = obj;
    }
    
    public void enlazarSiguiente(NodoMatriz siguiente){
        this.siguiente = siguiente;
    }
    public void enlazarLateral(NodoMatriz lateral){
        this.lateral = lateral;
    }

    public NodoMatriz getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(NodoMatriz siguiente) {
        this.siguiente = siguiente;
    }

    public NodoMatriz getLateral() {
        return lateral;
    }

    public void setLateral(NodoMatriz lateral) {
        this.lateral = lateral;
    }

    public Object getObj() {
        return obj;
    }

    public void setObj(Object obj) {
        this.obj = obj;
    }
    
    
}
