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
import piprojet.entities.Question;
import piprojet.entities.Reponses;

/**
 *
 * @author imen
 */
public class reponseService {
     private Connection cnx;
    private Statement st;
    private PreparedStatement pre;
    public reponseService() {
  cnx = connexionBd.getInstance().getCnx();
    }
    public boolean ajouterReponse(Reponses rep)
    {
        
          try {
            String req = "INSERT INTO reponse (idQuestion,reponse,vrai) VALUES "
                    + "('" + rep.getIdQuestion() + "', '" +rep.getReponse()+ "', '" +rep.getVrai()+"')";

            st = cnx.createStatement();

            st.executeUpdate(req);

            return true;

        } catch (SQLException ex) {
            System.out.println(ex);
            return false;
        }
  }
    
public boolean modifierReponse(Reponses rep)
{
  try {
            String req = "update reponse set  reponse=?,vrai=? where id = ?";

            pre = cnx.prepareStatement(req);
            pre.setString(1,rep.getReponse());
                        pre.setString(2,rep.getVrai());

            pre.setInt(3,rep.getId());


            pre.executeUpdate();

            System.out.println("Update 2 Reussie!");
            return true;

        } catch (SQLException ex) {
            System.out.println(ex);
            return false;
        }
   
} 
    
   public boolean supprimerReponse(int id)
   {
    try {
            String req = "delete from reponse where id = ?";

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
      public List<Reponses> afficherListeReponse(int id)
   { List<Reponses> listP = new ArrayList<>();

        try {
            String req = "select id,reponse,vrai,idQuestion from reponse where idQuestion ='"+id+"'";

            st = cnx.createStatement();
            ResultSet res = st.executeQuery(req);

            while (res.next()) {
                Reponses p = new Reponses();
p.setReponse(res.getString(2));
p.setId(res.getInt(1));
               p.setVrai(res.getString(3));
                     
p.setIdQuestion(res.getInt(4));
                listP.add(p);
            }
            
            System.out.println(listP);

        } catch (SQLException ex) {
            System.out.println(ex);
        }

        return listP;
   
   
   }
   
      
        public boolean CorrectExistForQuestionId(int id)
   { List<Reponses> listP = new ArrayList<>();

        try {
            String req = "select id,reponse,vrai,idQuestion from reponse where idQuestion ='"+id+"' and vrai like 'correcte'";

            st = cnx.createStatement();
            ResultSet res = st.executeQuery(req);

            while (res.next()) {
                Reponses p = new Reponses();
p.setReponse(res.getString(2));
p.setId(res.getInt(1));
               p.setVrai(res.getString(3));
                     
p.setIdQuestion(res.getInt(4));
                listP.add(p);
            }
            
            System.out.println(listP);

        } catch (SQLException ex) {
            System.out.println(ex);
        }
        if(listP.size() > 0)
            return true ;
        else return false ;
   
   
   }
   
   
   public List<Reponses> afficherReponse(String id)
   { List<Reponses> listP = new ArrayList<>();

        try {
            String req = "select id,reponse,vrai,idQuestion from reponse where reponse ='"+id+"'";

            st = cnx.createStatement();
            ResultSet res = st.executeQuery(req);

            while (res.next()) {
                Reponses p = new Reponses();
p.setReponse(res.getString(2));
p.setId(res.getInt(1));
               p.setVrai(res.getString(3));
                     
p.setIdQuestion(res.getInt(4));
                listP.add(p);
            }
            
            System.out.println(listP);

        } catch (SQLException ex) {
            System.out.println(ex);
        }

        return listP;
   
   
   }
   
   
   
   
   
   
}
