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

public class SignUp extends Controller{
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
    @FXML
    protected void switchToLogIn(ActionEvent event) throws IOException {
        Parent scene2 = FXMLLoader.load(getClass().getResource("Log in.fxml"));
        Scene displayScene = new Scene(scene2);
        Stage window = (Stage)((Node)(event.getSource())).getScene().getWindow();
        window.setScene(displayScene);
        window.show();
    }
}
