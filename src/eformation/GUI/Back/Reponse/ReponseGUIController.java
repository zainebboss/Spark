/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package piprojet.GUI.Back.Reponse;

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
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import piprojet.GUI.Back.Question.QuestionGuiController;
import piprojet.entities.Question;
import piprojet.entities.Reponses;
import piprojet.services.questionService;
import piprojet.services.reponseService;

/**
 * FXML Controller class
 *
 * @author imen
 */
public class ReponseGUIController implements Initializable {

    @FXML
    private TableView<Reponses> listeReponse;
    @FXML
    private TableColumn<Reponses, String> reponseCol;
    @FXML
    private TableColumn<Reponses, String> etatCol;
    @FXML
    private Label question;
    @FXML
    private TextArea reponse;
    @FXML
    private ComboBox<String> vrai;
    @FXML
    private Button ajouter;
    @FXML
    private Button supprimer;
    @FXML
    private Button modifier;
reponseService rep = new reponseService();
questionService ques =new questionService();
    @FXML
    private Button retour;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        comboBox();
        afficherQuestion();
         afficherListeReponse();
         vrai.setValue("");
    }    

    @FXML
    private void ajouterReponse(ActionEvent event) {
        if(vrai.getValue().equals("")|| reponse.getText().equals(""))
        {Error("Veuillez remplir tous les champs");
        }
            else if(!reponse.getText().matches("[a-zA-Z0-9\\s]*"))
        {        Error("La reponse doit contenir que des lettres et des chiffres");

        }
        else 
        {
        Reponses repe=new Reponses(QuestionGuiController.idQuestion,reponse.getText(),vrai.getValue());
        if(rep.ajouterReponse(repe))
        {Success("Ajout effectué avec succes");
         afficherListeReponse();
         comboBox();
        }
        }
    }

    @FXML
    private void supprimerReponse(ActionEvent event) {
                     Reponses a = listeReponse.getSelectionModel().getSelectedItem();

        if(rep.supprimerReponse(a.getId()))
        {
        Success("suppression effectue avec succes");
         afficherListeReponse();
         comboBox();
        } else 
            Error("Erreur");
    
    
    }

    @FXML
    private void modifierReponse(ActionEvent event) {
           if(vrai.getValue().equals("")|| reponse.getText().equals(""))
        {Error("Veuillez remplir tous les champs");
        }
            else if(!reponse.getText().matches("[a-zA-Z0-9\\s]*"))
        {        Error("La reponse doit contenir que des lettres et des chiffres");

        }
    else 
        {
             Reponses a = listeReponse.getSelectionModel().getSelectedItem();
             a.setReponse(reponse.getText());
             a.setVrai(vrai.getValue());
        if(rep.modifierReponse(a))
        {Success("Modification effectué avec succes");
         afficherListeReponse();
         comboBox();
        } 
        
        
        }
        
    }
    public void comboBox()
    {
    
           List<String> Li=new ArrayList<>();
           if(!rep.CorrectExistForQuestionId(QuestionGuiController.idQuestion))
           Li.add("correcte");
           Li.add("incorrecte");
           ObservableList<String> Liste=FXCollections.observableArrayList(Li);
          vrai.setItems(Liste);
    }
    
    private void Error(String msg) {
      Alert alert = new Alert(Alert.AlertType.ERROR);
alert.setTitle("Error Dialog");
alert.setHeaderText("Look, an Error Dialog");
alert.setContentText(msg);
alert.showAndWait();
clearForms();
    }
    private void Success(String msg) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Ajouter une reponse");
 
        // Header Text: nullCla
        alert.setHeaderText(null);
        alert.setContentText(msg);
 
        alert.showAndWait();
        clearForms();
    } 

    @FXML
    private void selectionnerReponse(MouseEvent event) {
        
             Reponses a = listeReponse.getSelectionModel().getSelectedItem();
                    vrai.setValue(a.getVrai());
                 reponse.setText(a.getReponse());

        
    }

public void afficherQuestion()
{             
question.setText(ques.afficherUneQuestion(QuestionGuiController.idQuestion).get(0).getQuestion());

}

public void afficherListeReponse()
{ List<Reponses> ls=rep.afficherListeReponse(QuestionGuiController.idQuestion);
        ObservableList<Reponses> Liste=FXCollections.observableArrayList(ls);
 
      reponseCol.setCellValueFactory(new PropertyValueFactory<>("reponse"));
      etatCol.setCellValueFactory(new PropertyValueFactory<>("vrai"));
    listeReponse.setItems(Liste);

}

    @FXML
    private void retour(ActionEvent event) throws IOException {
                       Stage stage = (Stage) retour.getScene().getWindow();
    stage.close();
      Parent root = FXMLLoader.load(getClass().getResource("/piprojet/GUI/Back/Question/questionGui.fxml"));
        Stage stage1=new Stage();
        Scene scene = new Scene(root);
        
        stage1.setScene(scene);
        stage1.show();
    }
    
    void clearForms()
    {
        reponse.setText("");
    }
}

