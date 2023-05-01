package com.example.peer_pi;

import io.github.palexdev.materialfx.controls.MFXButton;
import io.github.palexdev.materialfx.controls.MFXCheckTreeView;
import io.github.palexdev.materialfx.controls.MFXProgressBar;
import io.github.palexdev.materialfx.controls.MFXTextField;
import io.github.palexdev.materialfx.controls.legacy.MFXLegacyListView;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.*;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collection;
import java.util.ResourceBundle;

public class NoteController extends Controller implements Initializable{

    @FXML
    private MFXButton Done;
    @FXML
    private MFXProgressBar myProgressBar;
    @FXML
    private MFXLegacyListView<String> myList;
    private ArrayList<String> notes = new ArrayList<>();
    @FXML
    private MFXTextField myText;
    @FXML
    private MFXTextField myTarget;
    @FXML
    private TextArea myTextArea;
    double target=0.0;
    double progress=0.0;
    @FXML
    private Text progressText;

    public NoteController() throws FileNotFoundException {
    }

    @FXML
    private void SaveBtn(ActionEvent event) throws Exception {
        String text = myText.getText();
        if(!text.isEmpty()) {
            notes.add(text);
            myList.getItems().add(text);
            myText.clear();
            System.out.println(notes);
            BufferedWriter writer = new BufferedWriter(new FileWriter("To-Do.txt",true));
            for(String data: notes){
                writer.write(data);
                writer.write("++");
                writer.flush();
            }
            writer.close();
        }
    }
    public void updateDataToFile() throws Exception{
        BufferedWriter writer = new BufferedWriter(new FileWriter("To-Do.txt"));
        for(String data: notes){
            writer.write(data);
            writer.write("++");
            writer.flush();
        }
        writer.close();
    }
    public ArrayList<String> readDataFromFile() {
        ArrayList<String> dataList = new ArrayList<>();
        try {
            FileReader reader = new FileReader("To-Do.txt");
            BufferedReader bufferedReader = new BufferedReader(reader);
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                String[] dataItems = line.split("\\+\\+");
                for (String dataItem : dataItems) {
                    dataList.add(dataItem);
//                    notes.add(dataItem);
                }
            }
            bufferedReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return dataList;
    }
    @FXML
    private void StickySaveBtn(ActionEvent event){
        String text = myTextArea.getText();
        if(!text.isEmpty()) {
            notes.add(text);
            myList.getItems().add(text);
            myTextArea.clear();
        }
    }
    @FXML
    private void handleDeleteNoteButton(ActionEvent event) throws Exception {
        progress = progress+((10/target)/10);
        myProgressBar.setProgress(progress);
        int selectedIndex = myList.getSelectionModel().getSelectedIndex();
        if (selectedIndex != -1) {
            notes.remove(selectedIndex);
            System.out.println(notes);
            myList.getItems().remove(selectedIndex);
            updateDataToFile();
        }
        if (progress == 1){
            progressText.setText("Congratulations! Achievement Complete");
        }
    }
    @FXML
    private void handleDeleteStickyButton(ActionEvent event) throws IOException {
        int selectedIndex = myList.getSelectionModel().getSelectedIndex();
        if (selectedIndex != -1) {
            notes.remove(selectedIndex);
            myList.getItems().remove(selectedIndex);
        }
    }
    @FXML
    private void setTarget(ActionEvent actionEvent) throws IOException {
        target = Double.parseDouble(myTarget.getText());
        myTarget.clear();
        progressText.setText("Today's target is "+Math.round(target));
    }
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        ArrayList<String> list = readDataFromFile();
        System.out.println(notes);
        myList.getItems().addAll(list);
    }
}
