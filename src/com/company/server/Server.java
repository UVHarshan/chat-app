package com.company.server;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.security.spec.RSAOtherPrimeInfo;

public class Server {

    public static void main(String[] args) throws IOException, InterruptedException {
	        System.out.println("Server is running");
            ServerSocket serverSocket = new ServerSocket( 6000);
            System.out.println("Server socket is created");

            while(true) {
                // Server is running forever

                Socket client = serverSocket.accept(); // Wait until a client connects
                System.out.println("Server accepted a client");

                ClientHandler clientHandler = new ClientHandler(client);
                //clientHandler.run();
                Thread thread = new Thread(clientHandler);
                thread.start();
            }
            //Send some data to client

            //InputStream and OutputStream

    }
}
