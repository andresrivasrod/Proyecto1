/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

/**
 *
 * @author andresrivas
 */
public class ListaArista {
    private Arista first;
    private Arista last;
    private int size;

    public ListaArista() {//Constructor de la Lista de Aristas
        first = null;
        last = null;
        size = 0;
    }

    public boolean isEmpty() {//Determinar si está vacía
        return getFirst() == null;
    }

    public void insertLast(int usOrig, int usDest, NodoUser usOrigen, NodoUser usDestino, int tiempo) {//Método para insertar un elemento al final de la lista
        try {
            Arista temp = new Arista(usOrig, usDest, usOrigen, usDestino, tiempo);
            if (isEmpty()) {
                setFirst(temp);
                setLast(getFirst());
            }
            if (!isEmpty()) {
                Arista aux = getLast();
                setLast(temp);
                aux.setSiguiente(getLast());
            }
            setSize(getSize() + 1);
        } catch (NullPointerException i) {

        }
    }

    public Arista getFirst() {
        return first;
    }

    public void setFirst(Arista first) {
        this.first = first;
    }

    public Arista getLast() {
        return last;
    }

    public void setLast(Arista last) {
        this.last = last;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }
    
    

}
