/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package piprojet.GUI.Back;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author imen
 */
public class BackGuiController implements Initializable {

    @FXML
    private Button gestionMat;
    @FXML
    private Button examen;
    @FXML
    private Button question;
    @FXML
    private Button retour;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
       
         
        
    }    

    @FXML
    private void versMatieres(ActionEvent event) throws IOException {
         Stage stage = new Stage();

        Parent root = FXMLLoader.load(getClass().getResource("/piprojet/GUI/Back/Matiere/gestionMatiere.fxml"));
         Stage stage1 = (Stage) gestionMat.getScene().getWindow();
stage1.close();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

    }

    @FXML
    private void gestionExamen(ActionEvent event) throws IOException {
         Stage stage = new Stage();

        Parent root = FXMLLoader.load(getClass().getResource("/piprojet/GUI/Back/Examen/examenGUI.fxml"));
         Stage stage1 = (Stage) examen.getScene().getWindow();
stage1.close();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

    }

    @FXML
    private void versQuestion(ActionEvent event) throws IOException {
            Stage stage = new Stage();

        Parent root = FXMLLoader.load(getClass().getResource("/piprojet/GUI/Back/Question/questionGui.fxml"));
         Stage stage1 = (Stage) question.getScene().getWindow();
stage1.close();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

    
    }

    @FXML
    private void retour(ActionEvent event) throws IOException {
               Stage stage = (Stage) retour.getScene().getWindow();
    stage.close();
      Parent root = FXMLLoader.load(getClass().getResource("/piprojet/FXML.fxml"));
        Stage stage1=new Stage();
        Scene scene = new Scene(root);
        
        stage1.setScene(scene);
        stage1.show();
    }
    
}
