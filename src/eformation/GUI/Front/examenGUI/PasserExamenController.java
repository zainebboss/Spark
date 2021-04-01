/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package piprojet.GUI.Front.examenGUI;

import Note.Note;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.CheckBox;

import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import piprojet.GUI.Front.matiereGUI.MatiereGUIController;
import static piprojet.GUI.Front.matiereGUI.MatiereGUIController.idMatiere;
import piprojet.connectionBD.Translator;
import piprojet.entities.Matiere;
import piprojet.entities.Question;
import piprojet.entities.Reponses;
import piprojet.entities.examenQuestion;
import piprojet.entities.listeReponse;
import piprojet.services.examenService;
import piprojet.services.examenquestionService;
import piprojet.services.noteService;
import piprojet.services.reponseService;

/**
 * FXML Controller class
 *
 * @author imen
 */
public class PasserExamenController implements Initializable {

    @FXML
    private ScrollPane examen;
    @FXML
    private VBox questions;
   examenquestionService exa= new examenquestionService();
reponseService rep =new reponseService();
noteService note=new noteService();
examenService exam=new examenService();
    @FXML
    private Button valider;
    @FXML
    private Button retour;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        System.out.println("hetha examen :"+ExamenController.idExamen);
        displayExamen(ExamenController.idExamen);
    }    
    public static int j=0;
        public static int idQ=0;
        public static int idR=0;
public static Note n=new Note();
    listeReponse m= new listeReponse();
    private void displayExamen(int id)
    { n.setScore(0);
    n.setIdUser(1);
    List<examenQuestion> liste= new ArrayList();
    liste=exa.afficherExamen(id);
              List<VBox> list = new ArrayList<>();
while(j<liste.size())
{    n.setIdExamen(liste.get(j).getIdExamen());
                
                  
              VBox h= new VBox();
              Label question=new Label("Question :"+liste.get(j).getQuestion() +" ?");
              
              Button tr_fr =new Button("Traduire en Francais");
              tr_fr.setOnAction(new EventHandler<ActionEvent>() {

                  @Override
                  public void handle(ActionEvent event) {
                      try {
                          question.setText(Translator.translate("en", "fr", question.getText()));

                      } catch (IOException ex) {
                          Logger.getLogger(PasserExamenController.class.getName()).log(Level.SEVERE, null, ex);
                      }
                  }
});
               Button tr_en =new Button("Traduire en Anglais");
              tr_en.setOnAction(new EventHandler<ActionEvent>() {

                  @Override
                  public void handle(ActionEvent event) {
                      try {
                          question.setText(Translator.translate("fr", "en", question.getText()));
                      } catch (IOException ex) {
                          Logger.getLogger(PasserExamenController.class.getName()).log(Level.SEVERE, null, ex);
                      }
                  }
});
              
              
              VBox ins= new VBox();
              List<Reponses> listRep= new ArrayList();
              ComboBox<String> ch1= new ComboBox();
              List<String> listC = new ArrayList<>();

                  listRep= rep.afficherListeReponse(liste.get(j).getIdQuestion());
                  for(int i=0;i<listRep.size();i++)
                  {listC.add(listRep.get(i).getReponse());
                           //   
        
                  }
    ObservableList<String> Listes=FXCollections.observableArrayList(listC);
    ch1.setItems(Listes);
    idQ=liste.get(j).getIdQuestion();
     Button valider =new Button("Valider reponse");
valider.setOnAction(new EventHandler<ActionEvent>() {

                  @Override
                  public void handle(ActionEvent event) {
 idR=rep.afficherReponse(ch1.getValue()).get(0).getId();
m.setIdUser(1);
m.setIdQuestion(idQ);
m.setIdReponse(idR);

                     if (exa.ajouterReponse(m))
                     {Success("Votre reponse est validée");
                     
                     valider.setDisable(true);
                     }
                     else Error("votre reponse n'est pas validée");
               if(rep.afficherReponse(ch1.getValue()).get(0).getVrai().equals("correcte"))
               {n.setScore(n.getScore()+2);}

                     
                     
                  }
                  
                  
                  }
);
     ins.setSpacing(50);
     ins.setAlignment(Pos.CENTER);
        HBox hb = new HBox();
        hb.setAlignment(Pos.CENTER);
        hb.getChildren().addAll(valider, tr_en , tr_fr);
        ins.getChildren().addAll(question,ch1,hb);

                h.setSpacing(10);
              h.setAlignment(Pos.CENTER);
h.getChildren().add(ins);

VBox v1=new VBox();
               v1.setAlignment(Pos.CENTER);
               
               
               v1.setSpacing(50);
               

               v1.getChildren().addAll(h);
               list.add(v1);
               j++;
}
      questions.getChildren().clear();
         questions.getChildren().addAll(list);
        
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
        alert.setTitle("Ajouter une reponse");
 
        // Header Text: nullCla
        alert.setHeaderText(null);
        alert.setContentText(msg);
 
        alert.showAndWait();
    }

    @FXML
    private void valider(ActionEvent event) throws IOException {
        
        if(note.insererNote(n))
        {
        Success("Votre examen est validé");
         Stage stage = new Stage();
            Stage stage2 = (Stage) valider.getScene().getWindow();

        Parent root = FXMLLoader.load(getClass().getResource("/piprojet/GUI/Front/examenGUI/ScoreGUI.fxml"));
       stage2.close();
               Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
        }else Error("Erreur");
        
        
        
    }

    @FXML
    private void retour(ActionEvent event) throws IOException {
            Stage stage = (Stage) retour.getScene().getWindow();
         MatiereGUIController.idMatiere=   exam.afficherExamenMatiere2(ExamenController.idExamen);
         System.out.println("test"+MatiereGUIController.idMatiere);
            System.out.println("yok3ed id :"+ExamenController.idExamen);
    stage.close();
              Parent root = FXMLLoader.load(getClass().getResource("/piprojet/GUI/Front/examenGUI/examen.fxml"));
        Stage stage1=new Stage();
        Scene scene = new Scene(root);
        
        stage1.setScene(scene);
        stage1.show();
    }

   
}
