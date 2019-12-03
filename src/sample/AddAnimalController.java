package sample;

import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;

public class AddAnimalController {
  @FXML
  private AnchorPane rootPane;

  @FXML
  public void handleHomeMenuItem(ActionEvent actionEvent) throws IOException {
    AnchorPane pane = FXMLLoader.load(getClass().getResource("HomePage.fxml"));
    rootPane.getChildren().setAll(pane);
  }

  @FXML
  public void handleAdoptableDogsMenuItem(javafx.event.ActionEvent actionEvent) throws IOException {
    //This is a test to see if there is functionality to the menuitem
    System.out.println("You would like to adopt a dog!!");
    AnchorPane pane = FXMLLoader.load(getClass().getResource("AdoptableDogs.fxml"));
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
