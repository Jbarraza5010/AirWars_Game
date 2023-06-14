package Classes;

import com.example.airwars_game.HelloController;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;

import java.io.*;
import java.net.Socket;

/**
 * Clase del cliente
 */
public class Client {
    private Socket socket;
    private BufferedWriter bufferedWriter;
    private BufferedReader bufferedReader;

    /**
     * Clase constructora del cliente
     * @param socket
     */
    public Client(Socket socket){
        try{
            this.socket = socket;
            this.bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            this.bufferedWriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
        }catch(IOException e){
            System.out.println("Error creando cliente");
            e.printStackTrace();
            closeAll(socket, bufferedReader, bufferedWriter);
        }
    }

    /**
     * Metodo que recibe mensaje del controller
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
    public void recieveMessageFromServer(ImageView africa, ImageView asia, ImageView atlantico, ImageView europa, ImageView indico, ImageView norteamerica, ImageView oceania, ImageView pacifico1, ImageView pacifico2, ImageView suramerica,
                                         ImageView africaA, ImageView asiaA, ImageView atlanticoA, ImageView europaA, ImageView indicoA, ImageView norteamericaA, ImageView oceaniaA, ImageView pacifico1A, ImageView pacifico2A, ImageView suramericaA){
        new Thread(new Runnable() {
            @Override
            public void run() {
                while(socket.isConnected()){
                    try{
                        String message = bufferedReader.readLine();
                        HelloController.mapa(message, africa, asia, atlantico, europa, indico, norteamerica, oceania, pacifico1, pacifico2, suramerica);

                    }catch(IOException e){
                        e.printStackTrace();
                        System.out.println("Error reciviendo mensaje del controller");
                        closeAll(socket, bufferedReader, bufferedWriter);
                        break;
                    }
                }
            }
        }).start();
    }

    /**
     * Metodo que cierra el socket entre el cliente y el server
     * @param socket
     * @param bufferedReader
     * @param bufferedWriter
     */
    public void closeAll(Socket socket, BufferedReader bufferedReader, BufferedWriter bufferedWriter){
        try{
            if (bufferedReader != null){
                bufferedReader.close();
            }
            if (bufferedWriter != null){
                bufferedWriter.close();
            }
            if (socket != null){
                socket.close();
            }
        }catch(IOException e){
            e.printStackTrace();
        }
    }
}
