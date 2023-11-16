package com.example.games.networking;

import com.example.games.lib.utils.Constants;
import com.example.games.lib.utils.Log;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Client {
    private static Socket clientSocket;

    private static BufferedReader in;
    private static PrintWriter out;

    private Client() {
    }

    // TODO: Need to redo `in` and `out`
    public static void send(String msg) {
        out.println(msg);
    }

    // TODO: Need to redo `in` and `out`
    public static void onMessage(String msg) throws IOException {
        System.out.println(msg + in.readLine());
    }

    public static boolean isClientRunning() {
        return clientSocket != null && !clientSocket.isClosed() && clientSocket.isBound();
    }

    public static void start(String host) {
        Thread.startVirtualThread(() -> Client.clientProps(host));
        Log.message("Client connected");
    }

    private static void clientProps(String host) {
        try {
            clientSocket = new Socket(host, Constants.PORT);
            NetworkUtils.onOpponentConnect(Client.class);
            while (!clientSocket.isClosed()) {
                in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                onMessage("Message received: ");
                out = new PrintWriter(clientSocket.getOutputStream(), true);
                out.println("Hello 2");

            }
        } catch (IOException e) {
            NetworkUtils.close(clientSocket, in, out);
        }
    }

}
