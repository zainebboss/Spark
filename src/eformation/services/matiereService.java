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
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import piprojet.connectionBD.connexionBd;
import piprojet.entities.Matiere;

/**
 *
 * @author imen
 */
public class matiereService {
        private Connection cnx;
    private Statement st;
    private PreparedStatement pre;

    public matiereService() {
 cnx = connexionBd.getInstance().getCnx();

    }
    public boolean ajoutMatiere(Matiere m)
    {
          try {
            String req = "INSERT INTO matiere (nomMatiere, descriptionM,domaine) VALUES "
                    + "('" + m.getNomMatiere() + "', '" + m.getDescriptionM() +"', '"+m.getDomaine()+ "')";

            st = cnx.createStatement();

            st.executeUpdate(req);

            return true;

        } catch (SQLException ex) {
            System.out.println(ex);
            return false;
        }
        

    }
    
    public List<Matiere> afficherMatiere()
    {
         List<Matiere> listP = new ArrayList<>();

        try {

            String req = "SELECT* FROM matiere";

            st = cnx.createStatement();
            ResultSet res = st.executeQuery(req);

            while (res.next()) {
                Matiere p = new Matiere();
p.setNomMatiere(res.getString(2));
p.setDescriptionM(res.getString(3));
p.setDomaine(res.getString(4));
                p.setIdMatiere(res.getInt("idMatiere"));
             

                listP.add(p);
            }
            
            System.out.println(listP);

        } catch (SQLException ex) {
            System.out.println(ex);
        }

        return listP;
    }
    
    
    public boolean modifierMatiere(Matiere m)
    {
      try {
            String req = "update matiere set nomMatiere=?, descriptionM=?,domaine=? where idMatiere = ?";

            pre = cnx.prepareStatement(req);
            pre.setString(1,m.getNomMatiere());
            pre.setString(2,m.getDescriptionM());
            pre.setString(3,m.getDomaine());

pre.setInt(4, m.getIdMatiere());

            pre.executeUpdate();

            System.out.println("Update 2 Reussie!");
            return true;

        } catch (SQLException ex) {
            System.out.println(ex);
            return false;
        }

    }
    public boolean deleteMatiere(int id)
    {
           try {
            String req = "delete from matiere where idMatiere = ?";

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
    
    
    public int getIdMatiereByNom(String nom)
    {
     List<Matiere> listP = new ArrayList<>();
int id=0;
        try {

            String req = "SELECT idMatiere FROM matiere where nomMatiere ='"+nom+"'";

            st = cnx.createStatement();
            ResultSet res = st.executeQuery(req);

            while (res.next()) {
             id=res.getInt(1);
            }
            
            System.out.println(id);

        } catch (SQLException ex) {
            System.out.println(ex);
        }

        return id;
    }
    /******recherche avancée********/
                public ObservableList<Matiere> rechercheMatiere(String recherche) throws SQLException {
                   Matiere p = new Matiere();

        ObservableList<Matiere> list = FXCollections.observableArrayList();
        String requete = "select c.* from matiere c  WHERE c.nomMatiere LIKE '%"+recherche+"%' OR descriptionM LIKE '%"+recherche+"%' OR domaine LIKE '%"+recherche+"%'   ";
        try {
            PreparedStatement ps = cnx.prepareStatement(requete);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                p.setIdMatiere(rs.getInt("idMatiere"));
                p.setNomMatiere(rs.getString("nomMatiere"));
                p.setDescriptionM(rs.getString("descriptionM"));
                p.setDomaine(rs.getString("domaine"));
                
                list.add(p);
 
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return list;
    }
}
