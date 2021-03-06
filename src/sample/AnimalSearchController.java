package sample;

import java.io.IOException;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

public class AnimalSearchController implements Initializable {

  private final DatabaseManager db = new DatabaseManager();
  @FXML
  private AnchorPane rootPane;
  @FXML
  private TextField textField_AnimalName;
  @FXML
  private TableView<Animal> tbv_SearchAnimal;

  @Override
  public void initialize(URL location, ResourceBundle resources) {
    db.initializeDb();
  }

  @FXML
  public void handleAdoptableDogsMenuItem(ActionEvent actionEvent) throws IOException {
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
  public void handleAnimalInfoMenuItem(ActionEvent actionEvent) throws IOException {
    AnchorPane pane = FXMLLoader.load(getClass().getResource("AnimalInformation.fxml"));
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
  public void handleAnimalStatusMenuItem(ActionEvent actionEvent) throws IOException {
    AnchorPane pane = FXMLLoader.load(getClass().getResource("AnimalStatus.fxml"));
    rootPane.getChildren().setAll(pane);
  }

  @FXML
  public String getSearchQuery() {
    return (textField_AnimalName.getText());

  }

  @FXML
  public void getSearchResults() {
    ObservableList<Animal> animalList = FXCollections
        .observableArrayList(db.getAnimalSearch(getSearchQuery()));
    tbv_SearchAnimal.setItems(animalList);
  }


}
