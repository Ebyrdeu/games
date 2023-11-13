package com.example.games.networking;

import com.example.games.lib.utils.Log;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.concurrent.atomic.AtomicInteger;

public class NetworkUtils {
    private static final AtomicInteger activeConnections = new AtomicInteger(1);
    private static final BooleanProperty booleanProperty = new SimpleBooleanProperty(true);

    public static BooleanProperty isBooleanProperty() {
        return booleanProperty;
    }

    public static int getActiveConnectionsValues() {
        return activeConnections.get();
    }


    public static void incrementAndIsUser2() {
        activeConnections.incrementAndGet();
        booleanProperty.setValue(activeConnections.get() != 2);
    }

    public static void close(Socket socket, BufferedReader in, PrintWriter out) {
        try {
            if (socket != null) socket.close();
            if (in != null) in.close();
            if (out != null) out.close();
            activeConnections.decrementAndGet();
        } catch (IOException e) {
            Log.message("Error on Close");
            throw new RuntimeException(e);
        }
    }

}
