package com.example.games.networking;

import com.example.games.lib.utils.Log;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    private static ServerSocket serverSocket;

    public static boolean isServerRunning() {
        return serverSocket != null && !serverSocket.isClosed() && serverSocket.isBound();
    }

    private static void handleConnection(Socket socket) {
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            Log.info("From Client : " + bufferedReader.readLine());

            BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
            bufferedWriter.write("Hello from server!\n");
            bufferedWriter.flush();
        } catch (IOException e) {
            Log.error("Server Error on Handle");
            throw new RuntimeException(e);
        }
    }

    private static void serverProps() {
        try {
            serverSocket = new ServerSocket(8000);
            while (!serverSocket.isClosed()) {
                Socket clientSocket = serverSocket.accept();
                Thread.startVirtualThread(() -> handleConnection(clientSocket));
            }
        } catch (IOException e) {
            Log.error("Server Error on Start");
            throw new RuntimeException(e);
        }
    }

    public static void start() {
        Thread.startVirtualThread(Server::serverProps);
        Log.info("Server Started");
    }


}
