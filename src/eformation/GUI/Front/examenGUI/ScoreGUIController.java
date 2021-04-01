/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package piprojet.GUI.Front.examenGUI;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import piprojet.services.mail;

import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import piprojet.GUI.Front.matiereGUI.MatiereGUIController;
import piprojet.connectionBD.TextToSpeach;
/**
 * FXML Controller class
 *
 * @author imen
 */
public class ScoreGUIController implements Initializable {

    @FXML
    private Button mail;
    mail m=new mail(); 
    @FXML
    private Label score;
    @FXML
    private ImageView image;
    @FXML
    private Button sms;
    @FXML
    private Button retour;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        score.setText(String.valueOf(PasserExamenController.n.getScore()));
        TextToSpeach.speak("Your Score is " + String.valueOf(PasserExamenController.n.getScore()));
      
    }    

    @FXML
    private void envoiMail(ActionEvent event) throws IOException {
    m.envoyer("nour.bouali@esprit.tn", "Votre score est :"+ PasserExamenController.n.getScore());
    Success("Le mail est envoyé");
    
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
        alert.setTitle("Envoi ");
 
        // Header Text: nullCla
        alert.setHeaderText(null);
        alert.setContentText(msg);
 
        alert.showAndWait();
    }
public static final String ACCOUNT_SID = System.getenv("ACff668d9b00a30add3abd43c8283ec26c");
    public static final String AUTH_TOKEN = System.getenv("df92625546b4b251b8e3620e528382a3");
    @FXML
    private void envoiSms(ActionEvent event) {
    
   Twilio.init(ACCOUNT_SID, AUTH_TOKEN);
       
        Message message = Message.creator(
                new com.twilio.type.PhoneNumber("+21658857039"),
                new com.twilio.type.PhoneNumber("+12023352483"),
                "Where's Wallace?")
            .create();

        System.out.println(message.getSid());
    }

    private void envoiSms()
    {
    
    
    }

    @FXML
    private void retour(ActionEvent event) throws IOException {
           Stage stage = (Stage) retour.getScene().getWindow();
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
