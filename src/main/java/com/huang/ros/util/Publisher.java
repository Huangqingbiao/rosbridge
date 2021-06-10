package com.huang.ros.util;

import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;

@Component
public class Publisher {
    public static boolean publisher(Socket socket, OutputStream out, String msgjson){
        try {
            out = socket.getOutputStream();
            out.write(msgjson.getBytes());
            if(socket.isConnected() == true){
//                Thread.sleep(3000);
                return true;
            }
        } catch (IOException e) {
            return false;
        }
        return false;
    }
}
