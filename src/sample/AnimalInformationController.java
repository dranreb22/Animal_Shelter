package sample;


import java.net.URL;
import java.sql.Timestamp;

import java.util.ResourceBundle;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.time.ZoneId;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.DatePicker;
import javafx.scene.layout.AnchorPane;

public class AnimalInformationController implements Initializable {

  private final DatabaseManager db = new DatabaseManager();
  private java.util.Date date;

  @FXML
  private AnchorPane rootPane;
  @FXML
  private TextField textField_Name;
  @FXML
  private TextField textField_CollarID;
  @FXML
  private DatePicker datePicker_Groomers;
  @FXML
  private DatePicker datePicker_VetVisit;


  @Override
  public void initialize(URL location, ResourceBundle resources) {
    db.initializeDb();
  }

  @FXML
  public void handleUpdateBtn(ActionEvent actionEvent) {
    String name = textField_Name.getText();
    String collarID = textField_CollarID.getText();

    date = convertToDatePicker(datePicker_Groomers);
    Timestamp groomDate = new Timestamp(date.getTime());

    date = convertToDatePicker(datePicker_VetVisit);
    Timestamp vetDate = new Timestamp(date.getTime());

    db.updateAnimalInDB(name, groomDate, vetDate, collarID);

    textField_Name.clear();
    datePicker_Groomers.getEditor().clear();
    datePicker_VetVisit.getEditor().clear();
    textField_CollarID.clear();
  }

  public java.util.Date convertToDatePicker(DatePicker datePicked) {
    date = java.util.Date
        .from(datePicked.getValue().atStartOfDay(ZoneId.systemDefault()).toInstant());

    return date;
  }

  @FXML
  public void handleHomeMenuItem(ActionEvent actionEvent) throws IOException {
    AnchorPane pane = FXMLLoader.load(getClass().getResource("HomePage.fxml"));
    rootPane.getChildren().setAll(pane);
  }

  @FXML
  public void handleAnimalInfoMenuItem(ActionEvent actionEvent) throws IOException {
    AnchorPane pane = FXMLLoader.load(getClass().getResource("AnimalInformation.fxml"));
    rootPane.getChildren().setAll(pane);
  }

  @FXML
  public void handleAdoptableMenuItem(javafx.event.ActionEvent actionEvent) throws IOException {
    //This is a test to see if there is functionality to the menuitem
    AnchorPane pane = FXMLLoader.load(getClass().getResource("Adoptable.fxml"));
    rootPane.getChildren().setAll(pane);
  }

  @FXML
  public void handleAnimalCareMenuItem(ActionEvent actionEvent) throws IOException {
    AnchorPane pane = FXMLLoader.load(getClass().getResource("AnimalCare.fxml"));
    rootPane.getChildren().setAll(pane);
  }

  @FXML
  public void handleAddAnimalMenuItem(ActionEvent actionEvent) throws IOException {
    AnchorPane pane = FXMLLoader.load(getClass().getResource("AddAnimal.fxml"));
    rootPane.getChildren().setAll(pane);
  }

  @FXML
  public void handleAnimalSearchMenuItem(ActionEvent actionEvent) throws IOException {
    AnchorPane pane = FXMLLoader.load(getClass().getResource("AnimalSearch.fxml"));
    rootPane.getChildren().setAll(pane);
  }

}
