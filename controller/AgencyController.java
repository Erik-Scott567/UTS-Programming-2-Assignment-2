package controller;

import au.edu.uts.ap.javafx.*;
import javafx.stage.*;
import javafx.application.Application;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.ObservableList;
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


public class AgencyController extends Controller<Agency> {

    public AgencyController() {

    }

    private Agency agency = new Agency();

    @FXML 
    private Label welcome;

    @FXML 
    private Button ExFlyBtn;
    @FXML 
    private Button ExDestBtn;
    @FXML 
    private Button BookTripBtn;
    @FXML 
    private Button ExitAgency;

    private Administrator administrator;

    public final Agency getAgency() { return agency;}
    
    @FXML private void initialize() {
        welcomeMessage();
    }

    public void setAdministrator(Administrator administrator) {
        this.administrator = administrator;
        welcomeMessage();
    }

    public void welcomeMessage() {

        if (administrator != null) {
            String adminName = administrator.getName();
            welcome.setText("Hi " + adminName + ", welcome to the Prog2 Travel Agency");
        } else {
            welcome.setText("Welcome to the Prog2 Travel Agency");
        }
    }

    @FXML 
    private void exit(ActionEvent event) {
        Stage stage = (Stage) ExitAgency.getScene().getWindow();
        stage.close();
    }

    @FXML
    private void exploreFlights(ActionEvent event) throws IOException {
        Stage newStage = new Stage();
        newStage.getIcons().add(new Image("/image/flights_icon.png"));
        ViewLoader.showStage(new Stage(),"/view/Flights/ExploreFlightsView.fxml","Explore Flights", newStage);
    }

    @FXML
    private void exploreDestinations(ActionEvent event) throws IOException {
        Stage newStage = new Stage();
        newStage.getIcons().add(new Image("/image/destinations_icon.png"));
        ViewLoader.showStage(new Stage(),"/view/Destinations/ExploreDestinationsView.fxml","Explore Destinations", newStage);
    }

    @FXML
    private void BookTrip(ActionEvent event) throws IOException {
        Stage newStage = new Stage();
        newStage.getIcons().add(new Image("/image/trip_icon.png"));
        ViewLoader.showStage(new Stage(),"/view/Trip/BookTripView.fxml","Book Trip", newStage);
    }
}

