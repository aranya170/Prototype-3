package com.example.peer_pi;
import java.io.*;
import java.net.*;

public class Server {
    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(1234);
            Socket socket = serverSocket.accept();
            InputStream is = socket.getInputStream();
            BufferedReader br = new BufferedReader(new InputStreamReader(is));
            String message = br.readLine();
            System.out.println("Message received from client: " + message);
//            br.close();
//            is.close();
//            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
