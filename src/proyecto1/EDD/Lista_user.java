/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto1.EDD;

/**
 *
 * @author andresrivas
 */
public class Lista_user {
    
    private Nodo_user first;
    private Nodo_user last;
    private int tamaño;

    public Lista_user() {
        this.first = this.last = null;
        this.tamaño = 0;
    }
    
    public boolean esta_vacio() {//Verificar si la lista está vacía
        return (first == null);
    }

    public Nodo_user getFirst() {
        return first;
    }

    public void setFirst(Nodo_user first) {
        this.first = first;
    }

    public Nodo_user getLast() {
        return last;
    }

    public void setLast(Nodo_user last) {
        this.last = last;
    }

    public int getTamaño() {
        return tamaño;
    }

    public void setTamaño(int tamaño) {
        this.tamaño = tamaño;
    }
    
    public void añadir_elemento(int posicion, String nombre, int id) {//Insertar un elemento de la lista en cualquier posición
        if (first == null) {
            first = last = new Nodo_user(posicion, nombre, id);
        } else {
            Nodo_user nuevo = new Nodo_user(posicion, nombre, id);
            getLast().enlazar_siguiente(nuevo);
            setLast(null);
            setLast(nuevo);
        }
        tamaño++;
    }

    public void imprimir_lista() {// Método para imprimir los elementos de la lista
        Nodo_user temp = first;
        for (int i = 0; i < tamaño; i++) {
            String string = temp.getPosicion() + ",";
            string = string + temp.getNombre() + ",";
            string = string + temp.getId() + ",";
            System.out.println(string);
            temp = temp.getSiguiente();
        }
    }

    public void agregar_al_inicio(Nodo_user user) {//Método par insertar un elemento al inicio
        Nodo_user nuevo = new Nodo_user(user.getPosicion(), user.getNombre(), user.getId());
        if (esta_vacio()) {
            first = nuevo;
            last = nuevo;
        } else {
            nuevo.setSiguiente(first);
            first = nuevo;
        }
        tamaño++;

    }

    public void agregar_al_final(Nodo_user user) {//Insertar un elemento al final
        Nodo_user nuevo = new Nodo_user(user.getPosicion(), user.getNombre(), user.getId());
        if (esta_vacio()) {
            agregar_al_inicio(user);
        } else {
            last.setSiguiente(nuevo);
            last = nuevo;
            tamaño++;
        }
    }

    public void insertar(int index, Nodo_user user) {//Insertar un elemento en cualquier posición
        Nodo_user nuevo = new Nodo_user(user.getPosicion(), user.getNombre(), user.getId());
        if (esta_vacio()) {
            first = nuevo;
            last = nuevo;
            tamaño++;
        } else {
            if (index == 0) {
                agregar_al_inicio(user);
            } else {
                if ((tamaño + 1) == index) {
                    agregar_al_final(user);
                } else {
                    if ((index - 1) == 0) {
                        Nodo_user aux_siguiente = first.getSiguiente();
                        first.setSiguiente(nuevo);
                        nuevo.setSiguiente(aux_siguiente);
                        tamaño++;
                    } else {
                        Nodo_user aux_anterior = first;
                        for (int i = 0; i < (index - 1); i++) {
                            aux_anterior = aux_anterior.getSiguiente();
                        }

                        Nodo_user aux_siguiente = aux_anterior.getSiguiente();
                        aux_anterior.setSiguiente(nuevo);
                        nuevo.setSiguiente(aux_siguiente);
                        tamaño++;
                    }
                }
            }
        }
    }

    public void insertar_ordenado(Nodo_user user) {//Insertar un elemento y que la lista ya esté ordenada 
        Nodo_user nuevo_user = new Nodo_user(user.getPosicion(), user.getNombre(), user.getId());
        if (esta_vacio()) {
            this.agregar_al_inicio(user);
        } else {
            Nodo_user aux = first;
            for (int i = 0; i < (tamaño + 1); i++) {
                if (nuevo_user.getPosicion() < aux.getPosicion()) {
                    this.insertar(i, nuevo_user);
                    break;
                }
                if (aux.getSiguiente() == null) {
                    this.agregar_al_final(nuevo_user);
                    break;
                }

                aux = aux.getSiguiente();
            }
        }
    }


    public Nodo_user obtener_nodos(int pos) {//Obtener el nodo en la respectiva posición que se pasa como parámetro
        Nodo_user aux = first;
        for (int i = 0; i < pos; i++) {
            aux = aux.getSiguiente();
        }
        return aux;
    }
    
}
