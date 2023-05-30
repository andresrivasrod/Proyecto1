/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;

/**
 *
 * @author andresrivas
 */
public class GraficoGrafo {
    
    public ListaUser userGrafo = new ListaUser();
    public ListaArista relationGrafo = new ListaArista();
    
    public void ValoresIniciales() {//Setear valores iniciales
        relationGrafo.setFirst(null);
        relationGrafo.setFirst(null);
        relationGrafo.setSize(0);
        userGrafo.setFirst(null);
        userGrafo.setLast(null);
        userGrafo.setTamaño(0);
    }

    public void PintarNodo(Graphics g) {//Método para pintar el nodo en el mapa
        if (userGrafo.getFirst() != null) {
            NodoUser aux = userGrafo.getFirst();
            while (aux != null) {
                ((Graphics2D) g).setColor(Color.BLUE);
                ((Graphics2D) g).setStroke(new BasicStroke(3));
                ((Graphics2D) g).fillOval(aux.getX(), aux.getY(), 15, 15);
                ((Graphics2D) g).setColor(Color.BLUE);
                ((Graphics2D) g).drawOval(aux.getX(), aux.getY(), 15, 15);
                ((Graphics2D) g).setColor(Color.BLACK);
                Font fuente = new Font("Monospaced", Font.BOLD, 12);
                g.setFont(fuente);
                ((Graphics2D) g).drawString((aux.getPosicion() + "." + aux.getNombre()), aux.getX(), aux.getY());
                aux = aux.getSiguiente();
            }
        }
    }

    public void PintarArista(Graphics g) {//Método para pintar la arista en el gráfico
        Arista aux = relationGrafo.getFirst();
        while (aux != null) {
            ((Graphics2D) g).setColor(Color.GREEN);
            g.drawLine(aux.getNodoOrigen()[0], aux.getNodoOrigen()[1] + 15, aux.getNodoDestino()[0], aux.getNodoDestino()[1] + 10);
            aux = aux.getSiguiente();
        }
    }

    public void Pintar(Graphics g) {//Método para pintar todo
        PintarArista(g);
        PintarNodo(g);
    }
}
