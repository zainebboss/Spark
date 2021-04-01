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
public class Reponses {
    private int id;
    private int idQuestion;
    private String reponse;
private String question;
private String vrai;

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }
    public Reponses() {
    }

    public Reponses(int idQuestion, String reponse,String vrai) {
        this.idQuestion = idQuestion;
        this.reponse = reponse;
        this.vrai=vrai;
    }

    public String getVrai() {
        return vrai;
    }

    public void setVrai(String vrai) {
        this.vrai = vrai;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdQuestion() {
        return idQuestion;
    }

    public void setIdQuestion(int idQuestion) {
        this.idQuestion = idQuestion;
    }

    public String getReponse() {
        return reponse;
    }

    public void setReponse(String reponse) {
        this.reponse = reponse;
    }
    
    
}
