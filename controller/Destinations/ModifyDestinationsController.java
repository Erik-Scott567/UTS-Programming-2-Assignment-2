package controller.Destinations;
import java.util.Iterator;
import au.edu.uts.ap.javafx.*;
import controller.Flights.DisplayFlightsController;
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
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;


public class ModifyDestinationsController extends Controller<ExploreDestinationsController> {

    private ObservableList<Destination> destinations;

    @FXML 
    private TextField Name;

    @FXML 
    private TextField Country;

    @FXML 
    private TextField removename;

    @FXML 
    private TextField removecountry;

    @FXML 
    private Button AddBtn;

    @FXML 
    private Button RemoveBtn;

    @FXML
    private Button CloseBtn;

    public ModifyDestinationsController() {

    }

    @FXML
    private void initialize() {
        if (destinations == null) {
            destinations = FXCollections.observableArrayList();
        }

    }

    @FXML 
    private void add() {
        String name = Name.getText();
        String countryname = Country.getText();

        Destination destination = new Destination(name, countryname);

        DisplayDestinationsController.getDestinations().add(destination);

        Name.clear();
        Country.clear();


    }

    @FXML 
    private void remove() {
        String RName = removename.getText();
        String RCountry = removecountry.getText();

        Iterator<Destination> iterator = DisplayDestinationsController.getDestinations().iterator();
        while (iterator.hasNext()) {
            Destination destinations = iterator.next();
            if (RName.equals(destinations.getName()) && RCountry.equals(destinations.getCountry())) {
                iterator.remove();
            }
        }

        removename.clear();
        removecountry.clear();

    }


    @FXML 
    private void exit(ActionEvent event) {
        Stage stage = (Stage) CloseBtn.getScene().getWindow();
        stage.close();
    }

}
