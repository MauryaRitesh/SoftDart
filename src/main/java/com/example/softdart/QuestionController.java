package com.example.softdart;
import com.example.softdart.RegisterController;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.stage.StageStyle;


import java.io.File;
import java.net.URL;
import java.sql.Connection;
import java.sql.Statement;
import java.util.ResourceBundle;

public class QuestionController implements Initializable {

    @FXML
    private Button closeButton;

    @FXML
    private TextField questionTitleTextField;
    @FXML
    private TextField questionDescriptionTextField;
    @FXML
    private TextField questionTagTextField;

    public void initialize(URL url, ResourceBundle resourceBundle){

    }


    public void closeButtonOnAction(ActionEvent event){
        homePage();
    }

    public void addQuestionButtonOnAction(){
        DatabaseConnection connectNow = new DatabaseConnection();
        Connection connectDB = connectNow.getConnection();

        String tittle = questionTitleTextField.getText();
        String description = questionDescriptionTextField.getText();
        String tag = questionTagTextField.getText();
        String userName = "" ;

        String insertFields = "INSERT INTO questions(questionTitle, questionDescription, questionTag, userName) VALUES ('";
        String insertValues = tittle + "','" + description + "','"  + tag + "','" + userName+ "')";
        String insertToRegister = insertFields + insertValues;

        try{
            Statement statement = connectDB.createStatement();
            statement.executeUpdate(insertToRegister);

        }catch (Exception e){
            e.printStackTrace();
            e.getCause();
        }


    }

    @FXML
    public static void homePage(){
        RegisterController.BackToHomePage();
    }
}
