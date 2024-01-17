package controller.Flights;

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

public class ExploreFlightsController extends Controller<Agency> {

    public ExploreFlightsController() {

    }

    @FXML
    private Button ViewFlightsBtn;
    @FXML
    private Button ViewFlightsByCountBtn;
    @FXML
    private Button AddFlightBtn;
    @FXML
    private Button RemoveFlightBtn;
    @FXML
    private Button CloseBtn;

    @FXML
    private void ViewFlights(ActionEvent event) throws IOException {
        Stage newStage = new Stage();
        newStage.getIcons().add(new Image("/image/flights_icon.png"));
        ViewLoader.showStage(new Stage(),"/view/Flights/DisplayFlightsView.fxml","Display Flights", newStage);
    }

    @FXML
    private void ViewFilteredFlights(ActionEvent event) throws IOException {
        Stage newStage = new Stage();
        newStage.getIcons().add(new Image("/image/flights_icon.png"));
        ViewLoader.showStage(new Stage(),"/view/Flights/DisplayFilteredFlightsView.fxml","Display Flights Filtered", newStage);
    }

    @FXML
    private void Add(ActionEvent event) throws IOException {
        Stage newStage = new Stage();
        newStage.getIcons().add(new Image("/image/flights_icon.png"));
        ViewLoader.showStage(new Stage(),"/view/Flights/AddFlightView.fxml","Add Flight", newStage);
    }

    @FXML
    private void Remove(ActionEvent event) throws IOException {
        Stage newStage = new Stage();
        newStage.getIcons().add(new Image("/image/flights_icon.png"));
        ViewLoader.showStage(new Stage(),"/view/Flights/RemoveFlightView.fxml","Remove Flight", newStage);
    }

    @FXML 
    private void exit(ActionEvent event) {
        Stage stage = (Stage) CloseBtn.getScene().getWindow();
        stage.close();
    }

}
