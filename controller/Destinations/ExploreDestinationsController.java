package controller.Destinations;

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
import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class ExploreDestinationsController extends Controller<Agency> {

    public ExploreDestinationsController() {

    }

    @FXML
    private Button ViewAllDestBtn;
    @FXML
    private Button ViewFilteredDestBtn;
    @FXML
    private Button AddDestBtn;
    @FXML
    private Button RemoveDestBtn;
    @FXML
    private Button CloseBtn;

    @FXML
    private void ViewDestinations(ActionEvent event) throws IOException {
        Stage newStage = new Stage();
        newStage.getIcons().add(new Image("/image/destinations_icon.png"));
        ViewLoader.showStage(new Stage(),"/view/Destinations/DisplayDestinationsView.fxml","Display Destinations", newStage);
    }

    @FXML
    private void ViewFilteredDestinations(ActionEvent event) throws IOException {
        Stage newStage = new Stage();
        newStage.getIcons().add(new Image("/image/destinations_icon.png"));
        ViewLoader.showStage(new Stage(),"/view/Destinations/DisplayFilteredDestinationsView.fxml","Display Flights Filtered", newStage);
    }

    @FXML
    private void Add(ActionEvent event) throws IOException {
        Stage newStage = new Stage();
        newStage.getIcons().add(new Image("/image/destinations_icon.png"));
        ViewLoader.showStage(new Stage(),"/view/Destinations/AddDestinationView.fxml","Add Destination", newStage);
    }

    @FXML
    private void Remove(ActionEvent event) throws IOException {
        Stage newStage = new Stage();
        newStage.getIcons().add(new Image("/image/destinations_icon.png"));
        ViewLoader.showStage(new Stage(),"/view/Destinations/RemoveDestinationView.fxml","Remove Destination", newStage);
    }

    @FXML 
    private void exit(ActionEvent event) {
        Stage stage = (Stage) CloseBtn.getScene().getWindow();
        stage.close();
    }
   
}
