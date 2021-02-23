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
class Reponse {
    int ID;
    String reponse;
    Question question;
    Note note;

    public Reponse() {
    }

    public Reponse(int ID, String reponse) {
        this.ID = ID;
        this.reponse = reponse;
    }

    public int getID() {
        return ID;
    }

    public String getReponse() {
        return reponse;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public void setReponse(String reponse) {
        this.reponse = reponse;
    }

    @Override
    public String toString() {
        return "Reponse{" + "ID=" + ID + ", reponse=" + reponse + '}';
    }
    
    
}
