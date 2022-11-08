package com.example.softdart;
import java.io.IOException;
import java.net.Socket;

public class Client {
    public static void main(String[] args)
    {
        Socket socket;
        try{
            socket = new Socket("Localhost",7001);
            System.out.println("Connected to sever");
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }
}

