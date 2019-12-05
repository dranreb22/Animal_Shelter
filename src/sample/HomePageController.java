package sample;

import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.ListView;
import javafx.scene.layout.AnchorPane;

public class HomePageController {

  private DatabaseManager db = new DatabaseManager();

  public javafx.scene.control.MenuItem menuItem_AdoptableDogs;

  @FXML private AnchorPane rootPane;

  @FXML private ListView<String> listView_Animals = new ListView<>();

  @FXML
  public void handleAdoptableDogsMenuItem(ActionEvent actionEvent) throws IOException {
    AnchorPane pane = FXMLLoader.load(getClass().getResource("Adoptable.fxml"));
    rootPane.getChildren().setAll(pane);
  }

  @FXML
  public void handleAddAnimalMenuItem(ActionEvent actionEvent) throws IOException {
    System.out.println("Z");
    AnchorPane pane = FXMLLoader.load(getClass().getResource("AddAnimal.fxml"));
    System.out.println("Z");
    rootPane.getChildren().setAll(pane);
    System.out.println("Zzz");
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
    System.out.println("You would like to adopt a dog!!");
  }

  @FXML
  public void handleAnimalSearchMenuItem(ActionEvent actionEvent) throws IOException {
    AnchorPane pane = FXMLLoader.load(getClass().getResource("AnimalSearch.fxml"));
    rootPane.getChildren().setAll(pane);
  }


  /**
   * This method will initialize the ComboBox on the HomePage with text about the animal shelters
   * mission .. giving a better user home screen
   */
  @FXML
  public void initialize() {
    listView_Animals.getItems().add("\t" + "EVERY PET DESERVES A FOREVER HOME");
    listView_Animals.getItems().add("Our daily mission: ");
    listView_Animals.getItems().add("° Arrive bright eyed and bushy tailed");
    listView_Animals.getItems().add("° Insure every pet feels at home");
    listView_Animals.getItems().add("° Keep animals and area clean");
  }
}
