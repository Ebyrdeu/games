package com.example.games.networking;

import com.example.games.lib.utils.Constants;
import com.example.games.lib.utils.Log;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.atomic.AtomicInteger;

public class Server {
    private static final AtomicInteger activeConnections = new AtomicInteger(1);
    private static ServerSocket serverSocket;

    private Server() {
    }

    private static void close(Socket socket) {
        try {
            socket.close();
        } catch (IOException e) {
            Log.message("Server Error on Close");
            throw new RuntimeException(e);
        }
    }

    private static void handleConnection(Socket socket) {
        try {
            getActiveConnections().incrementAndGet();
            Log.message("Total users now: " + Server.getActiveConnectionsValues());

            var fromClient = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            Log.message("From Client : " + fromClient.readLine());

            var toClient = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
            toClient.write("Server!\n");
            toClient.flush();
        } catch (IOException e) {
            Log.message("Server Error on handleConnection");
            throw new RuntimeException(e);
        } finally {
            close(socket);
        }
    }

    private static void serverProps() {
        try {
            serverSocket = new ServerSocket(Constants.PORT);
            while (!serverSocket.isClosed()) {
                Socket clientSocket = serverSocket.accept();
                Thread.startVirtualThread(() -> handleConnection(clientSocket));
            }
        } catch (IOException e) {
            Log.message("Server Error on serverProps");
            throw new RuntimeException(e);
        }
    }

    public static AtomicInteger getActiveConnections() {
        return activeConnections;
    }

    public static int getActiveConnectionsValues() {
        return activeConnections.get();
    }


    public static boolean isServerRunning() {
        return serverSocket != null && !serverSocket.isClosed() && serverSocket.isBound();
    }

    public static void start() {
        Thread.startVirtualThread(Server::serverProps);
        Log.message("Server has Started");
    }

}
