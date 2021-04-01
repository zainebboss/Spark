/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package piprojet.GUI.Front.matiereGUI;

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
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import static piprojet.GUI.Back.Examen.ExamenGUIController.idExamen;
import piprojet.GUI.Back.Matiere.GestionMatiereController;
import piprojet.entities.Examen;
import piprojet.entities.Matiere;
import piprojet.services.matiereService;

/**
 * FXML Controller class
 *
 * @author imen
 */
public class MatiereGUIController implements Initializable {

    @FXML
    private TableView<Matiere> matiere;
matiereService mat=new matiereService();
    @FXML
    private TableColumn<Matiere, String> matiereCol;
    @FXML
    private TableColumn<Matiere, String> domaineCol;
    @FXML
    private TableColumn<Matiere, String> descriptionCol;
    public static int idMatiere;
    @FXML
    private Button examenListe;
    @FXML
    private Button retour;
    @FXML
    private TextField search;
    @FXML
    private Button staistique;
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
                Logger.getLogger(MatiereGUIController.class.getName()).log(Level.SEVERE, null, ex);
                }
             }
         });

        matiere.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
            if (newSelection != null) {
                try {
                    versExamenList();
                } catch (IOException ex) {
                    Logger.getLogger(MatiereGUIController.class.getName()).log(Level.SEVERE, null, ex);
                }
    }
});
    }    
    
    @FXML
    private void versPasserExamen(MouseEvent event) throws IOException {
        
    }
    
    private void afficherListeMatiere()
    {
       List<Matiere> ls=mat.afficherMatiere();
       ObservableList<Matiere> Liste=FXCollections.observableArrayList(ls);
       matiereCol.setCellValueFactory(new PropertyValueFactory<>("nomMatiere"));
       domaineCol.setCellValueFactory(new PropertyValueFactory<>("domaine"));
       descriptionCol.setCellValueFactory(new PropertyValueFactory<>("descriptionM"));
       matiere.setItems(Liste);
    }

    @FXML
    private void versExamenList() throws IOException {
        Stage stage = new Stage();
        Matiere a = matiere.getSelectionModel().getSelectedItem();
        idMatiere=a.getIdMatiere();
        Parent root = FXMLLoader.load(getClass().getResource("/piprojet/GUI/Front/examenGUI/examen.fxml"));
        Stage stage1 = (Stage) matiere.getScene().getWindow();
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
    
    private void afficherListeMatiere2(String s) throws SQLException
    {
        List<Matiere> ls=mat.afficherMatiere();
        ObservableList<Matiere> Liste=FXCollections.observableArrayList(ls);
        matiereCol.setCellValueFactory(new PropertyValueFactory<>("nomMatiere"));
        domaineCol.setCellValueFactory(new PropertyValueFactory<>("domaine"));
        descriptionCol.setCellValueFactory(new PropertyValueFactory<>("descriptionM"));
        matiere.setItems(mat.rechercheMatiere(s));
    }

    @FXML
    private void statistique(ActionEvent event) throws IOException {
                Stage stage = new Stage();

             Parent root = FXMLLoader.load(getClass().getResource("/piprojet/GUI/Front/examenGUI/statistique.fxml"));
         Stage stage1 = (Stage) staistique.getScene().getWindow();
stage1.close();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
        
    }
}
