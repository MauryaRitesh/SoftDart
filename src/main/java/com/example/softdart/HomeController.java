package com.example.softdart;

import javafx.application.Platform;
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

public class HomeController{
    @FXML
    private Label welcomeText;
    @FXML
    private Button profileButton;

    @FXML
    private Button trendingButton;
    @FXML
    private Button settingsButton;
    @FXML
    private Button logoutButton;
    @FXML
    private Button closeButton;

    @FXML
    private Button addQuestionButton;
    @FXML
    private TextField firstnameTextField;
    @FXML
    private TextField lastnameTextField;
    @FXML
    private TextField usernameTextField;


    //cards



    public void profileButtonOnAction(ActionEvent event){
        profilePage();
    }
    public void settingsButtonOnAction(ActionEvent event){

    }

    public void logoutButtonOnAction(ActionEvent event){

    }

    @FXML
    public void addQuestionButtonOnAction(ActionEvent event){
        //add question to the database.
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("questions.fxml"));
            Scene scene = new Scene(fxmlLoader.load(), 520, 470);
            Stage questionStage = HelloApplication.appStage;
            questionStage.setScene(scene);
            questionStage.show();

        } catch (Exception e){
            e.printStackTrace();
            e.getCause();
        }
    }

    public void closeButtonOnAction(ActionEvent event){
        Stage stage = (Stage) closeButton.getScene().getWindow();
        stage.close();
        Platform.exit();
    }


    @FXML
    public void profilePage(){
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("profile.fxml"));
            Scene scene = new Scene(fxmlLoader.load(), 520, 470);
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