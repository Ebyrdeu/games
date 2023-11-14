package com.example.games.networking;

import com.example.games.lib.utils.Constants;
import com.example.games.lib.utils.Log;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    private static ServerSocket serverSocket;
    private static BufferedReader in;
    private static PrintWriter out;

    private Server() {
    }

    public static void send(String msg) {
        out.println(msg);
    }

    public static void onMessage(String msg) throws IOException {
        System.out.println(msg + in.readLine());
    }

    private static void handleConnection(Socket socket) {
        try {
            NetworkUtils.setNewUser();

            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            onMessage("Message received: ");

            out = new PrintWriter(socket.getOutputStream(), true);
            out.println("Hello");

        } catch (IOException e) {
            NetworkUtils.close(socket, in, out);
        }
    }

    private static void serverProps() {
        try {
            serverSocket = new ServerSocket(Constants.PORT);
            while (!serverSocket.isClosed()) handleConnection(serverSocket.accept());
        } catch (IOException e) {
            Log.message("Server Error on serverProps");
            throw new RuntimeException(e);
        }
    }

    public static boolean isServerRunning() {
        return serverSocket != null && !serverSocket.isClosed() && serverSocket.isBound();
    }

    public static void start() {
        Thread.startVirtualThread(Server::serverProps);
        Log.message("Server has Started");
    }

}
