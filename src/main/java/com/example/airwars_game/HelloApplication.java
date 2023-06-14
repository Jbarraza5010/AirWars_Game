package com.example.airwars_game;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * Esta clase inicia la aplicacion del juego
 */
public class HelloApplication extends Application {
    /**
     * Funcion que abre la interfaz grafica
     * @param stage
     * @throws IOException
     */
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 1166, 700);
        stage.setTitle("AirWars");
        stage.setScene(scene);
        stage.show();
    }

    /**
     * Funcion main de la aplicacion
     * @param args
     */
    public static void main(String[] args) {
        launch();
    }
}