package sample;

import java.io.IOException;
import java.util.ArrayList;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;

public class AnimalSearchController {

  ArrayList<Animal> animalList = new ArrayList<>();
  ObservableList<Animal> searchList;
  @FXML
  private TableColumn<?,?> tableColumn_Name;
  @FXML
  private TableColumn<?,?> tableColumn_CollarID;
  @FXML
  private TableColumn<?,?> tableColumn_Breed;
  @FXML
  private TableColumn<?,?> tableColumn_SubSpecies;
  @FXML
  private AnchorPane rootPane;
  @FXML
  private TableView<Animal> tableView_AvailableAnimals;

  @FXML
  private TextField textField_AnimalName;

  @FXML
  public void handleAnimalCareMenuItem(ActionEvent actionEvent) throws IOException {
    AnchorPane pane = FXMLLoader.load(getClass().getResource("AnimalCare.fxml"));
    rootPane.getChildren().setAll(pane);
  }

  @FXML
  public void initialize() {
    searchList = FXCollections.observableArrayList();
    setupProductLineTable();
    tableView_AvailableAnimals.setItems(searchList);
  }

  public void handleSearchButton(ActionEvent actionEvent) {
    String searchQuery = textField_AnimalName.getText();
    searchForAnimal(searchQuery);
  }

  public void searchForAnimal(String query) {
    for(int i = 0; i < animalList.size(); i++) {
      if (query.equals(animalList.get(i).getName()) || query.equals(animalList.get(i).getCollarID())
          || query.equals(animalList.get(i).getSubSpecies()) || query.equals(animalList.get(i).getBreed())) {
        searchList.add(animalList.get(i));
      }
    }
  }

  public void setupProductLineTable() {
    tableColumn_Name.setCellValueFactory(new PropertyValueFactory("Name"));
    tableColumn_CollarID.setCellValueFactory(new PropertyValueFactory("Collar ID"));
    tableColumn_Breed.setCellValueFactory(new PropertyValueFactory("Breed"));
    tableColumn_SubSpecies.setCellValueFactory(new PropertyValueFactory("Sub Species"));
  }


}
