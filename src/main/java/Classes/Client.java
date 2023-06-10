package Classes;

import com.example.airwars_game.HelloController;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;

import java.io.*;
import java.net.Socket;

public class Client {
    private Socket socket;
    private BufferedWriter bufferedWriter;
    private BufferedReader bufferedReader;

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

    public void recieveMessageFromServer(ImageView africa, ImageView asia, ImageView atlantico, ImageView europa, ImageView indico, ImageView norteamerica, ImageView oceania, ImageView pacifico1, ImageView pacifico2, ImageView suramerica){
        new Thread(new Runnable() {
            @Override
            public void run() {
                while(socket.isConnected()){
                    try{
                        String posicionMapa = bufferedReader.readLine();
                        HelloController.mapa(posicionMapa, africa, asia, atlantico, europa, indico, norteamerica, oceania, pacifico1, pacifico2, suramerica);

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
