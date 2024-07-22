package com.example.euros_new;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Menu;
import javafx.scene.control.TextField;

import java.util.List;

public class TeamController {

    @FXML
    private Menu groupBtn;

    @FXML
    private Menu homeBtn;

    @FXML
    private Button idButton;

    @FXML
    private TextField idTextField;

    @FXML
    private Menu matchBtn;

    @FXML
    private Menu teamBtn;

    @FXML
    private Button viewTeamBtn;

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
    void idHandler(ActionEvent event) {
        String teamId = idTextField.getText();
        Alert alert = new Alert(Alert.AlertType.INFORMATION);

        if (teamId != null && !teamId.isEmpty()) {
            try {
                Api playerInfo = Api.displayTeam(teamId);

                alert.setTitle("Team Stats");
                alert.setHeaderText("Displaying Team Information");
                alert.setContentText(playerInfo.teamToFormattedString());

            } catch (Exception e) {
                alert.setAlertType(Alert.AlertType.ERROR);
                alert.setTitle("Error");
                alert.setHeaderText("Error Fetching Team Information");
                alert.setContentText("An error occurred while fetching player information. Please try again.");
                e.printStackTrace();
            }
        } else {
            alert.setAlertType(Alert.AlertType.WARNING);
            alert.setTitle("Input Required");
            alert.setHeaderText("Team ID Missing");
            alert.setContentText("Please enter a valid Team ID.");
        }

        alert.showAndWait();

    }

    @FXML
    void viewTeamHandler(ActionEvent event) {
        try {
            List<Api> allTeams = Api.displayAllTeams();
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Team Stats");
            alert.setHeaderText("Displaying All Team Information");

            // Concatenate all team information into a single string
            StringBuilder content = new StringBuilder();
            for (Api team : allTeams) {
                content.append(team.teamToFormattedString()).append("\n-------------------------\n");
            }

            // Set the content of the alert
            alert.setContentText(content.toString());
            alert.showAndWait(); // Show the alert

        } catch (Exception e) {
            e.printStackTrace();
            System.err.println("Error occurred: " + e.getMessage());
        }
    }


}

