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
class Cour {
    int ID;
    String titre;
    String fichier;
    Formation formation;
    Examen examen;

    public Cour() {
    }

    public Cour(int ID, String titre, String fichier) {
        this.ID = ID;
        this.titre = titre;
        this.fichier = fichier;
    }

    public int getID() {
        return ID;
    }

    public String getTitre() {
        return titre;
    }

    public String getFichier() {
        return fichier;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public void setFichier(String fichier) {
        this.fichier = fichier;
    }

    @Override
    public String toString() {
        return "Cour{" + "ID=" + ID + ", titre=" + titre + ", fichier=" + fichier + '}';
    }
    
    
    
}
