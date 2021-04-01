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

/**
 *
 * @author imen
 */
public class examenService {
  private Connection cnx;
    private Statement st;
    private PreparedStatement pre;
    public examenService() {
    cnx = connexionBd.getInstance().getCnx();
  }
    
      public boolean ajoutExamen(Examen m)
    {
          try {
            String req = "INSERT INTO examen ( idMatiere,description) VALUES "
                    + "('" + m.getIdMatiere() + "', '" +m.getDescription()+ "')";

            st = cnx.createStatement();

            st.executeUpdate(req);

            return true;

        } catch (SQLException ex) {
            System.out.println(ex);
            return false;
        }
    }
      
       public List<Examen> afficherExamen()
    {
         List<Examen> listP = new ArrayList<>();

        try {
            String req = "SELECT e.description,m.nomMatiere,e.id,e.idMatiere FROM examen e inner join matiere m on e.idMatiere= m.idMatiere";

            st = cnx.createStatement();
            ResultSet res = st.executeQuery(req);

            while (res.next()) {
                Examen p = new Examen();
p.setDescription(res.getString(1));
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
         public List<Examen> afficherExamenMatiere(int id)
    {
         List<Examen> listP = new ArrayList<>();

        try {
            String req = "SELECT id,description,idMatiere from examen where idMatiere ='"+id+"'";
            st = cnx.createStatement();
            ResultSet res = st.executeQuery(req);

            while (res.next()) {
                Examen p = new Examen();
p.setDescription(res.getString(2));
p.setId(res.getInt(1));
p.setIdMatiere(res.getInt(3));
             

                listP.add(p);
            }
            
            System.out.println(listP);

        } catch (SQLException ex) {
            System.out.println(ex);
        }

        return listP;
    }
    
    
    public int afficherExamenMatiere2(int id)
    {int idm=0;

        try {
            String req = "SELECT id,description,idMatiere from examen where id ='"+id+"'";
            st = cnx.createStatement();
            ResultSet res = st.executeQuery(req);

            while (res.next()) {
                Examen p = new Examen();
p.setDescription(res.getString(2));
p.setId(res.getInt(1));
p.setIdMatiere(res.getInt(3));
             
idm=p.getIdMatiere();
            }
            

        } catch (SQLException ex) {
            System.out.println(ex);
        }

        return idm;
    }
    
    
    public boolean modifierExamen(Examen m)
    {
      try {
            String req = "update examen set idMatiere=?, description=? where id = ?";

            pre = cnx.prepareStatement(req);
            pre.setInt(3,m.getId());
            pre.setString(2,m.getDescription());

pre.setInt(1, m.getIdMatiere());

            pre.executeUpdate();

            System.out.println("Update 2 Reussie!");
            return true;

        } catch (SQLException ex) {
            System.out.println(ex);
            return false;
        }

    }
    
        public boolean deleteExamen(int id)
    {
           try {
            String req = "delete from examen where id = ?";

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
}
