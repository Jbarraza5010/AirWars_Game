package com.example.airwars_game;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

import java.io.IOException;
import java.net.Socket;
import java.net.URL;
import java.util.ResourceBundle;

import Classes.Client;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class HelloController implements Initializable {

    private Client client;

    @FXML
    private ImageView africa;

    @FXML
    private ImageView asia;

    @FXML
    private ImageView atlantico;

    @FXML
    private ImageView europa;

    @FXML
    private ImageView indico;

    @FXML
    private ImageView norteAmerica;

    @FXML
    private ImageView oceania;

    @FXML
    private ImageView pacifico1;

    @FXML
    private ImageView pacifico2;

    @FXML
    private ImageView surAmerica;

    @FXML
    private ImageView worldmap;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        try{
            client = new Client(new Socket("localhost", 1234));
            System.out.println("Conectado al Servidor");
        }catch (IOException e){
            e.printStackTrace();
            System.out.println("Error conectandose el servidor");
        }

        client.recieveMessageFromServer(africa, asia, atlantico, europa, indico, norteAmerica, oceania, pacifico1, pacifico2, surAmerica);
    }

    public static void mapa(String lugar, ImageView africa, ImageView asia, ImageView atlantico, ImageView europa, ImageView indico, ImageView norteamerica, ImageView oceania, ImageView pacifico1, ImageView pacifico2, ImageView suramerica){
        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                if (lugar.contains("africa")){
                    Image africaA = new Image("C:\\Users\\Usuario WTK\\Proyectos GitHub\\AirWars_Game\\src\\main\\resources\\com\\example\\airwars_game\\airport.png");
                    africa.setImage(africaA);
                }
                else if(lugar.contains("asia")){
                    Image asiaA = new Image("C:\\Users\\Usuario WTK\\Proyectos GitHub\\AirWars_Game\\src\\main\\resources\\com\\example\\airwars_game\\airport.png");
                    asia.setImage(asiaA);
                }
                else if(lugar.contains("atlantico")){
                    Image asiaA = new Image("C:\\Users\\Usuario WTK\\Proyectos GitHub\\AirWars_Game\\src\\main\\resources\\com\\example\\airwars_game\\portaavion.png");
                    atlantico.setImage(asiaA);
                }
                else if(lugar.contains("europa")){
                    Image asiaA = new Image("C:\\Users\\Usuario WTK\\Proyectos GitHub\\AirWars_Game\\src\\main\\resources\\com\\example\\airwars_game\\airport.png");
                    europa.setImage(asiaA);
                }
                else if(lugar.contains("indico")){
                    Image asiaA = new Image("C:\\Users\\Usuario WTK\\Proyectos GitHub\\AirWars_Game\\src\\main\\resources\\com\\example\\airwars_game\\portaavion.png");
                    indico.setImage(asiaA);
                }
                else if(lugar.contains("norte america")){
                    Image asiaA = new Image("C:\\Users\\Usuario WTK\\Proyectos GitHub\\AirWars_Game\\src\\main\\resources\\com\\example\\airwars_game\\airport.png");
                    norteamerica.setImage(asiaA);
                }
                else if(lugar.contains("oceania")){
                    Image asiaA = new Image("C:\\Users\\Usuario WTK\\Proyectos GitHub\\AirWars_Game\\src\\main\\resources\\com\\example\\airwars_game\\airport.png");
                    oceania.setImage(asiaA);
                }
                else if(lugar.contains("pacifico1")){
                    Image asiaA = new Image("C:\\Users\\Usuario WTK\\Proyectos GitHub\\AirWars_Game\\src\\main\\resources\\com\\example\\airwars_game\\portaavion.png");
                    pacifico1.setImage(asiaA);
                }
                else if(lugar.contains("pacifico2")){
                    Image asiaA = new Image("C:\\Users\\Usuario WTK\\Proyectos GitHub\\AirWars_Game\\src\\main\\resources\\com\\example\\airwars_game\\portaavion.png");
                    pacifico2.setImage(asiaA);
                }
                else if(lugar.contains("sur america")){
                    Image asiaA = new Image("C:\\Users\\Usuario WTK\\Proyectos GitHub\\AirWars_Game\\src\\main\\resources\\com\\example\\airwars_game\\airport.png");
                    suramerica.setImage(asiaA);
                }
            }
        });
    }
}