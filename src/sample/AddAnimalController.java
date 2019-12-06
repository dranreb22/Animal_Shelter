package sample;

import java.io.IOException;
import java.lang.reflect.Array;
import java.util.Arrays;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

public class AddAnimalController {
    @FXML
    private AnchorPane rootPane;
    @FXML
    private TextField textField_Name;
    @FXML
    private TextField textField_Species;
    @FXML
    private TextField textField_SubSpecies;

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
    public String[] getNewAnimalInfo() {
        String[] separateInfo={textField_Name.getText().trim(),textField_Species.getText().trim(), textField_SubSpecies.getText().trim()};
        return separateInfo;
    }

}
