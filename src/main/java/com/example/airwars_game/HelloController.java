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

/**
 * Clase controller del juego
 */
public class HelloController implements Initializable {

    private Client client;

    @FXML
    private ImageView africa;

    @FXML
    private ImageView africaA;

    @FXML
    private ImageView asia;

    @FXML
    private ImageView asiaA;

    @FXML
    private ImageView atlantico;

    @FXML
    private ImageView atlanticoA;

    @FXML
    private ImageView europa;

    @FXML
    private ImageView europaA;

    @FXML
    private ImageView indico;

    @FXML
    private ImageView indicoA;

    @FXML
    private ImageView norteAmerica;

    @FXML
    private ImageView norteAmericaA;

    @FXML
    private ImageView oceania;

    @FXML
    private ImageView oceaniaA;

    @FXML
    private ImageView pacifico1;

    @FXML
    private ImageView pacifico1A;

    @FXML
    private ImageView pacifico2;

    @FXML
    private ImageView pacifico2A;

    @FXML
    private ImageView surAmerica;

    @FXML
    private ImageView surAmericaA;

    @FXML
    private ImageView worldmap;

    /**
     * Clase que inicia el cliente junto con sus metodos
     * @param url
     * @param resourceBundle
     */
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        try{
            client = new Client(new Socket("localhost", 1234));
            System.out.println("Conectado al Servidor");
        }catch (IOException e){
            e.printStackTrace();
            System.out.println("Error conectandose el servidor");
        }

        client.recieveMessageFromServer(africa, asia, atlantico, europa, indico, norteAmerica, oceania, pacifico1, pacifico2, surAmerica,
                africaA, asiaA, atlanticoA, europaA, indicoA, norteAmericaA, oceaniaA, pacifico1A, pacifico2A, surAmericaA);
    }

    /**
     * Metodo que crea los aeropuertos y portaaviones en el mapa
     * @param lugar
     * @param africa
     * @param asia
     * @param atlantico
     * @param europa
     * @param indico
     * @param norteamerica
     * @param oceania
     * @param pacifico1
     * @param pacifico2
     * @param suramerica
     */
    public static void mapa(String lugar, ImageView africa, ImageView asia, ImageView atlantico, ImageView europa, ImageView indico, ImageView norteamerica, ImageView oceania, ImageView pacifico1, ImageView pacifico2, ImageView suramerica){
        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                if (lugar.contains("africa")){
                    Image pos = new Image("C:\\Users\\jbarr\\Proyectos Github\\AirWars_Game\\src\\main\\resources\\com\\example\\airwars_game\\airport.png");
                    africa.setImage(pos);
                }
                else if(lugar.contains("asia")){
                    Image pos = new Image("C:\\Users\\jbarr\\Proyectos Github\\AirWars_Game\\src\\main\\resources\\com\\example\\airwars_game\\airport.png");
                    asia.setImage(pos);
                }
                else if(lugar.contains("atlantico")){
                    Image pos = new Image("C:\\Users\\jbarr\\Proyectos Github\\AirWars_Game\\src\\main\\resources\\com\\example\\airwars_game\\portaavion.png");
                    atlantico.setImage(pos);
                }
                else if(lugar.contains("europa")){
                    Image pos = new Image("C:\\Users\\jbarr\\Proyectos Github\\AirWars_Game\\src\\main\\resources\\com\\example\\airwars_game\\airport.png");
                    europa.setImage(pos);
                }
                else if(lugar.contains("indico")){
                    Image pos = new Image("C:\\Users\\jbarr\\Proyectos Github\\AirWars_Game\\src\\main\\resources\\com\\example\\airwars_game\\portaavion.png");
                    indico.setImage(pos);
                }
                else if(lugar.contains("norte america")){
                    Image pos = new Image("C:\\Users\\jbarr\\Proyectos Github\\AirWars_Game\\src\\main\\resources\\com\\example\\airwars_game\\airport.png");
                    norteamerica.setImage(pos);
                }
                else if(lugar.contains("oceania")){
                    Image pos = new Image("C:\\Users\\jbarr\\Proyectos Github\\AirWars_Game\\src\\main\\resources\\com\\example\\airwars_game\\airport.png");
                    oceania.setImage(pos);
                }
                else if(lugar.contains("pacifico1")){
                    Image pos = new Image("C:\\Users\\jbarr\\Proyectos Github\\AirWars_Game\\src\\main\\resources\\com\\example\\airwars_game\\portaavion.png");
                    pacifico1.setImage(pos);
                }
                else if(lugar.contains("pacifico2")){
                    Image pos = new Image("C:\\Users\\jbarr\\Proyectos Github\\AirWars_Game\\src\\main\\resources\\com\\example\\airwars_game\\portaavion.png");
                    pacifico2.setImage(pos);
                }
                else if(lugar.contains("sur america")){
                    Image pos = new Image("C:\\Users\\jbarr\\Proyectos Github\\AirWars_Game\\src\\main\\resources\\com\\example\\airwars_game\\airport.png");
                    suramerica.setImage(pos);
                }
            }
        });
    }

    /**
     * Metodo que genera los aviones en sus respectivos hangares
     * @param lugar
     * @param africaA
     * @param asiaA
     * @param atlanticoA
     * @param europaA
     * @param indicoA
     * @param norteamericaA
     * @param oceaniaA
     * @param pacifico1A
     * @param pacifico2A
     * @param suramericaA
     */
    public static void aviones (String lugar, String tipo,  ImageView africa, ImageView asia, ImageView atlantico, ImageView europa, ImageView indico, ImageView norteamerica, ImageView oceania, ImageView pacifico1, ImageView pacifico2, ImageView suramerica, ImageView africaA, ImageView asiaA, ImageView atlanticoA, ImageView europaA, ImageView indicoA, ImageView norteamericaA, ImageView oceaniaA, ImageView pacifico1A, ImageView pacifico2A, ImageView suramericaA){
        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                if (tipo.contains("SkyShredder")){
                    Image avion = new Image("C:\\Users\\jbarr\\Proyectos Github\\AirWars_Game\\src\\main\\resources\\com\\example\\airwars_game\\skyshredder.png");
                    if (lugar.contains("africa")){
                        africaA.setImage(avion);
                    }
                    else if(lugar.contains("asia")){
                        asiaA.setImage(avion);
                    }
                    else if(lugar.contains("atlantico")){
                        atlanticoA.setImage(avion);
                    }
                    else if(lugar.contains("europa")){
                        europaA.setImage(avion);
                    }
                    else if(lugar.contains("indico")){
                        indicoA.setImage(avion);
                    }
                    else if(lugar.contains("norte america")){
                        norteamericaA.setImage(avion);
                    }
                    else if(lugar.contains("oceania")){
                        oceaniaA.setImage(avion);
                    }
                    else if(lugar.contains("pacifico1")){
                        pacifico1A.setImage(avion);
                    }
                    else if(lugar.contains("pacifico2")){
                        pacifico2A.setImage(avion);
                    }
                    else if(lugar.contains("sur america")){
                        suramericaA.setImage(avion);
                    }
                } else if (tipo.contains("GroundZero")) {
                    Image avion = new Image("C:\\Users\\jbarr\\Proyectos Github\\AirWars_Game\\src\\main\\resources\\com\\example\\airwars_game\\groundzero.png");
                    if (lugar.contains("africa")){
                        africaA.setImage(avion);
                    }
                    else if(lugar.contains("asia")){
                        asiaA.setImage(avion);
                    }
                    else if(lugar.contains("atlantico")){
                        atlanticoA.setImage(avion);
                    }
                    else if(lugar.contains("europa")){
                        europaA.setImage(avion);
                    }
                    else if(lugar.contains("indico")){
                        indicoA.setImage(avion);
                    }
                    else if(lugar.contains("norte america")){
                        norteamericaA.setImage(avion);
                    }
                    else if(lugar.contains("oceania")){
                        oceaniaA.setImage(avion);
                    }
                    else if(lugar.contains("pacifico1")){
                        pacifico1A.setImage(avion);
                    }
                    else if(lugar.contains("pacifico2")){
                        pacifico2A.setImage(avion);
                    }
                    else if(lugar.contains("sur america")){
                        suramericaA.setImage(avion);
                    }
                } else if (tipo.contains("FlyingFortress")) {
                    Image avion = new Image("C:\\Users\\jbarr\\Proyectos Github\\AirWars_Game\\src\\main\\resources\\com\\example\\airwars_game\\flyingfortress.png");
                    if (lugar.contains("africa")){
                        africaA.setImage(avion);
                    }
                    else if(lugar.contains("asia")){
                        asiaA.setImage(avion);
                    }
                    else if(lugar.contains("atlantico")){
                        atlanticoA.setImage(avion);
                    }
                    else if(lugar.contains("europa")){
                        europaA.setImage(avion);
                    }
                    else if(lugar.contains("indico")){
                        indicoA.setImage(avion);
                    }
                    else if(lugar.contains("norte america")){
                        norteamericaA.setImage(avion);
                    }
                    else if(lugar.contains("oceania")){
                        oceaniaA.setImage(avion);
                    }
                    else if(lugar.contains("pacifico1")){
                        pacifico1A.setImage(avion);
                    }
                    else if(lugar.contains("pacifico2")){
                        pacifico2A.setImage(avion);
                    }
                    else if(lugar.contains("sur america")){
                        suramericaA.setImage(avion);
                    }
                }
            }
        });
    }
}