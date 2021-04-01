/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package piprojet.entities;

/**
 *
 * @author imen
 */
public class Matiere {
    
    private int idMatiere;
    private String nomMatiere;
    private String descriptionM;
    private String domaine;

    public Matiere() {
    }

    public Matiere(String nomMatiere, String descriptionM, String domaine) {
        this.nomMatiere = nomMatiere;
        this.descriptionM = descriptionM;
        this.domaine = domaine;
    }

    public int getIdMatiere() {
        return idMatiere;
    }

    public void setIdMatiere(int idMatiere) {
        this.idMatiere = idMatiere;
    }

    public String getNomMatiere() {
        return nomMatiere;
    }

    public void setNomMatiere(String nomMatiere) {
        this.nomMatiere = nomMatiere;
    }

    public String getDescriptionM() {
        return descriptionM;
    }

    public void setDescriptionM(String descriptionM) {
        this.descriptionM = descriptionM;
    }

    public String getDomaine() {
        return domaine;
    }

    public void setDomaine(String domaine) {
        this.domaine = domaine;
    }

    @Override
    public String toString() {
        return "Matiere{" + "idMatiere=" + idMatiere + ", nomMatiere=" + nomMatiere + ", descriptionM=" + descriptionM + ", domaine=" + domaine + '}';
    }
    
    
}
