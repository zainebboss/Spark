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
public class examenQuestion {
    private int id;
    private int idQuestion;
    private int idExamen;
private String question;

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
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

    public int getIdExamen() {
        return idExamen;
    }

    public void setIdExamen(int id) {
        this.idExamen= id;
    }

    public examenQuestion() {
    }

    public examenQuestion(int idQuestion, int id) {
        this.idQuestion = idQuestion;
        this.idExamen = id;
    }
    
    
}
