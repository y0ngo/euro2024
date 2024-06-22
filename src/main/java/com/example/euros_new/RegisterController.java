package com.example.euros_new;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

public class RegisterController {

    @FXML
    private Button cancelBtn;

    @FXML
    private Button confirmBtn;

    @FXML
    private TextField emailTextField;

    @FXML
    private TextField idTextField;

    @FXML
    private PasswordField passwordTextField;
    DBConnection DB = new DBConnection();

    @FXML
    private void cancelHandler(ActionEvent event) {

    }

    @FXML
    private void confirmHandler(ActionEvent event) {

        String id = idTextField.getText();
        String email = emailTextField.getText();
        String password = passwordTextField.getText();

        if (id != null && email != null && password != null && id.length() > 1 && email.contains("@")) {
        DB.addUserToDB(id,email,password);
        showDialog("Successful","Account created successfully now bringing you to login");
        navigateToLogin(event);



            }else {showDialog("Failed","Invalid format for registration, please try again ");
            }



    }



    private void showDialog(String title, String content) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(content);
        alert.showAndWait();
    }
    private void navigateToLogin(ActionEvent event) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("LogIn.fxml"));
            Parent loginRoot = fxmlLoader.load();
            Scene loginScene = new Scene(loginRoot);
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(loginScene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}