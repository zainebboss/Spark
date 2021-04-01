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
import piprojet.entities.examenQuestion;
import piprojet.entities.listeReponse;

/**
 *
 * @author imen
 */
public class examenquestionService {
     private Connection cnx;
    private Statement st;
    private PreparedStatement pre;

    public examenquestionService() {
   cnx = connexionBd.getInstance().getCnx();

    }
    
    public boolean preparerExamen(examenQuestion m)
    {
          try {
            String req = "INSERT INTO examenquestion ( idQuestion,idExamen) VALUES "
                    + "('" + m.getIdQuestion()+ "', '" +m.getIdExamen()+ "')";

            st = cnx.createStatement();

            st.executeUpdate(req);

            return true;

        } catch (SQLException ex) {
            System.out.println(ex);
            return false;
        }
    
    }
    public boolean modifierExamen(examenQuestion m)
    {  
      try {
        String req = "update examenquestion set idQuestion=?, idExamen=? where id = ?";

            pre = cnx.prepareStatement(req);
            pre.setInt(3,m.getId());
                      pre.setInt(1,m.getIdQuestion());
            pre.setInt(2,m.getIdExamen());


            pre.executeUpdate();

            System.out.println("Update 2 Reussie!");
            return true;

        } catch (SQLException ex) {
            System.out.println(ex);
            return false;
        }
    
    }
    public boolean supprimerExamen(int id)
    {
    try {
            String req = "delete from examenquestion where idQuestion = ?";

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
     public List<examenQuestion> afficherExamen(int id)
    {
         List<examenQuestion> listP = new ArrayList<>();

        try {
            String req = "SELECT e.id,m.question,e.idQuestion,e.idExamen FROM examenquestion e inner join question m on e.idQuestion= m.id where e.idExamen ='"+id+"'";

            st = cnx.createStatement();
            ResultSet res = st.executeQuery(req);

            while (res.next()) {
                examenQuestion p = new examenQuestion();

p.setId(res.getInt(1));
p.setIdExamen(res.getInt(4));
p.setIdQuestion(res.getInt(3));
p.setQuestion(res.getString(2));
                         System.out.println("hetha id examen"+p.getIdExamen());


                listP.add(p);
            }
            
            System.out.println(listP);

        } catch (SQLException ex) {
            System.out.println(ex);
        }

        return listP;
    }
    /********************passer Examen*************/
     
     
     
     public boolean ajouterReponse(listeReponse m)
     {
     
      try {
            String req = "INSERT INTO listereponse ( idUser,idQuestion,idReponse) VALUES "
                    + "('" + m.getIdUser()+ "', '" + m.getIdQuestion()+ "', '" +m.getIdReponse()+ "')";

            st = cnx.createStatement();

            st.executeUpdate(req);

            return true;

        } catch (SQLException ex) {
            System.out.println(ex);
            return false;
        }
     
     }
}
