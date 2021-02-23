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
public class Apprenant extends User {
    String nom;
    String prenom;
    int telephone;
    String adresse;
    Date date_naissance;
    boolean enable;
    Seance seance[];
    Inscription inscription[];

    public Apprenant() {
    }

    public Apprenant(String nom, String prenom, int telephone, String adresse, Date date_naissance, boolean enable, int ID, String email, String password) {
        super(ID, email, password);
        this.nom = nom;
        this.prenom = prenom;
        this.telephone = telephone;
        this.adresse = adresse;
        this.date_naissance = date_naissance;
        this.enable = enable;
        
    }

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public int getTelephone() {
        return telephone;
    }

    public String getAdresse() {
        return adresse;
    }

    public Date getDate_naissance() {
        return date_naissance;
    }

    public boolean isEnable() {
        return enable;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public void setTelephone(int telephone) {
        this.telephone = telephone;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public void setDate_naissance(Date date_naissance) {
        this.date_naissance = date_naissance;
    }

    public void setEnable(boolean enable) {
        this.enable = enable;
    }

    @Override
    public String toString() {
        return super.toString() + "Apprenant{" + "nom=" + nom + ", prenom=" + prenom + ", telephone=" + telephone + ", adresse=" + adresse + ", date_naissance=" + date_naissance + ", enable=" + enable + '}';
    }
    
    
    
}
