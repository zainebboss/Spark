/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package piprojet.GUI.Front.examenGUI;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import piprojet.GUI.Back.Examen.ExamenGUIController;
import piprojet.GUI.Front.matiereGUI.MatiereGUIController;
import static piprojet.GUI.Front.matiereGUI.MatiereGUIController.idMatiere;
import piprojet.entities.Examen;
import piprojet.entities.Matiere;
import piprojet.services.examenService;
import piprojet.services.examenquestionService;
import piprojet.services.noteService;

/**
 * FXML Controller class
 *
 * @author imen
 */
public class ExamenController implements Initializable {

    @FXML
    private TableView<Examen> examens;
    @FXML
    private TableColumn<Examen, String> descriptionCol;
examenService exa= new examenService();
noteService not=new noteService();
examenquestionService exq = new examenquestionService();
public static int idExamen;
    @FXML
    private Button passer;
    @FXML
    private Button retour;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        afficherListeExamen();
        System.out.println("id matier"+MatiereGUIController.idMatiere);
        
         examens.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
            if (newSelection != null) {
                try {
                    passer();
                } catch (IOException ex) {
                    Logger.getLogger(ExamenController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
                });    
                 }         

    @FXML
    private void verspasserExamen(MouseEvent event) throws IOException {
    
      
    }
    public void afficherListeExamen()
    {  List<Examen> ls=exa.afficherExamenMatiere(MatiereGUIController.idMatiere);
        ObservableList<Examen> Liste=FXCollections.observableArrayList(ls);
 
       descriptionCol.setCellValueFactory(new PropertyValueFactory<>("description"));
     examens.setItems(Liste);
    
    }

    @FXML
    private void passer() throws IOException {
           Stage stage = new Stage();
         Examen a = examens.getSelectionModel().getSelectedItem();
         idExamen=a.getId();
         int ids=not.idExamen(idExamen);
      System.out.println("hetha idddd :"+a.getId());

         idMatiere=a.getIdMatiere();
         
        if(exq.afficherExamen(idExamen).size() <= 0)
        {
            Error("examen n'est pas prêt !");
        }
        else if(ids==0 )
{         idExamen=a.getId();

        
        Parent root = FXMLLoader.load(getClass().getResource("/piprojet/GUI/Front/examenGUI/passerExamen.fxml"));
        Stage stage1 = (Stage) examens.getScene().getWindow();
        stage1.close();
        Scene scene = new Scene(root);
        stage.setScene(scene);
       stage.show();

}
else Error("examen déjà passé");
    }

     private void Error(String msg) {
      Alert alert = new Alert(Alert.AlertType.ERROR);
alert.setTitle("Error Dialog");
alert.setHeaderText("Look, an Error Dialog");
alert.setContentText(msg);
alert.showAndWait();
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
