/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

/**
 *
 * @author andresrivas
 */
public class ListaRelation {
    
    private NodoRelation first;
    private NodoRelation last;
    private int tamaño;

    public ListaRelation() {
        this.first = this.last = null;
        this.tamaño = 0;
    }

    public NodoRelation getFirst() {
        return first;
    }

    public void setFirst(NodoRelation first) {
        this.first = first;
    }

    public NodoRelation getLast() {
        return last;
    }

    public void setLast(NodoRelation last) {
        this.last = last;
    }

    public int getTamaño() {
        return tamaño;
    }

    public void setTamaño(int tamaño) {
        this.tamaño = tamaño;
    }
    
    public void añadirElemento(int user1, int user2, int tiempo) {//Método para añadir elemento en la lista
        if (first == null) {
            first = last = new NodoRelation(user1, user2, tiempo);
        } else {
            NodoRelation nuevo = new NodoRelation(user1, user2, tiempo);
            getLast().enlazarSiguiente(nuevo);
            setLast(null);
            setLast(nuevo);
        }
        tamaño++;
    }

    public void imprimirLista() {//Método para imprimir la lisa
        NodoRelation temp = first;
        for (int i = 0; i < tamaño; i++) {
            String string = temp.getUser1() + ",";
            string = string + temp.getUser2()+ ",";
            string = string + temp.getTiempo();
            System.out.println(string);
            temp = temp.getSiguiente();
        }
    }
    
}
