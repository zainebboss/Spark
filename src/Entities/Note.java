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
class Note {
    int ID;
    int note;
    Examen examen;
    Reponse reponse[];

    public Note() {
    }

    public Note(int ID, int note) {
        this.ID = ID;
        this.note = note;
    }

    public int getID() {
        return ID;
    }

    public Examen getExamen() {
        return examen;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public void setExamen(Examen examen) {
        this.examen = examen;
    }

    @Override
    public String toString() {
        return "Note{" + "ID=" + ID + ", note=" + note + '}';
    }
    
    
}
