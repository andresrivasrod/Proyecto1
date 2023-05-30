/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

/**
 *
 * @author andresrivas
 */
public class ListaUser {
    
    private NodoUser first;
    private NodoUser last;
    private int tamaño;

    public ListaUser() {
        this.first = this.last = null;
        this.tamaño = 0;
    }
    
    public boolean estaVacio() {//Verificar si la lista está vacía
        return (first == null);
    }

    public NodoUser getFirst() {
        return first;
    }

    public void setFirst(NodoUser first) {
        this.first = first;
    }

    public NodoUser getLast() {
        return last;
    }

    public void setLast(NodoUser last) {
        this.last = last;
    }

    public int getTamaño() {
        return tamaño;
    }

    public void setTamaño(int tamaño) {
        this.tamaño = tamaño;
    }
    
    public void añadirElemento(int posicion, String nombre, int id) {//Insertar un elemento de la lista en cualquier posición
        if (first == null) {
            first = last = new NodoUser(posicion, nombre, id);
        } else {
            NodoUser nuevo = new NodoUser(posicion, nombre, id);
            getLast().enlazarSiguiente(nuevo);
            setLast(null);
            setLast(nuevo);
        }
        tamaño++;
    }

    public void imprimirLista() {// Método para imprimir los elementos de la lista
        NodoUser temp = first;
        for (int i = 0; i < tamaño; i++) {
            String string = temp.getPosicion() + ",";
            string = string + temp.getNombre() + ",";
            string = string + temp.getId() + ",";
            System.out.println(string);
            temp = temp.getSiguiente();
        }
    }

    public void agregarAlInicio(NodoUser user) {//Método par insertar un elemento al inicio
        NodoUser nuevo = new NodoUser(user.getPosicion(), user.getNombre(), user.getId());
        if (estaVacio()) {
            first = nuevo;
            last = nuevo;
        } else {
            nuevo.setSiguiente(first);
            first = nuevo;
        }
        tamaño++;

    }

    public void agregarAlFinal(NodoUser user) {//Insertar un elemento al final
        NodoUser nuevo = new NodoUser(user.getPosicion(), user.getNombre(), user.getId());
        if (estaVacio()) {
            agregarAlInicio(user);
        } else {
            last.setSiguiente(nuevo);
            last = nuevo;
            tamaño++;
        }
    }

    public void insertar(int index, NodoUser user) {//Insertar un elemento en cualquier posición
        NodoUser nuevo = new NodoUser(user.getPosicion(), user.getNombre(), user.getId());
        if (estaVacio()) {
            first = nuevo;
            last = nuevo;
            tamaño++;
        } else {
            if (index == 0) {
                agregarAlInicio(user);
            } else {
                if ((tamaño + 1) == index) {
                    agregarAlFinal(user);
                } else {
                    if ((index - 1) == 0) {
                        NodoUser aux_siguiente = first.getSiguiente();
                        first.setSiguiente(nuevo);
                        nuevo.setSiguiente(aux_siguiente);
                        tamaño++;
                    } else {
                        NodoUser aux_anterior = first;
                        for (int i = 0; i < (index - 1); i++) {
                            aux_anterior = aux_anterior.getSiguiente();
                        }

                        NodoUser aux_siguiente = aux_anterior.getSiguiente();
                        aux_anterior.setSiguiente(nuevo);
                        nuevo.setSiguiente(aux_siguiente);
                        tamaño++;
                    }
                }
            }
        }
    }

    public void insertarOrdenado(NodoUser user) {//Insertar un elemento y que la lista ya esté ordenada 
        NodoUser nuevoUser = new NodoUser(user.getPosicion(), user.getNombre(), user.getId());
        if (estaVacio()) {
            this.agregarAlInicio(user);
        } else {
            NodoUser aux = first;
            for (int i = 0; i < (tamaño + 1); i++) {
                if (nuevoUser.getPosicion() < aux.getPosicion()) {
                    this.insertar(i, nuevoUser);
                    break;
                }
                if (aux.getSiguiente() == null) {
                    this.agregarAlFinal(nuevoUser);
                    break;
                }

                aux = aux.getSiguiente();
            }
        }
    }
    
    public void añadirCoordenada(int posicion, String nombre,int id, int x, int y) {//Método para agregar las coordenadas del cliente y que luego se pondrá en el gráfico del grafo
        if (first == null) {
            first = last = new NodoUser(posicion, nombre, id);
        } else {
            NodoUser nuevo = new NodoUser(posicion, nombre, id, x, y);
            getLast().enlazarSiguiente(nuevo);
            setLast(null);
            setLast(nuevo);
        }
        tamaño++;
    }



    public NodoUser obtenerNodos(int pos) {//Obtener el nodo en la respectiva posición que se pasa como parámetro
        NodoUser aux = first;
        for (int i = 0; i < pos; i++) {
            aux = aux.getSiguiente();
        }
        return aux;
    }
    
}
