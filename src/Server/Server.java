
package Server;

        import java.io.IOException;
        import java.net.ServerSocket;
        import java.net.Socket;
        import java.util.*;
public class Server {
    public static void main(String[] args)
    {
        ServerSocket serverSocket;
        Socket socket;
        try{
            serverSocket =new ServerSocket(7001);
            System.out.println("Waiting for connection");
            Socket s = serverSocket.accept();
            System.out.println("Connected.");
        }catch (IOException e)
        {
            e.printStackTrace();
        }
        while(true)
        {
            //assert sere
        }


    }

}