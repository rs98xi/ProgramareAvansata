package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ClientThread implements Runnable {

    private Socket socket;

    public ClientThread(Socket socket) {
        this.socket = socket;
    }

    public void run() {
        System.out.println("Thread created for client " + socket + ".");

        try {
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter out = new PrintWriter(socket.getOutputStream());

            while (true) {
                String command = in.readLine();
                System.out.println("Citit comanda.");
                if (command.equals("stop")) {
                    System.out.println("Thread for client " + socket + " stopped");
                    out.println("Thread stopped.");
                    out.flush();
                    break;
                } else {
                    System.out.println("Client " + socket + " executes command " + command + ".");
                    out.println("Ok.");
                    out.flush();
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
