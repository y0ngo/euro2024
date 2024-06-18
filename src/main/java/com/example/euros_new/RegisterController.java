package com.example.euros_new;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

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
    private TextField passwordTextField;

    @FXML
    private void cancelHandler(ActionEvent event) {

    }

    @FXML
    private void confirmHandler(ActionEvent event) {
        String id= idTextField.getText();
        String email=emailTextField.getText();
        String password= passwordTextField.getText();

        if (id != null && email != null && password != null && id.length()>1 && email.contains("@")){

        }


    }

}