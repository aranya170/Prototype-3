package com.example.peer_pi;

import io.github.palexdev.materialfx.controls.*;
import io.github.palexdev.materialfx.controls.legacy.MFXLegacyListView;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;

public class Controller {
    @FXML
    protected void switchToDash(ActionEvent event) throws IOException, InterruptedException {
        Parent scene2 = FXMLLoader.load(getClass().getResource("Dash.fxml"));
        Scene displayScene = new Scene(scene2);
        Stage window = (Stage)((Node)(event.getSource())).getScene().getWindow();
        window.setScene(displayScene);
        window.show();
    }
    @FXML
    protected void switchToKeepNotes(ActionEvent event) throws IOException {
        Parent scene2 = FXMLLoader.load(getClass().getResource("keepNotes.fxml"));
        Scene displayScene = new Scene(scene2);
        Stage window = (Stage)((Node)(event.getSource())).getScene().getWindow();
        window.setScene(displayScene);
        window.show();
    }
    @FXML
    protected void switchToStickyNotes(ActionEvent event) throws IOException {
        Parent scene2 = FXMLLoader.load(getClass().getResource("StickyNotes.fxml"));
        Scene displayScene = new Scene(scene2);
        Stage window = (Stage)((Node)(event.getSource())).getScene().getWindow();
        window.setScene(displayScene);
        window.show();
    }
    @FXML
    protected void switchToQstn(ActionEvent event) throws IOException {
        Parent scene2 = FXMLLoader.load(getClass().getResource("Questions.fxml"));
        Scene displayScene = new Scene(scene2);
        Stage window = (Stage)((Node)(event.getSource())).getScene().getWindow();
        window.setScene(displayScene);
        window.show();
    }
    @FXML
    protected void switchToWeb(ActionEvent event) throws IOException {
        Parent scene2 = FXMLLoader.load(getClass().getResource("DiscordPageOOP.fxml"));
        Scene displayScene = new Scene(scene2);
        Stage window = (Stage)((Node)(event.getSource())).getScene().getWindow();
        window.setScene(displayScene);
        window.show();
    }
    @FXML
    protected void switchToBioNotes(ActionEvent event) throws IOException {
        Parent scene2 = FXMLLoader.load(getClass().getResource("NotesBiology.fxml"));
        Scene displayScene = new Scene(scene2);
        Stage window = (Stage)((Node)(event.getSource())).getScene().getWindow();
        window.setScene(displayScene);
        window.show();
    }
    @FXML
    protected void switchToSignUp(ActionEvent event) throws IOException {
        Parent scene2 = FXMLLoader.load(getClass().getResource("SignUp.fxml"));
        Scene displayScene = new Scene(scene2);
        Stage window = (Stage)((Node)(event.getSource())).getScene().getWindow();
        window.setScene(displayScene);
        window.show();
    }
    @FXML
    protected void switchToFeedBack(ActionEvent event) throws IOException {
        Parent scene2 = FXMLLoader.load(getClass().getResource("FeedBack.fxml"));
        Scene displayScene = new Scene(scene2);
        Stage window = (Stage)((Node)(event.getSource())).getScene().getWindow();
        window.setScene(displayScene);
        window.show();
    }
}