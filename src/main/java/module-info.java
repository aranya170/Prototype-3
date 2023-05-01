module com.example.peer_pi {
    requires javafx.controls;
    requires javafx.fxml;
    requires MaterialFX;
    requires javafx.web;
    requires java.sql;


    opens com.example.peer_pi to javafx.fxml;
    exports com.example.peer_pi;
}