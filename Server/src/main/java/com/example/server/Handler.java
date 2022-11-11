package com.example.server;

        import java.io.IOException;
        import java.io.ObjectInputStream;
        import java.io.ObjectOutputStream;
        import java.net.Socket;

    public class Handler implements Runnable {     //Handler class created
    Socket socket;          //socket created
    ObjectOutputStream oos;
    ObjectInputStream ois;

    public Handler(Socket socket) {
        this.socket = socket;
        try {
            this.oos= new ObjectOutputStream(socket.getOutputStream());
            this.ois=new ObjectInputStream(socket.getInputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
        Server.list.add(oos);
    }

    @Override
    public void run() {
        System.out.println("Run method called in Handler, waiting for a message");
        Message msg;
        while (true){
            try {
                msg=(Message)ois.readObject();
                System.out.println(msg.getName()+" : "+ msg.getText());
                for (ObjectOutputStream oos: Server.list) {
                    if(oos.equals(this.oos))continue;
                    oos.writeObject(msg);
                }
            } catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
    }

    private class Message {
        public Object getName() {
            return null;
        }

        public Object getText() {
            return null;
        }
    }
}