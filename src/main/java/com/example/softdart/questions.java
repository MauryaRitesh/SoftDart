package com.example.softdart;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class questions {
    public SimpleIntegerProperty QuestionID = new SimpleIntegerProperty();
    public SimpleStringProperty QuestionTitle = new SimpleStringProperty();
    public  SimpleStringProperty QuestionDescription = new SimpleStringProperty();

    public  SimpleStringProperty user = new SimpleStringProperty();

    public SimpleIntegerProperty upvotes = new SimpleIntegerProperty();
    public SimpleIntegerProperty downvotes = new SimpleIntegerProperty();

    public int getQuestionID() {
        return this.QuestionID.get();
    }
    public void setQuestionID(int id) {
        this.QuestionID.set(id);
    }

    public String getQuestionTitle() {
        return QuestionTitle.get();
    }
    public void setQuestionTitle(String firstNameStr) {
        QuestionTitle.set(firstNameStr);
    }
    public String getQuestionDescription() {
        return QuestionDescription.get();
    }
    public void setQuestionDescription(String lastNameStr) {
        QuestionDescription.set(lastNameStr);
    }
    public String getUser() {
        return user.get();
    }
    public void setUser(String address) {
        this.user.set(address);
    }
    public int getUpvotes() {
        return this.upvotes.get();
    }
    public void setUpvotes(int upvotes) {
        this.upvotes.set(upvotes);
    }
    public int getDownvotes() {
        return this.downvotes.get();
    }
    public void setDownvotes(int downvotes) {
        this.downvotes.set(downvotes);
    }
}
