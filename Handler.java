package Server;//package Server;
import Server.ObjectOutputStreamStream;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
public class Handler implements Runnable {
    Socket socket;
    ObjectOutputStreamStream oos;
    ObjectInputStream ois;

    public Handler(Socket socket)
    {



    }

    @Override
    public void run() {

    }
}

