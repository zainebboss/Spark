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
class Examen {
    int ID;
    String titre;
    String description;
    Question question[];
    Note note[];
    Formateur formateur;
    Cour cour;

    public Examen() {
    }

    public Examen(int ID, String titre, String description) {
        this.ID = ID;
        this.titre = titre;
        this.description = description;
    }

    public int getID() {
        return ID;
    }

    public String getTitre() {
        return titre;
    }

    public String getDescription() {
        return description;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Examen{" + "ID=" + ID + ", titre=" + titre + ", description=" + description + '}';
    }
    
    
}
