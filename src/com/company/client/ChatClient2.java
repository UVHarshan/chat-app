package com.company.client;

import java.io.IOException;

public class ChatClient2 {

    public static void main(String[] args) throws IOException {

        Client client = new Client();
        client.start();

        client.sendMessage("Hello from the client");
        client.sendMessage("How are you?");
        client.sendMessage("I am fine");
        client.sendMessage("Thank You");
        client.sendMessage("exit");




        System.out.println("Client finished the execution");

        // Input stream and output Stream

        // Send data both ways
        // Server sends data according to the client input
        // Get the user input and send data to the server
        // handling multiple clients
    }
}


