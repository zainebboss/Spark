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
    
    
}
