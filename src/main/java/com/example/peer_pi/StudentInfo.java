package com.example.peer_pi;
import javafx.beans.property.*;
public class StudentInfo {



    //Declare Table Columns
    private IntegerProperty participant_no;
    private StringProperty first_name;
    private StringProperty last_name;
    private StringProperty email;
    private StringProperty password;

    //Constructor
    public StudentInfo() {
        this.participant_no = new SimpleIntegerProperty();
        this.first_name = new SimpleStringProperty();
        this.last_name = new SimpleStringProperty();
        this.email = new SimpleStringProperty();
        this.password = new SimpleStringProperty();
    }

    public int getParticipant_no() {
        return participant_no.get();
    }

    public void setParticipant_no(int participant_no) {
        this.participant_no.set(participant_no);
    }

    public IntegerProperty participant_noProperty() {
        return participant_no;
    }

    //first_name
    public String getFirstName() {
        return first_name.get();
    }

    public void setFirstName(String firstName) {
        this.first_name.set(firstName);
    }

    public StringProperty firstNameProperty() {
        return first_name;
    }

    //last_name
    public String getLastName() {
        return last_name.get();
    }

    public void setLastName(String lastName) {
        this.last_name.set(lastName);
    }

    public StringProperty lastNameProperty() {
        return last_name;
    }

    //email
    public String getEmail() {
        return email.get();
    }

    public void setEmail(String email) {
        this.email.set(email);
    }

    public StringProperty emailProperty() {
        return email;
    }

    //password
    public String getPassword() {
        return password.get();
    }

    public void setPassword(String password) {
        this.password.set(password);
    }

    public StringProperty passwordProperty() {
        return password;
    }

}


