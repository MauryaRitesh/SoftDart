package com.example.softdart;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.PasswordField;
import javafx.stage.Stage;
import javafx.stage.StageStyle;


import java.io.File;
import java.net.URL;
import java.sql.Connection;
import java.sql.Statement;
import java.util.ResourceBundle;

public class RegisterController implements Initializable {

    @FXML
    private Button closeButton;

    @FXML
    private Label registrationMessageLabel;
    @FXML
    private PasswordField setPasswordField;
    @FXML
    private PasswordField confirmPasswordField;
    @FXML
    private Label confirmPasswordLabel;
    @FXML
    private TextField firstnameTextField;
    @FXML
    private TextField lastnameTextField;
    @FXML
    private TextField usernameTextField;

    public void initialize(URL url, ResourceBundle resourceBundle){

    }

    public void registerButtonOnAction(ActionEvent event){
        if (setPasswordField.getText().equals(confirmPasswordField.getText())){
            registerUser();
            confirmPasswordLabel.setText("");
        } else {
            confirmPasswordLabel.setText("Password does not match");
        }

    }

    public void closeButtonOnAction(ActionEvent event){
        Stage stage = (Stage) closeButton.getScene().getWindow();
        stage.close();
        Platform.exit();
    }

    public void registerUser(){
        DatabaseConnection connectNow = new DatabaseConnection();
        Connection connectDB = connectNow.getConnection();

        String firstname = firstnameTextField.getText();
        String lastname = lastnameTextField.getText();
        String username = usernameTextField.getText();
        String password = setPasswordField.getText();

        String insertFields = "INSERT INTO user_account(firstname, lastname, username, password) VALUES ('";
        String insertValues = firstname + "','" + lastname + "','"  + username + "','" + password+ "')";
        String insertToRegister = insertFields + insertValues;

        try{
            Statement statement = connectDB.createStatement();
            statement.executeUpdate(insertToRegister);

            registrationMessageLabel.setText("User registered successfully!");

        }catch (Exception e){
            e.printStackTrace();
            e.getCause();
        }


    }
}
