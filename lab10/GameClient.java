package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class GameClient {

    public final String serverAddress = "127.0.0.1";
    public final int port = 3000;


    public void connect() {
        try {
            Socket socket = new Socket(serverAddress, port);
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            Scanner scanner = new Scanner(System.in);

            while (true) {
                System.out.println("Scrie comanda");
                String command = scanner.nextLine();
                String response;
                if (command.equals("exit")) {
                    command = "stop";
                }
                out.println(command);
                System.out.println("Trimis comanda " + command + ".");
                response = in.readLine();
                System.out.println("Primit raspuns " + response + ".");
                if (response.equals("Thread stopped.")) {
                    break;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
