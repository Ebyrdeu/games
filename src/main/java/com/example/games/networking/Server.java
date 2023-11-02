package com.example.games.networking;

import com.example.games.lib.utils.Log;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.atomic.AtomicInteger;

public class Server {
    private static ServerSocket serverSocket;

    private static final AtomicInteger activeConnections = new AtomicInteger(1);

    private Server() {
    }

    public static int getActiveConnections() {
        return activeConnections.get();
    }


    public static boolean isServerRunning() {
        return serverSocket != null && !serverSocket.isClosed() && serverSocket.isBound();
    }

    public static void start() {
        Thread.startVirtualThread(Server::serverProps);
        Log.info("Server Started");
    }

    private static void close() {
        try {
            serverSocket.close();
        } catch (IOException e) {
            Log.error("Server Error on Close");
            throw new RuntimeException(e);
        }
    }

    private static void handleConnection(Socket socket) {
        try {
            activeConnections.incrementAndGet();
            Log.info("Total users now: " + Server.getActiveConnections());

            var bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            Log.info("From Client : " + bufferedReader.readLine());

            var bufferedWriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
            bufferedWriter.write("Server!\n");
            bufferedWriter.flush();
        } catch (IOException e) {
            Log.error("Server Error on Handle");
            throw new RuntimeException(e);
        } finally {
            close();
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

}
