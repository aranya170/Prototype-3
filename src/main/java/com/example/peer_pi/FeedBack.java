package com.example.peer_pi;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
public class FeedBack extends Controller{
    @FXML
    private TextField msgField;
    @FXML
    private Text text;
    @FXML
    private Button sendButton;
    @FXML
    private void sendMessage() {
        try {
            Socket socket = new Socket("localhost", 1234);
            OutputStream os = socket.getOutputStream();
            PrintWriter pw = new PrintWriter(os, true);
            String message = msgField.getText();
            pw.println(message);
            pw.close();
            os.close();
            msgField.setVisible(false);
            sendButton.setVisible(false);
            text.setText("Thanks for your feedback");
//            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
