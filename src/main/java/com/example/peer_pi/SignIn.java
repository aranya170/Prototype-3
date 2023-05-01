package com.example.peer_pi;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class SignIn extends Controller{
    @FXML
    protected void switchToDash(ActionEvent event) throws IOException, InterruptedException {
        Parent scene2 = FXMLLoader.load(getClass().getResource("Dash.fxml"));
        Scene displayScene = new Scene(scene2);
        Stage window = (Stage)((Node)(event.getSource())).getScene().getWindow();
        window.setScene(displayScene);
        window.show();
    }
}
