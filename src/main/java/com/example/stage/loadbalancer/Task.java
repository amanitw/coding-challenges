package com.example.stage.loadbalancer;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketAddress;
import java.util.Arrays;
import java.util.List;

public class Task implements Runnable{
    private Socket clientSocket;
    private String host;

    public Task(Socket socket, String host) {
        this.clientSocket = socket;
        this.host = host;
    }

    @Override
    public void run() {
        try {
            System.out.println("Task executed");
            BufferedReader reader = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            StringBuilder request = new StringBuilder();
            String line;
            while (!(line = reader.readLine()).isEmpty()){
                request.append(line).append("\r\n");
                System.out.println(line);
            }
            request.append("\r\n");
            System.out.println("Request is "+request);
            List<String> connectionDetails = Arrays.stream(this.host.split(":")).toList();
            System.out.println("port is "+connectionDetails.get(2));
            SocketAddress socketAddress = new InetSocketAddress("127.0.0.1", Integer.parseInt(connectionDetails.get(2)));
            Socket backendSocket = new Socket();
            backendSocket.connect(socketAddress,60000);
            PrintWriter backendOut = new PrintWriter(backendSocket.getOutputStream(), true);

            BufferedReader backendIn = new BufferedReader(new InputStreamReader(backendSocket.getInputStream()));

            backendOut.print(request.toString());
            backendOut.flush();

            // Read response from backend server
            StringBuilder response = new StringBuilder();
            while ((line = backendIn.readLine()) != null) {
                response.append(line).append("\r\n");
            }
            System.out.println(response.toString());
            PrintWriter clientOut = new PrintWriter(clientSocket.getOutputStream(), true);
            clientOut.print(response.toString());
            clientOut.flush();

        }catch (Exception e){
            System.out.println("Exeception from task");
            System.out.println(e.getMessage());
        }
    }
}
