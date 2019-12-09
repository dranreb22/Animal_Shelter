package sample;

import java.io.IOException;
import java.net.URL;
import java.sql.Timestamp;
import java.time.ZoneId;

import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

public class AnimalCareController implements Initializable {

  private DatabaseManager db = new DatabaseManager();
  private java.util.Date date;
  private Timestamp nextVetVisit;
  private Timestamp nextGroomerVisit;
  @FXML
  private TextField textField_VetNotes;
  @FXML
  private TextField textField_GroomerNotes;
  @FXML
  private TextField textField_CollarID;
  @FXML
  private DatePicker datePicker_ScheduleVetVisit;
  @FXML
  private DatePicker datePicker_ScheduleGroomerVisit;
  @FXML
  private AnchorPane rootPane;

  @Override
  public void initialize(URL location, ResourceBundle resources) {
    db.initializeDb();
  }

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
  public void handleEnterButton(ActionEvent actionEvent) {
    String vetNotes = textField_VetNotes.getText();
    String groomerNotes = textField_GroomerNotes.getText();

    date = convertToDatePicker(datePicker_ScheduleVetVisit);
    nextVetVisit = new Timestamp(date.getTime());

    date = convertToDatePicker(datePicker_ScheduleGroomerVisit);
    nextGroomerVisit = new Timestamp(date.getTime());

    int collarID = Integer.parseInt(textField_CollarID.getText());

    db.scheduleVisit(vetNotes, groomerNotes, nextVetVisit, nextGroomerVisit, collarID);

    textField_VetNotes.clear();
    textField_GroomerNotes.clear();
    datePicker_ScheduleVetVisit.getEditor().clear();
    datePicker_ScheduleGroomerVisit.getEditor().clear();


  }

  public java.util.Date convertToDatePicker(DatePicker datePicked) {
    date = java.util.Date
        .from(datePicked.getValue().atStartOfDay(ZoneId.systemDefault()).toInstant());

    return date;
  }
}
