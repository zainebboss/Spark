/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;

/**
 *
 * @author Zaineb
 */
public class User {
    int ID;
    String email;
    String password;

    public User() {
    }

    public User(int ID, String email, String password) {
        this.ID = ID;
        this.email = email;
        this.password = password;
    }
    

    public int getID() {
        return ID;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "User{" + "ID=" + ID + ", email=" + email + ", password=" + password + '}';
    }
    
    
}
