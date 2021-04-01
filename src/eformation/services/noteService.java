/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package piprojet.services;

import Note.Note;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import piprojet.connectionBD.connexionBd;
import piprojet.entities.Question;

/**
 *
 * @author imen
 */
public class noteService {
        private Connection cnx;
    private Statement st;
    private PreparedStatement pre;
    public noteService() {
         cnx = connexionBd.getInstance().getCnx();

    }
    
    public boolean insererNote(Note note)
    {  try {
            String req = "INSERT INTO note ( idUser,idExamen,score) VALUES "
                    + "('" + note.getIdUser()+ "', '" + note.getIdExamen()+ "', '" +note.getScore()+ "')";

            st = cnx.createStatement();

            st.executeUpdate(req);

            return true;

        } catch (SQLException ex) {
            System.out.println(ex);
            return false;
        }
    
    }
    public int idExamen(int id)
    { int idi=0;
    

        try {
            String req = "SELECT id,idExamen from note where idUser =1 and idExamen='"+id+"'";

            st = cnx.createStatement();
            ResultSet res = st.executeQuery(req);

            while (res.next()) {
                Note p = new Note();
p.setId(res.getInt(1));
idi=res.getInt(2);

            }
            

        } catch (SQLException ex) {
            System.out.println(ex);
        }

        return idi;
    
    
    
    }
}
