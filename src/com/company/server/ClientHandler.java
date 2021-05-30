package com.company.server;

import java.io.*;
import java.net.Socket;

public class ClientHandler implements Runnable{

    private Socket client;
    public ClientHandler(Socket socket) {
        this.client = socket;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(2000);
            // Receiving data
            InputStream inputStream = client.getInputStream();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            DataOutputStream outputStream = new DataOutputStream(client.getOutputStream());

            // Continuous reading data from client
            String inputData;
            while((inputData = bufferedReader.readLine()) != null) {

                //System.out.println(" Client says: " + inputData);


                // Also you can use scanner class to get input
                // Send data to client
                switch(inputData) {
                    case "Hello from the client":
                        outputStream.writeBytes("Hello from the server \n");
                        break;
                    case "How are you?":
                        outputStream.writeBytes("I am fine. How are you? \n");
                        break;
                    case "I am fine":
                        outputStream.writeBytes("Okay good to know \n");
                        break;
                    case "Thank You":
                        outputStream.writeBytes("You are welcome \n");
                        break;
                    default:
                        outputStream.writeBytes("I didn't understand\n");
                }
//                outputStream.writeBytes( "Hello from the server.....\n");

                if(inputData.equals("exit")) {
                    break;
                }
            }

            this.client.close();
        } catch (InterruptedException | IOException e) {
            e.printStackTrace();
        }
    }

    // two ways to create a thread in java
    // 1. Extend the class using Thread Super Class
    // 2. Implement the class using Runnable interface

}
