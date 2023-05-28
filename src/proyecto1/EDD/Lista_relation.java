/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto1.EDD;

/**
 *
 * @author andresrivas
 */
public class Lista_relation {
    
    private Nodo_relation first;
    private Nodo_relation last;
    private int tamaño;

    public Lista_relation() {
        this.first = this.last = null;
        this.tamaño = 0;
    }

    public Nodo_relation getFirst() {
        return first;
    }

    public void setFirst(Nodo_relation first) {
        this.first = first;
    }

    public Nodo_relation getLast() {
        return last;
    }

    public void setLast(Nodo_relation last) {
        this.last = last;
    }

    public int getTamaño() {
        return tamaño;
    }

    public void setTamaño(int tamaño) {
        this.tamaño = tamaño;
    }
    
    public void añadir_elemento(int user1, int user2, int tiempo) {//Método para añadir elemento en la lista
        if (first == null) {
            first = last = new Nodo_relation(user1, user2, tiempo);
        } else {
            Nodo_relation nuevo = new Nodo_relation(user1, user2, tiempo);
            getLast().enlazar_siguiente(nuevo);
            setLast(null);
            setLast(nuevo);
        }
        tamaño++;
    }

    public void imprimir_lista() {//Método para imprimir la lisa
        Nodo_relation temp = first;
        for (int i = 0; i < tamaño; i++) {
            String string = temp.getUser1() + ",";
            string = string + temp.getUser2()+ ",";
            string = string + temp.getTiempo();
            System.out.println(string);
            temp = temp.getSiguiente();
        }
    }
    
}
