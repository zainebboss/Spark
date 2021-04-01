/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package piprojet.GUI.Back.Examen;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
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
import piprojet.entities.Examen;
import piprojet.entities.Matiere;
import piprojet.entities.Question;
import piprojet.entities.examenQuestion;
import piprojet.services.examenquestionService;
import piprojet.services.questionService;

/**
 * FXML Controller class
 *
 * @author imen
 */
public class PreparerExamenController implements Initializable {

    @FXML
    private TableView<Question> questions;
    @FXML
    private TableColumn<Question, String> questionCol;
    @FXML
    private TableView<Question> examen;
    @FXML
    private TableColumn<examenQuestion, String> examenCol;
    @FXML
    private Button ajouter;
    @FXML
    private Button supprimer;
questionService ques = new questionService();
examenquestionService exa=new examenquestionService();
    @FXML
    private Button retour;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        afficherListeQuestion();
        afficherListeQuestionExamen();
    }    

    @FXML
    private void ajouterQuestion(ActionEvent event) {
        if(   questions.getSelectionModel().getSelectedItem().equals(""))
        {Error("veuillez choisir une question");
        }else { 
                          Question a = questions.getSelectionModel().getSelectedItem();
                       examenQuestion m =new examenQuestion(a.getId(),ExamenGUIController.idExamen);  
if(exa.preparerExamen(m))
{Success("ajout effectué avec succés");
afficherListeQuestionExamen();
}
        
        }

    }

    private void supprimer(ActionEvent event) {
                 Question a = examen.getSelectionModel().getSelectedItem();
System.out.println("hetha id "+ a.getId());
        if(exa.supprimerExamen(a.getId()))
        { Success("suppression effectuée avec succés");
        afficherListeQuestionExamen();
        }else Error("erreur!");
    }
     public void afficherListeQuestion()
 {
  List<Question> ls=ques.afficherQuestionMatiere(ExamenGUIController.idMat);
        ObservableList<Question> Liste=FXCollections.observableArrayList(ls);
 
       questionCol.setCellValueFactory(new PropertyValueFactory<>("question"));
     questions.setItems(Liste);
 
 }
        public void afficherListeQuestionExamen()
 {
  List<examenQuestion> ls=exa.afficherExamen(ExamenGUIController.idExamen);

  List<Question> list= new ArrayList<>();
  for(int i=0;i<ls.size();i++)
  {   list.add(ques.afficherUneQuestion(ls.get(i).getIdQuestion()).get(0));
  }
  
        ObservableList<Question> Liste=FXCollections.observableArrayList(list);
 
      examenCol.setCellValueFactory(new PropertyValueFactory<>("question"));
     examen.setItems(Liste);
 
 }
   private void Error(String msg) {
      Alert alert = new Alert(Alert.AlertType.ERROR);
alert.setTitle("Error Dialog");
alert.setHeaderText("Look, an Error Dialog");
alert.setContentText(msg);
alert.showAndWait();
    }
    private void Success(String msg) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Ajouter une question à un examen");
 
        // Header Text: nullCla
        alert.setHeaderText(null);
        alert.setContentText(msg);
 
        alert.showAndWait();
    } 

    @FXML
    private void selectionnerExamen(MouseEvent event) {
                  Question a = questions.getSelectionModel().getSelectedItem();

    }

    @FXML
    private void retour(ActionEvent event) throws IOException {
               Stage stage = (Stage) retour.getScene().getWindow();
    stage.close();
      Parent root = FXMLLoader.load(getClass().getResource("/piprojet/GUI/Back/Examen/examenGUI.fxml"));
        Stage stage1=new Stage();
        Scene scene = new Scene(root);
        
        stage1.setScene(scene);
        stage1.show();
    }

    @FXML
    private void supprimerAction(ActionEvent event) {
          Question a = examen.getSelectionModel().getSelectedItem();
System.out.println("hetha id "+ a.getId());
      System.out.println("hetha size :"+ExamenGUIController.idExamen);

        if(exa.supprimerExamen(a.getId()))
        { Success("suppression effectuée avec succés");
        afficherListeQuestionExamen();
        }else Error("erreur!");
    }
    
}
