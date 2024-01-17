package controller.Flights;
import java.util.Iterator;
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
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;


public class ModifyFlightsController extends Controller<ExploreFlightsController> {

    private ObservableList<Flight> flights;

    @FXML 
    private TextField Airline;

    @FXML 
    private TextField FlightNum;

    @FXML 
    private TextField takeoff;

    @FXML 
    private TextField landing;

    @FXML 
    private TextField removetakeoff;

    @FXML 
    private TextField removelanding;

    @FXML 
    private TextField cost;

    @FXML 
    private Button AddBtn;

    @FXML 
    private Button RemoveBtn;

    @FXML
    private Button CloseBtn;

    public ModifyFlightsController() {
        
    }

    @FXML
    private void initialize() {
        if (flights == null) {
            flights = FXCollections.observableArrayList();
        }

    }

    @FXML 
    private void add() {
        String airlinename = Airline.getText();
        int flightnumber = Integer.parseInt(FlightNum.getText());
        String takeoffplace = takeoff.getText();
        String landingplace = landing.getText();
        double flightcost = Double.parseDouble(cost.getText());

        Flight flight = new Flight(airlinename, flightnumber, takeoffplace, landingplace, flightcost);

        DisplayFlightsController.getFlights().add(flight);

        Airline.clear();
        FlightNum.clear();
        takeoff.clear();
        landing.clear();
        cost.clear();

    }

    @FXML 
    private void remove() {
        String Rtakeoff = removetakeoff.getText();
        String Rlanding = removelanding.getText();

        Iterator<Flight> iterator = DisplayFlightsController.getFlights().iterator();
        while (iterator.hasNext()) {
            Flight flight = iterator.next();
            if (Rtakeoff.equals(flight.getTakeoff()) && Rlanding.equals(flight.getLanding())) {
                iterator.remove();
            }
        }

        removetakeoff.clear();
        removelanding.clear();

    }

    public String addedAirline(String airlinename) {
        return airlinename;
    }

    public int addedflightnumber(int flightnumber) {
        return flightnumber;
    }

    public String addedTakeoff(String takeoffplace) {
        return takeoffplace;
    }

    public String addedLanding(String landingplace) {
        return landingplace;
    }

    public double addedCost(double flightcost) {
        return flightcost;
    }

    @FXML 
    private void exit(ActionEvent event) {
        Stage stage = (Stage) CloseBtn.getScene().getWindow();
        stage.close();
    }
}
