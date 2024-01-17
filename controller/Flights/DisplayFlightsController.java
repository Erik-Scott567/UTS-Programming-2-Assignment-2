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
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;


public class DisplayFlightsController extends Controller<ExploreFlightsController>{
    
    public DisplayFlightsController(){

    }

    private static ObservableList<Flight> flights;

    static {
        flights = FXCollections.observableArrayList();
        flights.add(new Flight("American Airlines", 235, "Canada", "France", 299.99));
        flights.add(new Flight("QANTAS", 789, "Australia", "Peru", 599.99));
        flights.add(new Flight("JetStar", 456, "Australia", "France", 149.99));
        flights.add(new Flight("Tiger Airways", 123, "Peru", "Canada", 99.99));
        flights.add(new Flight("United Airlines", 678, "Canada", "France", 699.99));
        flights.add(new Flight("Egypt Air", 345, "Egypt", "Canada", 249.99));
        flights.add(new Flight("Etihad", 789, "Egypt", "France", 799.99));
        flights.add(new Flight("Singapore Airlines", 567, "Australia", "Peru", 449.99));
        flights.add(new Flight("British Air", 111, "France", "Canada", 799.99));
        flights.add(new Flight("Cathay Dragon", 888, "Canada", "Peru", 349.99));
        flights.add(new Flight("Air France", 222, "France", "Australia", 599.99));
        flights.add(new Flight("QANTAS", 333, "Australia", "Egypt", 399.99));
        flights.add(new Flight("Peruvian Airways", 444, "Peru", "France", 299.99));
        flights.add(new Flight("Egyptian Airlines", 555, "Egypt", "Canada", 499.99));
        flights.add(new Flight("Canadian Wings", 666, "Canada", "Australia", 449.99));
        flights.add(new Flight("Air France", 777, "France", "Peru", 199.99));
        flights.add(new Flight("Australian Skies", 888, "Australia", "Canada", 699.99));
        flights.add(new Flight("Peru Express", 999, "Peru", "France", 349.99));
        flights.add(new Flight("Canadian Jet", 101, "Canada", "Australia", 799.99));
        flights.add(new Flight("Nile Airways", 202, "Egypt", "Peru", 549.99));
    }

    public static ObservableList<Flight> getFlights() {
        return flights;
    }

    @FXML
    private Button CloseBtn;

    @FXML
    private TableView<Flight> tableView;

    @FXML 
    private TextField tablefilter;

    @FXML
    private void initialize() {      

        FilteredList<Flight> filteredFlights = new FilteredList<>(flights);

        if (tablefilter != null){

            tablefilter.textProperty().addListener((observable, oldValue, newValue) -> {
                filteredFlights.setPredicate(flight -> {
                    if (newValue == null || newValue.isEmpty()) {
                        return true;
                    }

                    String lowerCaseFilter = newValue.toLowerCase();
                    return flight.getTakeoff().toLowerCase().contains(lowerCaseFilter)
                            || flight.getLanding().toLowerCase().contains(lowerCaseFilter);
                });
            });

            SortedList<Flight> sortedFlights = new SortedList<>(filteredFlights);
            sortedFlights.comparatorProperty().bind(tableView.comparatorProperty());
            tableView.setItems(sortedFlights);
        }

        tableView.setItems(filteredFlights);
        
    }

    @FXML 
    private void exit(ActionEvent event) {
        Stage stage = (Stage) CloseBtn.getScene().getWindow();
        stage.close();
    }

}
