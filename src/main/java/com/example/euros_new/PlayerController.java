package com.example.euros_new;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.UnsupportedEncodingException;
import java.util.List;

import static com.example.euros_new.Api.topAssister;

public class PlayerController {
    @FXML
    private Button goalBtn;
    @FXML
    private Menu groupBtn;
    @FXML
    private Button idButton;

    @FXML
    private TextField idTextField;
    @FXML
    private Menu matchBtn;

    @FXML
    private Menu teamBtn;

    @FXML
    private TableView<Api> tableView;
    @FXML
    private TableColumn<Api, String> nameColumn;
    @FXML
    private TableColumn<Api, Integer> goalsColumn;
    @FXML
    private TableColumn<Api, Integer> assistsColumn;
    @FXML
    private TableColumn<Api, Integer> appearancesColumn;
    @FXML
    private TableColumn<Api, Integer> firstTeamAppearancesColumn;
    @FXML
    private TableColumn<Api, Integer> minutesPlayedColumn;
    @FXML
    private TableColumn<Api, String> teamNameColumn;
    @FXML
    void idHandler(ActionEvent event) {
        String playerId = idTextField.getText();
        Alert alert = new Alert(Alert.AlertType.INFORMATION);

        if (playerId != null && !playerId.isEmpty()) {
            try {
                Api playerInfo = Api.displayPlayer(playerId);

                alert.setTitle("Player Stats");
                alert.setHeaderText("Displaying Player Information");
                alert.setContentText(playerInfo.toFormattedString());

            } catch (Exception e) {
                alert.setAlertType(Alert.AlertType.ERROR);
                alert.setTitle("Error");
                alert.setHeaderText("Error Fetching Player Information");
                alert.setContentText("An error occurred while fetching player information. Please try again.");
                e.printStackTrace();
            }
        } else {
            alert.setAlertType(Alert.AlertType.WARNING);
            alert.setTitle("Input Required");
            alert.setHeaderText("Player ID Missing");
            alert.setContentText("Please enter a valid player ID.");
        }

        alert.showAndWait();
    }





    @FXML
    void goToGroupHandler(ActionEvent event) {

    }

    @FXML
    void goToHomeHandler(ActionEvent event) {

    }

    @FXML
    void goToMatchHandler(ActionEvent event) {

    }

    @FXML
    void goToTeamHandler(ActionEvent event) {

    }

    @FXML
    void goalHandler(ActionEvent event) {
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        goalsColumn.setCellValueFactory(new PropertyValueFactory<>("goals"));
        assistsColumn.setCellValueFactory(new PropertyValueFactory<>("assists"));
        appearancesColumn.setCellValueFactory(new PropertyValueFactory<>("appearances"));
        firstTeamAppearancesColumn.setCellValueFactory(new PropertyValueFactory<>("firstTeamAppearances"));
        minutesPlayedColumn.setCellValueFactory(new PropertyValueFactory<>("minutesPlayed"));
        teamNameColumn.setCellValueFactory(new PropertyValueFactory<>("teamName"));

        // Load data
        try {
            ObservableList<Api> topScorers = FXCollections.observableArrayList(Api.topScorer());
            tableView.setItems(topScorers);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @FXML
    void assistHandler(ActionEvent event) {
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        goalsColumn.setCellValueFactory(new PropertyValueFactory<>("goals"));
        assistsColumn.setCellValueFactory(new PropertyValueFactory<>("assists"));
        appearancesColumn.setCellValueFactory(new PropertyValueFactory<>("appearances"));
        firstTeamAppearancesColumn.setCellValueFactory(new PropertyValueFactory<>("firstTeamAppearances"));
        minutesPlayedColumn.setCellValueFactory(new PropertyValueFactory<>("minutesPlayed"));
        teamNameColumn.setCellValueFactory(new PropertyValueFactory<>("teamName"));

        // Load data
        try {
            ObservableList<Api> topAssists = FXCollections.observableArrayList(Api.topAssister());
            tableView.setItems(topAssists);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }


//    public void initialize() {
//        // Configure the table columns
//        nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
//        goalsColumn.setCellValueFactory(new PropertyValueFactory<>("goals"));
//        assistsColumn.setCellValueFactory(new PropertyValueFactory<>("assists"));
//        appearancesColumn.setCellValueFactory(new PropertyValueFactory<>("appearances"));
//        firstTeamAppearancesColumn.setCellValueFactory(new PropertyValueFactory<>("firstTeamAppearances"));
//        minutesPlayedColumn.setCellValueFactory(new PropertyValueFactory<>("minutesPlayed"));
//        teamNameColumn.setCellValueFactory(new PropertyValueFactory<>("teamName"));
//
//        // Load data
//        try {
//            ObservableList<Api> topScorers = FXCollections.observableArrayList(Api.topScorer());
//            tableView.setItems(topScorers);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
}