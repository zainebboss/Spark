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
class Seance {
    int ID;
    Date date_seance;
    String description;
    String lien;
    Formation formation;
    Formateur formateur;
    Apprenant apprenant[];

    public Seance() {
    }

    public Seance(int ID, Date date_seance, String description, String lien) {
        this.ID = ID;
        this.date_seance = date_seance;
        this.description = description;
        this.lien = lien;
    }

    public int getID() {
        return ID;
    }

    public Date getDate_seance() {
        return date_seance;
    }

    public String getDescription() {
        return description;
    }

    public String getLien() {
        return lien;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public void setDate_seance(Date date_seance) {
        this.date_seance = date_seance;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setLien(String lien) {
        this.lien = lien;
    }

    @Override
    public String toString() {
        return "Seance{" + "ID=" + ID + ", date_seance=" + date_seance + ", description=" + description + ", lien=" + lien + '}';
    }
    
    
    
}
