/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto1.EDD;

/**
 *
 * @author andresrivas
 */
public class User {
    private int id;
    private String name;
    
    public User(){
        
    }
    public User(int id, String name){
        this.id = id;
        this.name = name;
    }
    public User(String[] user){
        this.id = Integer.parseInt(user[0]);
        this.name = user[1];
    }
    
    public String printUser(){
        String user = Integer.toString(this.getId())+ ", " + this.getName();
        return user;
    }

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }
    
    
}
