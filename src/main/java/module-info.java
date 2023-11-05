module com.example.games {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.graphics;
    requires java.logging;
    requires java.prefs;

    opens com.example.games to javafx.fxml;
    exports com.example.games;
    exports com.example.games.controller;
    opens com.example.games.controller to javafx.fxml;
    exports com.example.games.controller.pvp;
    opens com.example.games.controller.pvp to javafx.fxml;
    exports com.example.games.controller.pve;
    opens com.example.games.controller.pve to javafx.fxml;
}
