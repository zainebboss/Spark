/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package piprojet.GUI.Front.examenGUI;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import piprojet.connectionBD.connexionBd;

/**
 * FXML Controller class
 *
 * @author imen
 */
public class StatistiqueController implements Initializable {

    @FXML
    private BarChart<String, Integer> chart;
  connexionBd connection = null;
        private Connection cnx;
    @FXML
    private Button retour;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        loadChart() ;
    }    
    
     private void loadChart() {
       try {
            String query="select n.score,m.nomMatiere FROM note n inner join examen e on n.idExamen =e.id inner join matiere m on e.idMatiere = m.idMatiere  where n.idUser =1 ORDER BY  score DESC";
            XYChart.Series<String,Integer> series = new XYChart.Series<>();
                    cnx= connexionBd.getInstance().getCnx();
            ResultSet rss = null;
            try {
                rss = cnx.createStatement().executeQuery(query);
            } catch (SQLException ex) {
                Logger.getLogger(StatistiqueController.class.getName()).log(Level.SEVERE, null, ex);
            }
            while (rss.next())
            {
                try {
                    series.getData().add(new XYChart.Data<>(rss.getString(2), rss.getInt(1)));

                } catch (SQLException ex) {
                    Logger.getLogger(StatistiqueController.class.getName()).log(Level.SEVERE, null, ex);
                }

            }                                                chart.getData().add(series);

        } catch (SQLException ex) {
            Logger.getLogger(StatistiqueController.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    }

    @FXML
    private void retour(ActionEvent event) throws IOException {
        
             Stage stage = (Stage) retour.getScene().getWindow();
    stage.close();
              Parent root = FXMLLoader.load(getClass().getResource("/piprojet/GUI/Front/matiereGUI/matiereGUI.fxml"));
        Stage stage1=new Stage();
        Scene scene = new Scene(root);
        
        stage1.setScene(scene);
        stage1.show();
    }
    
    
}
