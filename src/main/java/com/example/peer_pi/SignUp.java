package com.example.peer_pi;

import io.github.palexdev.materialfx.controls.MFXButton;
import io.github.palexdev.materialfx.controls.MFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Objects;

public class SignUp{
    @FXML
    private Label statusLabel;
    @FXML
    private MFXTextField lastName;

    @FXML
    private MFXButton logInBtn;

    @FXML
    private MFXButton signUpBtn;

    @FXML
    private MFXTextField uniID;

    @FXML
    private MFXTextField firstName;

    @FXML
    private MFXTextField email;

    @FXML
    private MFXTextField password;

    private Connection connection;
    private final String DATABASE_URL = "jdbc:mysql://localhost:3306/peer_pie_data";
    private final String DATABASE_USERNAME = "root";
    private final String DATABASE_PASSWORD = "arafath221158";

    private final String INSERT_QUERY = "INSERT INTO users (first_name, last_name, uni_id, email, password) VALUES (?, ?, ?, ?, ?)";

    @FXML
    void signUp(ActionEvent event) throws IOException {
        String first_Name = firstName.getText();
        String last_Name = lastName.getText();
        String UniID = uniID.getText();
        String userEmail = email.getText();
        String userPassword = password.getText();

        if (first_Name.isEmpty() || last_Name.isEmpty() || UniID.isEmpty() || userEmail.isEmpty() || userPassword.isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText(null);
            alert.setContentText("Please fill in all fields");
            alert.showAndWait();
            return;
        }

        try (Connection connection = DriverManager.getConnection(DATABASE_URL, DATABASE_USERNAME, DATABASE_PASSWORD);
             PreparedStatement preparedStatement = connection.prepareStatement(INSERT_QUERY)) {

            preparedStatement.setString(1, first_Name);
            preparedStatement.setString(2, last_Name);
            preparedStatement.setString(3, UniID);
            preparedStatement.setString(4, userEmail);
            preparedStatement.setString(5, userPassword);

            int rowsInserted = preparedStatement.executeUpdate();
            if (rowsInserted > 0) {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Success");
                alert.setHeaderText(null);
                alert.setContentText("Sign up successful");
                alert.showAndWait();
                switchToDash(event);
            }
        } catch (SQLException e) {
            printSQLException(e);
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText(null);
            alert.setContentText("Sign up failed. Please try again later");
            alert.showAndWait();
        }
    }

    private void printSQLException(SQLException e) {
        while (e != null) {
            System.err.println("SQLState: " + e.getSQLState());
            System.err.println("Error Code: " + e.getErrorCode());
            System.err.println("Message: " + e.getMessage());
            e = e.getNextException();
        }
    }


    @FXML
    protected void switchToDash(ActionEvent event) throws IOException {Parent dashParent = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("Dash.fxml")));
        Scene dashScene = new Scene(dashParent);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(dashScene);
        window.show();
    }



    @FXML
    private void switchToLogIn(ActionEvent event) throws IOException {
        Parent loginParent = FXMLLoader.load(getClass().getResource("LogIn.fxml"));
        Scene loginScene = new Scene(loginParent);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(loginScene);
        window.show();
    }
}
