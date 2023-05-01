package com.example.peer_pi;

import javafx.fxml.FXML;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;

public class NotesBiology extends Controller{
    @FXML
    private WebView web;
    public void initialize(){
        WebEngine webEngine = web.getEngine();
        webEngine.load("https://discord.gg/bJT6Fk8REa");
    }
}
