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
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;

public class DisplayDestinationsController extends Controller<ExploreDestinationsController> {

    public DisplayDestinationsController() {

    }

    private static ObservableList<Destination> destinations;

    @FXML
    private Button CloseBtn;

    @FXML
    private TableView<Destination> tableView;

    @FXML 
    private TextField tablefilter;

    public static ObservableList<Destination> getDestinations() {
        return destinations;
    }

    @FXML
    private void initialize() {

        FilteredList<Destination> filteredDestinations = new FilteredList<>(destinations);

        if (tablefilter != null){

            tablefilter.textProperty().addListener((observable, oldValue, newValue) -> {
                filteredDestinations.setPredicate(destination -> {
                    if (newValue == null || newValue.isEmpty()) {
                        return true;
                    }

                    String lowerCaseFilter = newValue.toLowerCase();
                    return destination.getName().toLowerCase().contains(lowerCaseFilter)
                            || destination.getCountry().toLowerCase().contains(lowerCaseFilter);
                });
            });

            SortedList<Destination> sortedFlights = new SortedList<>(filteredDestinations);
            sortedFlights.comparatorProperty().bind(tableView.comparatorProperty());
            tableView.setItems(sortedFlights);
        }

        tableView.setItems(filteredDestinations);
    }

    static {
        destinations = FXCollections.observableArrayList();
        destinations.add(new Destination("Eiffel Tower", "France"));
        destinations.add(new Destination("Opera House", "Australia"));
        destinations.add(new Destination("Uluru", "Australia"));
        destinations.add(new Destination("Machu Picchu", "Peru"));
        destinations.add(new Destination("Great Pyramids", "Egypt"));
        destinations.add(new Destination("Niagara Falls", "Canada"));
    }

    @FXML 
    private void exit(ActionEvent event) {
        Stage stage = (Stage) CloseBtn.getScene().getWindow();
        stage.close();
    }
    
    
}
