/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto1.EDD;

/**
 *
 * @author andresrivas
 */
public class Nodo {
    private User user;
    private Nodo pNext;

    public Nodo(User user) {
        this.user = user;
        this.pNext = null;
    }

    public Nodo(User user, Nodo nodo) {
        this.user = user;
        this.pNext = nodo;
    }

    /**
     * @return the user
     */
    public User getUser() {
        return user;
    }

    /**
     * @param user the user to set
     */
    public void setUser(User user) {
        this.user = user;
    }

    /**
     * @return the pNext
     */
    public Nodo getpNext() {
        return pNext;
    }

    /**
     * @param pNext the pNext to set
     */
    public void setpNext(Nodo pNext) {
        this.pNext = pNext;
    }
    
    
}
