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
class Inscription {
    int ID;
    Date date_inscription;
    Apprenant apprenant;
    Formation formation;

    public Inscription() {
    }

    public Inscription(int ID, Date date_inscription, Apprenant apprenant, Formation formation) {
        this.ID = ID;
        this.date_inscription = date_inscription;
        this.apprenant = apprenant;
        this.formation = formation;
    }
    

    public int getID() {
        return ID;
    }

    public Date getDate_inscription() {
        return date_inscription;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public void setDate_inscription(Date date_inscription) {
        this.date_inscription = date_inscription;
    }

    @Override
    public String toString() {
        return "Inscription{" + "ID=" + ID + ", date_inscription=" + date_inscription + '}';
    }
    
}
