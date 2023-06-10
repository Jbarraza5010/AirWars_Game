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

    public LinkedList recieveMessageFromServer(){
        LinkedList message = new LinkedList();
        message.insertFirst("hey");
        new Thread(new Runnable() {
            @Override
            public void run() {
                while(socket.isConnected()){
                    try{
                        String posicionMapa = bufferedReader.readLine();

                    }catch(IOException e){
                        e.printStackTrace();
                        System.out.println("Error reciviendo mensaje del controller");
                        closeAll(socket, bufferedReader, bufferedWriter);
                        break;
                    }
                }
            }
        }).start();
        message.displayList();
        return message;
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
