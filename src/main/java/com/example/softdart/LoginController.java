package com.example.softdart;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import javafx.event.ActionEvent;
import javafx.stage.StageStyle;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ResourceBundle;
import java.net.URL;

public class LoginController{
    @FXML
    private Label welcomeText;
    @FXML
    private Label loginMessageLabel;

    @FXML
    private Button loginButton;
    @FXML
    private Button signupButton;
    @FXML
    private Button cancelButton;
    @FXML
    private TextField usernameTextField;
    @FXML
    private PasswordField enterPasswordField;

    public void loginButtonOnAction(ActionEvent event){
        if (usernameTextField.getText().isBlank() == false && enterPasswordField.getText().isBlank() == false){
            validateLogin();
        } else{
            loginMessageLabel.setText("Invalid Credentials.");
        }
    }
    public void signupButtonOnAction(ActionEvent event){
        if (!usernameTextField.getText().isBlank() && !enterPasswordField.getText().isBlank()){
            createAccountForm();
        } else{
            loginMessageLabel.setText("Invalid Credentials.");
        }
    }

    public void cancelButtonOnAction(ActionEvent event){
        Stage stage = (Stage) cancelButton.getScene().getWindow();
        stage.close();
    }
    public void validateLogin(){
        DatabaseConnection connectNow = new DatabaseConnection();
        Connection connectDB = connectNow.getConnection();

        String verifyLogin = "SELECT count(1) FROM user_account WHERE username = '" + usernameTextField.getText() + "' AND password = '" + enterPasswordField.getText() + "'";

        try{
            Statement statement = connectDB.createStatement();
            ResultSet queryResult = statement.executeQuery(verifyLogin);

            while (queryResult.next()){
                if (queryResult.getInt(1) == 1){
                    loginMessageLabel.setText("Congratulations!");
                    //createAccountForm();
                }else{
                    loginMessageLabel.setText("Invalid Credentials. Please try again.");
                }
            }

        }catch (Exception e){
            e.printStackTrace();
            e.getCause();
        }
    }

    @FXML
    public void createAccountForm(){
        try{
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("register.fxml"));
            Scene scene = new Scene(fxmlLoader.load(), 520, 370);
            Stage registerStage = HelloApplication.appStage;
            registerStage.setScene(scene);
            registerStage.show();

        } catch (Exception e){
            e.printStackTrace();
            e.getCause();
        }
    }

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
    }
}