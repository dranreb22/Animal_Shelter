package sample;


import java.sql.Timestamp;
import javafx.scene.control.TextField;
import java.io.IOException;
import java.time.ZoneId;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.DatePicker;
import javafx.scene.layout.AnchorPane;

public class AnimalInformationController {

  private Timestamp checkInDate;
  private Timestamp checkOutDate;
  private Timestamp groomDate;
  private Timestamp vetDate;
  private DatabaseManager db = new DatabaseManager();
  private java.util.Date date;

  @FXML
  private AnchorPane rootPane;
  @FXML
  private TextField textField_Name;
  @FXML
  private DatePicker datePicker_CheckedIn;
  @FXML
  private DatePicker datePicker_CheckedOut;
  @FXML
  private DatePicker datePicker_Groomers;
  @FXML
  private DatePicker datePicker_VetVisit;



  @FXML
  public void handleUpdateBtn(ActionEvent actionEvent) {
    String name = textField_Name.getText();
    //String species = textField_Species.getText()
    //String subSpecies = textField_Species.getText()

    date = convertToDatePicker(datePicker_CheckedIn);
    checkInDate = new Timestamp(date.getTime());

    date = convertToDatePicker(datePicker_Groomers);
    groomDate = new Timestamp(date.getTime());

    date = convertToDatePicker(datePicker_VetVisit);
    vetDate = new Timestamp(date.getTime());

    db.updateAnimalInDB(name, null, null, checkInDate, groomDate, vetDate);

    textField_Name.clear();
    datePicker_CheckedIn.getEditor().clear();
    datePicker_CheckedOut.getEditor().clear();
    datePicker_Groomers.getEditor().clear();
    datePicker_VetVisit.getEditor().clear();
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
  public void handleAdoptableDogsMenuItem(javafx.event.ActionEvent actionEvent) throws IOException {
    //This is a test to see if there is functionality to the menuitem
    //System.out.println("You would like to adopt a dog!!");
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
  public void handleAdoptableCatsMenuItem(ActionEvent actionEvent) throws IOException {
    AnchorPane pane = FXMLLoader.load(getClass().getResource("AdoptableCats.fxml"));
    rootPane.getChildren().setAll(pane);
  }

  @FXML
  public void handleGroomersMenuItem(ActionEvent actionEvent) throws IOException {
    AnchorPane pane = FXMLLoader.load(getClass().getResource("AnimalCare.fxml"));
    rootPane.getChildren().setAll(pane);
  }

  @FXML
  public void handleAnimalInfoMenuItem(ActionEvent actionEvent) throws IOException {
    AnchorPane pane = FXMLLoader.load(getClass().getResource("AnimalInformation.fxml"));
    rootPane.getChildren().setAll(pane);
  }
  @FXML
  public void handleAnimalSearchMenuItem(ActionEvent actionEvent) throws IOException {
    AnchorPane pane = FXMLLoader.load(getClass().getResource("AnimalSearch.fxml"));
    rootPane.getChildren().setAll(pane);
  }
  @FXML
  public void handleAnimalStatusMenuItem(ActionEvent actionEvent) throws IOException {
    AnchorPane pane = FXMLLoader.load(getClass().getResource("AnimalStatus.fxml"));
    rootPane.getChildren().setAll(pane);
  }
}
