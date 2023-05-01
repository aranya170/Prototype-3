package com.example.peer_pi;

import io.github.palexdev.materialfx.controls.MFXButton;
import io.github.palexdev.materialfx.controls.MFXPasswordField;
import io.github.palexdev.materialfx.controls.MFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.InputMethodEvent;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class SignIn {

    @FXML
    private MFXTextField LastName;

    @FXML
    private MFXButton LogInBtn1;

    @FXML
    private MFXTextField UID;

    @FXML
    private MFXTextField firstName;

    @FXML
    private MFXTextField mailBtn1;

    @FXML
    private MFXPasswordField passBtn;

    @FXML
    private MFXButton signUpBtn;

    @FXML
    void Click_On_SignIn(ActionEvent event) throws IOException {
        Parent scene2 = FXMLLoader.load(getClass().getResource("SignUp.fxml"));
        Scene displayScene = new Scene(scene2);
        Stage window = (Stage)((Node)(event.getSource())).getScene().getWindow();
        window.setScene(displayScene);
        window.show();
    }

    @FXML
    void switchToDash(InputMethodEvent event) throws IOException {
        Parent dashParent = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("Dash.fxml")));
        Scene dashScene = new Scene(dashParent);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(dashScene);
        window.show();

    }

    @FXML
    void switchToLogIn(ActionEvent event) throws IOException {
        Parent loginParent = FXMLLoader.load(getClass().getResource("LogIn.fxml"));
        Scene loginScene = new Scene(loginParent);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(loginScene);
        window.show();
    }

}
