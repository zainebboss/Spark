/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package piprojet.services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import piprojet.connectionBD.connexionBd;
import piprojet.entities.Examen;
import piprojet.entities.Matiere;
import piprojet.entities.Question;

/**
 *
 * @author imen
 */
public class questionService {
  private Connection cnx;
    private Statement st;
    private PreparedStatement pre;
    public questionService() {
        
            cnx = connexionBd.getInstance().getCnx();    }
    
     public boolean ajoutQuestion(Question m)
    {
          try {
            String req = "INSERT INTO question ( idMatiere,question) VALUES "
                    + "('" + m.getIdMatiere() + "', '" +m.getQuestion()+ "')";

            st = cnx.createStatement();

            st.executeUpdate(req);

            return true;

        } catch (SQLException ex) {
            System.out.println(ex);
            return false;
        }
    }
    public boolean modifierQuestion(Question m)
    {
      try {
            String req = "update question set idMatiere=?, question=? where id = ?";

            pre = cnx.prepareStatement(req);
            pre.setInt(1,m.getIdMatiere());
            pre.setString(2,m.getQuestion());
            pre.setInt(3,m.getId());


            pre.executeUpdate();

            System.out.println("Update 2 Reussie!");
            return true;

        } catch (SQLException ex) {
            System.out.println(ex);
            return false;
        }

    }
    public boolean deleteQuestion(int id)
    {
           try {
            String req = "delete from question where id = ?";

            pre = cnx.prepareStatement(req);

          
            pre.setInt(1, id);

            pre.executeUpdate();

            System.out.println("supprimer 2 Reussie!");
            return true;

        } catch (SQLException ex) {
            System.out.println(ex);
            return false;
        }
    }
           public List<Question> afficherQuestion()
    {
         List<Question> listP = new ArrayList<>();

        try {
            String req = "SELECT e.question,m.nomMatiere,e.id,e.idMatiere FROM question e inner join matiere m on e.idMatiere= m.idMatiere";

            st = cnx.createStatement();
            ResultSet res = st.executeQuery(req);

            while (res.next()) {
                Question p = new Question();
p.setQuestion(res.getString(1));
p.setNomMatiere(res.getString(2));
p.setId(res.getInt(3));
                p.setIdMatiere(res.getInt(4));
             

                listP.add(p);
            }
            
            System.out.println(listP);

        } catch (SQLException ex) {
            System.out.println(ex);
        }

        return listP;
    }
    
       public List<Question> afficherUneQuestion(int id)
    {
         List<Question> listP = new ArrayList<>();

        try {
            String req = "SELECT id,question from question where id ='"+id+"'";

            st = cnx.createStatement();
            ResultSet res = st.executeQuery(req);

            while (res.next()) {
                Question p = new Question();
p.setQuestion(res.getString(2));
p.setId(res.getInt(1));

                listP.add(p);
            }
            
            System.out.println(listP);

        } catch (SQLException ex) {
            System.out.println(ex);
        }

        return listP;
    }
  
       
                 public List<Question> afficherQuestionMatiere(int id)
    {
         List<Question> listP = new ArrayList<>();

        try {
            String req = "SELECT e.question,m.nomMatiere,e.id,e.idMatiere FROM question e inner join matiere m on e.idMatiere= m.idMatiere where e.idMatiere ='"+id+"'";;

            st = cnx.createStatement();
            ResultSet res = st.executeQuery(req);

            while (res.next()) {
                Question p = new Question();
p.setQuestion(res.getString(1));
p.setNomMatiere(res.getString(2));
p.setId(res.getInt(3));
                p.setIdMatiere(res.getInt(4));
             

                listP.add(p);
            }
            
            System.out.println(listP);

        } catch (SQLException ex) {
            System.out.println(ex);
        }

        return listP;
    }
    
       
       
       
       
       
       
       
       
       
}
