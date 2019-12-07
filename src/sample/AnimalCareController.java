package sample;

import java.io.IOException;
import java.sql.Timestamp;
import java.time.ZoneId;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

public class AnimalCareController {
    private DatabaseManager db = new DatabaseManager();
    private java.util.Date date;
    private Timestamp nextVetVisit;
    private Timestamp nextGroomerVisit;
    @FXML
    private TextField textField_LastGroomerVisit;
    @FXML
    private TextField textField_LastVetVisit;
    @FXML
    private DatePicker datePicker_ScheduleVetVisit;
    @FXML
    private DatePicker datePicker_ScheduleGroomerVisit;
    @FXML
    private AnchorPane rootPane;

    @FXML
    public void handleAdoptableMenuItem(ActionEvent actionEvent) throws IOException {
        AnchorPane pane = FXMLLoader.load(getClass().getResource("Adoptable.fxml"));
        rootPane.getChildren().setAll(pane);
    }

    @FXML
    public void handleHomeMenuItem(ActionEvent actionEvent) throws IOException {
        AnchorPane pane = FXMLLoader.load(getClass().getResource("HomePage.fxml"));
        rootPane.getChildren().setAll(pane);
    }

    @FXML
    public void handleAddAnimalMenuItem(ActionEvent actionEvent) throws IOException {
        AnchorPane pane = FXMLLoader.load(getClass().getResource("AddAnimal.fxml"));
        rootPane.getChildren().setAll(pane);
    }


    @FXML
    public void handleAnimalCareMenuItem(ActionEvent actionEvent) throws IOException {
        AnchorPane pane = FXMLLoader.load(getClass().getResource("AnimalCare.fxml"));
        rootPane.getChildren().setAll(pane);
    }

    @FXML
    public void handleAnimalSearchMenuItem(ActionEvent actionEvent) throws IOException {
        AnchorPane pane = FXMLLoader.load(getClass().getResource("AnimalSearch.fxml"));
        rootPane.getChildren().setAll(pane);
    }

    @FXML
    public void handleAnimalInfoMenuItem(ActionEvent actionEvent) throws IOException {
        AnchorPane pane = FXMLLoader.load(getClass().getResource("AnimalInformation.fxml"));
        rootPane.getChildren().setAll(pane);
    }
    @FXML
    public void handleEnterButton(ActionEvent actionEvent){
            String lastVetVisit = textField_LastVetVisit.getText();
            String lastGroomerVisit = textField_LastGroomerVisit.getText();

            date = convertToDatePicker(datePicker_ScheduleVetVisit);
            nextVetVisit = new Timestamp(date.getTime());

            date = convertToDatePicker(datePicker_ScheduleGroomerVisit);
            nextGroomerVisit = new Timestamp(date.getTime());

            db.scheduleVisit(lastVetVisit, lastGroomerVisit, nextVetVisit, nextGroomerVisit);

            textField_LastVetVisit.clear();
            textField_LastGroomerVisit.clear();
            datePicker_ScheduleVetVisit.getEditor().clear();
            datePicker_ScheduleGroomerVisit.getEditor().clear();


    }
    public java.util.Date convertToDatePicker(DatePicker datePicked) {
        date = java.util.Date
                .from(datePicked.getValue().atStartOfDay(ZoneId.systemDefault()).toInstant());

        return date;
    }
}
