module com.example.airwars_game {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.airwars_game to javafx.fxml;
    exports com.example.airwars_game;
}