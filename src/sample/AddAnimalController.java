package sample;

import java.io.IOException;
import java.lang.reflect.Array;
import java.net.URL;
import java.sql.SQLException;
import java.util.Arrays;

import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

public class AddAnimalController implements Initializable {
    private DatabaseManager db = new DatabaseManager();
    @FXML
    private AnchorPane rootPane;
    @FXML
    private TextField textField_Name;
    @FXML
    private TextField textField_Species;
    @FXML
    private TextField textField_SubSpecies;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        db.initializeDb();
    }

    @FXML
    public void handleHomeMenuItem(ActionEvent actionEvent) throws IOException {
        AnchorPane pane = FXMLLoader.load(getClass().getResource("HomePage.fxml"));
        rootPane.getChildren().setAll(pane);
    }

    @FXML
    public void handleAdoptableDogsMenuItem(ActionEvent actionEvent) throws IOException {
        AnchorPane pane = FXMLLoader.load(getClass().getResource("Adoptable.fxml"));
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
        System.out.println("You would like to adopt a dog!!");
    }

    @FXML
    public void handleAnimalSearchMenuItem(ActionEvent actionEvent) throws IOException {
        AnchorPane pane = FXMLLoader.load(getClass().getResource("AnimalSearch.fxml"));
        rootPane.getChildren().setAll(pane);
    }

    @FXML
    public void addNewAnimal() throws SQLException {
        String[] separateInfo={textField_Name.getText().trim(),textField_Species.getText().trim(), textField_SubSpecies.getText().trim()};
        db.addAnimal(separateInfo);
        textField_Name.clear();
        textField_Species.clear();
        textField_SubSpecies.clear();
    }

}
