/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;

import java.util.Date;

/**
 *
 * @author Zaineb
 */
public class Formation {
    int ID;
    String titre;
    Date date_debut;
    Date date_fin;
    String description;
    Double prix;
    int nb_class;
    Inscription inscription[];
    Seance seances[];
    Cour cour[];

    public Formation() {
    }

    public Formation(int ID, String titre, Date date_debut, Date date_fin, String description, Double prix, int nb_class) {
        this.ID = ID;
        this.titre = titre;
        this.date_debut = date_debut;
        this.date_fin = date_fin;
        this.description = description;
        this.prix = prix;
        this.nb_class = nb_class;
    }

    public int getID() {
        return ID;
    }

    public String getTitre() {
        return titre;
    }

    public Date getDate_debut() {
        return date_debut;
    }

    public Date getDate_fin() {
        return date_fin;
    }

    public String getDescription() {
        return description;
    }

    public Double getPrix() {
        return prix;
    }

    public int getNb_class() {
        return nb_class;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public void setDate_debut(Date date_debut) {
        this.date_debut = date_debut;
    }

    public void setDate_fin(Date date_fin) {
        this.date_fin = date_fin;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setPrix(Double prix) {
        this.prix = prix;
    }

    public void setNb_class(int nb_class) {
        this.nb_class = nb_class;
    }

    @Override
    public String toString() {
        return "Formation{" + "ID=" + ID + ", titre=" + titre + ", date_debut=" + date_debut + ", date_fin=" + date_fin + ", description=" + description + ", prix=" + prix + ", nb_class=" + nb_class + '}';
    }
    
}
