package com.example.games.networking;

import com.example.games.lib.utils.Constants;
import com.example.games.lib.utils.Log;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class Client {
    private static Socket clientSocket;

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
            var bufferedReader = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

            while (!clientSocket.isClosed()) {
                var message = bufferedReader.readLine();
                if (message != null) Log.message("Server says: " + message);
                else Log.message("Server disconnected");
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            close();
        }
    }

    private static void close() {
        try {
            clientSocket.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
