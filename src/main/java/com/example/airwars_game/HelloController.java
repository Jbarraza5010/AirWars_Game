package com.example.airwars_game;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

import java.io.IOException;
import java.net.Socket;
import java.net.URL;
import java.util.ResourceBundle;

import Classes.Client;

public class HelloController implements Initializable {
    @FXML
    private Label welcomeText;

    private Client client;

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        try{
            client = new Client(new Socket("localhost", 1234));
            System.out.println("Conectado al Servidor");
        }catch (IOException e){
            e.printStackTrace();
            System.out.println("Error conectandose el servidor");
        }
    }
}