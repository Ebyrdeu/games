package com.example.games.networking;

import com.example.games.lib.utils.Constants;
import com.example.games.lib.utils.Log;

import java.io.*;
import java.net.Socket;

public class Client {
    private static Socket clientSocket;

    private static BufferedReader in;
    private static PrintWriter out;

    private Client() {
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
            in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

            NetworkUtils.incrementAndIsUser2();

            while (!clientSocket.isClosed()) {
                var message = in.readLine();
                if (message != null) Log.message("Server says: " + message);
                else Log.message("Server disconnected");
            }
        } catch (IOException e) {
            NetworkUtils.close(clientSocket, in, out);
        }
    }

}
