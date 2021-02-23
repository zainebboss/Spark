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
public class Question {
    int ID;
    String question;
    String reponse;
    Examen examen[];
    Reponse reponses[];

    public Question() {
    }

    public Question(int ID, String question, String reponse) {
        this.ID = ID;
        this.question = question;
        this.reponse = reponse;
    }

    public int getID() {
        return ID;
    }

    public String getQuestion() {
        return question;
    }

    public Examen[] getExamen() {
        return examen;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public void setExamen(Examen[] examen) {
        this.examen = examen;
    }

    @Override
    public String toString() {
        return "Question{" + "ID=" + ID + ", question=" + question + ", reponse=" + reponse + '}';
    }
    
    
}
