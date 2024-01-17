package controller.Error;

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

public class ErrorController {

    @FXML 
    private Button CloseBtn;

    @FXML 
    private void exit(ActionEvent event) {
        Stage stage = (Stage) CloseBtn.getScene().getWindow();
        stage.close();
    }
    
}
