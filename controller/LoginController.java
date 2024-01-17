package controller;

import au.edu.uts.ap.javafx.*;
import javafx.stage.*;
import javafx.application.Application;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.PasswordField;
import javafx.scene.image.Image;
import model.*;
import model.Exceptions.InvalidCredentialsException;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class LoginController extends Controller {

    public LoginController() {

    }

    private static ObservableList<Administrator> administrators;

    static {
        administrators = FXCollections.observableArrayList();
        administrators.add(new Administrator("Davey", "david46", "123"));
        administrators.add(new Administrator("Angela", "angela123", "mypw"));
        administrators.add(new Administrator("Rafiqul", "boss", "secure"));
        administrators.add(new Administrator("Vishesh", "legend", "notsecure"));
        administrators.add(new Administrator("Zyzz", "1", "1"));
    }

    @FXML 
    private Button loginBtn;

    @FXML
    private Button exitBtn;

    @FXML
    private TextField username;

    @FXML 
    private TextField password;

    @FXML
    void initialize() {
   
    }

    @FXML
    private void handleLogin(javafx.event.ActionEvent event) throws IOException {
        String enteredUsername = username.getText().trim();
        String enteredPassword = password.getText().trim();
    
        boolean Match = false;
        for (Administrator admin : getAdministrators()) {
            if (admin.getLogin().equals(enteredUsername) && admin.getPassword().equals(enteredPassword)) {
                Match = true;
                break;
            }
        }
    
        if (Match) {
            Stage stage = (Stage) exitBtn.getScene().getWindow();
            stage.close();
    
            Stage newStage = new Stage();
            newStage.getIcons().add(new Image("/image/agency_icon.png"));
            ViewLoader.showStage(new Agency(), "/view/AgencyView.fxml", "Agency", newStage);


        } else {
            Stage newStage = new Stage();
            newStage.getIcons().add(new Image("/image/error_icon.png"));
            ViewLoader.showStage(new Agency(), "/view/Error/ErrorView.fxml", "Error", newStage);
        }
    }

    public static ObservableList<Administrator> getAdministrators() {
        return administrators;
        
    }

    @FXML 
    private void exit(ActionEvent event) {
        Stage stage = (Stage) exitBtn.getScene().getWindow();
        stage.close();
    }

}
