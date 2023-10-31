module com.example.games {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.logging;


    opens com.example.games to javafx.fxml;
    exports com.example.games;
    exports com.example.games.controller;
    opens com.example.games.controller to javafx.fxml;
}