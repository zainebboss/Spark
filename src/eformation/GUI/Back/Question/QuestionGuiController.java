/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package piprojet.GUI.Back.Question;

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
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import piprojet.entities.Examen;
import piprojet.entities.Matiere;
import piprojet.entities.Question;
import piprojet.services.matiereService;
import piprojet.services.questionService;

/**
 * FXML Controller class
 *
 * @author imen
 */
public class QuestionGuiController implements Initializable {

    @FXML
    private TableView<Question> questions;
    @FXML
    private TableColumn<Question, String> matiereCol;
    @FXML
    private TableColumn<Question, String> questionCol;
    @FXML
    private Button supprimer;
    @FXML
    private TextArea question;
    @FXML
    private ComboBox<String> listeMatiere;
    @FXML
    private Button ajouter;
    @FXML
    private Button modifier;
    
    questionService ques= new questionService();
        matiereService mat= new matiereService();
    @FXML
    private Button reponses;
    
public static int  idQuestion;
    @FXML
    private Button retour;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        afficherListeQuestion();
        afficherCombo();
        listeMatiere.setValue("");
    }    

    @FXML
    private void listQuestion(MouseEvent event) {   
     Question a = questions.getSelectionModel().getSelectedItem();
                    listeMatiere.setValue(a.getNomMatiere());
                 question.setText(a.getQuestion());

    
    }

    @FXML
    private void supprimerQuestion(ActionEvent event) {
             Question a = questions.getSelectionModel().getSelectedItem();

        if(ques.deleteQuestion(a.getId()))
        {Success("suppression effectuée ");
        
                afficherListeQuestion();

        }
        else Error("suppression erreur");
        
    }

    @FXML
    private void ajouterQuestion(ActionEvent event){
    
    if(question.getText().equals("")|| listeMatiere.getValue().equals(""))
    {Error("Veuillez remplir tous les champs");
    }    else if(!question.getText().matches("[a-zA-Z0-9\\s]*"))
        {        Error("Le nom doit contenir que des lettres et des chiffres");

        }
     
      
    else 
    {
    Question q=new Question(getIdMat(),question.getText());
    if(ques.ajoutQuestion(q))
    {
    Success("Ajout effecgtué avec succés");
           afficherListeQuestion();

    }
        }
    }

    @FXML
    private void modifierQuestion(ActionEvent event) {
         Question a = questions.getSelectionModel().getSelectedItem();
if(question.getText().equals("") || listeMatiere.getValue().equals(""))
{Error("Veuillez remplir tous les champs");
}
    else if(!question.getText().matches("[a-zA-Z0-9\\s]*"))
        {        Error("La question doit contenir que des lettres et des chiffres");

        }
     
else 
{a.setIdMatiere(getIdMat());
a.setQuestion(question.getText());
if(ques.modifierQuestion(a))
{
Success("Modification éffectué avec succés");
        afficherListeQuestion();

}
}
    }
 private int getIdMat()
   {
   return mat.getIdMatiereByNom(listeMatiere.getValue());
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
        alert.setTitle("Ajouter une question");
 
        // Header Text: nullCla
        alert.setHeaderText(null);
        alert.setContentText(msg);
 
        alert.showAndWait();
        clearForms();
    } 
       private void afficherCombo()
   {
       List<Matiere> L=mat.afficherMatiere();
       List<String> Li=new ArrayList<>();
       for(int i=0;i<L.size();i++)
       {Li.add(L.get(i).getNomMatiere());
       }
                        ObservableList<String> Liste=FXCollections.observableArrayList(Li);
                        listeMatiere.setItems(Liste);
    
   }
 public void afficherListeQuestion()
 {
  List<Question> ls=ques.afficherQuestion();
        ObservableList<Question> Liste=FXCollections.observableArrayList(ls);
 
       matiereCol.setCellValueFactory(new PropertyValueFactory<>("nomMatiere"));
       questionCol.setCellValueFactory(new PropertyValueFactory<>("question"));
     questions.setItems(Liste);
 
 }

    @FXML
    private void versReponses(ActionEvent event) throws IOException {
            Stage stage = new Stage();
         Question a = questions.getSelectionModel().getSelectedItem();

         idQuestion=a.getId();
        Parent root = FXMLLoader.load(getClass().getResource("/piprojet/GUI/Back/Reponse/reponseGUI.fxml"));
         Stage stage1 = (Stage) reponses.getScene().getWindow();
stage1.close();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

    }

    @FXML
    private void retour(ActionEvent event) throws IOException {
                       Stage stage = (Stage) retour.getScene().getWindow();
    stage.close();
      Parent root = FXMLLoader.load(getClass().getResource("/piprojet/GUI/Back/backGui.fxml"));
        Stage stage1=new Stage();
        Scene scene = new Scene(root);
        
        stage1.setScene(scene);
        stage1.show();
    }
    
    void clearForms()
    {
        question.setText("");
    }
}
