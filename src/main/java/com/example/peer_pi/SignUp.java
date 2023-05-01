package com.example.peer_pi;
import io.github.palexdev.materialfx.controls.MFXButton;
import io.github.palexdev.materialfx.controls.MFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Random;
import java.awt.*;

public class SignUp extends Controller{
    @FXML
    private Label statusLabel;
    @FXML
    private MFXTextField LastName;

    @FXML
    private MFXButton LogInBtn;

    @FXML
    private MFXButton LogInBtn1;

    @FXML
    private MFXTextField UID;

    @FXML
    private MFXTextField firstName;

    @FXML
    private MFXTextField mailBtn1;

    @FXML
    private MFXTextField passBtn;

    private Connection connection;
    private final String url = "jdbc:mysql://localhost:3306/peer_pie_data";
    private final String username = "root";
    private final String password = "arafath221158";

    public SignUp() throws SQLException {
        connection = DriverManager.getConnection(url, username, password);
    }
    @FXML
    void Click_On_SignIn(ActionEvent event) throws SQLException {
        String first_Name = firstName.getText();
        String last_Name = LastName.getText();
        String UniID = UID.getText();
        String email = mailBtn1.getText();
        String password = passBtn.getText();

        if (first_Name.isEmpty() || last_Name.isEmpty() || UniID.isEmpty() || email.isEmpty() || password.isEmpty()) {
            statusLabel.setText("Please fill in all fields.");
        } else {
            int participantNo = generateParticipantNo();
            String signUpDateTime = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
            String query = "INSERT INTO users (participant_no, first_name, last_name, phone, email, password, sign_up_datetime) VALUES (?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, participantNo);
            statement.setString(2, first_Name);
            statement.setString(3, last_Name);
            statement.setString(4, UniID);
            statement.setString(5, email);
            statement.setString(6, password);
            statement.setString(7, signUpDateTime);
            statement.executeUpdate();
            //statusLabel.setText("Sign up successful! Your participant no. is " + participantNo);
        }
    }

    private int generateParticipantNo() {
        Random random = new Random();
        return random.nextInt(1000000);
    }
    @FXML
    protected void switchToLogIn(ActionEvent event) throws IOException {
        Parent scene2 = FXMLLoader.load(getClass().getResource("Log in.fxml"));
        Scene displayScene = new Scene(scene2);
        Stage window = (Stage)((Node)(event.getSource())).getScene().getWindow();
        window.setScene(displayScene);
        window.show();
    }
}
