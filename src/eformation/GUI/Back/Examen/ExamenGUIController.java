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
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import static piprojet.GUI.Back.Question.QuestionGuiController.idQuestion;
import piprojet.entities.Examen;
import piprojet.entities.Matiere;
import piprojet.entities.Question;
import piprojet.services.examenService;
import piprojet.services.matiereService;

/**
 * FXML Controller class
 *
 * @author imen
 */
public class ExamenGUIController implements Initializable {

    @FXML
    private TableView<Examen> examens;
    @FXML
    private Button supprimer;
    @FXML
    private TextArea description;
    @FXML
    private ComboBox<String> listeMatiere;
    @FXML
    private Button ajouter;
    matiereService mat=new matiereService();
examenService exa=new examenService();
    @FXML
    private TableColumn<Examen, String> matiereCol;
    @FXML
    private TableColumn<Examen, String> descriptionCol;
    @FXML
    private Button preparerExamen;
    public static int idExamen;
    @FXML
    private Button retour;
    public static int idMat;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        afficherCombo();
        afficherExamen();
        listeMatiere.setValue("");
    }    

    @FXML
    private void supprimerExamen(ActionEvent event) {
                     Examen m =examens.getSelectionModel().getSelectedItem();

        if(exa.deleteExamen(m.getId()))
        {Success("Suppression effectué avec succés");
        afficherExamen();
        
        }else 
        { Error("Erreur");}
        
    }

    @FXML
    private void ajouterExamen(ActionEvent event) {
       if(listeMatiere.getValue().equals("")|| description.getText().equals(""))
       {Error("Erreur");
       }
      
       else {
             Examen m =new Examen(getIdMat(),description.getText());
        if(exa.ajoutExamen(m))
        {
        Success("Ajout effectué avec succés");
        afficherExamen();
        }
    
       }
        
      
    }

    @FXML
    private void modifierExamen(ActionEvent event) {
    if(listeMatiere.getValue().equals("")|| description.getText().equals(""))
       {Error("Erreur");
       }else {
             Examen m =examens.getSelectionModel().getSelectedItem();
             m.setDescription(description.getText());
             m.setIdMatiere(getIdMat());
        if(exa.modifierExamen(m))
        {
        Success("Modification effectué avec succés");
        
        afficherExamen();
        }
    
       }
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
        alert.setTitle("Ajouter un examen");
 
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
   public void afficherExamen()
   {
      List<Examen> ls=exa.afficherExamen();
        ObservableList<Examen> Liste=FXCollections.observableArrayList(ls);
 
       matiereCol.setCellValueFactory(new PropertyValueFactory<>("nomMatiere"));
       descriptionCol.setCellValueFactory(new PropertyValueFactory<>("description"));
     examens.setItems(Liste);
    
   
   }
   private int getIdMat()
   {
   
   return mat.getIdMatiereByNom(listeMatiere.getValue());
   }

    @FXML
    private void selectionnerExamen(MouseEvent event) {
      Examen a = examens.getSelectionModel().getSelectedItem();
               listeMatiere.setValue(a.getNomMatiere());
                 description.setText(a.getDescription());

    }

    @FXML
    private void versPreparerExamen(ActionEvent event) throws IOException {
          Stage stage = new Stage();
         Examen a = examens.getSelectionModel().getSelectedItem();
idMat=a.getIdMatiere();
         idExamen=a.getId();
        Parent root = FXMLLoader.load(getClass().getResource("/piprojet/GUI/Back/Examen/preparerExamen.fxml"));
         Stage stage1 = (Stage) preparerExamen.getScene().getWindow();
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
    
    public void clearForms()
    {
        description.setText("");
    }
}
