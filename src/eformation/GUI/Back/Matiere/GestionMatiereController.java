/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package piprojet.GUI.Back.Matiere;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
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
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import piprojet.services.matiereService;
import piprojet.entities.Matiere;

/**
 * FXML Controller class
 *
 * @author imen
 */
public class GestionMatiereController implements Initializable {

    @FXML
    private TableView<Matiere> matieres;
    @FXML
    private Button supprimer;

    @FXML
    private Button ajouter;
    @FXML
    private Button modifier;
    matiereService mat = new matiereService();
    @FXML
    private TextArea description;
    @FXML
    private TextField nom;
    @FXML
    private TextField domaine;
    @FXML
    private TableColumn<Matiere, String> matiereCol;
    @FXML
    private TableColumn<Matiere, String> domaineCol;
    @FXML
    private TableColumn<Matiere, String> descriptionCol;
    @FXML
    private TextField search;
    @FXML
    private Button retour;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
                                        afficherListeMatiere();


         search.setOnKeyReleased(
         (   KeyEvent e)->{
             if(search.getText().equals("")){
                  afficherListeMatiere();
             }else{ 
                 try{
         afficherListeMatiere2(search.getText());
        
                 } catch (SQLException ex) {
                Logger.getLogger(GestionMatiereController.class.getName()).log(Level.SEVERE, null, ex);

                }



             }
         });
        
    }    

    @FXML
    private void supprimerMatiere(ActionEvent event) {
                              Matiere a = matieres.getSelectionModel().getSelectedItem();
    if( mat.deleteMatiere(a.getIdMatiere()))
       {
           Success("Suppression éffectué avec succes");
                   afficherListeMatiere();

       }
           else
                Error("erreur");

        
    }

    @FXML
    private void ajouterMatiere(ActionEvent event) {
        if(nom.getText().equals("") || domaine.getText().equals("") || description.getText().equals(""))
        {
        Error("Veuillez remplir tous les champs");
        }
        else if(!nom.getText().matches("[a-zA-Z]*"))
        {        Error("Le nom doit contenir que des lettres");

        }
        else if(!domaine.getText().matches("[a-zA-Z]*")) 
        {Error("Le domaine doit contenir que des lettres");
        }
        else if(nom.getText().length()<4)
        {Error("Le nom doit contenir que plus que qutatre lettres");}
                else if(domaine.getText().length()<4)
        {Error("Le domaine doit contenir que plus que qutatre lettres");}
        else
        {
            Matiere m= new Matiere(nom.getText(), domaine.getText(), description.getText());
        
       if( mat.ajoutMatiere(m))
       {
           Success("Ajout éffectué avec succes");
                   afficherListeMatiere();

       }
           
           }
   
    
    
    }

    @FXML
    private void modifierMatiere(ActionEvent event) {
                      Matiere a = matieres.getSelectionModel().getSelectedItem();

        if(nom.getText().equals("") || domaine.getText().equals("") || description.getText().equals(""))
        {
        Error("Veuillez remplir tous les champs");
        }
            else if(!nom.getText().matches("[a-zA-Z]*"))
        {        Error("Le nom doit contenir que des lettres");

        }
        else if(!domaine.getText().matches("[a-zA-Z]*")) 
        {Error("Le domaine doit contenir que des lettres");
        }
        else if(nom.getText().length()<4)
        {Error("Le nom doit contenir que plus que qutatre lettres");}
                else if(domaine.getText().length()<4)
        {Error("Le domaine doit contenir que plus que qutatre lettres");}
        else
        {
           a.setNomMatiere(nom.getText());
           a.setDescriptionM(description.getText());
           a.setDomaine(domaine.getText());
        
       if( mat.modifierMatiere(a))
       {
           Success("Ajout éffectué avec succes");
                   afficherListeMatiere();

       }
    
    
    }
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
        alert.setTitle("Ajouter une matiere");
 
        // Header Text: nullCla
        alert.setHeaderText(null);
        alert.setContentText(msg);
 
        alert.showAndWait();
    }
    private void afficherListeMatiere()
    {
     List<Matiere> ls=mat.afficherMatiere();
        ObservableList<Matiere> Liste=FXCollections.observableArrayList(ls);
 
       matiereCol.setCellValueFactory(new PropertyValueFactory<>("nomMatiere"));
       domaineCol.setCellValueFactory(new PropertyValueFactory<>("domaine"));
       descriptionCol.setCellValueFactory(new PropertyValueFactory<>("descriptionM"));
     matieres.setItems(Liste);
    
    }
      private void afficherListeMatiere2(String s) throws SQLException
    {
     List<Matiere> ls=mat.afficherMatiere();
        ObservableList<Matiere> Liste=FXCollections.observableArrayList(ls);
 
       matiereCol.setCellValueFactory(new PropertyValueFactory<>("nomMatiere"));
       domaineCol.setCellValueFactory(new PropertyValueFactory<>("domaine"));
       descriptionCol.setCellValueFactory(new PropertyValueFactory<>("descriptionM"));
     matieres.setItems(mat.rechercheMatiere(s));
    
    }

    @FXML
    private void selectionnerMat(MouseEvent event) {
                 Matiere a = matieres.getSelectionModel().getSelectedItem();
                 nom.setText(a.getNomMatiere());
                 domaine.setText(a.getDomaine());
                 description.setText(a.getDescriptionM());

    }

    @FXML
    private void recherche(KeyEvent event) throws SQLException {
     
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
}
