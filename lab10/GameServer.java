package com.company;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;


public class GameServer {

    public static final int port = 3000;


    public GameServer() {
        try {
            ServerSocket serverSocket = new ServerSocket(port);

            System.out.println("Server up and running on socket " + serverSocket + ".");

            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("Client connected on socket " + socket + ".");
                new Thread(new ClientThread(socket)).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
