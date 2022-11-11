package com.example.Client;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;

public class HelloApplication extends Application {
    public static Stage appStage;

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("login.fxml"));//fxml object created
        Scene scene = new Scene(fxmlLoader.load(), 520, 400);    //scene object created
        stage.setTitle("SoftDart");
        stage.setScene(scene);

        appStage = stage;

        stage.show();
    }


    public static void main(String[] args) {
        launch();
        Thread1 thread1 = new Thread1();//thread 1 object is created
        thread1.start();//thread 1 to begin execution
        Thread2 thread2 = new Thread2();//thread 2 object is created
        thread2.start();//thread 2 to begin execution
        Thread thread = new Thread((Runnable) new Hello());
        thread.start();
        while (true) {     //infinite loop
            System.out.println("I am main thread");
            try {            //try block to check for exception
                Thread.sleep(5000);   //it will sleep the thread for 5 sec
            } catch (InterruptedException e) {    //interrupt the execution of thread
                e.printStackTrace();    //print stack trace
            }
        }
    }

    public static class Hello extends HelloApplication implements Runnable {


        @Override
        public void run() {
            while (true) {     // infinite loop
                System.out.println("I am thread 3 created using runnable interface");
                try { //try block to check for exception
                    Thread.sleep(3000);//it will sleep the thread for 3 sec
                } catch (InterruptedException e) { //interrupt the execution of thread
                    e.printStackTrace(); //print stack trace
                }
            }
        }
    }
}