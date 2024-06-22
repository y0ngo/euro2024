package com.example.euros_new;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class LogInController {

    @FXML
    private Button cancelBtn;

    @FXML
    private Button loginBtn;

    @FXML
    private TextField loginTextField;

    @FXML
    private TextField passwordTextfield;

    @FXML
    private Hyperlink registerLink;

    @FXML
    private void cancelHandler(ActionEvent event) {

    }

    @FXML
    private void loginHandler(ActionEvent event) {

    }

    @FXML
    private void registerHandler(ActionEvent event) {
        Stage secondaryStage = new Stage();
        Stage primaryStage = (Stage) registerLink.getScene().getWindow();
        try {


            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("register.fxml"));
            Parent root = loader.load();
            Scene scene = new Scene(root, 640, 480);
            secondaryStage.setScene(scene);

            secondaryStage.show();

            primaryStage.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    }


