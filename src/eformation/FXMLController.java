/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package piprojet;

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
public class FXMLController implements Initializable {

    @FXML
    private Button back;
    @FXML
    private Button front;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void versBack(ActionEvent event) throws IOException {
     Stage stage = new Stage();

        Parent root = FXMLLoader.load(getClass().getResource("/piprojet/GUI/Back/backGui.fxml"));
         Stage stage1 = (Stage) back.getScene().getWindow();
stage1.close();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    
    }

    @FXML
    private void versFront(ActionEvent event) throws IOException {
        Stage stage = new Stage();

        Parent root = FXMLLoader.load(getClass().getResource("/piprojet/GUI/Front/matiereGUI/matiereGUI.fxml"));
         Stage stage1 = (Stage) back.getScene().getWindow();
stage1.close();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

    }
    
}
